# Introduction

This project aimed to get deep insights into managing relational databases, and manipulating the data contained in them using various DDL and DML commands. The IDE and database management system used to implement this project is pgadmin4 and PostgreSQL.

## SQL Queries
### Table Setup (DDL)
1. Create table cd.members 
```
CREATE TABLE cd.members
(
   memid integer NOT NULL, 
   surname character varying(200) NOT NULL, 
   firstname character varying(200) NOT NULL, 
   address character varying(300) NOT NULL, 
   zipcode integer NOT NULL, 
   telephone character varying(20) NOT NULL, 
   recommendedby integer,
   joindate timestamp NOT NULL,
   CONSTRAINT members_pk PRIMARY KEY (memid),
   CONSTRAINT fk_members_recommendedby FOREIGN KEY (recommendedby)
);         
```
2. Create table cd.booking
```
CREATE TABLE cd.bookings
(
   bookid integer NOT NULL, 
   facid integer NOT NULL, 
   memid integer NOT NULL, 
   starttime timestamp NOT NULL,
   slots integer NOT NULL,
   CONSTRAINT bookings_pk PRIMARY KEY (bookid),
   CONSTRAINT fk_bookings_facid FOREIGN KEY (facid) REFERENCES cd.facilities(facid),
   CONSTRAINT fk_bookings_memid FOREIGN KEY (memid) REFERENCES cd.members(memid)
);  
```
3. Create table cd.facilities
```
CREATE TABLE cd.facilities
(
   facid integer NOT NULL, 
   name character varying(100) NOT NULL, 
   membercost numeric NOT NULL, 
   guestcost numeric NOT NULL, 
   initialoutlay numeric NOT NULL, 
   monthlymaintenance numeric NOT NULL, 
   CONSTRAINT facilities_pk PRIMARY KEY (facid)
);
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
###### Question 7: Control which rows are retrieved 
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
FROM 
  cd.members 
WHERE 
  joindate >= '2012-09-01'
```
###### Questions 11: Combining results from multiple queries
Combined list of all surnames and all facility names. 

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
###### Questions 12: Retrieve the start times of members' bookings
How can you produce a list of the start times for bookings by members named 'David Farrell'?
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
How can you produce a list of the start times for bookings for tennis courts, for the date '2012-09-21'? Return a list of start time and facility name pairings, ordered by the time.
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

###### Questions 14: Produce a list of all members, along with their recommender
How can you output a list of all members, including the individual who recommended them (if any)? Ensure that results are ordered by (surname, firstname).
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
###### Question 15: Produce a list of all members who have recommended another member
How can you output a list of all members who have recommended another member? Ensure that there are no duplicates in the list, and that results are ordered by (surname, firstname).
```
SELECT 
  DISTINCT mems.firstname firstname, 
  mems.surname surname 
FROM 
  cd.members mems 
  inner JOIN cd.members recm ON mems.memid = recm.recommendedby 
ORDER BY 
  surname, 
  firstname;
```
###### Question 16: Produce a list of all members, along with their recommender, using no joins.
How can you output a list of all members, including the individual who recommended them (if any), without using any joins? Ensure that there are no duplicates in the list, and that each firstname + surname pairing is formatted as a column and ordered.
```
SELECT DISTINCT mems.firstname || ' ' ||  mems.surname AS member,
	(SELECT recs.firstname || ' ' || recs.surname AS recommender 
		FROM cd.members recs 
		WHERE recs.memid = mems.recommendedby
	)
	FROM 
		cd.members mems
ORDER BY member;          
```
###### Questions 17: Count the number of recommendations each member makes.
Produce a count of the number of recommendations each member has made. Order by member ID.

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
FROM
    cd.bookings
GROUP BY
    f.acid
ORDER BY
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
ORDER BY 
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
FROM 
  cd.bookings
```

##### Questions 22: List each member's first booking after September 1st 2012
Produce a list of each member name, id, and their first booking after September 1st 2012. Order by member ID.
```
 SELECT
     mems.surname,
     mems.firstname,
     mems.memid,
     min(bks.starttime) AS starttime
 FROM
     cd.members mems
     INNER JOIN cd.bookings bks ON mems.memid = bks.memid
 WHERE
     starttime >= '2012-09-01'
 GROUP BY
     mems.surname,
     mems.firstname,
     mems.memid
 ORDER BY
     mems.memid;
```
###### Question 23: Produce a list of member names, with each row containing the total member count
Produce a list of member names, with each row containing the total member count. Order by join date, and include guest members.

```
select count(*) over(), firstname, surname
	from cd.members
order by joindate   
```
###### Question 24: Produce a numbered list of members
Produce a monotonically increasing numbered list of members (including guests), ordered by their date of joining. Remember that member IDs are not guaranteed to be sequential.

```
SELECT row_number() over(order by joindate), firstname, surname
FROM cd.members
ORDER BY joindate 
```
###### Question 25: Output the facility id that has the highest number of slots booked, again
Output the facility id that has the highest number of slots booked. Ensure that in the event of a tie, all tieing results get output.
```
SELECT 
  fac.facid, 
  sum(bok.slots) as total 
FROM 
  cd.facilities fac 
  INNER JOIN cd.bookings bok ON fac.facid = bok.facid 
GROUP BY 
  fac.facid 
ORDER BY 
  total DESC 
LIMIT 
  1
```
###### Question 26: Format the names of members
Output the names of all members, formatted as 'Surname, Firstname'

```
SELECT 
  CONCAT(surname, ',', firstname) AS name 
FROM 
  cd.members
```
###### Question 27: Find telephone numbers with parentheses
You've noticed that the club's member table has telephone numbers with very inconsistent formatting. You'd like to find all the telephone numbers that contain parentheses, returning the member ID and telephone number sorted by member ID.
```
SELECT 
  memid, 
  telephone 
FROM 
  cd.members 
WHERE 
  telephone ~ '[()]'
```

###### Question 28: Count the number of members whose surname starts with each letter of the alphabet
You'd like to produce a count of how many members you have whose surname starts with each letter of the alphabet. Sort by the letter, and don't worry about printing out a letter if the count is 0.

```
SELECT
  SUBSTR(mems.surname, 1, 1) AS letter, 
  count(*) AS  count 
FROM 
  cd.members mems 
GROUP BY 
  letter 
order by 
  letter

```
