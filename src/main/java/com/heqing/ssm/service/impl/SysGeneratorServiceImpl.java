package com.heqing.ssm.service.impl;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipOutputStream;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heqing.ssm.dao.SysGeneratorDao;
import com.heqing.ssm.entity.generator.GenUtils;
import com.heqing.ssm.service.SysGeneratorService;

@Service
public class SysGeneratorServiceImpl implements SysGeneratorService {
	
	@Autowired
	private SysGeneratorDao sysGeneratorDao;

	@Override
	public List<Map<String, Object>> queryList(Map<String, Object> map) {
		return sysGeneratorDao.queryList(map);
	}

	@Override
	public int queryTotal(Map<String, Object> map) {
		return sysGeneratorDao.queryTotal(map);
	}

	@Override
	public Map<String, String> queryTable(String tableName) {
		return sysGeneratorDao.queryTable(tableName);
	}

	@Override
	public List<Map<String, String>> queryColumns(String tableName) {
		return sysGeneratorDao.queryColumns(tableName);
	}

	@Override
	public byte[] generatorCode(String[] tableNames) {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		ZipOutputStream zip = new ZipOutputStream(outputStream);
		
		try {
			for(String tableName : tableNames){
				//查询表信息
				Map<String, String> table = queryTable(tableName);
				//查询列信息
				List<Map<String, String>> columns = queryColumns(tableName);
				//生成代码
				GenUtils.generatorCode(table, columns, zip);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		IOUtils.closeQuietly(zip);
		return outputStream.toByteArray();
	}

}
