package com.example.todolist.controller;

import com.example.todolist.dto.TodoListRequestDto;
import com.example.todolist.dto.TodoListResponseDto;
import com.example.todolist.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todoLists")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    // 1. 할일 생성
    @PostMapping
    public ResponseEntity<TodoListResponseDto> createTodoList(@RequestBody TodoListRequestDto dto) {
        return new ResponseEntity<>(todoService.saveTodoList(dto), HttpStatus.CREATED);
    }

    // 2. 할일 단건 조회
    @GetMapping("/{id}")
    public ResponseEntity<List<TodoListResponseDto>> findTodoListById(@PathVariable Long id) {
        return new ResponseEntity<>(todoService.findTodoListById(id), HttpStatus.OK);
    }

    // 3. 할일 목록 조회
    @GetMapping
    public ResponseEntity<List<TodoListResponseDto>> findAllTodoList() {
        return new ResponseEntity<>(todoService.findAllTodoList(), HttpStatus.OK);
    }

    // 4. 할일 수정
    @PutMapping("/{id}")
    public ResponseEntity<List<TodoListResponseDto>> updateTodoList
    (   @PathVariable Long id,
        @RequestParam String password,
        @RequestBody TodoListRequestDto dto
    )
    {
        return new ResponseEntity<>(todoService.updateTodoList(id, password, dto), HttpStatus.OK);
    }

    // 5. 헐알 삭제
    @DeleteMapping("/{id}")
    public void deleteTodoList(@PathVariable Long id, @RequestParam String password) {
        todoService.deleteTodoList(id, password);
    }
}
