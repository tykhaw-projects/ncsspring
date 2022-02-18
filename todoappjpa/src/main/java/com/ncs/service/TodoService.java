package com.ncs.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncs.model.Todo;
import com.ncs.repository.TodoRepository;

@Service
public class TodoService {
	
	@Autowired
	TodoRepository todoRepository;
	
	ArrayList<Todo> todoArr = new ArrayList<>();
	
	{
		todoArr.add(new Todo(1, "test1", "todo1", LocalDate.now(), false));
		todoArr.add(new Todo(2, "test2", "todo2", LocalDate.now(), false));
		todoArr.add(new Todo(3, "test3", "todo3", LocalDate.now(), false));
	}
	
	public List<Todo> getTodos(){
		return todoArr;
	}
	
	
	public List<Todo> getTodosByUser(String user){
		ArrayList<Todo> resultArr = new ArrayList<>();
		
		for (Todo todo : todoArr) {
			if(todo.getUser().equals(user)) {
				resultArr.add(todo);
			}
		}
		
		return resultArr;
	}
	
	
	public Todo getTodosById(int id){
		
		for (Todo todo : todoArr) {
			if(todo.getTodoid() == id) {
				return todo;
			}
		}
		
		return new Todo(0, "default", "default", LocalDate.now(), false);
	}
	
	
	public Todo addTodo(Todo todo){
		
//		todoArr.add(todo);
//		
//		return todo;
		
		return todoRepository.saveAndFlush(todo);
	}
	
	public Todo deleteTodo(int todoid){
		
		Todo todo = todoArr.stream().filter(t -> t.getTodoid() == todoid).findFirst().orElseThrow();
		
		todoArr.remove(todo);
		
		return todo;
	}


	public Todo patchTodoUser(int todoid, String user) {
		
		Todo todo = todoArr.stream().filter(t -> t.getTodoid() == todoid).findFirst().orElseThrow();
		
		todo.setUser(user);
		
		return todo;
	}
	
	public Todo patchTodoDesc(int todoid, String desc) {
		
		Todo todo = todoArr.stream().filter(t -> t.getTodoid() == todoid).findFirst().orElseThrow();
		
		todo.setDesc(desc);
		
		return todo;
	}
	
	public Todo patchTodoDate(int todoid, String date) {
		
		Todo todo = todoArr.stream().filter(t -> t.getTodoid() == todoid).findFirst().orElseThrow();
		
		todo.setTargetDate(LocalDate.parse(date));;
		
		return todo;
	}

	public Todo patchTodoDone(int todoid, String done) {
	
	Todo todo = todoArr.stream().filter(t -> t.getTodoid() == todoid).findFirst().orElseThrow();
	
	if(done.equalsIgnoreCase("true")) {
		todo.setDone(true);
	} else {
		todo.setDone(false);
	}
	
	return todo;
	}

}
