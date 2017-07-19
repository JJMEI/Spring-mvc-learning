package cn.meijunjie.mvc.service;

import java.util.List;

import cn.meijunjie.mvc.po.Book;
import cn.meijunjie.mvc.po.Category;

public interface BookService {

	List<Category> getAllCategoies();
	Category getCategory(int id);
	
	List<Book> getAllBooks();
	
	Book save(Book book);
	Book update(Book book);
	Book get(long id);
	long getNextId();
	void deleteBook(long id);
	
}
