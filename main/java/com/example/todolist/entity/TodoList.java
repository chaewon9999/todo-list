package com.example.todolist.entity;

import com.example.todolist.dto.TodoListRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class TodoList {

    private Long id;
    private String name;
    private String contents;
    private String password;
    private LocalDateTime date;

    public TodoList(TodoListRequestDto dto) {
        this.name = dto.getName();
        this.contents = dto.getContents();
        this.password = dto.getPassword();
        this.date = LocalDateTime.now();
    }
}
