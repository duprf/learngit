package dwz.web.management;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import dwz.business.chapter.Chapter;
import dwz.business.chapter.ChapterConditionVO;
import dwz.business.chapter.ChapterServiceMgr;
import dwz.business.common.Author;
import dwz.business.common.AuthorServiceMgr;
import dwz.business.common.AuthorType;
import dwz.business.common.Authorizer;
import dwz.business.common.AuthorizerServiceMgr;
import dwz.business.common.Category;
import dwz.business.common.Publishing;
import dwz.business.common.PublishingServiceMgr;
import dwz.business.enums.AuthorizerRelativeType;
import dwz.business.enums.ChapterRelativeType;
import dwz.common.util.FileUtils;
import dwz.framework.config.AppConfiguration;
import dwz.persistence.BaseConditionVO;
import dwz.web.BaseController;

@Controller("management.chapterController")
@RequestMapping(value = "/management/chapter")
public class ChapterController extends BaseController{
	@Autowired
	private ChapterServiceMgr chapterMgr;
	@Autowired
	private AuthorizerServiceMgr authorizerMgr;
	@Autowired
	private PublishingServiceMgr publishingMgr;
	@Autowired
	private AuthorServiceMgr authorMgr;
	

	@RequestMapping("/lookupAuthorizer")
	public String lookupAuthorizer(@RequestParam(value="authorizerRelativeType", required=false)AuthorizerRelativeType authorizerRelativeType,
			@RequestParam(value="keywords", required=false)String keywords,
			HttpServletRequest request, Model model) {
		BaseConditionVO vo = new BaseConditionVO();
		vo.setKeywords(keywords);
		
		switch (authorizerRelativeType) {
		case author:
			List<Author> authorList = authorMgr.searchAuthor(vo);
			model.addAttribute("authorizerList", authorList);
			break;
		case publishing:
			List<Publishing> publishingList = publishingMgr.searchPublishing(vo);
			model.addAttribute("authorizerList", publishingList);
			break;
		case thirdparty:
			List<Authorizer> authorizerList = authorizerMgr.searchAuthorizer(vo);
			model.addAttribute("authorizerList", authorizerList);
			break;
		}
		
		model.addAttribute("authorizerRelativeTypeList", AuthorizerRelativeType.values());
		model.addAttribute("vo",vo);
		
		return "/management/chapter/lookupAuthorizer";
	}
	
	@RequestMapping("/list")
	public String list(ChapterConditionVO vo, Model model) {
		
		List<Chapter> chapters = chapterMgr.searchChapters(vo);

		model.addAttribute("chapters",chapters);
		model.addAttribute("vo",vo);
		return "/management/chapter/list";
	}

	@RequestMapping("/add")
	public String add(@RequestParam("relativeId") int relativeId, @RequestParam("relativeType") ChapterRelativeType relativeType, 
			 Model model) {

		Chapter chapter = new Chapter();
		chapter.setRelativeId(relativeId);
		chapter.setRelativeType(relativeType.toString());
		
		Category category = chapter.getRelativeSolr().getCategory();
		if (category != null) {
			model.addAttribute("categories", category.getSubCategories());
		}
		
		model.addAttribute("vo",chapter);
		return "/management/chapter/add";
	}

	@RequestMapping("/edit/{chapterId}")
	public String edit(@PathVariable("chapterId") int chapterId, Model model) {

		Chapter chapter = chapterMgr.getChapter(chapterId);


		Category category = chapter.getRelativeSolr().getCategory();
		if (category != null) {
			model.addAttribute("categories", category.getSubCategories());
		}
		
		model.addAttribute("chapter",chapter);
		model.addAttribute("authorTypeList", AuthorType.values());

		return "/management/chapter/edit";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ModelAndView insert(Chapter chapter, @RequestParam("file") CommonsMultipartFile mFile, HttpServletRequest request) {

		if (!mFile.isEmpty()) {
			AppConfiguration config = AppConfiguration.getInstance();
			String tmpPath = config.getTempPath();
			String ext = FileUtils.getFileExt(mFile.getOriginalFilename());
			String filePath = tmpPath + "/" +System.currentTimeMillis() + "."+ext;
			
			File file = new File(filePath); // 新建一个文件
			try {
				mFile.getFileItem().write(file); // 将上传的文件写入新建的文件中
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			chapterMgr.addChapter(chapter, file);

			
			String forwardUrl = request.getParameter("forwardUrl");
			if (forwardUrl != null) {
				forwardUrl = forwardUrl.replace("{chapterId}", String.valueOf(chapter.getId()));
				String message = getMessage("msg.add.ok");
				return ajaxDone(200, message, forwardUrl);
			}
			return ajaxDoneSuccess(getMessage("msg.operation.success"));
		} else {
			return ajaxDoneError(getMessage("msg.operation.failure"));
		}
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView update(Chapter chapter) {
		
		chapterMgr.updChapter(chapter);
		
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
	
	@RequestMapping("/delete/{chapterId}")
	public ModelAndView delete(@PathVariable("chapterId") int chapterId,ChapterConditionVO vo,Model model) {

		chapterMgr.delChapter(chapterId);
		model.addAttribute("vo",vo);

		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
}
