package in.library.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import in.library.entity.Book;
import in.library.entity.MyBooks;
import in.library.services.BookService;
import in.library.services.MyBookService;

@org.springframework.stereotype.Controller
public class Controller 
{
	@Autowired
	private BookService bookService;
	
	@Autowired
	private MyBookService myBookService;
	
	@GetMapping("/")
	public String home()
	{
		return "index";
	}
	@GetMapping("/book_register")
	public String bookRegister()
	{
		return "bookRegister";
	}
	@GetMapping("/available_Book")
	public ModelAndView getAllBook()
	{
		List<Book> list = bookService.getAllBook();
//		ModelAndView m =new ModelAndView();
//		m.setViewName("booklist");		
//		m.addObject("book", list);
//		return m;
		
		return new ModelAndView("booklist", "book", list);
	}
	
	@PostMapping("/save")
	public String saveBook(@ModelAttribute Book b)
	{
		bookService.save(b);
		return "redirect:/available_Book";
	}
	
	@GetMapping("my_books")
	public String myBooks(Model model)
	{
		List<MyBooks> list = myBookService.getAllBook();
		model.addAttribute("book", list);
		return "mybooks";
	}
	@RequestMapping("/myList/{id}")
	public String getMyBook( @PathVariable("id") long id )
	{
		Book b= bookService.getBookById(id);
		MyBooks myBooks=new MyBooks(b.getId(), b.getName(), b.getAuthor(), b.getPrice());
		myBookService.saveMyBook(myBooks);
		return "redirect:/my_books";
	}
	@RequestMapping("/deletebook/{id}")
	public String deleteMyBook(@PathVariable("id") long id)
	{
		bookService.deleteById(id);
		return "redirect:/available_Book";
	}
	
	@RequestMapping("/editbook/{id}")
	public String editBook(@PathVariable("id") long id,Model model)
	{
		model.addAttribute("book", bookService.getBookById(id));
		return "bookedit";
	}
}













