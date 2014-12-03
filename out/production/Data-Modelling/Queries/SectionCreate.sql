CREATE TABLE Sections(
	SectionNumber INTEGER PRIMARY KEY,
	CourseNumber CHAR(10),
	DaysOfTheWeek CHAR(5),
	Time CHAR(10),
	FacultyTeaching CHAR(9)
	);


ALTER TABLE Sections
ADD CONSTRAINT fk_FacultyTeaching
FOREIGN KEY(FacultyTeaching)
REFERENCES FacultyMembers(FacultyNumber)
ON DELETE CASCADE;

ALTER TABLE Sections
ADD CONSTRAINT fk_Course
FOREIGN KEY(CourseNumber)
REFERENCES Courses(CourseNumber)
ON DELETE CASCADE;

CREATE TABLE StudentsSections(
	Section INTEGER,
	StudentEnrolled CHAR(9),
	Course CHAR(10),
	Faculty CHAR(9)
);

ALTER TABLE StudentsSections
ADD CONSTRAINT fk_Student
FOREIGN KEY(StudentEnrolled)
REFERENCES Students(StudentNumber)
ON DELETE CASCADE;

ALTER TABLE StudentsSections
ADD CONSTRAINT fk_Section
FOREIGN KEY(Section)
REFERENCES Sections(SectionNumber)
ON DELETE CASCADE;

ALTER TABLE StudentsSections
ADD CONSTRAINT fk_SCourse
FOREIGN KEY(Course)
REFERENCES Courses(CourseNumber)
ON DELETE CASCADE;

ALTER TABLE StudentsSections
ADD CONSTRAINT fk_SFaculty
FOREIGN KEY(Faculty)
REFERENCES FacultyMembers(FacultyNumber)
ON DELETE CASCADE;