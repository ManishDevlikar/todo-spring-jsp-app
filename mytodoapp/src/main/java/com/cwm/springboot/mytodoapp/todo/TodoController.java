package com.cwm.springboot.mytodoapp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class TodoController {
	@Autowired
	private TodoService todoService;

	@GetMapping("todo-list")
	public String findAllTodos(ModelMap modelMap) {
		List<Todo> todos = todoService.findAllByUsername(getLoggedInUsername());
		modelMap.addAttribute("todoList", todos);
		return "listTodos";
	}

	@GetMapping("add-todo")
	public String showNewTodo(ModelMap model) {
		Todo todo = new Todo(0, (String) (model.get("name")), "", LocalDate.now().plusYears(1), false);
		model.put("todo", todo);
		return "todo";
	}

	@PostMapping("add-todo")
	public String addNewTodo(ModelMap model, @Valid Todo todos, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "todo";
		}
		todoService.addNewTodo(getLoggedInUsername(), todos.getDescription(), todos.getTargetDate(), todos.isDone());
		// if we dont use the redirect we need to write the logic onces again to
		return "redirect:todo-list";
	}

	@GetMapping("delete-todo")
	public String deleteTodo(@RequestParam int id) {
		todoService.deleteTodo(id);
		return "redirect:todo-list";
	}

	@GetMapping("update-todo")
	public String showUpdateToDo(@RequestParam int id, ModelMap model) {
		Todo todo = todoService.findById(id);
		model.put("todo", todo);
		return "todo";
	}

	@PostMapping("update-todo")
	public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "todo";
		}
		todo.setUsername(getLoggedInUsername());
		todoService.updateTodo(todo);
		return "redirect:todo-list";
	}

	private String getLoggedInUsername() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
}
