package com.netctoss2.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.netctoss2.entity.Admin;
import com.netctoss2.entity.Permissions;
import com.netctoss2.entity.Role;
import com.netctoss2.dao.AdminDao;
import com.netctoss2.dao.RoleDao;
import com.netctoss2.service.AdminService;

public class AdminServiceImpl implements AdminService {
	private AdminDao adminDao;
	private SqlSession session;
	//获取dao层操作对象
	public AdminDao getAdminDao(){
		InputStream is;
		try {
			//创建输入流读取mybatis_config配置文件内容
			is = Resources.getResourceAsStream("mybatis_config.xml");
			//构建会话工厂
			SqlSessionFactory build = new SqlSessionFactoryBuilder().build(is);
			//打开会话
			session = build.openSession(false);
			//获取admin表的操作对象
			adminDao = session.getMapper(AdminDao.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return adminDao;
	}
	//关闭会话
	public void close(){
		if(session!=null) session.close();
	}
	@Override
	public Admin login(Admin admin) {
		// TODO Auto-generated method stub
		adminDao = this.getAdminDao();
		admin = adminDao.adminLogin(admin);
		this.close();
		return admin;
	}

	@Override
	public boolean updateAdmin(Admin admin) {
		// TODO Auto-generated method stub
		adminDao = this.getAdminDao();
		if(adminDao.updateAdmin(admin)>0){
			session.commit();
			this.close();
			return true;
		}
		this.close();
		return false;
	}

	@Override
	public boolean updateAdminPsw(Admin admin) {
		// TODO Auto-generated method stub
		adminDao = this.getAdminDao();
		if(adminDao.updateAdminPsw(admin)>0) return true;
		this.close();
		return false;
	}

	@Override
	public List<Admin> getPageAdmin(int sIndex, int length, Role role, Permissions per) {
		// TODO Auto-generated method stub
		adminDao = this.getAdminDao();
		List<Admin> la1 = adminDao.selPerOfAdmin(per);
		List<Admin> la2 = adminDao.selRoleOfAdmin(role);
		List<Admin> la3 = new ArrayList<Admin>();
		for(Admin a1:la1){
			for(Admin a2:la2){
				if(a1.getAdminID().equals(a2.getAdminID())){
					la3.add(a1);
				}
			}
		}
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("sIndex", sIndex);
		map.put("length", length);
		map.put("la", la3);
		return adminDao.selPageAdmin(map);
	}

	@Override
	public boolean addAdmin(Admin admin) {
		// TODO Auto-generated method stub
		adminDao = this.getAdminDao();
		if(adminDao.insertAdmin(admin)>0&&adminDao.insertAdminofRole(admin)>0){
			session.commit();
			this.close();
			return true;
		}
		this.close();
		return false;
	}

	@Override
	public Admin getAdminInfo(Admin admin) {
		// TODO Auto-generated method stub
		adminDao = this.getAdminDao();
		return adminDao.selAdminByID(admin);
	}

	@Override
	public boolean manageAdmin(Admin admin) {
		// TODO Auto-generated method stub
		adminDao = this.getAdminDao();
		if(adminDao.manageAdminInfo(admin)>0&&adminDao.delAdminOfRole(admin)>0&&adminDao.insertAdminofRole(admin)>0){
			session.commit();
			this.close();
			return true;
		}
		this.close();
		return false;
	}

	@Override
	public boolean delAdmin(Admin admin) {
		// TODO Auto-generated method stub
		adminDao = this.getAdminDao();
		if(adminDao.delAdminOfRole(admin)>0&&adminDao.delAdmin(admin)>0){
			session.commit();
			this.close();
			return true;
		}
		this.close();
		return false;
	}

	@Override
	public boolean resetAdminPsw(List<Admin> la) {
		// TODO Auto-generated method stub
		adminDao = this.getAdminDao();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("la", la);
		if(adminDao.resetAdminPsw(map)==map.size()){
			session.commit();
			this.close();
			return true;
		}
		this.close();
		return false;
	}

}
