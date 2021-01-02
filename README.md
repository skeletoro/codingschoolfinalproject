# Brickbuster Classic Video and Video Game Rentals API 

<h4>DESCRIPTION</h4>

This is an application programming interface made to replicate the classic brick and mortar movie rental store front.

When interfacing with the application, employees for our fictitious store known as Brickbuster can add new movie and video game entries into the database. These articles can be subsequently rented out to members in the system, thereby creating a new rental record in the database. The rental record includes the rental date, the date the rental is due back, a list of the movies or video games rented, and also calculates the invoice total. Each member is assigned a subscription level when they sign up and are allotted a discount based on their membership tier: BASIC, GOLD, or SUPERSTAR. The database also holds records for employees of the rental store. 


The application is written in Java, with a connection to a database where the data is stored. The database was created using Hibernate and is used to read, create, update, and delete records for the following entities:

 - Employees
 - Members
 - Movies
 - VideoGames
 - Rentals

<h4>FUNCTIONALITY</H4>
Postman is used to send HTTP requests to the database to perform the functions described above. 

<h5>Rentals</h5>

<h6>1. Create a new movie rental record </h6>

	POST: /rentals/movies/members/{memberId}

<h6>2. Create a new video game rental record </h6>

	POST: /rentals/videogames/members/{memberId}

<h6>3. Access a list of all rental records </h6>

	GET: /rentals
	
<h6>4. Update the status of a rental</h6>

	POST: /rentals/{rentalId}
	
<h6>5. Delete a rental</h6>

	DELETE: /rentals/{rentalId}

<h5>Movies</h5>
	
<h6>1. Create a new movie record</h6>

	POST: /movies
	
<h6>2. Access a list of all movie records and their information </h6>

	GET: /movies
	
<h6>3. Update a movie record</h6>

	PUT: /movies/{movieId}
	
<h6>4. Delete a movie record</h6>

	DELETE: /movies/{movieId}
	
<h5>Video Games</h5>
	
<h6>1. Create a new videoGame record </h6>

	POST: /videoGames
	
<h6>2. Access a list of all video game records and their information </h6>

	GET: /videoGames
	
<h6>3. Update a video game record</h6>

	PUT: /videoGames/{videoGameId}
	
<h6>4. Delete a video game record</h6>

	DELETE: /videoGames/{videoGameId}	
	
<h5>Members</h5>
	
<h6>1. Create a new member </h6>

	POST: /members
	
<h6>2. Access a specific member's information </h6>
	
	GET: /members/{memberId}
	
<h6>3. Access a list of all members' information </h6>

	GET: /members
	
<h6>4. Update a member</h6>

	PUT: /members/{memberId}
	
<h6>5. Delete a member</h6>

	DELETE: /members/{memberId}	
	
<h5>Employees</h5>
	
<h6>1. Create a new employee </h6>

	POST: /employees
	
<h6>2. Access a specific employee's information </h6>
	
	GET: /employees/{employeeId}
	
<h6>3. Access a list of all employees' information </h6>

	GET: /employees
	
<h6>4. Update an employee</h6>

	PUT: /employees/{employeeId}
	
<h6>5. Delete an employee</h6>

	DELETE: /employees/{employeeId}
	
<h5>POSTMAN SCREEN SHOT EXAMPLES</h5>

<h6>Create an employee</h6>

![Screenshot](https://github.com/skeletoro/codingschoolfinalproject/blob/main/Screen%20Shots/Create%20Employee.jpg)

<h6>Delete a video game record</h6>

![Screenshot](https://github.com/skeletoro/codingschoolfinalproject/blob/main/Screen%20Shots/Delete%20Video%20Game.jpg)

<h6>Display all rental records in database</h6>

![Screenshot](https://github.com/skeletoro/codingschoolfinalproject/blob/main/Screen%20Shots/Get%20Rentals.jpg)

<h6>Update a rental status</h6>

![Screenshot](https://github.com/skeletoro/codingschoolfinalproject/blob/main/Screen%20Shots/Update%20Rental.jpg)

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

 
