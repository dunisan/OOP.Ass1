# OOP.Assignment1
The project is part of  OOP course. 

In this project we are implementing and practicing the ‘observer’ design pattern. 
We will have an admin that holds an UndoableStringBuilder object, and we have the members that
observe the status of the undoableStringBuilder object status. 
The job of the admin is to notify the members in any change of the undoableStringBuilder. 
****
## Observer design pattern
Observer is a behavioral design pattern that lets you define a subscription mechanism to notify multiple objects about any events that happen to the object they’re observing.
****
## Deeply into the project

### The classes

In the project we have 5 classes.

* The undoableStringBuilder class: 
*the class was implemented in the first OOP assignment,
and adds to the stringBuilder original class - the undo operation*

For the admin side we have 2 classes: 
* The **sender** interface class
* The **GroupAdmin** class that implements the Sender interface: 
*The admin uses a linked list as a data structure for saving the members*

For the members side we have 2 classes: 
* The **Member** inteface class
* The **concreteMember** class that implements the Member interface

Another important class is the **Tests** class, 
that provides tests on the methods of the groupAdmin, and concrete member classes.
***

## How to Install and Run the Project
The project is java written.
For running it you need to download the pom.Xml file and run it as a project. 


****



#### licenses 
* authors:  Daniel Schneiderman && Tuvia Smadar
* version 1.0
* since   2022-28-12


