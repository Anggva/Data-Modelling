--Create Table Statement
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
--add foreign key
ALTER TABLE Faculty
ADD FOREIGN KEY (CoursesTaught)
REFERENCES Course(CourseNumber);


alter table Faculty
drop constraint CoursesTaught_fk;

alter table Section
add constraint FacultyTeaching
foreign key(continent)
references continent
  5    on delete cascade;

alter table FacultyMembers
add PrefFormNumber CHAR(8);