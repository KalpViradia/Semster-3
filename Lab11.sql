--Create below tables as per following data

create table STU_INFO(
Rno int,
Name varchar(50),
Branch varchar(20))

insert into STU_INFO values
(101,'Raju','CE'),
(102,'Amit','CE'),
(103,'Sanjay','ME'),
(104,'Neha','EC'),
(105,'Meera','EE'),
(106,'Mahesh','ME');

create table RESULT(
Rno int,
SPI decimal(8,2))

insert into RESULT
(101,8.8),
(102,9.2),
(103,7.6),
(104,8.2),
(105,7.0),
(107,8.9);

create table EMPLOYEE_MASTERS(
EmployeeNo varchar(20),
Name varchar(50),
ManagerNo varchar(20))

insert into EMPLOYEE_MASTERS values
('E01','Tarun',null),
('E02','Rohan','E02'),
('E03','Priya','E01'),
('E04','Milan','E03'),
('E05','Jay','E01'),
('E06','Anjana','E04');

--Part – A:
--1. Combine information from student and result table using cross join or Cartesian product.
select * from STU_INFO cross join RESULT;

--2. Perform inner join on Student and Result tables.
select * from STU_INFO inner join RESULT;

--3. Perform the left outer join on Student and Result tables.
select * from STU_INFO left outer join RESULT;

--4. Perform the right outer join on Student and Result tables.
select * from STU_INFO right outer join RESULT;

--5. Perform the full outer join on Student and Result tables.
select * from STU_INFO full outer join RESULT;

--6. Display Rno, Name, Branch and SPI of all students.
select STU_INFO.Rno, STU_INFO.Name, STU_INFO.Branch, RESULT.SPI from STU_INFO join RESULT on STU_INFO.Rno = RESULT.Rno;

--7. Display Rno, Name, Branch and SPI of CE branch’s student only.
select STU_INFO.Rno, STU_INFO.Name, STU_INFO.Branch, RESULT.SPI from STU_INFO join RESULT on STU_INFO.Rno = RESULT.Rno where STU_INFO.Branch = 'CE';

--8. Display Rno, Name, Branch and SPI of other than EC branch’s student only.
select STU_INFO.Rno, STU_INFO.Name, STU_INFO.Branch, RESULT.SPI from STU_INFO join RESULT on STU_INFO.Rno = RESULT.Rno where not STU_INFO.Branch = 'EC';

--9. Display average result of each branch.
select STU_INFO.Branch, avg(RESULT.SPI) as AVG_RESULT from STU_INFO join RESULT on STU_INFO.Rno = RESULT.Rno group by STU_INFO.Branch;

--10. Display average result of CE and ME branch.
select STU_INFO.Branch, avg(RESULT.SPI) as AVG_RESULT from STU_INFO join RESULT on STU_INFO.Rno = RESULT.Rno group by STU_INFO.Branch having STU_INFO.Branch = 'CE' and STU_INFO.Branch = 'ME';

--Part – B:
--1. Display average result of each branch and sort them in ascending order by SPI.
select STU_INFO.Branch, avg(RESULT.SPI) as AVG_RESULT from STU_INFO join RESULT on STU_INFO.Rno = RESULT.Rno group by STU_INFO.Branch order by AVG_RESULT;

--2. Display highest SPI from each branch and sort them in descending order.
select STU_INFO.Branch, max(RESULT.SPI) as HIGHEST_RESULT from STU_INFO join RESULT on STU_INFO.Rno = RESULT.Rno group by STU_INFO.Branch order by HIGHEST_RESULT desc;

--Part – C:
--1. Retrieve the names of employee along with their manager’s name from the Employee table.
select e1.Name ,e2.Name from EMPLOYEE_MASTERS e1 left join EMPLOYEE_MASTERS e2 on e1.EmployeeNo = e2.ManagerNo;