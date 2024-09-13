package org.example.authorxbook.Model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BookResponse<T>{
    private String message;
    private T data;
    private Timestamp timestamp;
    private HttpStatus status;
}
