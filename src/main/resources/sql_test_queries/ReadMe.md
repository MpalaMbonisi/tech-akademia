# Tech Akademia System Database Setup Guide

This guide provides detailed steps to set up the PostgreSQL database for the Tech Akademia System using **pgAdmin 4**. Follow these instructions to create the database, load the schema, and populate initial data.

---

## Prerequisites

- **pgAdmin 4**: Ensure that **pgAdmin 4** is installed and connected to your PostgreSQL server.
- **SQL Files** located in `resources/sql_test_queries`:
    - `create_all_tables.sql`: Creates all required tables for the application.
    - `populate_courses.sql`: Inserts data into the `courses` table.
    - `populate_enrollments.sql`: Inserts data into the `enrollments` table.
    - `populate_instructors.sql`: Inserts data into the `instructors` table.
    - `populate_students.sql`: Inserts data into the `students` table.

---

## Step 1: Open pgAdmin and Connect to the Server

1. **Launch pgAdmin 4** and log in.
2. In the **Object Browser** (left sidebar), expand **Servers** and locate your PostgreSQL server.
3. Expand **Databases** to view the list of available databases.

---

## Step 2: Create the Database

1. Right-click on **Databases**, select **Create > Database...**.
2. Name the new database **tech_akademia_system**, then click **Save**.

---

## Step 3: Open the Query Tool

1. Right-click on the `tech_akademia_system` database and select **Query Tool**.
2. This opens the query editor where SQL commands can be executed.

---

## Step 4: Execute SQL Files to Create and Populate Tables

1. **Create All Tables**:
    - In the **Query Tool**, click **File > Open File...**.
    - Navigate to `resources/sql_test_queries/create_all_tables.sql` and open it.
    - Click **Execute** (or press `F5`) to create the tables.

2. **Populate Tables**:
    - Following the table creation, load each of the following SQL files in order and execute them:
        - `populate_instructors.sql`
        - `populate_students.sql`
        - `populate_courses.sql`
        - `populate_enrollments.sql`

---

## Step 5: Verify Database Structure and Data

1. Load and execute the `test.sql` file to confirm the data structure.
2. The following output should be displayed:

| student_id | first_name | last_name | instructor_title | instructor_name | instructor_surname |
|------------|------------|-----------|------------------|-----------------|---------------------|
| 40000      | Anna       | Kowalski  | PhD             | Andrzej         | Kowalski           |

---

This setup will prepare the **Tech Akademia System** database with all necessary tables and initial data for use within the application.