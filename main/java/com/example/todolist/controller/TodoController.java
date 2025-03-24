package com.example.todolist.controller;

import com.example.todolist.dto.TodoListRequestDto;
import com.example.todolist.dto.TodoListResponseDto;
import com.example.todolist.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("{todoLists}")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public ResponseEntity<TodoListResponseDto> createTodoList(@RequestBody TodoListRequestDto dto) {
        return new ResponseEntity<>(todoService.saveTodoList(dto), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public void getTodoListById() {

    }

    @GetMapping
    public void getTodoList() {

    }

    @PutMapping
    public void updateTodoList() {

    }

    @DeleteMapping
    public void deleteTodoList() {

    }
}
