--show Faculty table
SELECT ALL* FROM Faculty;

--see courses requested by a student
SELECT StudentNumber, CoursesNeeded, Semester, PreferredCourseDays, PrefereredCourseTimes
FROM Student
WHERE StudentNumber=SN;