package mvc.bean;

public class Book {
	
	private Integer ID;
	private Integer bookYear;
	private String bookName;
	private String ISBN;
	
	public Book() {
		
	}
	

	public Book(Integer iD, Integer bookYear, String bookName) {
		ID = iD;
		this.bookYear = bookYear;
		this.bookName = bookName;
	}

	public String getISBN() {
		return ISBN;
	}
	
	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
	}
	
	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public Integer getBookYear() {
		return bookYear;
	}

	public void setBookYear(Integer bookYear) {
		this.bookYear = bookYear;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	@Override
	public String toString() {
		return "Book [ID=" + ID + ", bookYear=" + bookYear + ", bookName=" + bookName + "]";
	}
	

}
