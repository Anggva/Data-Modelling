INSERT INTO Section VALUES (31000, 'COP3100', 'MW', '9 am - 12 pm', 'S00000001', 'F20102010');

CREATE TABLE Section(
	SectionNumber INTEGER PRIMARY KEY,
	CourseNumber CHAR(10),
	DaysOfTheWeek CHAR(5),
	Time CHAR(10),
	StudentsEnrolled CHAR(9),
	FacultyTeaching CHAR(9),
	FOREIGN KEY (CourseNumber) REFERENCES Course(CourseNumber),
	FOREIGN KEY (StudentsEnrolled) REFERENCES Student(StudentNumber),
	FOREIGN KEY (FacultyTeaching) REFERENCES Faculty(FacultyNumber)
	);