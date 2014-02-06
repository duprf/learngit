package dwz.web.management;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dwz.business.common.Category;
import dwz.business.common.CategoryServiceMgr;
import dwz.framework.sys.exception.ServiceException;
import dwz.persistence.BaseConditionVO;
import dwz.web.BaseController;

@Controller("management.categoryController")
@RequestMapping(value="/management/category")
public class CatagoryController extends BaseController{
	@Autowired
	private CategoryServiceMgr categoryMgr;
	
	@RequestMapping("/json/categories/{parentCategoryId}")
	public String subCategories(@PathVariable("parentCategoryId") int parentCategoryId, Model model) {
		List<Category> categoryList = categoryMgr.getSubCategories(parentCategoryId);

		model.addAttribute("categoryList",categoryList);
		return "/management/category/json_categories";
	}
	
	@RequestMapping("")
	public String list(BaseConditionVO vo, HttpServletRequest request, Model model) {
		List<Category> categoryList = categoryMgr.searchCategory(vo);
		int totalCount = categoryMgr.searchCategoryNum(vo);
		
		vo.setTotalCount(totalCount);
		
		model.addAttribute("vo", vo);
		model.addAttribute("categoryList", categoryList);
		
		if (request.getParameter("popSelect") != null) {
			return "/management/category/popSelect";
		}
		if (request.getParameter("suggest") != null) {
			return "/management/category/suggest";
		}
		
		return "/management/category/list";
	}
	
	@RequestMapping("/add")
	public String add(@RequestParam("pid") int pid, Model model) {
		if (pid > 0) {
			Category category = categoryMgr.getCategory(pid);
			model.addAttribute("parentCategory",category);
		}
		return "/management/category/add";
	}
	
	@RequestMapping("/edit/{categoryId}")
	public String edit(@PathVariable("categoryId") int categoryId, Model model) {
		Category category = categoryMgr.getCategory(categoryId);

		model.addAttribute("category",category);

		return "/management/category/edit";
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ModelAndView insert(Category category) {
		try {
			categoryMgr.addCategory(category.getPid(), category.getSn(), category.getName());
		} catch (ServiceException e) {
			return ajaxDoneError(e.getMessage());
		}
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView update(Category category) {
		try {
			categoryMgr.updCategory(category.getId(), category.getSn(), category.getName());
		} catch (ServiceException e) {
			return ajaxDoneError(e.getMessage());
		}
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
	
	@RequestMapping("/delete/{categoryId}")
	public ModelAndView delete(@PathVariable("categoryId") int categoryId) {

		try {
			categoryMgr.delCategory(categoryId);
		} catch (ServiceException e) {
			return ajaxDoneError(e.getMessage());
		}

		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
}
