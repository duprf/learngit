package dwz.web.management;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dwz.business.common.Author;
import dwz.business.common.AuthorServiceMgr;
import dwz.business.common.AuthorType;
import dwz.persistence.BaseConditionVO;
import dwz.web.BaseController;

@Controller("management.authorController")
@RequestMapping(value="/management/author")
public class AuthorController extends BaseController{
	@Autowired
	private AuthorServiceMgr authorMgr;
	
	
	@RequestMapping("/authorTypeSelect")
	public String authorTypeSelect(Model model) {
		model.addAttribute("authorTypeList", AuthorType.values());

		return "/management/author/authorTypeSelect";
	}
	
	@RequestMapping("")
	public String list(BaseConditionVO vo, HttpServletRequest request, Model model) {
		List<Author> authorList = authorMgr.searchAuthor(vo);
		int totalCount = authorMgr.searchAuthorNum(vo);
		
		vo.setTotalCount(totalCount);
		
		model.addAttribute("vo", vo);
		model.addAttribute("authorList", authorList);
		
		if (request.getParameter("popSelect") != null) {
			return "/management/author/popSelect";
		}
		
		return "/management/author/list";
	}
	
	@RequestMapping("/add")
	public String add(Model model) {

		return "/management/author/add";
	}
	
	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable("id") int id, Model model) {
		Author author = authorMgr.getAuthor(id);

		model.addAttribute("vo",author);

		return "/management/author/edit";
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ModelAndView insert(Author author) {
		try {
			authorMgr.addAuthor(author);
		} catch (Exception e) {
			return ajaxDoneError(e.getMessage());
		}
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView update(Author author) {
		try {
			authorMgr.updAuthor(author);
		} catch (Exception e) {
			return ajaxDoneError(e.getMessage());
		}
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
	
	@RequestMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") int id) {

		try {
			authorMgr.delAuthor(id);
		} catch (Exception e) {
			return ajaxDoneError(e.getMessage());
		}

		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
}
