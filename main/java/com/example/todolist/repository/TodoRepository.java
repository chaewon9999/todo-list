package com.example.todolist.repository;

import com.example.todolist.dto.TodoListResponseDto;
import com.example.todolist.entity.TodoList;

public interface TodoRepository {

    public TodoListResponseDto saveTodoList(TodoList todoList);
}
