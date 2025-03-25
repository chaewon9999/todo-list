package com.example.todolist.service;

import com.example.todolist.dto.TodoListRequestDto;
import com.example.todolist.dto.TodoListResponseDto;
import com.example.todolist.entity.TodoList;
import com.example.todolist.repository.JdbcTemplateRepository;
import com.example.todolist.repository.TodoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

        if (updateRow == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "아이디나 비밀번호가 잘못되었습니다."); //수정 실패시 예외처리
        }

         return todoRepository.findTodoListById(id);
    }

    @Override
    public void deleteTodoList(Long id, String password) {
        todoRepository.deleteTodoList(id, password);
    }

}
