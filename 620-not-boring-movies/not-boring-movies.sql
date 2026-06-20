/* Write your PL/SQL query statement below */
SELECT * FROM Cinema WHERE MOD(id, 2) = 1 AND TRIM(description) <> 'boring' ORDER BY rating DESC;