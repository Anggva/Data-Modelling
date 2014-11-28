CREATE TABLE Student(StudentNumber CHAR(9) PRIMARY KEY,
	FirstName CHAR(15),
	LastName CHAR(15),
	Semester CHAR(7),
	CoursesNeeded CHAR(10) FOREIGN KEY REFERENCES Courses(CourseNumber),
	PreferredCourseDays CHAR(5),
	PreferredCourseTimes CHAR(25),
	Gender CHAR(1),
	PhoneNumber CHAR(10));