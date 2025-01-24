# Library Management Project

This project is meant to be a program that would process all aspects of managing a library but since this project isn't robust enough nor does it have a GUI, it just simulates such
a managing program and is incomplete.

## Books

Books hold the following properties :
`Name`, `ISBN`, `Author`, `Category`, `Borrower`, `Reservers`

The properties above are self-explanatory, as for the reservers property :

> RESERVERS: a queue that holds the members that wanted to borrow this book but could not due to it being already borrowed.

A book has the functionality to update it's borrower and it's borrowed status. 

## Members

Members represent people who have registered in the library and intend to use the services.
Members have the following properties

`Name`, `MembershipID`, `PhoneNumber`, `SignUpDate`, `SubscriptionStatus`, `SpecialSubscription`, `BorrowedBooks`

> SubscriptionStatus: a boolean value that determines wether the account is active or deactivated.
> SpecialSubscription: a boolean value that determines wether the account as special privileges or not.
> BorrowedBooks: an ArrayList holding the books that the member has currently borrowed.

A normal member can borrow upto six books and special members upto nine books.

Members can borrow books.
Whenever a member tries to borrow a book that has already been borrowed, they are added to the end of the book's reservers queue.

Data concerning each member can be edited post initialization of the account.

## Manager


## Employees


## The library

The library has the following properties:

`Name`, `ID`, `Manager`, `ListOfBooks`, `ListOfEmployees`, `ListOfMembers`

The info concerning the library can not be edited post initialization.

Same goes for the manager of the library.

All the data concerning the library can be viewed at any time

Members, Books and Employees can be added and removed.

Members of the library can be accessed through either their name, membershipID or phoneNumber.

Books that share the same name, category or author can be viewed.

Manager cannot be changed.




