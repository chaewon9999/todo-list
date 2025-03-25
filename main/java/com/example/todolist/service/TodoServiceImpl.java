package com.example.todolist.service;

import com.example.todolist.dto.TodoListRequestDto;
import com.example.todolist.dto.TodoListResponseDto;
import com.example.todolist.entity.TodoList;
import com.example.todolist.repository.JdbcTemplateRepository;
import com.example.todolist.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<TodoListResponseDto> findTodoListById(Long id) {
        return todoRepository.findTodoListById(id);
    }

    @Override
    public List<TodoListResponseDto> findAllTodoList() {
        return todoRepository.findAllTodoList();
    }

    @Override
    public List<TodoListResponseDto> updateTodoList(Long id, String password, TodoListRequestDto dto) {

        int updateRow = todoRepository.updateTodoList(id, dto.getName(), password, dto.getContents());

         return todoRepository.findTodoListById(id);
    }

}
