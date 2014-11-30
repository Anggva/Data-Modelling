CREATE TABLE Students(StudentNumber CHAR(9) PRIMARY KEY,
	FirstName CHAR(15),
	LastName CHAR(15),
	Semester CHAR(7),
	PreferredCourseDays CHAR(5),
	PreferredCourseTimes CHAR(25),
	Gender CHAR(1),
	PhoneNumber CHAR(10)
	);

CREATE TABLE StCourses (
	StudentNumber CHAR(9),
	CoursesNeeded CHAR(10)
);

ALTER TABLE StCourses
ADD CONSTRAINT fk_Courses
FOREIGN KEY(CoursesNeeded)
REFERENCES Courses(CourseNumber)
ON DELETE CASCADE;

ALTER TABLE StCourses
ADD CONSTRAINT fk_Students
FOREIGN KEY(StudentNumber)
REFERENCES Students(StudentNumber)
ON DELETE CASCADE;