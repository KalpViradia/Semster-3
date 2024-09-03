--Create following table (Using Design Mode)
--From the above given table perform the following queries:
--Part-A
--1. Find all persons with their department name & code.
SELECT P.PersonName,D.DepartmentName,D.DepartmentCode FROM PERSON AS P INNER JOIN DEPT AS D ON P.DepartmentID=D.DepartmentID;

--2. Find the person's name whose department is in C-Block.
SELECT P.PersonName FROM PERSON AS P INNER JOIN DEPT AS D ON P.DepartmentID=D.DepartmentID WHERE D.Location='C-BLOCK';

--3. Retrieve person name, salary & department name who belongs to Jamnagar city.
SELECT P.PersonName,P.SALARY,D.DepartmentName FROM PERSON AS P INNER JOIN DEPT AS D ON P.DepartmentID=D.DepartmentID WHERE P.CITY='JAMNAGAR';

--4. Retrieve person name, salary & department name who does not belong to Rajkot city.
SELECT P.PersonName,P.SALARY,D.DepartmentName FROM PERSON AS P INNER JOIN DEPT AS D ON P.DepartmentID=D.DepartmentID WHERE P.CITY!='RAJKOT';

--5. Retrieve person’s name of the person who joined the Civil department after 1-Aug-2001.
SELECT P.PersonName FROM PERSON AS P INNER JOIN DEPT AS D ON P.DepartmentID=D.DepartmentID WHERE D.DepartmentName='CIVIL' AND P.JoiningDate>01-07-2001;

--6.Find details of all persons who belong to the computer department.
SELECT * FROM PERSON AS P INNER JOIN DEPT AS D ON P.DepartmentID=D.DepartmentID WHERE D.DepartmentName='COMPUTER';

--7.Display all the person's name with the department whose joining date difference with the current date is more than 365 days.
SELECT P.PersonName,D.DepartmentName FROM PERSON AS P INNER JOIN DEPT AS D ON P.DepartmentID=D.DepartmentID WHERE DATEDIFF(YEAR,P.JoiningDate,GETDATE())>1;

--8.Find department wise person counts.
SELECT D.DepartmentName,COUNT(P.PersonID) AS TOTALCOUNT FROM PERSON AS P INNER JOIN DEPT AS D ON P.DepartmentID=D.DepartmentID GROUP BY D.DepartmentName;

--9.Give department wise maximum & minimum salary with department name.
SELECT D.DepartmentName,MAX(P.SALARY) AS MAXSALARY,MIN(P.SALARY) AS MINSALARY FROM PERSON AS P INNER JOIN DEPT AS D ON P.DepartmentID=D.DepartmentID GROUP BY D.DepartmentName;

--10.Find city wise total, average, maximum and minimum salary.
SELECT P.CITY,MAX(P.SALARY) AS MAXSALARY,MIN(P.SALARY) AS MINSALARY,AVG(P.SALARY) AS AVERAGESALARY,SUM(P.SALARY) AS TOTALSALARY FROM PERSON AS P INNER JOIN DEPT AS D ON P.DepartmentID=D.DepartmentID GROUP BY P.CITY;

--11.Find the average salary of a person who belongs to Ahmedabad city.
SELECT CITY,AVG(SALARY) AS AVERAGESALARY FROM PERSON WHERE CITY='AHMEDABAD' GROUP BY CITY;

--12.Produce Output Like: <PersonName> lives in <City> and works in <DepartmentName> Department. (In single column)
SELECT P.PersonName+' LIVES IN '+P.CITY+' AND WORKS IN '+D.DepartmentName AS DATA FROM PERSON AS P INNER JOIN DEPT AS D ON P.DepartmentID=D.DepartmentID;

--Part-B

--1.Produce Output Like: <PersonName> earns <Salary> from <DepartmentName> department monthly. (In single column)
SELECT CONCAT(P.PersonName,' EARNS ',P.SALARY,' FROM ',D.DepartmentName,' DEPARTMENT MONTHLY') AS DATA FROM PERSON AS P INNER JOIN DEPT AS D ON P.DepartmentID=D.DepartmentID;

--2.Find city & department wise total, average & maximum salaries.
SELECT D.DepartmentName,P.CITY,SUM(P.SALARY) AS TOTALSALARY,AVG(P.SALARY) AS AVERAGESALARY,MAX(P.SALARY) AS MAXSALARY FROM PERSON AS P INNER JOIN DEPT AS D ON P.DepartmentID=D.DepartmentID GROUP BY P.CITY,D.DepartmentName;

--3.Find all persons who do not belong to any department.
SELECT PersonName FROM PERSON WHERE DepartmentID IS NULL;

--4.Find all departments whose total salary is exceeding 100000.
SELECT D.DepartmentName,SUM(P.SALARY) AS TOTALSALARY FROM PERSON AS P INNER JOIN DEPT AS D ON P.DepartmentID=D.DepartmentID GROUP BY D.DepartmentName HAVING SUM(P.SALARY)>100000;

--Part-C

--1.List all departments who have no person.
SELECT D.DepartmentName FROM PERSON AS P INNER JOIN DEPT AS D ON P.DepartmentID=D.DepartmentID WHERE D.DepartmentID IS NULL;

--2.List out department names in which more than two persons are working.
SELECT D.DepartmentName,COUNT(P.PersonID) AS COUNTPERSON FROM PERSON AS P INNER JOIN DEPT AS D ON P.DepartmentID=D.DepartmentID GROUP BY D.DepartmentName HAVING COUNT(P.PersonID)>2;

--3.Give a 10% increment in the computer department employee’s salary. (Use Update)
UPDATE PERSON SET SALARY=(P.SALARY+.1*P.SALARY) FROM PERSON AS P INNER JOIN DEPT AS D ON P.DepartmentID=D.DepartmentID WHERE D.DepartmentID=2;
SELECT * FROM PERSON;