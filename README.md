# CMPE 202 Individual Project - Billing Application 

Steps to run the Application : 
1) Maven and JDK 18.0.1 must be pre installed on the local system before running the application 
2) Clone the repository to your local system or download as a zip file
3) Go to the project root folder i.e Billing Application on terminal
4) Run the command "mvm compile" to compile the application
5) Run the command "mvn exec:java -Dexec.mainClass=com.billing.Billing" to run the application 
6) Provide the input CSV file path when it prompts 
7) Finally, the result will be generated in the Output folder of the project structure 


# Introduction : 

This is a Billing Application that takes a CSV file as an Input. The input CSV contains the list of items to be ordered, quantity of each items along with the credit card to be used for payment.
Upon receiving the correct input CSV file path the application checks if the required items are available in sufficient quantity in the Static in-memory database and also checks for any items exceeding the category limit set. 
Upon successful validation the order is processed and the database is being updated. Also, an invoice CSV file will be generated with the list of Items and Total price to be paid. 
Upon validation error a text file will be generated with the cause of the error. 

# Design Patterns Used:
The application implements the following design patterns:

# 1) Singleton Design Pattern:  
The application makes use of the singleton design pattern which is a creational design pattern used for creating the database object. Here, the database object is used in multiple classes and only one object would be sufficient to use throughout the project. Thus, we create a static database object that will be created only once and be used for subsequent object creation requests. Also, the database constructor will be private to avoid explicit object creation. With the singleton pattern implementation we get the global access point to the database object. 

# 2) Factory Design Pattern: 
The application also implements the Factory Design pattern.
In our application we are writing data to two different file formats i.e CSV(for success) and text file (for error). Since only the implementation is different, but the high level usecase is same we can extract these methods to an interface and write different implementation classes for CSV File writing and Text File writing. Using the factory pattern we can get the concrete class object at runtime based upon the requirement. Thus, promoting loose coupling. 
