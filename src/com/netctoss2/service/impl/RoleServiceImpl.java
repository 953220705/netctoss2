package com.netctoss2.service.impl;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.netctoss2.dao.RoleDao;
import com.netctoss2.entity.Role;
import com.netctoss2.service.RoleService;


public class RoleServiceImpl implements RoleService {
	private RoleDao roleDao;
	private SqlSession session;
	//获取dao层操作对象
	public RoleDao getRoleDao(){
		InputStream is;
		try {
			//创建输入流读取mybatis_config配置文件内容
			is = Resources.getResourceAsStream("mybatis_config.xml");
			//构建会话工厂
			SqlSessionFactory build = new SqlSessionFactoryBuilder().build(is);
			//打开会话
			session = build.openSession(false);
			//获取admin表的操作对象
			roleDao = session.getMapper(RoleDao.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return roleDao;
	}
	//关闭会话
	public void close(){
		if(session!=null) session.close();
	}
	@Override
	public List<Role> getPageRole(int sIndex, int length) {
		// TODO Auto-generated method stub
		roleDao = this.getRoleDao();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("sIndex", sIndex);
		map.put("length", length);
		List<Role> lro = roleDao.selPageRole(map);
		this.close();
		return lro;
	}

	@Override
	public boolean addRole(Role role) {
		// TODO Auto-generated method stub
		roleDao = this.getRoleDao();
		if(roleDao.insertRole(role)>0&&roleDao.insertRoleOfPer(role)>0){
			session.commit();
			this.close();
			return true;
		}
		this.close();
		return false;
	}

	@Override
	public boolean updateRole(Role role) {
		// TODO Auto-generated method stub
		roleDao = this.getRoleDao();
		if(roleDao.updateRoleName(role)>0&&roleDao.delRoleOfPer(role)>0&&roleDao.insertRoleOfPer(role)>0){
			session.commit();
			this.close();
			return true;
		}
		this.close();
		return false;
	}

	@Override
	public boolean delRole(Role role) {
		// TODO Auto-generated method stub
		roleDao = this.getRoleDao();
		if(roleDao.delRoleOfPer(role)>0&&roleDao.delRole(role)>0){
			session.commit();
			this.close();
			return true;
		}
		this.close();
		return false;
	}

	@Override
	public Role getRole(Role role) {
		// TODO Auto-generated method stub
		roleDao = this.getRoleDao();
		Role role1 = roleDao.selRole(role);
		this.close();
		return role1;
	}

	@Override
	public List<Role> getAllRole() {
		// TODO Auto-generated method stub
		roleDao = this.getRoleDao();
		return roleDao.selAllRole();
	}

	@Override
	public boolean validationRoleName(Role role) {
		// TODO Auto-generated method stub
		return false;
	}

}
