package com.ncs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ncs.model.Todo;
import com.ncs.service.TodoService;

@CrossOrigin
@RestController
@RequestMapping("/todos")
public class TodoController {
	
	@Autowired
	TodoService todoService;

	@GetMapping
	public ResponseEntity<List<Todo>> getTodos() {
		return new ResponseEntity<List<Todo>>(todoService.getTodos(), HttpStatus.OK);
	}
	
	@GetMapping("/user/{user}")
	public ResponseEntity<List<Todo>> getTodosByUser(@PathVariable String user) {
		return new ResponseEntity<List<Todo>>(todoService.getTodosByUser(user), HttpStatus.OK);
	}
	
	@GetMapping("/todoid/{todoid}")
	public ResponseEntity<Todo> getTodosById(@PathVariable int todoid) {
		return new ResponseEntity<Todo>(todoService.getTodosById(todoid), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Todo> addTodo(@RequestBody Todo todo) {
		return new ResponseEntity<Todo>(todoService.addTodo(todo), HttpStatus.CREATED);
	}
	
	@DeleteMapping
	public ResponseEntity<Todo> deleteTodo(@RequestBody int todoid) {
		return new ResponseEntity<Todo>(todoService.deleteTodo(todoid), HttpStatus.OK);
	}
	
	@PatchMapping("/todoid/{todoid}/user/{user}")
	public ResponseEntity<Todo> patchTodoUser(@PathVariable int todoid, @PathVariable String user) {
		return new ResponseEntity<Todo>(todoService.patchTodoUser(todoid, user), HttpStatus.OK);
	}
	
	@PatchMapping("/todoid/{todoid}/desc/{desc}")
	public ResponseEntity<Todo> patchTodoDesc(@PathVariable int todoid, @PathVariable String desc) {
		return new ResponseEntity<Todo>(todoService.patchTodoDesc(todoid, desc), HttpStatus.OK);
	}
	
	@PatchMapping("/todoid/{todoid}/date/{date}")
	public ResponseEntity<Todo> patchTodoDate(@PathVariable int todoid, @PathVariable String date) {
		return new ResponseEntity<Todo>(todoService.patchTodoDate(todoid, date), HttpStatus.OK);
	}
	
	@PatchMapping("/todoid/{todoid}/done/{done}")
	public ResponseEntity<Todo> patchTodoDone(@PathVariable int todoid, @PathVariable String done) {
		return new ResponseEntity<Todo>(todoService.patchTodoDone(todoid, done), HttpStatus.OK);
	}
}
