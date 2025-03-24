package com.example.todolist.dto;

import com.example.todolist.entity.TodoList;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TodoResponseDto {

    private long id;
    private String name;
    private String contents;
    private String date;

    public TodoResponseDto(TodoList todoList) {
        this.id = todoList.getId();
        this.name = todoList.getName();
        this.contents = todoList.getContents();
        this.date = todoList.getDate();
    }
}
