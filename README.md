# Library Management Project

This project is meant to simulate a program that would process all aspects of managing a library but since this project isn't robust enough nor does it have a GUI, it just simulates such
a managing program.

## Books

Books hold the following properties :
`Name` , `ISBN` , `Author` , `Category`, `Borrower` , `Reservers`

The properties above are self-explanatory, as for the reservers property :

> RESERVERS: a queue that holds the members that wanted to borrow this book but could not due to it being already borrowed.

A book has the functionality to update it's borrower and it's borrowed status. 

## Members

Members represent people who have registered in the library and intend to use the services.
Members have the following properties

## The library

The library has the following properties:

`Name` , `ID` , `Manager` , `ListOfBooks` , `ListOfEmployees` , `ListOfMembers`

