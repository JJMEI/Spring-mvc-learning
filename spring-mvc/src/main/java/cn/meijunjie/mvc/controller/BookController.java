package cn.meijunjie.mvc.controller;

import java.util.List;

import javax.annotation.Resource;

import org.junit.runners.model.FrameworkField;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.meijunjie.mvc.po.Book;
import cn.meijunjie.mvc.po.Category;
import cn.meijunjie.mvc.service.BookService;

@Controller
public class BookController {
	
	@Resource
	private BookService bookService;
	
	private static final Logger logger = LoggerFactory.getLogger(Book.class);
	
	@RequestMapping(value="/book_input")
	public String inputBook(Model model)
	{
		//通过model对象，向页面中注入数据模型，通过model的addAtribute方法将属性与对象绑定，在页面进行调用
		List<Category> categories = bookService.getAllCategoies();
		model.addAttribute("categories", categories);
		model.addAttribute("book", new Book());
		
		return "BookAddForm";
	}
	
	@RequestMapping(value="/book_save",method=RequestMethod.POST)
	public String saveBook(@ModelAttribute Book book)
	{
		Category category = bookService.getCategory(book.getCategory().getId());
		book.setCategory(category);
		bookService.save(book);
		return "redirect:/book_list";  //重定向至book 详细页面
	}
	
	@RequestMapping(value="/book_list")
	public String listBooks(Model model)
	{
		logger.info("book_list");
		List<Book> books = bookService.getAllBooks();
		model.addAttribute("books", books);
		return "BookList";
	}
	
	@RequestMapping(value="/book_edit/{id}")
	public String editBook(Model model, @PathVariable long id)
	{
		List<Category> categories = bookService.getAllCategoies();
		
		model.addAttribute("categories", categories);
		
		Book book = bookService.get(id);
		
		model.addAttribute("book", book);
		
		return "BookEditForm";
	}
	
	@RequestMapping(value="/book_delete/{id}")
	public  String deleteBook(Model model,@PathVariable long id)
	{
		logger.info("进入到方法。。。。");
		List<Book> books = bookService.getAllBooks();
		try {
			for(Book book:books)
			{
				if(book.getId() == id)
				{
						books.remove(books.indexOf(book));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/book_list";
	}
	
	@RequestMapping(value="/book_update",method=RequestMethod.POST)
	public String updateBook(@ModelAttribute Book book)
	{
		Category category = bookService.getCategory(book.getCategory().getId());
		book.setCategory(category);
		bookService.update(book);
		return "redirect:/book_list";
	}
}
