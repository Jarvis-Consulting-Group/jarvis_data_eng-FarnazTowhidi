#Set and validate arguments (again, don't copy comments)
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
hostname=$(hostname -f | xargs)
lscpu_out=`lscpu`

cpu_number=$(echo "$lscpu_out" | grep "^CPU(s)" | awk '{print $2}' | xargs)
cpu_architecture=$(echo "$lscpu_out" | grep "^Architecture:" | awk '{print $2}' | xargs)
cpu_model=$(echo "$lscpu_out" | grep '^Model name' | awk '{$1=$2=""; print $0}' | xargs) 
cpu_mhz=$(echo "$lscpu_out" | grep '^CPU MHz' | awk '{print $3}')
l2_cache=$(lscpu | grep -w 'L2 cache' | awk '{print $3}'| sed 's/[a-z,A-Z]//g')
total_mem=$(vmstat --unit M | tail -1 | awk '{print $4}')
timestamp=$(vmstat -t | tail -1 | awk '{print $18,$19}')

insert_stmt="INSERT INTO host_info (hostname, cpu_number, cpu_architecture, cpu_model, cpu_mhz, l2_cache, "timestamp", total_mem) VALUES('$hostname', '$cpu_number', '$cpu_architecture', '$cpu_model', '$cpu_mhz', '$l2_cache', '$timestamp', 601324)"

export PGPASSWORD=$psql_password
psql -h "$psql_host" -p "$psql_port" -d "$db_name" -U "$psql_user" -c "$insert_stmt"
#psql -h "$psql_host" -p "$psql_port" -d "$db_name" -U "$psql_user" -c "SELECT  * FROM host_info"

exit $?

