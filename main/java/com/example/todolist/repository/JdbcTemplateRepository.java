package com.example.todolist.repository;

import com.example.todolist.dto.TodoListResponseDto;
import com.example.todolist.entity.TodoList;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class JdbcTemplateRepository implements TodoRepository{

    private final JdbcTemplate jdbcTemplate;

    public JdbcTemplateRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public TodoListResponseDto saveTodoList(TodoList todoList) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);

        jdbcInsert.withTableName("todoList").usingGeneratedKeyColumns("id");

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("name", todoList.getName());
        parameters.put("contents", todoList.getContents());
        parameters.put("password", todoList.getPassword());
        parameters.put("date", todoList.getDate());

        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));

        return new TodoListResponseDto(key.longValue(), todoList.getName(), todoList.getContents(), todoList.getDate());
    }

    @Override
    public List<TodoListResponseDto> findTodoListById(Long id) {
        return jdbcTemplate.query("select * from todoList where id = ?", rowMapper(), id);
    }

    @Override
    public List<TodoListResponseDto> findAllTodoList() {
        return jdbcTemplate.query("select * from todolist order by date desc", rowMapperAll());
    }

    @Override
    public int updateTodoList(Long id, String name, String password,  String contents) {

        return jdbcTemplate.update("update todoList set name = ?, contents = ? where id = ? and password = ?", name, contents, id, password);
    }

    private RowMapper<TodoListResponseDto> rowMapper() {

        return new RowMapper<TodoListResponseDto>() {
            @Override
            public TodoListResponseDto mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new TodoListResponseDto(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("contents"),
                        rs.getString("date")
                );
            }
        };
    }

    private RowMapper<TodoListResponseDto> rowMapperAll() {
        return new RowMapper<TodoListResponseDto>() {
            @Override
            public TodoListResponseDto mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new TodoListResponseDto(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("contents"),
                        rs.getString("date")
                );
            }
        };
    }
}
