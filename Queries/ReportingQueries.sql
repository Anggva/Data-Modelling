--Show all existing courses
SELECT * FROM Courses;

--Show all existing sections
SELECT * FROM Sections;

--Show courses on a specific day
SELECT *
FROM Sections
WHERE DaysOfTheWeek=ourDaysVar;

--Show courses with the specific time
SELECT *
FROM Sections
WHERE Time=ourTimeVar;

--show all faculty members
SELECT * FROM Faculty;