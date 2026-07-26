# Write your MySQL query statement below
select name AS Customers from Customers
 where id NOT IN
 (select customerID from Orders);
