# MyPlace

The software engineering project that we plan to work on is a command line tool that generates a pop-up display to save places that you have been to that you liked and places that you want to go to in the future. This application will allow for people to more easily save their travel recommendations and travel wishlist with a model more interactive and engaging than a traditional list.


To install and run this software, you must:

1. Make sure that Java is installed on your computer.
2. Git clone this github repo.
3. Both the SQLite JDBC and the JSON Simple jar files are included in our github repo so when you clone the repo you will automatically download those necessary resources as well. However, you will have to change the dependencies in your project so that in the .classpath file it uses your local file path for the jar files.
4. Run MyApp.java as a Java Application.


To operate the application:

1. When you first open the application, you have the option to either make an account or log in to an existing account. 
2. If this is your first time using the application, then click Sign Up to create an account. You will just have to enter a username, password, and answers to two security questions.  
3. If you already have an account, you can either click Login to login to your account or Forgot Password to retrieve the password to your account if you forget it.
4. If you click Forgot Password, then you will be prompted to answer your username and security question answers, and if they match up then your password will be displayed to you.
5. If you click Login, then you will be prompted to enter your username and password. The application will let you know if the username and password are incorrect. If they are valid credentials then you will be logged in to your account.
6. Once logged in to the application, you can either choose to view the list of places you've been or places you wish to go. 
7. Within either list, you can choose to see all the places you've added to the list or you can add a new place to the list.
8. To add a new place to the list, click the button in the upper right hand corner of the list page and then you will be prompted to enter your search criteria. From there, you can choose the place from the search results that you want to add to your list, add a comment about the place, and then click add to add that place to the list.
9. To view a specific place's information, you can select the desired place and click "View Info" button. You will then be prompted to another page, where you must click "See Info" in order for that pinned place's information such as address, name and comment to appear.
10. You can then either go back to see the list and see specifc information, go back to go to the other list, search and add a new place, or simply logout.


To run the tests, you must:

1. Make sure that Java is installed on your computer.
2. Git clone this github repo.
3. Both the SQLite JDBC and the JSON Simple jar files are included in our github repo so when you clone the repo you will automatically download those necessary resources as well. However, you will have to change the dependencies in your project so that in the .classpath file it uses your local file path for the jar files.
4. Make sure to select src/JUnit instead of MyApp.java to run all the tests simultaneously. If seeking to run an individual test, select dropdown button from run button and select the name of the desired test file, situated next to JUnit symbol (Test files include: AddLocation_Test, Login_TestFX, CreateAccount_Test, Login_Test, PlaceSearch_Test, Place_Test, ForgotPassword_Test).
