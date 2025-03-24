package com.example.todolist.service;

import com.example.todolist.dto.TodoListRequestDto;
import com.example.todolist.dto.TodoListResponseDto;
import com.example.todolist.entity.TodoList;
import com.example.todolist.repository.JdbcTemplateRepository;
import com.example.todolist.repository.TodoRepository;
import org.springframework.stereotype.Service;

@Service
public class TodoServiceImpl implements TodoService{

    private final TodoRepository todoRepository;

    public TodoServiceImpl(JdbcTemplateRepository repository) {
        this.todoRepository = repository;
    }

    @Override
    public TodoListResponseDto saveTodoList(TodoListRequestDto dto) {
        TodoList todoList = new TodoList(dto);
        return todoRepository.saveTodoList(todoList);
    }
}
