package com.example.todolist.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TodoList {

    private Long id;
    private String name;
    private String password;
    private String contents;
    private String date;

    public TodoList(String name, String contents, String date) {
        this.name = name;
        this.contents = contents;
        this.date = date;
    }

    public void updateContents(String contents) {
        this.contents = contents;
    }

    public void updateName(String name) {
        this.name = name;
    }
}
