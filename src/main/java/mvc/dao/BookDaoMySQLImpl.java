package mvc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import mvc.bean.Book;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
//
public class BookDaoMySQLImpl implements BookDao {

	@Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;
    
    private final String sqlAll = "SELECT * FROM library.book";

    @Override
    public List<Book> findAllBooks() {
        return jdbcTemplate.query(sqlAll, new BeanPropertyRowMapper<>(Book.class));
    }
    
    @Override
    public int addBook(Book book) {
        String sqlInsert = "INSERT INTO library.book (ISBN, bookname, bookyear) VALUES (:isbn, :bookName, :bookYear)";

        MapSqlParameterSource paramMap = new MapSqlParameterSource();
        paramMap.addValue("isbn", book.getISBN());
        paramMap.addValue("bookName", book.getBookName());
        paramMap.addValue("bookYear", book.getBookYear());

        return jdbcTemplate.update(sqlInsert, paramMap);
    }

    @Override
    // by ID
    public int updateBook(Book book) {
        String sql = "UPDATE Book SET BookName = :bookName, ISBN = :isbn, BookYear = :bookYear WHERE ID = :id";

        Map<String, Object> paramMap = new HashMap<>();;
        paramMap.put("bookName", book.getBookName());
        paramMap.put("isbn", book.getISBN());
        paramMap.put("bookYear", book.getBookYear());

        return jdbcTemplate.update(sql, paramMap);
    }

    @Override
    public Book findByName(String bookName) {
        String sql = "SELECT * FROM Book WHERE BookName = :bookName";

        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("bookName", bookName);

        return jdbcTemplate.queryForObject(sql, paramMap, new BeanPropertyRowMapper<>(Book.class));
    }

    @Override
    public Book findByISBN(String isbn) {
        String sql = "SELECT * FROM Book WHERE ISBN = :isbn";

        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("isbn", isbn);

        return jdbcTemplate.queryForObject(sql, paramMap, new BeanPropertyRowMapper<>(Book.class));
    }

    @Override
    public List<Book> findByBookYear(int bookYear) {
        String sql = "SELECT * FROM Book WHERE BookYear = :bookYear";

        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("bookYear", bookYear);

        return jdbcTemplate.query(sql, paramMap, new BeanPropertyRowMapper<>(Book.class));
    }

    @Override
    public int deleteBook(Book book) {
        String sql = "DELETE FROM library.book WHERE ID = :id";

        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", book.getID());

        return jdbcTemplate.update(sql, paramMap);
    }


	
}
