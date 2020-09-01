# Book-Store-Spring-Boot-App
Spring Boot application for Book Store

Book Store Application:

Introduction: This is a Book Store web application that allows the user to view the list of books, view details of a particular book and delete a book from the list. The application is built using Java, Spring Boot and Spring Data JPA for the Back end and Angular 8, jQuery, Bootstrap, HTML and CSS for the UI part. For exception handling, the application uses @ControllerAdvice, this allows the application to handle all the exceptions at one place instead of handling in each controller or service classes. The application uses JUnit, Mockito and MockMVC to test the RESTful API endpoints. 

Once the user hits the URL in the browser the landing page of the application loads up, the user is provided with a link/button to get the list of all books. The list of books is populated in the form of a table. Each row in the table consists of a View Details and a Delete button. If the user clicks the Details button, he/she is navigated to another page to view the details of the book which includes a cover image of the book and other details are same as listed in the table. The user is provided with a back button to get back to the list of books page. The default number of books listed per page is 5 and the user can change it to 10 or 15 items. The list of books can be sorted based on all the headers in the table for E.g. title, author name, category and publication date. The user can navigate to the next page using the pagination feature.

Back end:

Technologies used: Java, Spring Boot, Spring Data JPA, JUNit, Mockito and Maven.

The Back-end application exposes three RESTful API end points for the clients to consume.

1.	To get the list of Books:

     Method name: getAllBooks()
     
     Resource URI: /books
     
     Request Type: GET
     
     RequestParams:  pageNo(Page Number), pageSize, sortBy and sortDirection

The bookRepository extends PagingAndSorting repository which enables Pagination and Sorting in the server side. These parameters are optional and have a default value if the URL does not contain them.

URLs for getAllBook ():
1)	http://localhost:8089/bookstoreservice/books
2)	http://localhost:8089/bookstoreservice/books?pageSize=5
3)	http://localhost:8089/bookstoreservice/books?pageSize=5&pageNo=0
4)	http://localhost:8089/bookstoreservice/books?pageSize=5&pageNo=0&sortBy=title
5)	http://localhost:8089/bookstoreservice/books?pageSize=5&pageNo=0&sortBy=title&sortDirection=asc
6)   http://localhost:8089/bookstoreservice/books?pageSize=5&pageNo=1&sortBy=authorName&sortDirection=desc

We can form more combinations of the URL

The method returns the Response code as 200 and Response status OK for success.

2.	To get a book using id:

Method name: getBookById()

Resource URI: /books/{id}

Request Type: GET

Pathvariable: id

URL for getBookById():

http://localhost:8089/bookstoreservice/books/1

Success :

Response Code :200

Response Status : OK

Failure:
Response Code:404

Response Status: “Book with the id is not found”

 If a resource is not found, the method throws ‘BookNotFoundException’ (RuntimeException) and the exception is handled using the @ControllerAdvice which sends the corresponding error message.
 
3.	To delete a Book using id:

Method name: deleteBookById()

Resource URI: /books/{id}

Request Type: DELETE

Pathvariable: id

URL for deleteById()

http://localhost:8089/bookstoreservice/books/1

Success :

Response Code :200

Response Status : Ok

Failure:

Response Code:404

Response Status: “Book with the id is not found”

Note : The bookstoreservice appearing in the URL is the name of the application war file. Please use the same name and change the port accordingly while deploying in Tomcat. The .war file is present in the target folder of the application.

Unit Testing: I have used JUnit, Mockito and MockMVC to test all the above RESTful endpoints. These test cases check the results returned, the response status, response code, the number of interactions with the method, and the Content-type. I have mocked the Service and verified it with the data returned from the Database. These tests run automatically during the build process. All the test cases have passed for me . Below are the three test cases to check all the three available RESTful APIs.

1.	test_get_all_success() for getAllBooks()

2.	test_get_book_by_id_success() for getBookById()

3.	test_delete_book_success() for deleteBookById()

 Test Class : BookStorTest.java
  
   Database: I have used the in-memory H2 Database provided by Spring boot. As advised I have included all the fileds given in the requirement. Book id is the primary key in the table. I have used Spring Data JPA to construct the Database and tables.
   
   Database Colunmns:
   
   id - Primary key
   
   Title
   
   AuthornName
   
   Category
   
   Publication Date
   
   Improvements (If had more time):
   
 Using Docker container to run MySQL Database. I would have definitely completed the stretch goal if I had a day or two. One of the problems using Docker is the time it takes for the initial set up in the Laptop/Computer and the URLs which can easily get confusing. Next improvement that I want to mention is about sorting using multiple fields. Currently, the application supports sorting using all the individual fields independently but not in a combined way. I would definitely want to implement the sorting using multiple fields.
   
 Steps to start the application:
 
 Please find the .war (bookstoreservice.war) file in the target folder
 
 Deploy it in Tomcat 
 
 Start the application in Tomcat
 
 Use this URL to get the list of books: http://localhost:8089/bookstoreservice/books
 
 Note:8089 is the port where I have deployed my tomcat.
 
    
 
