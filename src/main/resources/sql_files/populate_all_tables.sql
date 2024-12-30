-- Please execute the whole code at once ;-)

-- add students
-- DELETE FROM students;
INSERT INTO students (student_id, first_name, middle_name, last_name, email, date_of_birth)
VALUES
    (40000, 'Anna', 'Maria', 'Kowalski', 'akowalski01@stu.techakademia.edu.pl', '1998-04-25'),
    (40002, 'Piotr', null, 'Nowak', 'pnowak02@stu.techakademia.edu.pl', '2000-11-14'),
    (40004, 'Katarzyna', 'Elzbieta', 'Zielinska', 'kzielinska03@stu.techakademia.edu.pl', '1999-08-10'),
    (40006, 'Jan', 'Pawel', 'Wojcik', 'jwojcik04@stu.techakademia.edu.pl', '2001-01-20'),
    (40008, 'Marek', null, 'Wisniewski', 'mwisniewski05@stu.techakademia.edu.pl', '2002-07-07'),
    (40010, 'Ewa', 'Aleksandra', 'Kaminska', 'ekaminska06@stu.techakademia.edu.pl', '1997-12-05'),
    (40012, 'Tomasz', null, 'Krawczyk', 'tkrawczyk07@stu.techakademia.edu.pl', '2001-06-17')
;

-- add instructors
-- DELETE FROM instructors;
INSERT INTO instructors (
    instructor_id, first_name, middle_name, last_name, email, education_title
) VALUES
      (1000, 'Andrzej', 'Piotr', 'Kowalski', 'akowalski02@stu.techakademia.edu.pl', 'PhD'),
      (1005, 'Anna', 'Maria', 'Nowak', 'anowak15@stu.techakademia.edu.pl', 'MSc'),
      (1010, 'Marek', 'Jan', 'Wójcik', 'mwojcik23@stu.techakademia.edu.pl', 'MSc'),
      (1015, 'Zofia', 'Ewa', 'Wiśniewska', 'zwisniewska08@stu.techakademia.edu.pl', 'PhD'),
      (1020, 'Tomasz', 'Krzysztof', 'Lewandowski', 'tlewandowski34@stu.techakademia.edu.pl', 'MSc'),
      (1025, 'Ewa', 'Joanna', 'Kamińska', 'ekaminska27@stu.techakademia.edu.pl', 'BSc'),
      (1030, 'Piotr', 'Adam', 'Zieliński', 'pzielinski11@stu.techakademia.edu.pl', 'PhD'),
      (1035, 'Katarzyna', 'Małgorzata', 'Mazur', 'kmazur19@stu.techakademia.edu.pl', 'MSc'),
      (1040, 'Jan', 'Paweł', 'Kwiatkowski', 'jkwiatkowski03@stu.techakademia.edu.pl', 'BSc'),
      (1045, 'Magdalena', 'Agnieszka', 'Szymańska', 'mszymanska47@stu.techakademia.edu.pl', 'PhD')
;

-- add courses
-- DELETE FROM courses;
INSERT INTO courses (course_id, course_name, description, credits, instructor_id)
VALUES
    (100, 'Introduction to Programming', 'Basic principles of programming using Python.', 4, 1000),   -- Andrzej Kowalski
    (110, 'Data Structures', 'An in-depth look into data organization, storage, and algorithms.', 3, 1005),  -- Anna Nowak
    (120, 'Database Systems', 'Study of database design, implementation, and management.', 3, 1010),  -- Marek Wójcik
    (130, 'Web Development', 'Introduction to web technologies including HTML, CSS, and JavaScript.', 4, 1015),  -- Zofia Wiśniewska
    (140, 'Cybersecurity Basics', 'Overview of cybersecurity threats and protection measures.', 3, 1020),  -- Tomasz Lewandowski
    (150, 'Machine Learning', 'Introduction to machine learning algorithms and data science.', 5, 1025),  -- Ewa Kamińska
    (160, 'Network Fundamentals', 'Fundamentals of computer networks and internet technologies.', 3, 1030) -- Piotr Zieliński
;

-- add enrollments
-- DELETE FROM enrollments;
INSERT INTO enrollments (student_id, course_id, date_enrolled)
VALUES
    (40000, 100, '2023-09-02'),  -- Anna Kowalski enrolled in Introduction to Programming
    (40002, 110, '2023-09-03'),  -- Piotr Nowak enrolled in Data Structures
    (40004, 120, '2023-09-04'),  -- Katarzyna Zielinska enrolled in Database Systems
    (40006, 130, '2023-09-05'),  -- Jan Wojcik enrolled in Web Development
    (40008, 140, '2023-09-06'),  -- Marek Wisniewski enrolled in Cybersecurity Basics
    (40010, 150, '2023-09-07'),  -- Ewa Kaminska enrolled in Machine Learning
    (40012, 160, '2023-09-08'),  -- Tomasz Krawczyk enrolled in Network Fundamentals
    (40000, 110, '2023-09-09'),  -- Anna Kowalski also enrolled in Data Structures
    (40004, 130, '2023-09-10') -- Katarzyna Zielinska also enrolled in Web Development
;
