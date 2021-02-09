# ShoppingListApp
The goal:

The goal of this project is to create a simple shopping list app, which allows users to add items to list, as well as edit and delete the items. The users can also check off items in a list to keep track of their purchases.

How to compile and run:

Compiling the application can be done by building an APK file, which can then be downloaded on an Android device. 
Alternatively the application can be run on an emulator. 

Testing: 

To run tests the application, run MainActivityTest in the androidTest folder.

Architecture:

The application uses Firebase realtime database.
The data entered by a user will be stored in Firebase.
Once the data is entered, a call to display the items in a list is made.
The list consists of a each item on a separate card.
Once the list is displayed, the user has the option of editing or deleting an item.
To edit, the item is chosen by its unique ID and once the text is changed, the value is updated in the database and the new value displayed in the list.
To delete, the item is chosen by its unique ID and removed from the database.


This application is built using Java. Java was used due to the developer's previous experience and familiarity with this particular programming language.
 


