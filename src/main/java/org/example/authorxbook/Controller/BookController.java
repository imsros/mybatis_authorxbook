package org.example.authorxbook.Controller;

import lombok.AllArgsConstructor;
import org.example.authorxbook.Model.entities.Book;
import org.example.authorxbook.Model.request.BookRequest;
import org.example.authorxbook.Model.response.BookResponse;
import org.example.authorxbook.Service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@AllArgsConstructor
@RestController
public class BookController {
    private BookService bookService;
    @GetMapping("api/book")
    public ResponseEntity<BookResponse> getAllBooks(){
        List<Book> books = bookService.getAllBook();
        BookResponse bookResponse = BookResponse.builder()
                .message("Get All Books Successfully")
                .data(books)
                .timestamp(new Timestamp(System.currentTimeMillis()))
                .status(HttpStatus.OK)
                .build();
        return new ResponseEntity<>(bookResponse,HttpStatus.valueOf(200));
    }
    @PostMapping("api/addbook")
    public ResponseEntity<BookResponse> addBook(@RequestBody BookRequest bookRequest){
        System.out.println("ID : " + bookRequest.getId());
        System.out.println("Title : " + bookRequest.getTitle());
        System.out.println("Author Name : " + bookRequest.getAuthor_name());
        System.out.println("Created At : " + bookRequest.getCreated_at());
        bookService.addBook(bookRequest);
        return null;
    }
    @DeleteMapping("/api/delete/{id}")
    public ResponseEntity<BookResponse> deleteBook(@PathVariable int id){
        bookService.deleteBook(id);
        BookResponse bookResponse = BookResponse.builder()
                .message("Delete Book Successfully")
                .timestamp(new Timestamp(System.currentTimeMillis()))
                .status(HttpStatus.OK)
                .build();
        return new ResponseEntity<>(bookResponse,HttpStatus.valueOf(200));
    }
    @PutMapping("/api/update/{id}")
    public ResponseEntity<BookResponse<Book>> updateBook(@PathVariable int id, @RequestBody BookRequest bookRequest){
        Book checkBook = bookService.getBookById(id);
        if(checkBook == null){
            BookResponse bookResponse = BookResponse.builder()
                    .message("NO Data Found")
                    .timestamp(new Timestamp(System.currentTimeMillis()))
                    .status(HttpStatus.NOT_FOUND)
                    .build();
            return new ResponseEntity<>(bookResponse,HttpStatus.valueOf(404));
        }
        if(
                bookRequest.getAuthor_name() ==null || bookRequest.getAuthor_name() ==null
        ){
            BookResponse bookResponse = BookResponse.builder()
                    .message("Add Book not successfully")
                    .timestamp(new Timestamp(System.currentTimeMillis()))
                    .status(HttpStatus.BAD_REQUEST)
                    .build();
            return new ResponseEntity<>(bookResponse,HttpStatus.BAD_REQUEST);
        }
        Book book= bookService.updateBook(bookRequest,id);
        BookResponse bookResponse = BookResponse.builder()
                .message("Update Book Successfully")
                .data(book)
                .timestamp(new Timestamp(System.currentTimeMillis()))
                .status(HttpStatus.valueOf(200))
                .build();
        return new ResponseEntity<>(bookResponse,HttpStatus.OK);
    }
    @GetMapping("/book/name")
    public ResponseEntity<BookResponse<List<Book>>> getBookByName(@RequestParam String author_name){
        List<Book> books= bookService.getBookByName(author_name);
        if(books.isEmpty()){
            BookResponse bookResponse = BookResponse.builder()
                    .message("No data found")
                    .timestamp(new Timestamp(System.currentTimeMillis()))
                    .status(HttpStatus.NOT_FOUND)
                    .build();
            return new ResponseEntity<>(bookResponse,HttpStatus.valueOf(404));
        }
        BookResponse bookResponse = BookResponse.builder()
                .message("Get All author Successfully")
                .data(books)
                .timestamp(new Timestamp(System.currentTimeMillis()))
                .status(HttpStatus.OK)
                .build();
        return new ResponseEntity<>(bookResponse,HttpStatus.valueOf(200));
    }
    @GetMapping("/book/{id}")
    public ResponseEntity<BookResponse<Book>> getBookById(@PathVariable int id){
        Book book= bookService.getBookById(id);
        if(book == null){
            BookResponse bookResponse = BookResponse.builder()
                    .message("No data found")
                    .timestamp(new Timestamp(System.currentTimeMillis()))
                    .status(HttpStatus.NOT_FOUND)
                    .build();
            return new ResponseEntity<>(bookResponse,HttpStatus.valueOf(404));
        }
        BookResponse bookResponse = BookResponse.builder()
                .data(book)
                .message("Get Author Successfully")
                .timestamp(new Timestamp(System.currentTimeMillis()))
                .status(HttpStatus.OK)

                .build();
        return new ResponseEntity<>(bookResponse,HttpStatus.valueOf(200));
    }
}
