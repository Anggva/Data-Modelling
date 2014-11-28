CREATE TABLE Section(
	SectionNumber INTEGER PRIMARY KEY,
	CourseNumber CHAR(10) FOREIGN KEY REFERENCES Courses(CourseNumber),
	DaysOfTheWeek CHAR(5),
	Time CHAR(10),
	StudentsEnrolled CHAR(9) FOREIGN KEY REFERENCES Students(StudentNumber),
	FacultyTeaching CHAR(15) FOREIGN KEY REFERENCES Faculty(FacultyNumber)
	);