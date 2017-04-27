package com.heqing.ssm;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.heqing.ssm.entity.TUserEntity;
import com.heqing.ssm.service.TUserService;

@RunWith(SpringJUnit4ClassRunner.class)		// 表示继承了 SpringJUnit4ClassRunner 类
@ContextConfiguration(locations = {"classpath*:spring_core.xml","classpath:spring_mybatis.xml"})
public class TestUser {
	
	@Resource
	private TUserService tUserService;

//	@Test
	public void testSave() {
		TUserEntity user = new TUserEntity();
		user.setUserid(System.currentTimeMillis());
		user.setName("hq1");
		user.setAddress("安庆");
		user.setBirthday(new Date());
		tUserService.save(user);
	}
	
	@Test
	public void testSaveBatch() {
		TUserEntity user1 = new TUserEntity();
		user1.setUserid(System.currentTimeMillis());
		user1.setName("hq1");
		user1.setAddress("安庆");
		user1.setBirthday(new Date());
		
		TUserEntity user2 = new TUserEntity();
		user2.setUserid(System.currentTimeMillis()+100);
		user2.setName("hq2");
		user2.setAddress("安庆");
		user2.setBirthday(new Date());
		
		List<TUserEntity> users = new ArrayList<>();
		users.add(user1); users.add(user2);
		tUserService.saveBatch(users);
	}
	
//	@Test
	public void testUpdate() {
		TUserEntity user = new TUserEntity();
		user.setUserid(1491382374687L);
		user.setName("hq2");
		user.setAddress("安庆");
		user.setBirthday(new Date());
		tUserService.update(user);
	}
	
//	@Test
	public void testgetById() {
		//http://blog.csdn.net/cao478208248/article/details/27492067
		//特别强调 ：使用 resultType 参照上面的博客。
		TUserEntity user = tUserService.getById(1491392366814L);
		System.out.println(user.getName());
	}
	
//	@Test
	public void testgetByIds() {
		List<TUserEntity> user = tUserService.getByIds(new Long[]{1491382374687L, 1491383346767L});
		System.out.println(user.size());
	}
	
//	@Test
	public void testFindAll() {
		List<TUserEntity> users1 = tUserService.findAll();
		System.out.println(users1.size());
		
		TUserEntity user = new TUserEntity();
		user.setName("hq2");
		List<TUserEntity> users2 = tUserService.findAll(user);
		System.out.println(users2.size());
	}
	
//	@Test
	public void testGetPageBean() {
		List<TUserEntity> users1 = tUserService.getPageBean(0, 5);
		System.out.println(users1.size());
		
		TUserEntity user = new TUserEntity();
		user.setName("hq2");
		List<TUserEntity> users2 = tUserService.getPageBean(user, 0, 1);
		System.out.println(users2.size());
	}
	
//	@Test
	public void testDelete() {
		tUserService.delete(1491382374687L);
	}
	
//	@Test
	public void testDeleteBatch() {
		tUserService.deleteBatch(new Long[]{1491383346767L, 1491391892569L});
	}
}
