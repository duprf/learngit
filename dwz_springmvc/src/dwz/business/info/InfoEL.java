package dwz.business.info;

import java.util.ArrayList;
import java.util.List;

import dwz.common.util.EnumUtils;
import dwz.framework.sys.business.BusinessFactory;

public class InfoEL {

	public static List<News> listNews(String type, Integer startIndex, Integer count) {

		if (EnumUtils.isDefined(NewsType.values(), type)) {
			NewsServiceMgr manager = BusinessFactory.getInstance().getService(NewsServiceMgr.SERVICE_NAME);
			return manager.listNewsOnWeb(NewsType.valueOf(type), startIndex, count);
		}
		return new ArrayList<News>();
	}

}
