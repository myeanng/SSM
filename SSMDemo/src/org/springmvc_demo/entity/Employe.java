package org.springmvc_demo.entity;

import java.io.Serializable;

public class Employe implements Serializable{

	private static final long serialVersionUID = -1676047787126063908L;

	private Integer empId;
	private String empName;
	private String email;
	private Group group;
	
	public Employe() {}

	public Employe(String empName, String email, Group group) {
		super();
		this.empName = empName;
		this.email = email;
		this.group = group;
	}

	public Employe(Integer empId, String empName, String email) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.email = email;
	}

	public Employe(Integer empId, String empName, String email, Group group) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.email = email;
		this.group = group;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	@Override
	public String toString() {
		return "Employe [email=" + email + ", empId=" + empId + ", empName="
				+ empName + ", group=" + group + "]";
	}
}
