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

import dwz.business.common.Authorizer;
import dwz.business.common.AuthorizerServiceMgr;
import dwz.persistence.BaseConditionVO;
import dwz.web.BaseController;

@Controller("management.authorizerController")
@RequestMapping(value="/management/authorizer")
public class AuthorizerController extends BaseController{
	@Autowired
	private AuthorizerServiceMgr authorizerMgr;

	
	@RequestMapping("")
	public String list(BaseConditionVO vo, HttpServletRequest request, Model model) {
		List<Authorizer> authorizerList = authorizerMgr.searchAuthorizer(vo);
		int totalCount = authorizerMgr.searchAuthorizerNum(vo);
		
		vo.setTotalCount(totalCount);
		
		model.addAttribute("vo", vo);
		model.addAttribute("authorizerList", authorizerList);
		
		if (request.getParameter("popSelect") != null) {
			return "/management/authorizer/popSelect";
		}
		
		return "/management/authorizer/list";
	}
	
	@RequestMapping("/add")
	public String add(Model model) {

		return "/management/authorizer/add";
	}
	
	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable("id") int id, Model model) {
		Authorizer authorizer = authorizerMgr.getAuthorizer(id);

		model.addAttribute("vo",authorizer);

		return "/management/authorizer/edit";
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ModelAndView insert(Authorizer authorizer) {
		try {
			authorizerMgr.addAuthorizer(authorizer);
		} catch (Exception e) {
			return ajaxDoneError(e.getMessage());
		}
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView update(Authorizer authorizer) {
		try {
			authorizerMgr.updAuthorizer(authorizer);
		} catch (Exception e) {
			return ajaxDoneError(e.getMessage());
		}
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
	
	@RequestMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") int id) {

		try {
			authorizerMgr.delAuthorizer(id);
		} catch (Exception e) {
			return ajaxDoneError(e.getMessage());
		}

		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
}
