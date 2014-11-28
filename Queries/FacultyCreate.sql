--Create Table Statement
CREATE TABLE Faculty(
	FacultyNumber CHAR(9) PRIMARY KEY,
	FirstName CHAR(15),
	LastName CHAR(15),
	Position CHAR(20),
	AreaOfExpertise CHAR(20),
	CoursesTaught CHAR(10),
	PreferredCourseDays CHAR(5),
	PreferredCourseTimes CHAR(25),
	Gender CHAR(1),
	PhoneNumber CHAR(10),
	isAdministrator CHAR(1),
	Password CHAR(15),
	FOREIGN KEY (CoursesTaught) REFERENCES Course(CourseNumber)
	);
--add foreign key
ALTER TABLE Faculty
ADD FOREIGN KEY (CoursesTaught)
REFERENCES Course(CourseNumber);