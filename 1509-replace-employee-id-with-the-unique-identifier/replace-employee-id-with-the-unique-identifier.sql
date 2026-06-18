/* Write your PL/SQL query statement below */
SELECT c1.unique_id, c2.name FROM EmployeeUNI c1 RIGHT JOIN Employees c2 ON c1.id = c2.id;