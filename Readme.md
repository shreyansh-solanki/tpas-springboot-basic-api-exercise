## Spring Boot Simple Api Exercise

### Port is running on http://localhost:8080/api/v1/books

### For Swagger Ui Url:- http://localhost:8080/swagger-ui/index.html

### For H2 Database Console:- http://localhost:8080/h2-console

- JDBC URL: jdbc:h2:mem:tpasBook
- User Name: root
- Password: root

#### _Initially adding data in the database using util service DataLoader which implements CommandLineRunner for adding data when the springboot app start_

### For end point testing

_POST_ - _Adding Book_

- http://localhost:8080/api/v1/books
  - Data:
    {
    "title": "Classical Mythology",
    "author": "Mark P. O. Morford",
    "isbn": "0195153448"
    }

_Get_ - _Get All Books_

- http://localhost:8080/api/v1/books

_Get_ - _Get Book By Id_

- http://localhost:8080/api/v1/books/:bookId
  - Example: http://localhost:8080/api/v1/books/1

_Put_ - _Update Book By Id_

- http://localhost:8080/api/v1/books/:bookId
  - http://localhost:8080/api/v1/books/1
  - Data:
    {
    "title": "Clara Callan",
    "author": "Richard Bruce Wright",
    "isbn": "0002005018"
    }

_Delete_ - _Delete Book By Id_

- http://localhost:8080/api/v1/books/:bookId
  - Example: http://localhost:8080/api/v1/books/1

### For Testing

- Run the application
- Open Postman Or Swagger UI
- Hit the above mentioned end points
- Check the response

### If Book Id is not found

- It will return 404 Not Found Custom Exception(Resource Not Found) with message "Book not found with id : {bookId}" and status code 404.

### If Book Id is found

- It will return 200 OK with the response.
