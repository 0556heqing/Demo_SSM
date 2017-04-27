package com.heqing.ssm.service.impl;

import org.springframework.stereotype.Service;

import com.heqing.ssm.base.BaseServiceImpl;
import com.heqing.ssm.entity.TUserEntity;
import com.heqing.ssm.entity.Test;
import com.heqing.ssm.service.TUserService;

@Service("tUserService")
public class TUserServiceImpl  extends BaseServiceImpl<TUserEntity> implements TUserService {
	
	@Override
	public String test(int id, String name, Test test) {
		// TODO Auto-generated method stub
		System.out.println("id="+id+", name="+name+", "+test.toString());
		return "Hello Wrold!";
	}
}
