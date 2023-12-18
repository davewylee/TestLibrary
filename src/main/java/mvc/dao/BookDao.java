package mvc.dao;

import java.util.List;

import mvc.bean.Book;

public interface BookDao {
	
	List<Book> findAllBooks();
	
	int addBook(Book book);

    int updateBook(Book book);
    
    int deleteBook(Book book);

    // Find a book by name
    Book findByName(String bookName);

    // Find a book by ISBN
    Book findByISBN(String isbn);

    // Find a book by book year
    List<Book> findByBookYear(int bookYear);
}