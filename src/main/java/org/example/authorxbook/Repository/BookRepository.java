package org.example.authorxbook.Repository;

import org.apache.ibatis.annotations.*;
import org.example.authorxbook.Model.entities.Book;
import org.example.authorxbook.Model.request.BookRequest;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface BookRepository {
    @Select("SELECT * FROM tbbook")
    public List<Book> getBook();
    @Insert("INSERT INTO tbbook(id,title,author_name,created_at)"+
            "VALUES (#{book.id},#{book.title},#{book.author_name},#{book.created_at})")
    public void insertBook(@Param("book") BookRequest bookRequest);
    @Delete("DELETE FROM tbbook WHERE id = #{id}")
    public void deleteBook(@Param("id") int id);

    @Select("SELECT * FROM tbbook WHERE id = #{id}")
    public Book getBookById(int id);
    @Select("SELECT * FROM tbbook WHERE author_name LIKE #{authorname}")
    public List<Book> getBookByName(@Param("authorname") String author_name);
    @Update("UPDATE tbbook SET id = #{book.id}, title = #{book.title}, author_name = #{book.author_name}, created_at = #{book.created_at} WHERE id = #{bookID}")
    public void updateBook(@Param("book") BookRequest bookRequest,@Param("bookID")int id);
}
