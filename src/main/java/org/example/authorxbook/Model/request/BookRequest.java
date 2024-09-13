package org.example.authorxbook.Model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookRequest {
    private int id;
    private String title;
    private String author_name;
    private String created_at;
}
