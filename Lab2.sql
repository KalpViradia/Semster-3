--Part A

--1. Retrieve all data from table DEPOSIT.
--2. Retrieve all data from table BORROW.
--3. Retrieve all data from table CUSTOMERS.
--4. Display Account No, Customer Name & Amount from DEPOSIT.
--5. Display Loan No, Amount from BORROW.
--6. Display loan details of all customers who belongs to ‘ANDHERI’ branch from borrow table.
--7. Give account no and amount of depositor, whose account no is equals to 106 from deposit table.
--8. Give name of borrowers having amount greater than 5000 from borrow table.
--9. Give name of customers who opened account after date '1-12-96' from deposit table.
--10. Display name of customers whose account no is less than 105 from deposit table.
--11. Display name of customer who belongs to either ‘NAGPUR’ or ‘DELHI’ from customer table. (OR & IN)
--12. Display name of customers with branch whose amount is greater than 4000 and account no is less than
--105 from deposit table.
--13. Find all borrowers whose amount is greater than equals to 3000 & less than equals to 8000 from borrow
--table. (AND & BETWEEN)
--14. Find all depositors who do not belongs to ‘ANDHERI’ branch from deposit table.
--15. Display Account No, Customer Name & Amount of such customers who belongs to ‘AJNI’, ‘KAROLBAGH’
--Or ‘M.G.ROAD’ and Account No is less than 104 from deposit table.


SELECT * FROM DEPOSIT;

SELECT * FROM BORROW;

SELECT * FROM CUSTOMERS;

SELECT ACTNO,CNAME,AMOUNT FROM DEPOSIT;

SELECT LOANNO,AMOUNT FROM BORROW;

SELECT * FROM BORROW WHERE BNAME = 'ANDHERI';

SELECT ACTNO,AMOUNT FROM DEPOSIT WHERE ACTNO = 106;

SELECT CNAME FROM BORROW WHERE AMOUNT > 5000;

SELECT CNAME FROM DEPOSIT WHERE ADATE > '1996-12-01';

SELECT CNAME FROM DEPOSIT WHERE ACTNO < 105;

SELECT CNAME FROM CUSTOMERS WHERE CITY = 'NAGPUR' OR CITY = 'DELHI';

SELECT CNAME FROM CUSTOMERS WHERE CITY IN ('NAGPUR','DELHI');

SELECT CNAME FROM DEPOSIT WHERE AMOUNT > 4000 AND ACTNO < 105;

SELECT CNAME FROM BORROW WHERE AMOUNT >= 3000 AND AMOUNT <= 8000;

SELECT CNAME FROM BORROW WHERE AMOUNT BETWEEN 3000 AND 8000;

SELECT CNAME FROM DEPOSIT WHERE NOT BNAME = 'ANDHERI';

SELECT ACTNO,CNAME,AMOUNT FROM DEPOSIT WHERE BNAME = 'AJNI' OR BNAME = 'KAROLBAGH' OR BNAME = 'M.G. ROAD' AND ACTNO < 104;

--Part B

--1. Display all the details of first five customers from deposit table.
--2. Display all the details of first three depositors whose amount is greater than 1000.
--3. Display Loan No, Customer Name of first five borrowers whose branch name does not belongs to
--‘ANDHERI’ from borrow table.
--4. Retrieve all unique cities using DISTINCT. (Use Customers Table)
--5. Retrieve all unique branches using DISTINCT. (Use Branch Table)


SELECT TOP 5 * FROM DEPOSIT;

SELECT TOP 3 * FROM DEPOSIT WHERE AMOUNT > 1000;

SELECT TOP 5 LOANNO,CNAME FROM BORROW WHERE NOT BNAME = 'ANDHERI';

SELECT DISTINCT CITY FROM CUSTOMERS;

SELECT DISTINCT BNAME FROM BRANCH;

--Part C 

--1. Retrieve top 50% record from table BORROW.
--2. Display top 10% amount from table DEPOSIT.
--3. Display top 25% customer who deposited more than 5000.
--4. Retrieve first 10% Loan Amounts.
--5. Retrieve all unique customer names with city.
--6. Retrieve all Loan records with one more column in Loan Amount as 10% extra amount.
--7. Retrieve all odd/even value loan number from Borrow table.


SELECT TOP 50 PERCENT * FROM BORROW;

SELECT TOP 10 PERCENT AMOUNT FROM DEPOSIT;

SELECT TOP 25 PERCENT CNAME FROM DEPOSIT WHERE AMOUNT > 5000;

SELECT TOP 10 PERCENT AMOUNT FROM DEPOSIT;

SELECT DISTINCT CNAME,CITY FROM CUSTOMERS;

SELECT * , AMOUNT * 1.1 AS EXTRA_AMOUNT FROM BORROW;

SELECT * FROM BORROW WHERE LOANNO % 2 = 0;

SELECT * FROM BORROW WHERE LOANNO % 2 = 1;