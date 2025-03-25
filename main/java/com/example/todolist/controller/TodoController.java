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

    /**
     * 할일 생성
     */
    @PostMapping
    public ResponseEntity<TodoListResponseDto> createTodoList(@RequestBody TodoListRequestDto dto) {
        return new ResponseEntity<>(todoService.saveTodoList(dto), HttpStatus.CREATED);
    }

    /**
     * 할일 단건 조회
     * @PathVariable을 통해 URL로 id 값 받아오기
     */
    @GetMapping("/{id}")
    public ResponseEntity<List<TodoListResponseDto>> findTodoListById(@PathVariable Long id) {
        return new ResponseEntity<>(todoService.findTodoListById(id), HttpStatus.OK);
    }

    /**
     * 할일 목록 조회
     */
    @GetMapping
    public ResponseEntity<List<TodoListResponseDto>> findAllTodoList() {
        return new ResponseEntity<>(todoService.findAllTodoList(), HttpStatus.OK);
    }

    /**
     * 할일 단건 조회
     * @PathVariable을 통해 URL로 id 값 받아오기
     * @RequestParam을 통해 password 받아오기
     * @RequestBody를 통해 수정할 본문 받아오기
     */
    @PutMapping("/{id}")
    public ResponseEntity<List<TodoListResponseDto>> updateTodoList
    (   @PathVariable Long id,
        @RequestParam String password,
        @RequestBody TodoListRequestDto dto
    )
    {
        return new ResponseEntity<>(todoService.updateTodoList(id, password, dto), HttpStatus.OK);
    }

    /**
     * 할일 단건 조회
     * @PathVariable을 통해 URL로 id 값 받아오기
     * @RequestParam을 통해 password 받아오기
     */
    @DeleteMapping("/{id}")
    public void deleteTodoList(@PathVariable Long id, @RequestParam String password) {
        todoService.deleteTodoList(id, password);
    }
}
