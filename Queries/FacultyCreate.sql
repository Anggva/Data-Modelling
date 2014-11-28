--Create Table Statement
CREATE TABLE Faculty(FacultyNumber CHAR(9) PRIMARY KEY,
	FirstName CHAR(15),
	LastName CHAR(15),
	Position CHAR(20),
	AreaOfExpertise CHAR(20),
	CoursesTaught CHAR(10) FOREIGN KEY REFERENCES Courses(CourseNumber),
	PreferredCourseDays CHAR(5),
	PreferredCourseTimes CHAR(25),
	Gender CHAR(1),
	PhoneNumber CHAR(10),
	isAdministrator CHAR(1),
	Password CHAR(15)
	);