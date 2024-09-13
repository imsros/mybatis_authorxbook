package org.example.authorxbook.Service;

import lombok.AllArgsConstructor;
import org.example.authorxbook.Model.entities.Author;
import org.example.authorxbook.Model.request.AuthorRequest;
import org.example.authorxbook.Repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;
    public List<Author> getAllAuthor(){
        return authorRepository.getAuthor();
    }
    public void addAuthor(AuthorRequest authorRequest){
        authorRepository.insertAuthor(authorRequest);
    }
    public void deleteAuthor(int id){
        authorRepository.deleteAuthor(id);
    }
    public  Author getAuthorById(int id){
        return authorRepository.getAuthorById(id);
    }
    public List<Author> getAuthorByName(String username){
        return authorRepository.getAuthorByName("%"+username+"%");
    }
    public Author updateAuthor(AuthorRequest authorRequest,int id){
        authorRepository.updateAuthor(authorRequest,id);
        return authorRepository.getAuthorById(id);
    }
}
