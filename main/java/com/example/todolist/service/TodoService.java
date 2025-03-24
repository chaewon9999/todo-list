package com.example.todolist.service;

import com.example.todolist.dto.TodoListRequestDto;
import com.example.todolist.dto.TodoListResponseDto;

public interface TodoService {

    public TodoListResponseDto saveTodoList(TodoListRequestDto dto);
}
