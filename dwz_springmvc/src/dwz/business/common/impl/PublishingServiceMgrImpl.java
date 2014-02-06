package dwz.business.common.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dwz.business.common.Publishing;
import dwz.business.common.PublishingServiceMgr;
import dwz.framework.sys.business.AbstractBusinessObjectServiceMgr;
import dwz.framework.sys.exception.ServiceException;
import dwz.persistence.BaseConditionVO;
import dwz.persistence.beans.ComPublishing;
import dwz.persistence.mapper.ComPublishingMapper;

@Transactional(rollbackFor = Exception.class)
@Service(PublishingServiceMgr.SERVICE_NAME)
public class PublishingServiceMgrImpl extends AbstractBusinessObjectServiceMgr
		implements PublishingServiceMgr {

	@Autowired
	private ComPublishingMapper publishingMapper;
	
//	@Autowired
//	private ResJournalMapper journalMapper;

	public List<Publishing> searchPublishing(BaseConditionVO vo) {
		List<Publishing> bos = new ArrayList<Publishing>();

		RowBounds rb = new RowBounds(vo.getStartIndex(), vo.getPageSize());
		List<ComPublishing> pos = publishingMapper.findPageBreakByCondition(vo, rb);

		for (ComPublishing po : pos) {
			bos.add(new Publishing(po));
		}
		return bos;
	}
	
	public List<Publishing> searchPublishingWeight() {
		List<Publishing> bos = new ArrayList<Publishing>();

		List<ComPublishing> pos = publishingMapper.findPublishingWeight();
		
		for (ComPublishing po : pos) {
			bos.add(new Publishing(po));
		}
		return bos;
	}

	public Integer searchPublishingNum(BaseConditionVO vo) {

		return publishingMapper.findNumberByCondition(vo);
	}

	public Publishing getPublishing(int id) {
		ComPublishing po = publishingMapper.load(id);
		if (po == null) return null;
		
		return new Publishing(po);
	}

	public void addPublishing(Publishing publishing) {
		publishingMapper.insert(publishing.getComPublishing());
	}

	public void updPublishing(Publishing publishing) {
		ComPublishing po = publishingMapper.load(publishing.getId());
		po.setName(publishing.getName());
		po.setRegion(publishing.getRegion().toString());
		po.setWeight(publishing.getWeight());
		if (publishing.getAgency() != null) {
			po.setAgency(publishing.getAgency().toString());
		}
		po.setSummary(publishing.getSummary());
		po.setDescription(publishing.getDescription());
		
		publishingMapper.updateSelective(po);
	}

	public void delPublishing(int id) throws ServiceException {
		
//		int count = journalMapper.countByPublishingId(id);
//		if (count > 0) {
//			throw new ServiceException(getMessage("msg.del.related", "journal"));
//		}
		
		publishingMapper.delete(id);
	}

}
