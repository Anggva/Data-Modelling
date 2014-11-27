Data-Modelling
==============


feature/frank
-------------
There are two class files important to the generation of database
 reports, **ReportGen** and **Relationship**. ReportGen does not necessarily
 need Relationship to function, but Relationship is very helpful. In
 that, it can provide statistical functionality (entity counts, query
  speed, and so on) to ReportGen's helper classes if needed.

 ReportGen, as the name implies, prints the reports to the screen. It
 has the final say if and when the report is shown. ReportGen is part
  of a larger console application and can be replaced by a GUI if
  so desired.

  As of 11/27, a helper class called CourseSection is provided to satisfy
  the first Reporting item. It has all of the trimmings of an ordinary class
  with getters and setters. _getDBData()_ is crucial for fetching the rows
   which are then passed upward to ReportGen.

 <h4> ReportGen usage </h4>

To use ReportGen in your console application, place it and all of its helper
classes in the same folder. Since every helper class (for example, CourseSection)
inherits methods from Relationship, Relationship should also be in the same
folder.

Make an instance of ReportGen in your program like so:

```java
ReportGen someReport = new ReportGen();
```

and you're ready to start using ReportGen's methods.

ReportGen's methods require at least two pieces of information, the submenu
option provided by the user and the user's type (S=student, F=faculty, A=admin).
Passing the user type to ReportGen itself is planned, but as of now each method
receives the type.

<h4> DB connectivity notes </h4>
If at any time anyone wishes to make a database connection, you need only make an
instance of DBConnection from any class you want (it doesn't have to be a helper
class for use with ReportGen).

For example:

```java
Connection connection = DBConnection.connect();
```

does the job for you if the class, DBConnection, is found in the working folder.




