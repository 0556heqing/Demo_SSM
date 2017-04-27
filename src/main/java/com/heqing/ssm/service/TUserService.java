package com.heqing.ssm.service;

import com.heqing.ssm.base.BaseService;
import com.heqing.ssm.entity.TUserEntity;
import com.heqing.ssm.entity.Test;

/**
 * 用户管理
 * 
 * @author heqing
 * @email 975656343@qq.com
 * @date 2017-04-06 13:38:34
 */
public interface TUserService extends BaseService<TUserEntity>{

	public String test(int id, String name, Test test);
}
