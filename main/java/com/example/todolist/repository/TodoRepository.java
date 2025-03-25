package com.example.todolist.repository;

import com.example.todolist.dto.TodoListResponseDto;
import com.example.todolist.entity.TodoList;

import java.util.List;

public interface TodoRepository {

    public TodoListResponseDto saveTodoList(TodoList todoList);

    public List<TodoListResponseDto> findTodoListById(Long id);

    public List<TodoListResponseDto> findAllTodoList();

    public int updateTodoList(Long id, String name, String password, String contents);

    public void deleteTodoList(Long id, String password);
}
