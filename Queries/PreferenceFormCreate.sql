CREATE TABLE PreferenceForm(
	FormNumber CHAR(8) PRIMARY KEY,
	FacultyNumber CHAR(9),
	Semester CHAR (12),
	NumberOfCourses INTEGER,
	CoursePrefImportance INTEGER,
	DaysImportance INTEGER,
	TimesImportance INTEGER,
	CoursePref1 INTEGER,
	CoursePref2 INTEGER,
	CoursePref3 INTEGER,
	MorningPref INTEGER,
	DayPref INTEGER,
	EveningPref INTEGER,
	SummerPref CHAR(15));

alter table PreferenceForm
add constraint fk_FacultyNumber
foreign key(FacultyNumber)
references FacultyMembers(FacultyNumber)
on delete cascade;