# pizza_order_service

## Description
 This is a practice project creating an online pizzeria website for customers and managers, using Spring, MySQL
 
### How to use
At this stage, the application requires a local MySQL database. To ensure full functionality, start the MySQL server and run the following commands.

```
create database pizzeria;
create user 'pizzauser'@'%' identified by 'secretPass';
grant all on pizzeria.* to 'pizzauser'@'%';
```