--See all students
SELECT * FROM Students;

--Create a new student entry
INSERT INTO Students									
VALUES(newSNumber, newFirstName, newLastName, newSemester, newDays, newTime, newGender, newPhoneNumber);

--see courses requested by a student
SELECT StudentNumber, CoursesNeeded
FROM StCourses
WHERE StudentNumber=ourStudentVar;

--see prefered days and times by a student
SELECT StudentNumber, PreferredCourseDays, PreferredCourseTimes
FROM Students
WHERE StudentNumber=ourStudentVar;

--see term schedule by a student
SELECT SectionNumber, CourseNumber, DaysOfTheWeek, StudentEnrolled
FROM Sections, StSection
WHERE StudentEnrolled=ourStudentVar AND SectionNumber=StSection.Section;