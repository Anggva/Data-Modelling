--Delete student entry
DELETE FROM Student
WHERE StudentNumber=OurValue;

--Add a new user
INSERT INTO FacultyMembers
VALUES (newFacultyNumber, newFirstName, newLastName, newPosition, newAreaOfExpertise,
	newDays, newTimes, newGender, newPhone, newPriveleges, newPassword);

--Update priveleges
UPDATE FacultyMembers
SET isAdministrator=newValue
WHERE FacultyNumber=ourFacultyVar;

--Update password
UPDATE FacultyMembers
SET Password=newValue
WHERE FacultyNumber=ourFacultyVar;