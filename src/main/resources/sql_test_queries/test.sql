-- this query should give you the students attending the "Intro To Progamming Course"
select s.student_id, s.first_name, s.last_name, 
		i.education_title as instructor_title, i.first_name as instructor_name, i.last_name as instructor_surname
from students s
join enrollments e on s.student_id = e.student_id
join courses c on e.course_id = c.course_id
join instructors i on c.instructor_id = i.instructor_id
where c.course_id = 110;