package com.karpen.taskmanagerapi.service

import com.karpen.taskmanagerapi.model.Todo
import com.karpen.taskmanagerapi.storage.TodoFileStorage
import org.springframework.stereotype.Service

@Service
class TodoService (private val todoFileStorage: TodoFileStorage){

    private fun getTodos(): MutableList<Todo>{
        return todoFileStorage.readTodos().toMutableList()
    }

    fun getAllTodos(): List<Todo> {
        return getTodos()
    }

    fun createTodo(todo: Todo): Todo {
        val todos = getTodos()
        todo.id = (todos.maxOfOrNull { it.id ?: 0 } ?: 0) + 1
        todos.add(todo)
        todoFileStorage.writeTodos(todos)
        return todo
    }

    fun deleteTodo(id: Long){
        val todos = getTodos()
        todos.removeIf { it.id == id }
        todoFileStorage.writeTodos(todos)
    }

}