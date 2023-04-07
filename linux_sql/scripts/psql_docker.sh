#! /bin/sh:
cmd=$1
db_username=$2
db_password=$3
#Start docker
#check docker status, if it is not running, srart it
sudo systemctl status docker || systemctl start docker

#check container status (try the following cmds on terminal)
docker container inspect jrvs-psql
container_status=$?

#User switch case to handle create|stop|start opetions

case $cmd in 
  create)
	echo 'create mode'  
	# Check if the container is already created
 	if [ $container_status -eq 0 ]; then
     		echo 'Container already exists'
     		exit 1	
  	fi

  	#check # of CLI arguments
	 if [ $# -ne 3 ]; then
     		echo 'Create requires username and password'
     		exit 1
  	fi
  
        #Create container
	docker pull pgdata
  	docker volume  pgdata
	#Start the container
  	docker run volume1
  	#Make sure you understand what's `$?`
  	exit $?
  	;;

  start|stop)
	echo 'stop start mode' 
  	#check instance status; exit 1 if container has not been created
 
        if [ $container_status -ne 0 ]; then
  	  	echo 'container does not exist'
		exit 1
  	fi

  	#start or stop the container
  	docker container $cmd jrvs-psql
 	exit $?
  	;;	

esac 

