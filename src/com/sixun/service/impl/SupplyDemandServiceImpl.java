package com.sixun.service.impl;

import java.util.List;

import com.sixun.entity.SupplyDemand;
import com.sixun.page.PageBean;
import com.sixun.service.ISupplyDemandService;
import com.sixun.util.StringUtils;

public class SupplyDemandServiceImpl implements ISupplyDemandService {

	public PageBean<SupplyDemand> list(String pageNow, String supplyDemand) {
		PageBean<SupplyDemand> pb = new PageBean<SupplyDemand>();
		if (!StringUtils.checkNull(pageNow)) {
			try {
				pb.setPageNow(Integer.parseInt(pageNow));
				pb.setCondition(supplyDemand);
			} catch (NumberFormatException e) {
				throw new RuntimeException("��ҳ��ѯ������Ϣʱ�����ҳ��Ϊ������");
			}
		}

		System.out.println("��û�������ﴴ������");
		supplyDemandDao.getByPage(pb, supplyDemand);
		return pb;
	}

	public boolean add(SupplyDemand sd) {
		if (sd == null)
			return false;
		return supplyDemandDao.add(sd);
	}

	public boolean update(SupplyDemand sd) {
		if (sd == null)
			return false;
		return supplyDemandDao.update(sd);

	}

	public boolean delete(String id) {
		if (StringUtils.checkNull(id))
			return false;
		try {
			return supplyDemandDao.delete(Integer.parseInt(id));
		} catch (NumberFormatException e) {
			throw new RuntimeException("ɾ��������Ϣʱ�����idΪ������");
		}
	}

	public List<SupplyDemand> getAll() {
		return supplyDemandDao.getAll();
	}

	public List<SupplyDemand> getByName(String name) {
		if (StringUtils.checkNull(name)) {
			// select * from messages
			return supplyDemandDao.getAll();
		} else {
			// select * from messages where username like '%name%'
			return supplyDemandDao.getByName(name);
		}
	}

	public SupplyDemand getById(String id) {
		if (StringUtils.checkNull(id))
			return null;
		try {
			return supplyDemandDao.getById(Integer.parseInt(id));
		} catch (Exception e) {
			throw new RuntimeException("����id��ѯ������Ϣʱ��idΪ������");
		}
	}
}
