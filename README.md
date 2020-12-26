# Brickbuster Classic Video and Video Game Rentals API 

<h4>DESCRIPTION</h4>

This is an application programming interface that is made to replicate the classic movie store front.

When interfacing with the application, employees for our fictitious store known as Brickbuster can add new movie and video game entries into the database. These articles can be subsequently rented out to members in the system, thereby creating a new rental record in the database. Each member is assigned a subscription level when they sign up and are allotted a discount based on their membership tier: BASIC, GOLD, or SUPERSTAR. The database also holds records for employees. 


The application is written in Java, with a connection to a database where the data is stored. The database was created using Hibernate and is used to read, create, update, and delete records for the following entities:

 - Employees
 - Members
 - Movies
 - VideoGames
 - Rentals

Postman is used to send HTTP requests to the database to perform the functions described above.

![Screenshot](!!!folder location here!!!)

DISPLAY ALL RENTALS IN DATABASE

![Screenshot](!!!folder location here!!!)

<h4> FUTURE DEVELOPMENT </h4>
Future improvements include the ability to assign a commission for the employee that generates a rental. Each employee is currently assigned a commission level when added to the employee table: ENTRYLEVEL, INTERMEDIATE, or SENIOR. A commissions entity has been created, but the functionality to generate the commission for each rental has yet to be implemented.

<h4> PROJECT REQUIREMENTS </h4>
This application was created as a team project for the Promineo Tech Boot Camp final project. The bootcamp covered Java, MySQL, and SpringBoot 2.0. 
The project requirements are below.

- Contain at least five entities
- Contain all CRUD operations
- Contain at least one one-to-many relationship
- Contain at least one many-to-many relationship
- Contain different application layers, including at least controller, service, and repository

 
