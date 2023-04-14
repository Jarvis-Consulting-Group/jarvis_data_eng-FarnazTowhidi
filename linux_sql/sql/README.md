# Introduction

This project aimed to get deep insights into managing relational databases, and manipulating the data contained in them using various DDL and DML commands. The IDE and database management system used to implement this project is pgadmin4 and PostgreSQL.

## SQL Queries
### Table Setup (DDL)
1. Create table cd.members 
```sql
SELECT *
FROM cd.members
```
2. Create table cd.booking
```sql
SELECT *
FROM cd.members
```
3. Create table cd.facilities
```sql
SELECT *
FROM cd.members
```


### DML queries solutions

###### Question 1: Insert some data into a table
The club is adding a new facility - a spa. We need to add it into the facilities table. Use the following values: 
facid: 9, Name: 'Spa', membercost: 20, guestcost: 30, initialoutlay: 100000, monthlymaintenance: 800.
```
INSERT INTO cd.facilities (
  facid, name, membercost, guestcost, initialoutlay, 
  monthlymaintenance
) 
VALUES 
  (9, 'spa', 20, 30, 100000, 800)
```
###### Question 2: Insert calculated data into a table
Let's try adding the spa to the facilities table again. This time, though, we want to automatically generate the value for the next facid, rather than specifying it as a constant. Use the following values for everything else:
Name: 'Spa', membercost: 20, guestcost: 30, initialoutlay: 100000, monthlymaintenance: 800.
```
INSERT into cd.facilities (
  facid, name, membercost, guestcost, 
  initialoutlay, monthlymaintenance
) 
SELECT 
  (
    SELECT 
      max(facid) 
    FROM 
      cd.facilities
  )+ 1, 
  'Spa', 20, 30, 100000, 800;
```

###### Question 3: Update some existing data
We made a mistake when entering the data for the second tennis court. The initial outlay was 10000 rather than 8000: you need to alter the data to fix the error.

```
update 
  cd.facilities 
set 
  initialoutlay = 10000 
where 
  facid = 1

```
###### Question 4: Update a row based on the contents of another row
We want to alter the price of the second tennis court so that it costs 10% more than the first one. Try to do this without using constant values for the prices, so that we can reuse the statement if we want to.
```
update cd.facilities facs
set
    membercost = (select membercost * 1.1 from cd.facilities where facid = 0),
    guestcost = (select guestcost * 1.1 from cd.facilities where facid = 0)
where facs.facid = 1;  
```

###### Question 5: Delete all bookings
```
delete from 
  cd.bookings;

```
###### Question 6: Delete a member from the cd.members table


```
DELETE FROM 
  cd.members 
WHERE 
  memid = 37;

```
###### Question 7: Control which rows are retrieved - part 2
How can you produce a list of facilities that charge a fee to members, and that fee is less than 1/50th of the monthly maintenance cost? Return the facid, facility name, member cost, and monthly maintenance of the facilities in question.
```sql
SELECT
   facid,
   name,
   membercost,
   monthlymaintenance
from
   cd.facilities
where
   membercost > 0
and membercost < monthlymaintenance / 50
```

###### Question 8: Basic string searches
How can you produce a list of all facilities with the word 'Tennis' in their name?
```sql
select 
  * 
from 
  cd.facilities 
where 
  name like '%Tennis%'
```
###### Questions 9: Matching against multiple possible values
How can you retrieve the details of facilities with ID 1 and 5? Try to do it without using the OR operator.
```
SELECT 
  * 
from 
  cd.facilities 
where 
  facid in (1, 5);
```
###### Questions 10: Working with dates
How can you produce a list of members who joined after the start of September 2012? Return the memid, surname, firstname, and joindate of the members in question.
```
SELECT 
  memid, 
  surname, 
  firstname, 
  joindate 
from 
  cd.members 
where 
  joindate >= '2012-09-01'
```
###### Questions 11: You, for some reason, want a combined list of all surnames and all facility names. Yes, this is a contrived example :-). Produce that list!

```
SELECT
surname
FROM
cd.members
UNION
SELECT
name
FROM
cd.facilities
```
###### Questions 12: How can you produce a list of the start times for bookings by members named 'David Farrell'?
```
SELECT 
  bks.starttime 
FROM 
  cd.bookings bks 
  INNER JOIN cd.members mems ON bks.memid = mems.memid 
WHERE 
  mems.firstname = 'David' 
  AND mems.surname = 'Farrell'
```
###### Questions 13: Work out the start times of bookings for tennis courts
```
SELECT 
  bks.starttime AS start, 
  fac.name 
FROM 
  cd.bookings bks 
  INNER JOIN cd.facilities fac on bks.facid = fac.facid 
WHERE 
  bks.starttime >= '2012-09-21' 
  and bks.starttime < '2012-09-22' 
ORDER BY 
  bks.starttime
```
###### Question 13

```

```

###### Questions 14: Produce a list of all members, along with their recommender
```
SELECT 
  mems.firstname AS memfname, 
  mems.surname AS memsname, 
  recs.firstname AS recfname, 
  recs.surname AS recsname 
FROM 
  cd.members mems 
  LEFT OUTER JOIN cd.members recs ON mems.memid = recs.recommendedby 
ORDER BY 
  memfname, 
  memsname
```
###### Question 15

```

```
###### Question 16

```

```
###### Questions 17: Count the number of recommendations each member makes.
```
SELECT 
  recommendedby, 
  count(*) 
FROM 
  cd.members 
GROUP BY 
  recommendedby 
ORDER BY 
  recommendedby
```
###### Questions 18: List the total slots booked per facility. 
Produce a list of the total number of slots booked per facility. For now, just produce an output table consisting of facility id and slots, sorted by facility id.
```
SELECT
    facid,
    sum(slots) AS "TOTAL Slots"
from
    cd.bookings
group by
    f.acid
order by
    facid
```
###### Questions 19: List the total slots booked per facility in a given month
Produce a list of the total number of slots booked per facility in the month of September 2012. Produce an output table consisting of facility id and slots, sorted by the number of slots.
```
SELECT 
  facid, 
  SUM(slots) AS "total Slots" 
FROM 
  cd.bookings 
WHERE 
  starttime >= '2012-09-01' 
  and starttime < '2012-10-01' 
GROUP BY 
  facid 
order by 
  SUM(slots)
```

###### Questions 20: List the total slots booked per facility per month
Produce a list of the total number of slots booked per facility per month in the year of 2012. Produce an output table consisting of facility id and slots, sorted by the id and month.
```
SELECT facid, extract(month from starttime) as month, SUM(slots) AS "Total Slots" 
FROM cd.bookings
where extract(year from starttime) = 2012
GROUP BY facid, month
ORDER BY facid, month
```
###### Questions 21: Find the count of members who have made at least one booking
Find the total number of members (including guests) who have made at least one booking.
```
SELECT 
  count(
    DISTINCT(memid)
  ) AS count 
from 
  cd.bookings
```
### Questions 22: List each member's first booking after September 1st 2012
Produce a list of each member name, id, and their first booking after September 1st 2012. Order by member ID.
```
SELECT 
  mems.surname, 
  mems.firstname, 
  mems.memid, 
  min(bks.starttime) as starttime 
FROM 
  cd.members mems 
  INNER JOIN cd.bookings bks ON mems.memid = bks.memid 
where 
  starttime >= '2012-09-01' 
group by 
  mems.surname, 
  mems.firstname, 
  mems.memid 
order by 
  mems.memid;
```
###### Question 23

```

```
###### Question 24

```

```
###### Question 25

```

```
###### Question 26

```

```
###### Question 27

```

```
###### Question 28

```

```
