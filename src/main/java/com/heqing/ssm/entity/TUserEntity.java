package com.heqing.ssm.entity;

import java.util.Date;


/**
 * 用户管理
 * 
 * @author heqing
 * @email  975656343@qq.com
 * @date   2017-04-06 13:38:34
 */
public class TUserEntity {
	
	private Long userid;	//用户ID
	private String name;	//姓名
	private String address;	//地址
	private String phone;	//联系方式
	private Date birthday;	//出生日期

	/**
	 * 设置：用户ID
	 */
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	/**
	 * 获取：用户ID
	 */
	public Long getUserid() {
		return userid;
	}
	
	/**
	 * 设置：姓名
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：姓名
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 设置：地址
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 获取：地址
	 */
	public String getAddress() {
		return address;
	}
	
	/**
	 * 设置：联系方式
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * 获取：联系方式
	 */
	public String getPhone() {
		return phone;
	}
	
	/**
	 * 设置：出生日期
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	/**
	 * 获取：出生日期
	 */
	public Date getBirthday() {
		return birthday;
	}
	
}
