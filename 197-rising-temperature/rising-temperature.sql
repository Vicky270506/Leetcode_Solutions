/* Write your PL/SQL query statement below */
SELECT w.id FROM Weather w JOIN Weather b ON w.id != b.id WHERE (w.recordDate - b.recordDate) = 1 AND w.temperature > b.temperature;