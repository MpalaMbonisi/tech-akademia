-- view student info by student_id
select first_name, last_name, email, date_of_birth, date_enrolled
from students
where student_id = 40000;

-- view all students 
select first_name, last_name, email, date_of_birth, date_enrolled
from students

-- view courses enrolled by each student 
select course_name as course_enrolled, description
from students s
join enrollments e on s.student_id = e.student_id
join courses c on c.course_id = e.course_id
where s.student_id = 40000; 

-- view all courses 
select course_name, description, credits, i.education_title as instructor_title, 
		i.first_name as instructor_name, i.last_name as instructor_surname, i.email
from courses c
join instructors i on c.instructor_id = i.instructor_id;

-- view course info by course_id
select course_name, description, credits, i.education_title as instructor_title, 
		i.first_name as instructor_name, i.last_name as instructor_surname, i.email
from courses c
join instructors i on c.instructor_id = i.instructor_id
where c.course_id = 125;

-- view all instructors 
select education_title as title, first_name, middle_name, last_name, email
from instructors;

-- view instructor by id 
select education_title as title, first_name, middle_name, last_name, email
from instructors
where instructor_id = 10015;
