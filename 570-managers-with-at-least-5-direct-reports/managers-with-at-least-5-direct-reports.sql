# Write your MySQL query statement below
select e1.name 
from employee e1
where e1.id in 
(select e1.managerId 
 from employee e1
 group by e1.managerId
 having count(e1.managerId) >= 5
);