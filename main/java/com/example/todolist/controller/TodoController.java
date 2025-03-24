package com.example.todolist.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todoLists")
public class TodoController {

    @PostMapping
    public void createTodoList() {

    }

    @GetMapping("{/id}")
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
