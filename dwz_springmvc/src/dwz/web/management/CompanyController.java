package dwz.web.management;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dwz.business.company.Company;
import dwz.business.company.CompanyServiceMgr;
import dwz.business.company.CompanyStatus;
import dwz.persistence.BaseConditionVO;
import dwz.web.BaseController;

@Controller("management.companyController")
@RequestMapping(value="/management/company")
public class CompanyController extends BaseController{
	@Autowired
	private CompanyServiceMgr companyMgr;

	@RequestMapping("")
	public String list(BaseConditionVO vo, Model model) {
		List<Company> companyList = companyMgr.searchCompany(vo);
		Integer totalCount = companyMgr.searchCompanyNum(vo);
		
		model.addAttribute("companyList", companyList);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("companyStatusList", CompanyStatus.values());
		model.addAttribute("pageSize", vo.getPageSize());

		return "/management/company/list";
	}
	
	@RequestMapping("/add")
	public String add(Model model) {
		model.addAttribute("now", new Date());
		model.addAttribute("companyStatusList", CompanyStatus.values());
		return "/management/company/add";
	}
	
	@RequestMapping("/edit/{companyId}")
	public String edit(@PathVariable("companyId") int companyId, Model model) {
		Company company = companyMgr.getCompany(companyId);

		model.addAttribute("vo", company);
		model.addAttribute("companyStatusList", CompanyStatus.values());
		
		return "/management/company/edit";
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ModelAndView insert(Company company) {
	
		companyMgr.addCompany(company);

		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView update(Company company) {
		companyMgr.updCompany(company);
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
	
	@RequestMapping("/delete/{companyId}")
	public ModelAndView delete(@PathVariable("companyId") int companyId) {

		companyMgr.delCompany(companyId);

		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
}
