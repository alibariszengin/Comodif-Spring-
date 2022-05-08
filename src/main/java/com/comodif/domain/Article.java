package com.comodif.domain;



import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;


import java.util.Date;

@Document("article")
@Data
@Getter
@Setter
public class Article {

    @Id
    private String id;
    private String title;
    private String author;
    private String content;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date publishDate;

    public Article(String title, String author, String content, Date publishDate) {
        this.title = title;
        this.author = author;
        this.content = content;
        this.publishDate = publishDate;
    }
}