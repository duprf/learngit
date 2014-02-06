package dwz.web.management;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import dwz.business.book.Book;
import dwz.business.book.BookServiceMgr;
import dwz.business.chapter.ChapterConditionVO;
import dwz.business.common.Category;
import dwz.business.common.CategoryServiceMgr;
import dwz.framework.sys.exception.ServiceException;
import dwz.web.BaseController;

@Controller("management.bookController")
@RequestMapping(value="/management/book")
public class BookController extends BaseController{
	@Autowired
	private BookServiceMgr bookMgr;
	@Autowired
	private CategoryServiceMgr categoryMgr;
	
	@ModelAttribute("topCategories")
	public List<Category> getTopCategories() {
		return categoryMgr.getSubCategories(null);
	}
	
	@RequestMapping("")
	public String list(ChapterConditionVO vo, Model model) {
		List<Book> bookList = bookMgr.searchBook(vo);
		model.addAttribute(bookList);
		return "/management/book/list";
	}
	
	@RequestMapping("/add")
	public String add(Model model) {
		return "/management/book/add";
	}
	
	@RequestMapping("/edit/{bookId}")
	public String edit(@PathVariable("bookId") int bookId, Model model) {
		Book book = bookMgr.getBook(bookId);

		model.addAttribute(book);
		
		return "/management/book/edit";
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ModelAndView insert(Book book) {
		bookMgr.addBook(book);

		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView update(Book book) {
		bookMgr.updBook(book);
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
	
	@RequestMapping("/uploadIcon/{bookId}")
	public String uploadIcon(@PathVariable("bookId") int bookId, Model model) {
		Book book = bookMgr.getBook(bookId);

		model.addAttribute(book);

		return "/management/book/uploadIcon";
	}
	@RequestMapping(value = "/doUploadIcon/{bookId}", method = RequestMethod.POST)
	public ModelAndView doUploadIcon(@PathVariable("bookId") int bookId, @RequestParam("file") CommonsMultipartFile mFile) {
		
		try {
			bookMgr.uploadIcon(bookId, mFile);
		} catch (ServiceException e) {
			return ajaxDoneError(e.getMessage());
		}
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
	
	@RequestMapping("/delete/{bookId}")
	public ModelAndView delete(@PathVariable("bookId") int bookId) {

		try {
			bookMgr.delBook(bookId);
		} catch (ServiceException e) {
			return ajaxDoneError(e.getMessage());
		}

		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
}
