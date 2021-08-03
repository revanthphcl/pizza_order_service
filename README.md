# pizza_order_service

## Description
 This is a practice project creating an online pizzeria website for customers and managers, using Spring, MySQL
 
### How to use
At this stage, the application requires a local MySQL database. To ensure full functionality, start the MySQL server and run the following commands.
The url for all endpoints begins with /pizzeria/, when you're consuming endpoints the url should look like localhost:8080/pizzeria/{endpoint}
```
create database pizzeria;
create user 'pizzauser'@'%' identified by 'secretPass';
grant all on pizzeria.* to 'pizzauser'@'%';
```


#### Dummy Data
Run a ciean install with the project to set up the table(s) in the database, then run the data.sql to populate them with dummy data.