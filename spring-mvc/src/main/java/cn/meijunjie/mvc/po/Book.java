package cn.meijunjie.mvc.po;

import java.io.Serializable;


public class Book  implements Serializable{
	
	private static final long serialVersionId = 4254545344543432L;
	
	private long id;
	private String isbn;
	private String title;
	private Category category;
	
	public Book()
	{
		
	}
	
	public Book(long id, String isbn, String title, Category category, String author) {
		super();
		this.id = id;
		this.isbn = isbn;
		this.title = title;
		this.category = category;
		this.author = author;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	private String author;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public static long getSerialversionid() {
		return serialVersionId;
	}
	
	
	
}
