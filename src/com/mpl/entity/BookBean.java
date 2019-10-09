package com.mpl.entity;

public class BookBean {
	private int id;
	private String bookName;
	private int price;
	private String description;

	public BookBean() {
		super();
	}

	public BookBean(int id, String bookName, int price, String description) {
		super();
		this.id = id;
		this.bookName = bookName;
		this.price = price;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "BookBean [id=" + id + ", bookName=" + bookName + ", price=" + price + ", description=" + description
				+ "]";
	}

}
