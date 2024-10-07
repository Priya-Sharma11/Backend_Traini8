
# Backend_Traini8_Project
## Training Center API

This is a Spring Boot application that manages training center information.

## Technologies Used
- Java 17
- Spring Boot
- Spring Data JPA
- MySQL
- Maven

### Prerequisites
- Java 17
- MySQL Server
- Maven

### Steps to Set Up
1. **Clone the repository:**
   git clone https://github.com/your-username/Backend_Traini8.git
   cd Backend_Traini8
2. Configure MySQL Database
* Start your MySQL service and create a new database: CREATE DATABASE training_center_db;

3. Update the database configuration in src/main/resources/application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/training_center_db
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD

4. Build the project: mvn clean install

5. Run the application: mvn spring-boot:run

After successfully running the project, the APIs will be available at:
* http://localhost:8080/

## API Endpoints
1. Create a Training Center (POST)
   * **URL:** /api/training-centers
   * **Method:** POST
   * **Content-Type:** application/json
   * **Body:**
   ```{
   "name": "Center 1",
   "city": "New York",
   "state": "NY",
   "studentCapacity": 100,
   "coursesOffered": ["Java", "Spring Boot", "Microservices"],
   "contactEmail": "contact@center1.com",
   "contactPhone": "1234567890"
   }

2. Get All Training Centers (GET)
   * **URL:** /api/training-centers
   * **Method:** GET
   * **Response:** Returns the list of all saved training centers.

3. **Filter Training Centers (GET)**
    * URL: /api/training-centers/filter
    * Method: GET
    * Query Parameters:
      * city: (optional) Filter by city.
      * state: (optional) Filter by state.
      * course: (optional) Filter by course offered.

* Example:
   GET http://localhost:8080/api/training-centers/filter?city=New%20York&course=Java

Testing the API
You can use tools like Postman or curl to test the API endpoints.
