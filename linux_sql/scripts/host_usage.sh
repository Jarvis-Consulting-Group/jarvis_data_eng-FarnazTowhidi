psql_host=$1
psql_port=$2
db_name=$3
psql_user=$4
psql_password=$5

#Check # of args
if [ "$#" -ne 5 ]; then
    echo "Illegal number of parameters"
    exit 1
fi

#Save machine statistics in MB and current machine hostname to variables
vmstat_mb=$(vmstat --unit M)
hostname=$(hostname -f)
lscpu_out=`lscpu`

timestamp=$(vmstat -t | tail -1 | awk '{print $18,$19}')
memory_free=$(vmstat --unit M | tail -1 | awk -v col="4" '{print $col}')
cpu_idle=$(vmstat --unit M | tail -1 | awk '{print $15}')
cpu_kernel=$(vmstat | tail -1 | awk '{print $14}')
disk_io=$(vmstat --unit M -d | tail -1 | awk -v col="10" '{print $col}')
disk_available=$(vmstat | tail -1 | awk '{print $4}')

export PGPASSWORD=$psql_password
hostid=$( psql -h "$psql_host" -p "$psql_port" -d "$db_name" -U "$psql_user" -t -c "SELECT id FROM host_info WHERE hostname='$hostname'" )
insert_stmt="INSERT INTO host_usage ("timestamp", host_id, memory_free, cpu_idel, cpu_kernel, disk_io, disk_available) VALUES('$timestamp', '$hostid', '$memory_free', '$cpu_idle', '$cpu_kernel', '$disk_io', '$disk_available')"
psql -h "$psql_host" -p "$psql_port" -d "$db_name" -U "$psql_user" -c "$insert_stmt"

exit $?

