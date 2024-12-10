package com.karpen.taskmanagerapi.storage

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.karpen.taskmanagerapi.model.Todo
import org.springframework.stereotype.Component
import java.io.File

@Component
class TodoFileStorage {

    private val filePath = "todos.json"
    private val ObjectMapper = ObjectMapper()

    init {
        val file = File(filePath)
        if (!file.exists()){
            file.createNewFile()
            file.writeText("[]")
        }
    }

    fun readTodos(): List<Todo> {
        return ObjectMapper.readValue(File(filePath))
    }

    fun writeTodos(todos: List<Todo>){
        ObjectMapper.writeValue(File(filePath), todos)
    }
}