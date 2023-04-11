# Linux Cluster Monitoring Agent

# Introduction

The project will be used by Jarvis Linux Cluster administrator (LCA) to manage 10 server node that connect to each other. LCA want project to record hardware spec of each server and real time resource usage. The MVP plan is to use two bash scripts, host_info.sh, to save the server information, the the other, host_usage that save the real time usage of resources for each node. For persist data Postsql Database is used. 



# Quick Start

### Start a psql instance using psql_docker.sh
- Create tables using ddl.sql

````
# Insert hardware specs into the DB using host_info.sh
bash host_info.sh psql_host psql_port db_name psql_user psql_password

# Insert hardware usage data into the DB using host_usage.sh
bash host_usage.sh psql_host psql_port db_name psql_user psql_password
bash
````

# Implemenation
1. The psql database will be used to persist data over the application. 
2. The `bash agent` gathers server usage data, and then insert into the psql instance. The `agent` will be installed on every host/server/node. The `agent` consists of two bash scripts
- `host_info.sh` collects the host hardware info and insert it into the database. It will be run only once at the installation time.
- `host_usage.sh` collects the current host usage and then insert into the database. It will be triggered by the `cron` job every minute.



## Architecture
Draw a cluster diagram with three Linux hosts, a DB, and agents (use draw.io website). Image must be saved to the `assets` directory.

## Scripts
Shell script description and usage (use markdown code block for script usage)
- psql_docker.sh
- host_info.sh
- host_usage.sh
- crontab
- queries.sql (describe what business problem you are trying to resolve)

## Database Modeling
Describe the schema of each table using markdown table syntax (do not put any sql code)
The host_info table designed to store hardware specifications, and the host_usage table designed to keep the resource usage data.
```
## host_info

| `Field Name`     | `Data Type`           |
| ---------------- | --------------------- |
| id               | SERIAL NOT NULL       | 
| hostname         | VARCHAR NOT NULL      |
| cpu_number       | INT2 NOT NULL         | 
| cpu_architecture | VARCHAR NOT NULL      |
| cpu_model        | VARCHAR NOT NULL      | 
| cpu_mhz          | FLOAT8 NOT NULL       | 
| l2_cache         | INT4 NOT NULL         |
| timestamp"       | TIMESTAMP NULL        |
| total_mem        | INT4 NULL             |

## host_usage

| `Field Name`     | `Data Type`           |
| ---------------- | --------------------- |
| timestamp        | TIMESTAMP NOT NULL    | 
| host_id          | SERIAL NOT NULL       |
| memory_free      | INT2 NOT NULL         | 
| cpu_idel         | VARCHAR NOT NULL      |
| cpu_kernel       | VARCHAR NOT NULL      | 
| disk_io          | FLOAT8 NOT NULL       | 
| disk_available   | INT4 NOT NULL         |
| timestamp"       | TIMESTAMP NULL        |
| total_mem        | INT4 NULL             |
```


# Test
Manual test done by running two bash script and check the host_usage and host_info tables to check if the data added properly to the DB. 
````
bash -x host_info.sh psql_host psql_port db_name psql_user psql_password
bash -x host_usage.sh psql_host psql_port db_name psql_user psql_password
````


# Deployment
 The agent program is scheduled using cron. Source code is managed by GitHub. Database is provisioned with Docker.

# Improvements
Write at least three things you want to improve
e.g.
- Create resource planning report
- Create alert for under usage and over usage situation. 
- Create average memory usage in percentage 