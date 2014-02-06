package dwz.business.common.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dwz.business.common.Category;
import dwz.business.common.CategoryServiceMgr;
import dwz.framework.sys.business.AbstractBusinessObjectServiceMgr;
import dwz.framework.sys.exception.ServiceException;
import dwz.persistence.BaseConditionVO;
import dwz.persistence.beans.ComCategory;
import dwz.persistence.mapper.ComCategoryMapper;

@Service(CategoryServiceMgr.SERVICE_NAME)
public class CategoryServiceMgrImp extends AbstractBusinessObjectServiceMgr
		implements CategoryServiceMgr {

	@Autowired
	private ComCategoryMapper categoryMapper;
	
	public List<Category> getSubCategories(Integer pid) {
		ArrayList<Category> bos = new ArrayList<Category>();

		List<ComCategory> pos = this.categoryMapper.findByPid(pid != null ? pid : 1);

		if (pos == null || pos.size() == 0)
			return bos;

		for (ComCategory po : pos){
			bos.add(new Category(po));
		}

		return bos;
	}
	
	public List<Category> searchCategory(BaseConditionVO vo) {
		ArrayList<Category> bos = new ArrayList<Category>();

		RowBounds rb = new RowBounds(vo.getStartIndex(), vo.getPageSize());
		List<ComCategory> pos = this.categoryMapper.findPageBreakByCondition(vo, rb);

		if (pos == null || pos.size() == 0)
			return bos;

		for (ComCategory po : pos){
			bos.add(new Category(po));
		}

		return bos;
	}

	public int searchCategoryNum(BaseConditionVO vo) {

		Integer totalCount = this.categoryMapper.findNumberByCondition(vo);
		
		return null==totalCount ? 0 : totalCount;
	}
	
	public Category getCategory(int id) {
		ComCategory po = categoryMapper.load(id);

		return new Category(po);
	}

	public void addCategory(int pid, String sn, String name) throws ServiceException{
		if (sn == null || sn.length() == 0) {
			throw new ServiceException(getMessage("msg.category.fields.failure"));
		}
		ComCategory po = new ComCategory();
		po.setPid(pid>0 ? pid : 1);
		po.setSn(sn);
		po.setName(name);
		categoryMapper.insert(po);
		categoryMapper.procsCategoryInit(1,1);
	}

	public void updCategory(int id, String sn, String name) throws ServiceException{
		if (sn == null || sn.length() == 0) {
			throw new ServiceException(getMessage("msg.category.fields.failure"));
		}
		
		ComCategory po = categoryMapper.load(id);
		po.setSn(sn);
		po.setName(name);
		
		categoryMapper.updateSelective(po);
	}

	public void delCategory(int id) throws ServiceException {
		Integer subCategoryNum = categoryMapper.findNumberByPid(id);
		
		if (subCategoryNum != null && subCategoryNum > 0) {
			throw new ServiceException(getMessage("msg.category.del.failure1"));
		}
		
		Integer bookNum = categoryMapper.findBookNumberById(id);
		if (bookNum != null && bookNum > 0) {
			throw new ServiceException(getMessage("msg.category.del.failure2", bookNum));
		}
		
		categoryMapper.delete(id);
		categoryMapper.procsCategoryInit(1,1);
	}

	public List<Category> getParentCategories(Integer categoryId) {
		ArrayList<Category> bos = new ArrayList<Category>();

		List<ComCategory> pos = this.categoryMapper.findParentCategories(categoryId);

		if (pos == null || pos.size() == 0)
			return bos;

		for (ComCategory po : pos){
			bos.add(new Category(po));
		}

		return bos;
	}

	

}
