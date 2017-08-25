package com.netctoss2.service.impl;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.netctoss2.dao.ServicesDao;
import com.netctoss2.entity.Services;
import com.netctoss2.service.ServicesService;

public class ServicesServiceImpl implements ServicesService {
	private ServicesDao servicesDao;
	private SqlSession session;
	//获取dao层操作对象
	public ServicesDao getServicesDao(){
		InputStream is;
		try {
			//创建输入流读取mybatis_config配置文件内容
			is = Resources.getResourceAsStream("mybatis_config.xml");
			//构建会话工厂
			SqlSessionFactory build = new SqlSessionFactoryBuilder().build(is);
			//打开会话
			session = build.openSession(false);
			//获取admin表的操作对象
			servicesDao = session.getMapper(ServicesDao.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return servicesDao;
	}
	//关闭会话
	public void close(){
		if(session!=null) session.close();
	}
	@Override
	public List<Services> getPageServices(int sIndex, int length, Services ser) {
		// TODO Auto-generated method stub
		servicesDao = this.getServicesDao();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("sIndex", sIndex);
		map.put("length", length);
		map.put("ser", ser);
		List<Services> lser = servicesDao.selPageServices(map);
		for(Services s:lser){
			if("0".equals(s.getSer_state())){
				s.setSer_state("暂停");
			}
			if("1".equals(s.getSer_state())){
				s.setSer_state("开通");
			}
			if("2".equals(s.getSer_state())){
				s.setSer_state("删除");
			}
		}
		return lser;
	}
	@Override
	public boolean addService(Services ser) {
		// TODO Auto-generated method stub
		servicesDao = this.getServicesDao();
		if(servicesDao.insertSer(ser)>0){
			session.commit();
			this.close();
			return true;
		}
		this.close();
		return false;
	}
	@Override
	public Services getServicesByID(Services ser) {
		// TODO Auto-generated method stub
		servicesDao = this.getServicesDao();
		return servicesDao.selSerByID(ser);
	}
	@Override
	public boolean updateSer(Services ser) {
		// TODO Auto-generated method stub
		servicesDao = this.getServicesDao();
		if(servicesDao.updateSer(ser)>0){
			session.commit();
			this.close();
			return true;
		}
		this.close();
		return false;
	}
	@Override
	public boolean updateSerState(Services ser) {
		// TODO Auto-generated method stub
		servicesDao = this.getServicesDao();
		if(servicesDao.updateSerState(ser)>0){
			session.commit();
			this.close();
			return true;
		}
		this.close();
		return false;
	}
	
}
