# Tech Akademia

Tech Akademia is a Student Management System developed to showcase my skills in Java and SQL. This project represents a significant milestone in my journey to becoming a software engineer. It implements CRUD operations and leverages various technologies, including Maven, Plain Old Java Objects (POJO), PostgreSQL, and JUnit for testing.

## Features

- **Student Management**: Create, read, update, and delete student records.
- **Database Integration**: Robust integration with a PostgreSQL database.
- **Testing Suite**: Comprehensive unit testing using JUnit.
- **Maven Project Structure**: Organized and managed dependencies using Maven.
- **Well-Documented Code**: Clear and concise documentation for maintainability and scalability.

## Technologies Used

- **Java**: Core programming language for the application.
- **SQL**: Used for database design and management.
- **PostgreSQL**: Relational database system.
- **Maven**: Build automation and dependency management.
- **JUnit**: Unit testing framework.

## Getting Started

### Prerequisites

- **Java Development Kit (JDK)** 8 or higher
- **Maven**
- **PostgreSQL**

### Installation

1. Clone this repository:
   ```bash
   git clone https://github.com/your-username/tech-akademia.git
   ```
2. Navigate to the project directory:
   ```bash
   cd tech-akademia
   ```
3. Set up the PostgreSQL database:
    - Create a database named `tech_akademia`.
    - Execute the SQL scripts in the `resources/sql_files` folder to set up tables.
4. Configure the database connection in the `application.properties` file:
   ```properties
   db.url=jdbc:postgresql://localhost:5432/tech_akademia
   db.username=your_username
   db.password=your_password
   ```
5. Build the project using Maven:
   ```bash
   mvn clean install
   ```
6. Run the application:
   ```bash
   java -jar target/tech-akademia.jar
   ```

### Running Tests

To run the test suite, use the following command:
```bash
mvn test
```

## Project Structure

```
tech-akademia
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.teckakademia
│   │   │       ├── config
│   │   │       ├── dao (data access object)
│   │   │       ├── model
│   │   │       ├── service
|   |   |       ├── userinterface
|   |   |       ├── util
|   |   |       └── App
│   │   └── resources
│   │       └── database_configuration
│   │       └── sql_files
│   └── test
│       └── java
│           └── com.techakademia
|               └── dao
├── pom.xml
└── README.md
```

## Contribution

Contributions are welcome! Feel free to fork this repository and submit pull requests. For major changes, please open an issue first to discuss what you would like to change.

## Acknowledgments

- To all mentors, educators, and peers who have guided me through my journey into software engineering.
- Special thanks to the open-source community for providing tools and resources.


Thank you for checking out Tech Akademia! I hope this project serves as a testament to my skills and dedication to becoming a proficient software engineer.


**;-) Mbonisi Mpala**