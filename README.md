# Bank-Library-System
bank's library project for PwC technical assessment

## Database Schema
<pre> 
db: postgres
table: books (id (seq), name (VARCHAR(255) NOT NULL), author(VARCHAR(255)), genre(VARCHAR(255)))
</pre> 
## How To Run

```cmd
docker compose up
```

## API Documentation

This app consists of 5 APIs.

### 1. /books
This API insert a record to books table  
<pre> 
 request:  
  method: POST 
    content-type: application/json  
    body:  
        name: string  
        author: string  
        genre: string  
 response:  
    body:  
        message: string
 </pre>

```cmd
curl --location --request POST 'localhost:8080/books' \
--header 'Content-Type: application/json' \
--data-raw '{
    
  "name": "book1",
  "author": "music",
  "genre": "Banking"
}'
```

### 2. /books/{id}
This API return book by id.
<pre> 
 request:  
  method: GET
 response:  
    body:  
        id : string
        name: string
        author: string
        genre: string
 </pre>

```cmd
curl --location --request GET 'localhost:8080/books/1' \
--data-raw ''
```
### 3. /books/name/{name}
This API return a list of book by name
<pre> 
 request:  
  method: GET
 response:  
    body:  
        id : string
        name: string
        author: string
        genre: string
 </pre>

```cmd
curl --location --request GET 'localhost:8080/books/name/book1' \
--data-raw ''
```
### 4. /books/{id} (update)

This API update a book by id.
<pre> 
 request:  
  method: PUT
  body:
    id : string
    name: string
    author: string
    genre: string
 response:  
    body:  
        message: string
 </pre>

```cmd
curl --location --request PUT 'localhost:8080/books/2' \
--header 'Content-Type: application/json' \
--data-raw ' {
      
        "name": "book2",
        "author": "music2",
        "genre": "Banking"
    },'
```

### 5. /books/{id} (delete)
This  API delete book by id
<pre> 
 request:  
  method: DELETE
 response:  
    body:  
        message: string
 </pre>

```cmd
curl --location --request DELETE 'localhost:8080/books/2' \
--header 'Content-Type: application/json' \
--data-raw ' '
```



