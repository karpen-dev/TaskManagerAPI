package com.karpen.taskmanagerapi.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import com.karpen.taskmanagerapi.model.Todo
import com.karpen.taskmanagerapi.service.TodoService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/todos")
class TodoController(private val todoService: TodoService) {

    @GetMapping
    fun getAllTodos(): List<Todo>{
        return todoService.getAllTodos()
    }

    @PostMapping
    fun createTodo(@RequestBody todo: Todo): ResponseEntity<Todo>{
        val createdTodo = todoService.createTodo(todo)
        return ResponseEntity(createdTodo, HttpStatus.CREATED)
    }

    @DeleteMapping("/{id}")
    fun deleteTodo(@PathVariable id: Long): ResponseEntity<Void>{
        todoService.deleteTodo(id)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }
}