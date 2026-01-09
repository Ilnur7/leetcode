
Table: Employee

+-------------+------+
| Column Name | Type |
+-------------+------+
| id          | int  |
| salary      | int  |
+-------------+------+
id is the primary key (column with unique values) for this table.
Each row of this table contains information about the salary of an employee;


SELECT
    (SELECT DISTINCT Salary
     FROM Employee
     ORDER BY Salary DESC
     LIMIT 1 OFFSET 1) AS SecondHighestSalary;

-- How it works
-- SELECT DISTINCT Salary FROM Employee – remove duplicates.
-- ORDER BY Salary DESC – sort salaries from highest to lowest.
-- LIMIT 1 OFFSET 1 – skip the first (highest) salary, take the next one.
-- If no second salary exists, the subquery returns NULL.


SELECT
    MAX(Salary) AS SecondHighestSalary
FROM Employee
WHERE Salary < (SELECT MAX(Salary) FROM Employee);
