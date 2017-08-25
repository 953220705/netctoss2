package com.netctoss2.service.impl;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.netctoss2.dao.PermissionsDao;
import com.netctoss2.entity.Permissions;
import com.netctoss2.service.PermissionsService;


public class PermissionsServiceImpl implements PermissionsService {
	private PermissionsDao perDao;
	private SqlSession session;
	//获取dao层操作对象
	public PermissionsDao getPerDao(){
		InputStream is;
		try {
			//创建输入流读取mybatis_config配置文件内容
			is = Resources.getResourceAsStream("mybatis_config.xml");
			//构建会话工厂
			SqlSessionFactory build = new SqlSessionFactoryBuilder().build(is);
			//打开会话
			session = build.openSession(false);
			//获取admin表的操作对象
			perDao = session.getMapper(PermissionsDao.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return perDao;
	}
	//关闭会话
	public void close(){
		if(session!=null) session.close();
	}
	@Override
	public List<Permissions> getAllPermissions() {
		// TODO Auto-generated method stub
		perDao = this.getPerDao();
		return perDao.selAllPer();
	}

}
