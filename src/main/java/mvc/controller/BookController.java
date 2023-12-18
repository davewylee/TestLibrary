package mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/library")
public class BookController {

	@GetMapping()
	@ResponseBody
	public String spring(HttpServletRequest req, HttpServletResponse resp) {
		return "Hello ! Spring!";
	}

	@GetMapping("/123")
	@ResponseBody
	public String hello(@ModelAttribute Model model) {
		return "123";
	}

//	@Autowired
//	@Qualifier("BookDaoMySQLImpl")
//	private BookDao bookDao;
//
//	@GetMapping("/hello")
//	public String model(Model model) {
//		model.addAttribute("submit", "Hello");
//		return "hello";
//	}

//	@PostMapping("/add")
//	public String addBook(@ModelAttribute Book book, Model model) {
//		// You can add validation logic here if needed
//
//		// Call the addBook method in the BookDao implementation
//		int result = bookDao.addBook(book);
//
//		if (result > 0) {
//			model.addAttribute("message", "Book added successfully");
//		} else {
//			model.addAttribute("message", "Failed to add book");
//		}
//
//		return "add-book-result"; // Return the name of the HTML result page
//	}

}
