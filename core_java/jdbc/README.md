# Introduction
The JDBC application performs CRUD operations (Create, Read, Update, Delete) on a database using the JDBC API. A PostgreSQL database running in a Docker container was used, along with Maven to manage packages and dependencies and Git for version control.

## Prerequisites
1. Docker is installed
2. psql client is installed

## Implementaiton
1. Pull Docker Image
```docker pull postgres```

2. Run docker image
```docker run --rm --name lil-postgres -e POSTGRES_PASSWORD=password -d -v $HOME/srv/postgres:/var/lib/postgresql/data -p 5432:5432 postgres```

3. Check Docker status and start Docker container
```
sudo systemctl status docker
docker ps
docker container start lil-postgres
```
4. Create database hplussport and load all the data in the tables by running these sql files
```
psql -h localhost -U postgres -p 5554 -f database.sql
psql -h localhost -U postgres -d hplussport -p 5554 -f customer.sql
psql -h localhost -U postgres -d hplussport  -p 5554 -f product.sql
psql -h localhost -U postgres -d hplussport -p 5554 -f salesperson.sql
psql -h localhost -U postgres -d hplussport -p 5554 -f orders.sql
```

5. Connect to the PSQL instance
```
psql -h localhost -U postgres -d hplussport
psql -h localhost -U postgres -p 5554
```
6. Creating stored procedure
`psql -h localhost -U postgres -f stored_proc.sql`
## ER Diagram
![core_java_ER.png](..%2Fassets%2Fcore_java_ER.png)

## Design Patterns
The DAO pattern abstracts database operations and puts them in a separate object, making it easier to change the database implementation without affecting the rest of the application. DAO also provides a clean separation of concerns between the database and business logic.

The Repository pattern provides a higher-level interface to access data by putting the details of the data storage behind a common interface. This makes it easier to manage data across multiple sources while also providing a way to abstract the database-specific implementation details.

## Test
1. To ensure docker is running.
```docker ps -f name=lil-postgres```
2. Checking if the database was created using the following command
```psql -h localhost -U postgres -d hplussport```
3. Used Queries to check if data has populated in the tables
```SELECT COUNT(*) FROM customer;```
4. Run the java file to check if the JDBC connection is established
5. It is manually tested the application by querying the PostgresSQL database within a terminal to confirm whether data from the application had been created, updated, or deleted the data. When reading from the database, The PostgresSQL database was set up and deployed within a docker container using the docker run command with the Postgres base image from Docker Hub.