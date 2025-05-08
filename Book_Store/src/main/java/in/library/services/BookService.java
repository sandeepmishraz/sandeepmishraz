package in.library.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.library.entity.Book;
import in.library.repository.BookRepository;

@Service
public class BookService 
{
	@Autowired
	BookRepository bookRepository;
	public void save(Book b)
	{
		bookRepository.save(b);
	}
	
	public List<Book> getAllBook()
	{
		return bookRepository.findAll();
	}
	public Book getBookById(long id)
	{
		return bookRepository.findById(id).get();
	}

	public void deleteById(long id) 
	{
		bookRepository.deleteById(id);
	}
}
