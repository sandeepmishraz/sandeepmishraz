package in.library.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.library.entity.Book;
import in.library.entity.MyBooks;
import in.library.repository.MyBookRepository;

@Service
public class MyBookService 
{
	@Autowired
	private MyBookRepository myBookRepository;
	
	public void saveMyBook(MyBooks myBook)
	{
		myBookRepository.save(myBook);
	}
	public List<MyBooks> getAllBook()
	{
		return myBookRepository.findAll();
	}
	public void deleteById(long id)
	{
		myBookRepository.deleteById(id);
	}
}
