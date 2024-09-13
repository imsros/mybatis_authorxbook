package org.example.authorxbook.Repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;
import org.example.authorxbook.Model.entities.Author;
import org.example.authorxbook.Model.request.AuthorRequest;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface AuthorRepository {
    @Select("SELECT * FROM tb_author")
    public List<Author> getAuthor();
    @Insert("INSERT INTO tb_author(id,username,gender)"+
            "VALUES (#{author.id},#{author.username},#{author.gender})")
    public void insertAuthor(@Param("author")AuthorRequest authorRequest);
    @Delete("DELETE FROM tb_author WHERE id = #{id}")
    public void deleteAuthor(@Param("id")int id);
    @Select("SELECT * FROM tb_author WHERE id = #{id}")
    public Author getAuthorById(int id);
    @Select("SELECT * FROM tb_author WHERE username LIKE #{authorname}")
    public List<Author> getAuthorByName(@Param("authorname") String username);
    @Update("UPDATE tb_author SET id = #{author.id}, username = #{author.username}, gender = #{author.gender} WHERE id = #{authorID}")
    public void updateAuthor(@Param("author") AuthorRequest authorRequest, @Param("authorID")int id);
}
