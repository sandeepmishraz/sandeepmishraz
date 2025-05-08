package in.library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import in.library.entity.MyBooks;
import in.library.services.MyBookService;

@Controller
public class MyBookController 
{
	@Autowired
	private MyBookService myBookService;
	
	@RequestMapping("/deletemybook/{id}")
	public String deleteMyBook(@PathVariable("id") long id)
	{
		myBookService.deleteById(id);
		return "redirect:/my_books";
	}
	
}
