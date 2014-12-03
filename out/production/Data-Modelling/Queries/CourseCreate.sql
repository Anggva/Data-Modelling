--Create table Course
CREATE TABLE Courses(CourseNumber CHAR(10) PRIMARY KEY,
	CourseDescription CHAR(100),
	Type CHAR(25),
	CreditHours INTEGER,
	Cost DECIMAL(6,2),
	Semester CHAR(6)
	);