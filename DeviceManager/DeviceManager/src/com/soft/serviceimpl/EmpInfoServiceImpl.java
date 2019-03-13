package com.soft.serviceimpl;

import java.util.List;

import com.soft.dao.EmpInfoDAO;
import com.soft.model.EmpInfo;
import com.soft.service.EmpInfoService;

public class EmpInfoServiceImpl implements EmpInfoService {
	
	EmpInfoDAO empInfoDAO;
	
	public void setEmpInfoDAO(EmpInfoDAO empInfoDAO) {
		this.empInfoDAO = empInfoDAO;
	}
	
	

	@Override
	public boolean addEmpInfo(EmpInfo empInfo) {
		// TODO Auto-generated method stub
		try {
			empInfoDAO.save(empInfo);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateEmpInfo(EmpInfo empInfo) {
		// TODO Auto-generated method stub
		try {
			empInfoDAO.update(empInfo);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteEmpInfo(EmpInfo empInfo) {
		// TODO Auto-generated method stub
		try {
			empInfoDAO.delete(empInfo);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<EmpInfo> queryAllEmpInfo() {
		// TODO Auto-generated method stub
		try {
			List<EmpInfo> list = empInfoDAO.findAll(EmpInfo.class);
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}



	@Override
	public EmpInfo queryUserByPhone(String phone) {
		// TODO Auto-generated method stub
		try {
			List<EmpInfo> list = empInfoDAO.findByProperty(EmpInfo.class, "empMobile",phone);
			if(list.size() != 0)
			{
				
				return list.get(0);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return null;
	}


}
