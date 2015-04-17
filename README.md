# SpringMVCMongoIntegeration
The POC is used to demonstrate the steps required to follow to create a Spring MVC based project backed by MongoDB.
The application is a very basic SpringMVC skeleton application that uses Spring-Security as authentication mechanism to enable login

### What is this repository for? ###
* Spring MVC + MongoDB POC
* Spring Security Implemenation
* ver0.1

### How do I get set up? ###

* CheckOut the source code from repository
* Make sure MongoDB is up and running
* Import as existing maven project
* Resolve the dependencies by allowing maven to download the same
* Update the config.properties
* Deploy on tomcat

### Overview ###
The POC explains 3 type of user access roles : root, admin and user. As soos as the application is loaded, a DB call is made to check if root user is present or not.
If a user with root privilages is not found, a new root user is created (only once). After that a Spring-Security based login-page is opened and the user can login with the credentials
as configured. The root credentials are hard-coded and can be read from a property file as well for first time usage

### Who do I talk to? ###
Please feel free to raise an issue or you can contact me at : sumit.gaur@optimumalgorithms.com



