# CRUD API for Animal Objects

The REST API performs CRUD operations on Animal objects as described below.

## Installation

### Get the project

1. **Clone the repository**:
   ```bash
   git clone https://github.com/abe-tesfaye/Individual-Assignment-4-CRUD-API.git

2.	Download ZIP (if preferred).

Setup the project

	1.	Open the project in IntelliJ.
	2.	Navigate to the /src/main/resources/application.properties file.
	•	This file contains the configuration for the MySQL database.
	•	Ensure that the database URL, username, and password are correctly set for your local MySQL instance.
	•	The database name should be specified between the last / and the ? in the spring.datasource.url property.
Example:
spring.datasource.url=jdbc:mysql://localhost:3306/f24-340?useSSL=false
spring.datasource.username=root
spring.datasource.password=
3.	Run MySQL:
	•	Start your MySQL server (e.g., via XAMPP or your system service manager).
	•	Ensure the database f24-340 is available.
	4.	Build and run:
	•	Run the main class in IntelliJ to start the Spring Boot application.
	•	Once the application is running, the necessary tables will be created in the database.

API Endpoints

Use POSTMAN to test the following endpoints:

Get list of Animals
	•	Request: GET /f24-340/all
	•	URL: http://localhost:8080/f24-340/all
	•	Response:
 ```bash
 [
  {"animalId": 1, "name": "Lion", "species": "Mammal", "habitat": "Savannah"},
  {"animalId": 2, "name": "Elephant", "species": "Mammal", "habitat": "Grasslands"}
]
```
Get a specific Animal by ID
	•	Request: GET /f24-340/{animalId}
	•	URL: http://localhost:8080/f24-340/1
	•	Response:
```bash
 {
  "animalId": 1,
  "name": "Lion",
  "species": "Mammal",
  "habitat": "Savannah"
}
```

Create a new Animal


	•	Request: POST /f24-340/new
 
	•	URL: http://localhost:8080/f24-340/new
 
	•	Body:
 

 ```bash
 {
  "name": "Killer Whale",
  "species": "Mammal",
  "habitat": "Oceans"
}
```

	•	Response:
 
```bash
 {
  "animalId": 3,
  "name": "Killer Whale",
  "species": "Mammal",
  "habitat": "Oceans"
}
```
Update an existing Animal
	•	Request: PUT /f24-340/update/{animalId}
	•	URL: http://localhost:8080/f24-340/update/1
	•	Body:
```bash
 {
  "name": "Lion Updated",
  "species": "Mammal",
  "habitat": "Savannah"
}
```
	•	Response:
```bash
 {
  "animalId": 1,
  "name": "Lion Updated",
  "species": "Mammal",
  "habitat": "Savannah"
}
```
Delete an existing Animal
	•	Request: DELETE /f24-340/delete/{animalId}
	•	URL: http://localhost:8080/f24-340/delete/1
	•	Response:
```bash
 [
  {"animalId": 2, "name": "Elephant", "species": "Mammal", "habitat": "Grasslands"}
]
```
Search for Animals by species
	•	Request: GET /f24-340/species?species=mammal
	•	URL: http://localhost:8080/f24-340/species?species=mammal
	•	Response:
```bash
 [
  {"animalId": 1, "name": "Lion", "species": "Mammal", "habitat": "Savannah"},
  {"animalId": 2, "name": "Elephant", "species": "Mammal", "habitat": "Grasslands"}
]
```
Search for Animals by name
	•	Request: GET /f24-340/search?name=Lion
	•	URL: http://localhost:8080/f24-340/search?name=Lion
	•	Response:
```bash
 [
  {"animalId": 1, "name": "Lion", "species": "Mammal", "habitat": "Savannah"}
]
```
