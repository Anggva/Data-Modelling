--Create table Course
CREATE TABLE Course(CourseNumber CHAR(10) PRIMARY KEY,
	CourseRegistrationNumber INTEGER,
	CourseDescription CHAR(100),
	Type CHAR(25),
	CreditHours INTEGER,
	Cost DECIMAL(3,2));
--Add foreign key
ALTER TABLE Course
ADD FOREIGN KEY (CourseRegistrationNumber)
REFERENCES Section(SectionNumber);