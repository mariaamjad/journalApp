package com.maria.journalApp.entity;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

//these kind of classes are also called POJO (plain old java object)
@Document(collection = "journal_entries") //map to db table/collection
@Getter
@Setter
public class JournalEntry {

    @Id
    private ObjectId id;
    @NonNull //another lombok extension
    private String title;
    private String content;
    private LocalDateTime date;

}
