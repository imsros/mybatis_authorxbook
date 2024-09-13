package org.example.authorxbook.Service;

import lombok.AllArgsConstructor;
import org.example.authorxbook.Model.entities.Book;
import org.example.authorxbook.Model.request.BookRequest;
import org.example.authorxbook.Repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class BookService {
    private final BookRepository bookRepository;
    public List<Book> getAllBook(){
        return bookRepository.getBook();
    }
    public void  addBook(BookRequest bookRequest){
        bookRepository.insertBook(bookRequest);
    }
    public void deleteBook(int id){
        bookRepository.deleteBook(id);
    }
    public  Book getBookById(int id){
        return bookRepository.getBookById(id);
    }
    public List<Book> getBookByName(String username){
        return bookRepository.getBookByName("%"+username+"%");
    }
    public Book updateBook(BookRequest bookRequest,int id){
        bookRepository.updateBook(bookRequest,id);
        return bookRepository.getBookById(id);
    }
}
