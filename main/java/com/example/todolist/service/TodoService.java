package com.example.todolist.service;

import com.example.todolist.dto.TodoListRequestDto;
import com.example.todolist.dto.TodoListResponseDto;

import java.util.List;

public interface TodoService {

    public TodoListResponseDto saveTodoList(TodoListRequestDto dto);

    public List<TodoListResponseDto> findTodoListById(Long id);

    public List<TodoListResponseDto> findAllTodoList();

    public List<TodoListResponseDto> updateTodoList(Long id, String password, TodoListRequestDto dto);

    public void deleteTodoList(Long id, String password);
}
