package com.heqing.ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.heqing.ssm.base.BaseDao;
import com.heqing.ssm.entity.Teacher;

public interface TeacherDao extends BaseDao<Teacher> {

	/**
	 * 根据班级ID查找所有授课教师
	 * @param id 实体类ID
	 * @return List<T>  实体列表
	 */
	public List<Teacher> getTeacherByClassId(long classId);
	
	/**
	 * 多个教师对多个班级的增加
	 * @param classId 	班级ID
	 * @param teacherId 教师ID
	 */
	public void saveTeacherClass(@Param(value="classId")long classId, @Param(value="teacherId")long teacherId);

	/**
	 * 多个教师对多个班级的删除
	 * @param classId 	班级ID
	 * @param teacherId 教师ID
	 */
	public void deleteTeacherClass(@Param(value="classId")long classId, @Param(value="teacherId")long teacherId);
}
