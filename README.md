#CRUD Application for Product & Category Management

This project is a Spring Boot application developed as part of a machine test . It implements CRUD operations for Category and Product entities with a One-to-Many relationship, server-side pagination, and properly structured REST APIs.

✅ Machine Test Requirements Implemented

✅ One-to-many relationship between Category and Product

✅ Server-side pagination

✅ Single product details populated with its category

✅ CRUD operations for both entities

✅ Tested using Postman

1️⃣ GitHub Link

[🔗 GitHub Repository](https://github.com/dsarkar6575/Assessment)

2️⃣ How Did You Run the Code?

Clone the repository:

https://github.com/dsarkar6575/Assessment.git
cd Assessment

Configure MySQL Database:
src/main/resources/application.properties:

spring.application.name=nimap-infotech-assessment
spring.datasource.url=jdbc:mysql://localhost:3306/nimap_infotech_assessment
spring.datasource.username=root
spring.datasource.password=1234
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update

Run the application:

mvn spring-boot:run

Test the APIs:

Import Postman collection or manually test endpoints.

Base URL: http://localhost:8080/api/categories
Base URL: http://localhost:8080//api/products


3️⃣ How Did You Run the Machine Test?

Tested endpoints using Postman:

✅ Category APIs

POST /categories – Add new category

GET /categories – Get all categories

GET /categories/{id} – Get category by ID

PUT /categories/{id} – Update category

DELETE /categories/{id} – Delete category

✅ Product APIs

POST /products – Add new product 

GET /products – List products with pagination

Example: /products?page=0

GET /products/{id} – Get product by ID with category details

PUT /products/{id} – Update product

DELETE /products/{id} – Delete product

4️⃣ DB Design

| Table Name | Columns                       | Description                  |
|------------|-------------------------------|------------------------------|
| Category   | id (PK), name, description    | Stores product categories     |
| Product    | id (PK), name, price, category_id (FK) | Stores products with category reference |


📁 Folder Structure

src/main/java/com/nimap/
├── config/
│   └── ModelMapperConfig.java                  
├── controller/
│   ├── CategoryController.java                 
│   └── ProductController.java                  
├── dto/
│   ├── CategoryDto.java                       
│   └── ProductDto.java                        
├── exception/
│   └── ResourceNotFoundException.java         
├── model/
│   ├── Category.java                          
│   └── Product.java                           
├── repository/
│   ├── CategoryRepository.java                 
│   └── ProductRepository.java                  
├── service/
│   ├── CategoryService.java                    
│   ├── ProductService.java                    
│   └── impl/
│       ├── CategoryServiceImpl.java            
│       └── ProductServiceImpl.java            
└── NimapInfotechAssessmentApplication.java                      




✅ Tech Stack

Java 24
Spring Boot 3
Spring Data JPA
Hibernate
MySQL
Maven
Postman
