package com.example.todolist.dto;

import lombok.Getter;

@Getter
public class TodoListResponseDto {

    private Long id;
    private String name;
    private String contents;
    private String date;

    public TodoListResponseDto(Long id, String name, String contents, String date) {
        this.id = id;
        this.name = name;
        this.contents = contents;
        this.date = date;
    }
}
