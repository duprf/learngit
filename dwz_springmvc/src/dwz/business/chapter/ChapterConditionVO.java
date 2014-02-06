package dwz.business.chapter;

import dwz.persistence.BaseConditionVO;

public class ChapterConditionVO extends BaseConditionVO {

	private Integer relativeId;
	private String relativeType;

	public Integer getRelativeId() {
		return relativeId;
	}

	public void setRelativeId(Integer relativeId) {
		this.relativeId = relativeId;
	}

	public String getRelativeType() {
		return relativeType;
	}

	public void setRelativeType(String relativeType) {
		this.relativeType = relativeType;
	}

}
