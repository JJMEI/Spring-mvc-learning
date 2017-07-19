package cn.meijunjie.mvc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import cn.meijunjie.mvc.po.Book;
import cn.meijunjie.mvc.po.Category;

@Service
public class BookServiceImpl  implements BookService

{
	private List<Category> categories;
	private List<Book> books;
	
	public  BookServiceImpl() 
	{
		categories = new ArrayList<Category>();
		Category category1 = new Category(1, "Computing");
		Category category2 = new Category(2, "Travel");
		Category category3 = new Category(3,"Health");
		
		categories.add(category1);
		categories.add(category2);
		categories.add(category3);
		
		books = new ArrayList<Book>();
		books.add(new Book(1L, "3432423423", "Ser", category1, "meijunjie"));
		books.add(new Book(2L, "343242323423", "Ser", category2, "meijunjie"));
	}
	@Override
	public List<Category> getAllCategoies() {
		return categories;
	}

	@Override
	public Category getCategory(int id) {
		for(Category category:categories)
		{
			if(id == category.getId())
			{
				return category;
			}
		}
		return null; 
	}

	@Override
	public List<Book> getAllBooks() {
		return books;
	}

	@Override
	public Book save(Book book) {
		book.setId(getNextId());
		books.add(book);
		return book;
	}

	@Override
	public Book update(Book book) {
		int bookCount = books.size();
		for(int i=0;i<bookCount;i++)
		{
			Book saveBook = books.get(i);
			if(saveBook.getId() == book.getId())
			{
				books.set(1, book);
				return book;
			}
		}
		return book;
	}

	@Override
	public Book get(long id) {
		for(Book book:books)
		{
			if(id == book.getId())
			{
				return book;
			}
		}
		return null;
	}

	@Override
	public long getNextId() {
		long id = 0L;
		for(Book book:books)
		{
			long bookId = book.getId();
			if(bookId > id)
			{
				id = bookId;
			}
		}
		return id + 1;
	}
	
	@Override
	public void deleteBook(long id) {
			books.remove((int) id);
	
	}

}
