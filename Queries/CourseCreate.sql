CREATE TABLE Course(CourseNumber CHAR(10) PRIMARY KEY,
	CourseRegistrationNumber INTEGER FOREIGN KEY REFERENCES Section(SectionNumber),
	CourseDescription CHAR(100),
	Type CHAR(25),
	CreditHours INTEGER,
	Cost DECIMAL(3,2));