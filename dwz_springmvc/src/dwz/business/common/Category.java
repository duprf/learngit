/*
 * Powered By [dwz4j-framework]
 * Web Site: http://j-ui.com
 * Google Code: http://code.google.com/p/dwz4j/
 * Generated 2012-11-24 16:41:30 by code generator
 */
package dwz.business.common;

import java.util.List;

import org.apache.commons.lang.StringEscapeUtils;

import dwz.framework.sys.business.AbstractBusinessObject;
import dwz.framework.sys.business.BusinessFactory;
import dwz.persistence.beans.ComCategory;

public class Category extends AbstractBusinessObject{
	private static final long serialVersionUID = 1L;
	private ComCategory comCategory;
	private List<Category> parentCategories;
	
	/* generateConstructor */
	public Category() {
		this.comCategory = new ComCategory();
	}
	public Category(ComCategory comCategory) {
		this.comCategory = comCategory;
	}
	public ComCategory getComCategory(){
		return this.comCategory;
	}

	
	public Integer getId() {
		return this.comCategory.getId();
	}

	public void setId(Integer id) {
		this.comCategory.setId(id);
	}
	
	public String getSn() {
		return this.comCategory.getSn();
	}

	public void setSn(String sn) {
		this.comCategory.setSn(sn);
	}
	
	public String getName() {
		return this.comCategory.getName();
	}

	public void setName(String name) {
		this.comCategory.setName(name);
	}
	
	public int getPid() {
		Integer value = this.comCategory.getPid();
		return value != null ? value : 0;
	}

	public void setPid(int pid) {
		this.comCategory.setPid(pid);
	}
	
	public int getLft() {
		Integer value = this.comCategory.getLft();
		return value != null ? value : 0;
	}

	public int getRgt() {
		Integer value = this.comCategory.getRgt();
		return value != null ? value : 0;
	}

	public int getDepth() {
		Integer value = this.comCategory.getDepth();
		return value != null ? value : 0;
	}

	public boolean isLeaf() {
		return getRgt() == getLft() + 1;
	}
	
	public List<Category> getSubCategories() {
		CategoryServiceMgr categoryMgr = BusinessFactory.getInstance().getService(CategoryServiceMgr.SERVICE_NAME);
		return categoryMgr.getSubCategories(this.getId());
	}

	public List<Category> getParentCategories() {
		int categoryId = this.getId();
		if (categoryId > 0 && parentCategories == null) {
			CategoryServiceMgr categoryMgr = BusinessFactory.getInstance().getService(CategoryServiceMgr.SERVICE_NAME);
			parentCategories = categoryMgr.getParentCategories(categoryId);
		}
		return parentCategories;
	}
	
	public String getParentNames(){
		String parentNames = null;
		
		List<Category> _parents = getParentCategories();
		
		if (_parents != null) {
			for (Category parent: _parents) {
				if (parentNames == null){
					parentNames = parent.getName();
				} else {
					parentNames += " -> " + parent.getName();
				}
			}
		}
		
//		if (parentNames != null) {
//			parentNames = parentNames.replaceAll("\\s", "");
//		}
		
		return parentNames;
	}
}

