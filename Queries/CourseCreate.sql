--Create table Course
CREATE TABLE Courses(CourseNumber CHAR(10) PRIMARY KEY,
	CourseRegistrationNumber INTEGER,
	CourseDescription CHAR(100),
	Type CHAR(25),
	CreditHours INTEGER,
	Cost DECIMAL(6,2));
--Add foreign key
ALTER TABLE Course
ADD FOREIGN KEY (CourseRegistrationNumber)
REFERENCES Section(SectionNumber);
--Drop foreign key
ALTER TABLE Course
DROP CONSTRAINT fk_COURSEREGISTRATIONNUMBER;

SELECT constraint_name, 
       constraint_type 
FROM   all_constraints 
WHERE  table_name = 'Course'; 




SELECT dc.constraint_name, dc.constraint_type, dc.owner, dc.table_name
FROM dba_cons_columns dcc 
JOIN dba_constraints dc ON (dcc.constraint_name = dc.r_constraint_name and dc.owner = dcc.owner)
WHERE dcc.table_name = 'COURSE';


SELECT c.constraint_name,
	c.constraint_type,
	c.table_name,
	o.column_name
	FROM user_constraints c, user_cons_columns o
	WHERE o.constraint_name = c.constraint_name AND c.table_name LIKE 'Course%'
	ORDER BY c.table_name, c.constraint_type;


SELECT *
  FROM ALL_CONS_COLUMNS
 WHERE table_name = 'Course';
