package org.springmvc_demo.entity;

import java.io.Serializable;
import java.util.List;


public class Group implements Serializable{

	private static final long serialVersionUID = 4918627794150073094L;
	
	private Integer groupId;
	private String groupName;
	private List<Employe> emplist;
	
	public Group() {}
	
	public Group(String groupName) {
		super();
		this.groupName = groupName;
	}

	public Group(Integer groupId, String groupName) {
		super();
		this.groupId = groupId;
		this.groupName = groupName;
	}
	
	public Group(Integer groupId, String groupName, List<Employe> emplist) {
		super();
		this.groupId = groupId;
		this.groupName = groupName;
		this.emplist = emplist;
	}

	public Group(String groupName, List<Employe> emplist) {
		super();
		this.groupName = groupName;
		this.emplist = emplist;
	}

	public List<Employe> getEmplist() {
		return emplist;
	}

	public void setEmplist(List<Employe> emplist) {
		this.emplist = emplist;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	@Override
	public String toString() {
		return "Group [emplist=" + emplist + ", groupId=" + groupId
				+ ", groupName=" + groupName + "]";
	}

}
