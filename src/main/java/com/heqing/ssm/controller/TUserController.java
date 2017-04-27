package com.heqing.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;

import com.heqing.ssm.entity.PageBean;
import com.heqing.ssm.entity.TUserEntity;
import com.heqing.ssm.service.TUserService;
import com.heqing.ssm.utils.ResultUtil;

/**
 * 用户管理
 * 
 * @author heqing
 * @email 975656343@qq.com
 * @date 2017-04-06 13:38:34
 */
@Controller
@RequestMapping("/tuser")
public class TUserController {

	@Autowired
	private TUserService tUserService;
	
	@RequestMapping("/tuser.html")
	public String list(){
		return "tuser.html";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	public ResultUtil save(@RequestBody TUserEntity tUser){
		tUserService.save(tUser);
		return ResultUtil.ok();
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	public ResultUtil update(@RequestBody TUserEntity tUser){
		tUserService.update(tUser);
		return ResultUtil.ok();
	}
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info/{userid}")
	public ResultUtil info(@PathVariable("userid") Long userid){
		TUserEntity tUser = tUserService.getById(userid);
		return ResultUtil.ok().put("tUser", tUser);
	}
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	public ResultUtil list(Integer page, Integer limit){
		if(page==null) page = 1;
		if(limit==null) limit = 10;
		//查询列表数据
		List<TUserEntity> tUserList = tUserService.getPageBean((page - 1) * limit, limit);
		int total = tUserService.findAll().size();
		PageBean pageUtil = new PageBean(page, limit, tUserList, total);
		return ResultUtil.ok().put("page", pageUtil);
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public ResultUtil delete(@RequestBody Long[] userids){
		tUserService.deleteBatch(userids);
		return ResultUtil.ok();
	}
	
}
