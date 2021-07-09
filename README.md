# IShop-Java
Course project

This project is written using these tecnologies:
Database: 
  Mysql;
  
JDBC:
  JDBCTemplate;

Main language:
  Java;

Project-builder:
  Maven;

Security:
  Spring-security;

Framework:
  Spring;

Project includes:
  - Product categories. The administrator can add, remove and change categories
  - List of products in each category. The administrator can add and remove products in categories
  - Product information page includes name, photo, product description and price. The administrator can change the product information
  - On the pages of categories and products, there is an add to basket button
  - The basket contains a list of products, the number of units of each product, the total cost of the order and the submit button
  - Upon successful submit, the administrator receives a notification by email (I used org.springframework.mail.javamail.JavaMailSenderImpl; ). The administrator must see all orders in the admin panel.
  
 Also I added different dunctionality, e.g. updating account information, deleting basket or updating order status for the administrator.
