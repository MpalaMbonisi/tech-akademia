-- This query should give you the students attending the "Intro To Programming Course"
SELECT s.student_id, s.first_name, s.last_name,
       i.education_title AS instructor_title, i.first_name AS instructor_name, i.last_name AS instructor_surname
FROM students s
         JOIN enrollments e ON s.student_id = e.student_id
         JOIN courses c ON e.course_id = c.course_id
         JOIN instructors i ON c.instructor_id = i.instructor_id
WHERE c.course_id = 110;

-- outcome : [40000] Anna Kowalski and [40002] Piotr Nowak with instructor Msc. Anna Nowak
