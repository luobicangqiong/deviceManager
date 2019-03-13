package com.soft.model;

import java.util.HashSet;
import java.util.Set;

/**
 * EmpInfo entity. @author MyEclipse Persistence Tools
 */

public class EmpInfo implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String empId;
	private String empMobile;
	private String empName;
	private String empDep;
	private String empAddrass;
	private String empEmail;
	private String partCompany;
	

	/** default constructor */
	public EmpInfo() {
	}

	/** full constructor */
	

	// Property accessors

	public String getEmpId() {
		return this.empId;
	}

	public EmpInfo(String empId, String empMobile, String empName, String empDep, String empAddrass, String empEmail,
			String partCompany) {
		super();
		this.empId = empId;
		this.empMobile = empMobile;
		this.empName = empName;
		this.empDep = empDep;
		this.empAddrass = empAddrass;
		this.empEmail = empEmail;
		this.partCompany = partCompany;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpMobile() {
		return this.empMobile;
	}

	public void setEmpMobile(String empMobile) {
		this.empMobile = empMobile;
	}

	public String getEmpName() {
		return this.empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpDep() {
		return this.empDep;
	}

	public void setEmpDep(String empDep) {
		this.empDep = empDep;
	}

	public String getEmpAddrass() {
		return this.empAddrass;
	}

	public void setEmpAddrass(String empAddrass) {
		this.empAddrass = empAddrass;
	}

	public String getEmpEmail() {
		return this.empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	public String getPartCompany() {
		return this.partCompany;
	}

	public void setPartCompany(String partCompany) {
		this.partCompany = partCompany;
	}

	@Override
	public String toString() {
		return "EmpInfo [empId=" + empId + ", empMobile=" + empMobile + ", empName=" + empName + ", empDep=" + empDep
				+ ", empAddrass=" + empAddrass + ", empEmail=" + empEmail + ", partCompany=" + partCompany
				+ "]";
	}
	
}