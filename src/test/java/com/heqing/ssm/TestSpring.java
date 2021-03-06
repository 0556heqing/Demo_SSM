package com.heqing.ssm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.heqing.ssm.service.TUserService;

@RunWith(SpringJUnit4ClassRunner.class)		// 表示继承了 SpringJUnit4ClassRunner 类
@ContextConfiguration(locations = {"classpath:spring_core.xml","classpath:spring_mybatis.xml"})
public class TestSpring {
	
	@Autowired
	private TUserService tUserService;
	
	@Test
	public void hello() {
		com.heqing.ssm.entity.Test test = new com.heqing.ssm.entity.Test();
		test.setId(2);
		test.setName("贺庆");
//		tUserService.test(1, "heqing", test);
		int total = tUserService.findAll().size();
	}
	
//	@Test
	public void testMVC() {
		try {
			URI uri = new URI("http://localhost:8080/Samples_FrameWork/springMVC/jsonUtil");
			String param = "id=2&name="+URLEncoder.encode("贺庆", "utf-8");  
			SimpleClientHttpRequestFactory schr = new SimpleClientHttpRequestFactory();
			ClientHttpRequest chr = schr.createRequest(uri, HttpMethod.POST);
            chr.getBody().write(param.getBytes());//body中设置请求参数
			ClientHttpResponse res = chr.execute();
			InputStream is = res.getBody(); //获得返回数据,注意这里是个流
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String str = "";
			while((str = br.readLine())!=null){
				System.out.println(str);//获得页面内容或返回内容
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
