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

import dwz.business.common.Publishing;
import dwz.business.common.PublishingServiceMgr;
import dwz.business.enums.Region;
import dwz.persistence.BaseConditionVO;
import dwz.web.BaseController;

@Controller("management.publishingController")
@RequestMapping(value="/management/publishing")
public class PublishingController extends BaseController{
	@Autowired
	private PublishingServiceMgr publishingMgr;

	@RequestMapping("")
	public String list(BaseConditionVO vo, HttpServletRequest request, Model model) {
		List<Publishing> publishingList = publishingMgr.searchPublishing(vo);
		int totalCount = publishingMgr.searchPublishingNum(vo);
		
		vo.setTotalCount(totalCount);
		
		model.addAttribute("vo", vo);
		model.addAttribute("publishingList", publishingList);
		
		if (request.getParameter("popSelect") != null) {
			return "/management/publishing/popSelect";
		}
		
		return "/management/publishing/list";
	}
	
	@RequestMapping("/add")
	public String add(Model model) {

		return "/management/publishing/add";
	}
	
	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable("id") int id, Model model) {
		Publishing publishing = publishingMgr.getPublishing(id);

		model.addAttribute("vo",publishing);

		return "/management/publishing/edit";
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ModelAndView insert(Publishing publishing) {
		try {
			publishingMgr.addPublishing(publishing);
		} catch (Exception e) {
			return ajaxDoneError(e.getMessage());
		}
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView update(Publishing publishing) {
		try {
			publishingMgr.updPublishing(publishing);
		} catch (Exception e) {
			return ajaxDoneError(e.getMessage());
		}
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
	
	@RequestMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") int publishingId) {

		try {
			publishingMgr.delPublishing(publishingId);
		} catch (Exception e) {
			return ajaxDoneError(e.getMessage());
		}

		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
	
	@RequestMapping("/agencyList")
	public String agencyList(@RequestParam("region") Region region, Model model){
		if (region != null){
			model.addAttribute("agencyList", region.getPublishingAgencyList());
		}
		
		return "/management/publishing/agencyList";
	}
}
