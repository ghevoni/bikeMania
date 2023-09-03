# Description
***The bikeMania project***

-This project was made at the end of the junior Java programmer course and represents a fictitious online Romanian store that sells bicycles.

-Besides the online store, there is also a service, a showroom and a warehouse all at the same address, where customers can come to repair their bikes, see and test the bikes they want to buy and where the goods are received.

-Bicycles are of several types - mens, ladies, children, electrics and sports.

-Because from the images presented in the application, a user cannot easily realize the type of bicycles sold, each type has a letter added at the end of the brand name that symbolizes the type of bicycles sold, as follows: M – for men bicycles, W – for women bikes, C – for children bikes, E – for electrics bikes and S – for sports bikes.

## Description of the project interface

***Front side up*** 

-I created a fictitious company BikeMania, with a rather suggestive logo, with the message "A bicycle for everyone". There, users can find out information about the company and the products sold, in the "About us" section, the working hours of the bicycle service, the prices for their repair, in the "Service" section, and the working hours for online orders, of the warehouse and showroom, contact details, in the "Contact" section.
-Also here, users can search for the products they are interested in, register, log in and access the shopping cart.


***Front left side***

-Here the user can select from the five types of bicycles mentioned previously.
-Below this information, I have vertically inserted two widgets, one for the weather in Bucharest and another for the exchange rate for several main currencies.
-Below them I displayed a processed image, from a sports cycling race, with a mobilizing message underneath.

***The central part of the application***

-This part includes bicycle cards with famous international brands such as: Merida, Rich, Rockrider, Cub, Ranger, Sprint, Ghost, Cross, Devon, Romet, Econic, Cannodale with the types mentioned above.

***Registration and Logging***

-The user can register and then log in as Admin or as a simple user with the name chosen during registration.
-If he logs in as Admin, he can add a new product, edit it to make the changes he considers necessary and delete it, if it is no longer up-to-date.
-If he logs in as an existing user, he can find out details about the products - description, stocks, prices and can buy the product if he is satisfied with it.
-If he does not log in, the user can only find out details about the products for sale.

[top](#description)

***Shopping cart***

-When the logged in user buys a product, he can add the products to the shopping cart.
-Also, in the shopping cart, once the user has bought one or more products, he has information about them, such as: the type of products purchased, the brand chosen, the products in stock at the time of purchase, the quantity of products ordered , the value per piece, the total value per type of purchased products, as well as the total value of all purchased products.
-The user has the possibility to return to the shopping cart at any time and review the information there. Also here he has two buttons "Continue shopping" and "Complete order."
-With the help of the first button, he returns to the application to continue shopping, and with the second button, after he has purchased everything he wants, he completes the order. Once it has done this, all ordered products are deducted from the existing stocks.

[top](#description)

### Screenshots from project

-First page - 
https://i.postimg.cc/13Lw4BSD/first-Page1.png
https://i.postimg.cc/76CL78N6/first-Page2.png

-"AboutUs" section - 
https://i.postimg.cc/zGX8KYzr/aboutUs.png

-"Service" section - 
https://i.postimg.cc/FFMGzw5s/service1.png

https://i.postimg.cc/xjJt0nZ4/service2.png

https://i.postimg.cc/7h2VXn7k/service3.png

-"Contact" section - 
https://i.postimg.cc/G2H9PKNh/contact.png

-"Terms and Conditions" section - 
https://i.postimg.cc/P597r5j3/terms-And-Conditions.png

-"Return policy" section - 
https://i.postimg.cc/zB6wTVx6/return-Policy.png

-"Privacy policy" section - 
https://i.postimg.cc/FsgcHWX2/privacy-Policy.png

-"Cookie policy" section - 
https://i.postimg.cc/MGk83Dvp/cookie-Policy.png

-"Free revisions" section - 
https://i.postimg.cc/q7Qj6BVH/free-Revisions.png

-Login page - 
https://i.postimg.cc/xjNhhHVk/login-Page.png

-Shopping cart - example with Vlad user who buy some products - 
https://i.postimg.cc/66hjDh1p/shopping-Cart.png

[top](#description)

### Technologies used

-Programming language - Java

-Frameworks - Spring Boot, Bootstrap

-Database - MySQL

-I have also used - HTML5, CSS3, JavaScript

-Integrated Development Environment(IDE) - Intellij Community

-Where it was necessary, I processed images with the help of PosterMyWall, Microsoft Office Picture Manager, Paint, Photos applications

[top](#description)

### Features

-The non-logged user can see the products displayed in the application.

-The logged-in user can see these products, as well as add them to the shopping cart and make orders.

-The Admin can add products to the application, edit them, make changes to them and delete them if they are no longer up-to-date.

[top](#description)

### System requirements

To run this application, make sure you have the following installed:
-Java Development Kit (JDK) - version 8 or more recent - 
[Download JDK](https://www.oracle.com/java/technologies/javase-downloads.html)

-MySQL Server - for storing application data - 
[Download MySQL](https://www.mysql.com/downloads/)

-Integrated Development Environment(IDE) - 
it recommend Intellij IDEA, but you can use anything other IDE you prefer - 
[Download Intellij IDEA](https://www.jetbrains.com/idea/download/)

[top](#description)

### Installation and running

-Make sure you have installed the Java Development Kit (JDK) and MySQL Server.

-Clone this repository using 'git clone - 
https://github.com/mitnaru/bikeMania.git'

-Configure a MySQL database on your personal computer, called 'bikeMania'.

-Open the 'application.properties' file and complete the database connection settings with the specific information - username and password - of your personal database. Keep in mind that this information is sensitive and must be kept safe.

```
###Database configuration
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.username=username
spring.datasource.password=password
spring.datasource.url= jdbc:mysql://localhost:3306/bikemania?createDatabaseIfNotExist=true
###JPA Configuration
spring.jpa.database=MYSQL
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update
```
-Start the application using './mvn spring-boot:run'

-Access the application in the browser at the address - 
[http:localhost:8080](http://localhost:8080)

### License

-"bikeMania" project is licensed under the MIT license. Please see the license document for more information.

[top](#description)