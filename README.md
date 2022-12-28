# OOP.Assignment2

In this project we are implementing and practicing the ‘observer’ design pattern. 
We have an admin that holds an UndoableStringBuilder, and we have the members that know what is the status of the string builder. 
The job of the admin is to notify the members in any change of the undoableStringBuilder. 

## Deeply into the project

In the project we have 6 classes.

**for the admin
1. An interface class called **Sender** - contains all the method that are needed for managing the Undoable String Builder
2. The **GroupAdmin** class that implements the Sender interface - the group admin holds the list of members and the status of the string builder
3. The **GroupAdminTest** - contains tests for the Group Admin class. 
**for the observers(members)
4. An inteface class called **Member** - contain the update method. 
5. The **concreteMember** class that implements the Member interface - that implements the update method for the members (and inheirtace a toString)
6. The **concreteMemberTest** - contains tests for the concreteMember class. 

7. The **UndoableStringBuilder** class 


To get to the UndoableStringBuilder, GroupAdmin, ConcreteMember and the interfaces we will get int /src/main/java/observer
To get the tests we will get into src/test/java/observer 

## How to Install and Run the Project
The project is java wirtten.
For running it you need to download the files, 
and run it in a java IDE. 




#### licenses 
authors  Daniel Schneiderman && Tuvia Smadar
version 1.0
since   2022-28-12
