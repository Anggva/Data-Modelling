INSERT INTO Faculty 
VALUES (‘facultynumber’, ‘firstname’, ‘lastname’, ‘position’, ‘areaofexpertise’, ‘coursestaught’, ‘MW/MWF/TH’,  ‘Morning (9 am – Noon)/Afternoon (Noon – 4:15 pm)/Evening (4:30 pm – 9:10 pm)’, ‘M/F’, ‘phonenumber’, ‘Y/N’);


CREATE TABLE FacultyMembers(
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
	Password CHAR(15)
	);


	FOREIGN KEY (CoursesTaught) REFERENCES Course(CourseNumber)


INSERT INTO faculty
VALUES ('F20102010', 'Bilbo', 'Baggins', 'Professor', 'Computer Science', 'COP3100', 'MW', '9 am - 12 pm', 'M', '9041110000', 'N', 'qwerty');