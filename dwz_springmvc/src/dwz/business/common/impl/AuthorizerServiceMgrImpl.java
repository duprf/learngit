package dwz.business.common.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dwz.business.common.Authorizer;
import dwz.business.common.AuthorizerServiceMgr;
import dwz.business.enums.AuthorizerRelativeType;
import dwz.framework.sys.business.AbstractBusinessObjectServiceMgr;
import dwz.framework.sys.exception.ServiceException;
import dwz.persistence.BaseConditionVO;
import dwz.persistence.beans.ComAuthorizer;
import dwz.persistence.mapper.ComAuthorizerMapper;
import dwz.persistence.mapper.ResChapterAuthorizerMapper;

@Transactional(rollbackFor = Exception.class)
@Service(AuthorizerServiceMgr.SERVICE_NAME)
public class AuthorizerServiceMgrImpl extends AbstractBusinessObjectServiceMgr
		implements AuthorizerServiceMgr {

	@Autowired
	private ComAuthorizerMapper authorizerMapper;
	
	@Autowired
	private ResChapterAuthorizerMapper chapterAuthorizerMapper;

	public List<Authorizer> searchAuthorizer(BaseConditionVO vo) {
		List<Authorizer> bos = new ArrayList<Authorizer>();

		RowBounds rb = new RowBounds(vo.getStartIndex(), vo.getPageSize());
		List<ComAuthorizer> pos = authorizerMapper.findPageBreakByCondition(
				vo.getKeywords(), rb);

		for (ComAuthorizer po : pos) {
			bos.add(new Authorizer(po));
		}

		return bos;
	}

	public Integer searchAuthorizerNum(BaseConditionVO vo) {

		return authorizerMapper.findNumberByCondition(vo.getKeywords());
	}

	public Authorizer getAuthorizer(int id) {
		ComAuthorizer po = authorizerMapper.load(id);
		return new Authorizer(po);
	}

	public void addAuthorizer(Authorizer authorizer) {
		authorizerMapper.insert(authorizer.getComAuthorizer());
	}

	public void updAuthorizer(Authorizer authorizer) {
		ComAuthorizer po = authorizerMapper.load(authorizer.getId());
		po.setName(authorizer.getName());
		po.setRegion(authorizer.getRegion().toString());
		po.setSummary(authorizer.getSummary());
		po.setDescription(authorizer.getDescription());
		
		authorizerMapper.updateSelective(po);
	}

	public void delAuthorizer(int id) throws ServiceException {
		int count = chapterAuthorizerMapper.countByRelativeIdAndType(id, AuthorizerRelativeType.thirdparty.toString());
		if (count > 0) {
			throw new ServiceException(getMessage("msg.del.related", "chapter_authorizer"));
		}
		authorizerMapper.delete(id);
	}

}
