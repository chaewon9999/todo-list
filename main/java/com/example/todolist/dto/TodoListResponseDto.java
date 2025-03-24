package com.example.todolist.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class TodoListResponseDto {

    private long id;
    private String name;
    private String contents;
    private LocalDateTime date;

    public TodoListResponseDto(long id, String name, String contents) {
        this.id = id;
        this.name = name;
        this.contents = contents;
        this.date = LocalDateTime.now();
    }
}
