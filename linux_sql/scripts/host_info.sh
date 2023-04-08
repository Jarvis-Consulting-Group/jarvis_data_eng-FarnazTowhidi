#Setup and validate arguments (again, don't copy comments)
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

echo $id
echo 'Farnazzzzzzzzzzzzzzzzzzzzzzzzzzzz'


#Retrieve hardware specification variables
cpu_number=$(echo "$lscpu_out" | grep "^CPU(s)" | awk '{print $2}' | xargs)
cpu_architecture=$(lscpu | grep "^Architecture:" | awk '{print $2}' | xargs)
#cpu_model= $(lscpu | grep '^Model name' | awk '{print $3}' |xargs) 
cpu_model="cpu_model"
#memory_free=$(echo "$vmstat_mb" | awk '{print $4}'| tail -n1 | xargs)
#cpu_idle=$(echo "$vmstat_mb" | tail -1 | awk '{print $15}')
#cpu_kernel=$(echo "$vmstat_mb" | tail -1 | awk '{print $14}')


#Current time in `2019-11-26 14:40:19` UTC format
#timestamp=$(vmstat -t | tail -1 | awk '{print $18,$19}')

#Subquery to find matching id in host_info table
#host_id="(SELECT id FROM host_info WHERE hostname='$hostname')";
host_id=2


insert_stmt="INSERT INTO host_info (id, hostname, cpu_number, cpu_architecture, cpu_model, cpu_mhz, l2_cache, "timestamp", total_mem) VALUES('$id', '$hostname', 1, 'x86_64', 'Intel(R) Xeon(R) CPU @ 2.30GHz', 2300, 256, '2019-05-29 17:49:53.000', 601324);"

#set up env var for pql cmd
export PGPASSWORD=$psql_password 
#Insert date into a database
psql  -h $psql_host -p $psql_port -d $db_name -U $psql_user -c "$insert_stmt"
exit $?
