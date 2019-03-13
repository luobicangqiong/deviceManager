package com.soft.service;

import java.util.List;

import org.hibernate.sql.Update;

import com.soft.model.EmpInfo;

public interface EmpInfoService {
	/**
	 * query by name and phone
	 * @return
	 */
	public EmpInfo queryUserByPhone(String phone);
	
	/**
	 * add empInfo
	 * @param empInfo
	 * @return
	 */
	public boolean addEmpInfo(EmpInfo empInfo);
	
	/**
	 * update empInfo
	 * @param empInfo
	 * @return
	 */
	public boolean updateEmpInfo(EmpInfo empInfo);
	
	/**
	 * delete empInfo
	 * @param empInfo
	 * @return
	 */
	public boolean deleteEmpInfo(EmpInfo empInfo);
	
	/**
	 * query all
	 * @return
	 */
	public List<EmpInfo> queryAllEmpInfo();

}
