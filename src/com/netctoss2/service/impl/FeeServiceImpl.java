package com.netctoss2.service.impl;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.netctoss2.dao.FeeDao;
import com.netctoss2.entity.Fee;
import com.netctoss2.service.FeeService;


public class FeeServiceImpl implements FeeService {
	private FeeDao feeDao;
	private SqlSession session;
	//获取dao层操作对象
	public FeeDao getFeeDao(){
		InputStream is;
		try {
			//创建输入流读取mybatis_config配置文件内容
			is = Resources.getResourceAsStream("mybatis_config.xml");
			//构建会话工厂
			SqlSessionFactory build = new SqlSessionFactoryBuilder().build(is);
			//打开会话
			session = build.openSession(false);
			//获取admin表的操作对象
			feeDao = session.getMapper(FeeDao.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return feeDao;
	}
	//关闭会话
	public void close(){
		if(session!=null) session.close();
	}
	@Override
	public boolean insertFee(Fee fee) {
		// TODO Auto-generated method stub
		feeDao = this.getFeeDao();
		if(feeDao.insertFee(fee)>0){
			session.commit();
			this.close();
			return true;
		}
		this.close();
		return false;
	}

	@Override
	public List<Fee> selPageFee(int sIndex,int length,String rank, String order) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("sIndex", sIndex);
		map.put("length", length);
		map.put("rank", rank);
		map.put("order", order);
		feeDao = this.getFeeDao();
		List<Fee> lf = feeDao.selPageFee(map);
		System.out.println(lf.get(0).getFeeID());
		for(Fee f:lf){
			if("0".equals(f.getFeeState())){
				f.setFeeState("暂停");
			}
			if("1".equals(f.getFeeState())){
				f.setFeeState("开通");
			}
		}
		return lf;
	}

	@Override
	public List<Fee> selAllFee() {
		// TODO Auto-generated method stub
		feeDao = this.getFeeDao();
		return feeDao.selAllFee();
	}


	@Override
	public boolean updateFee(Fee fee) {
		// TODO Auto-generated method stub
		feeDao = this.getFeeDao();
		if(feeDao.updateFee(fee)>0){
			session.commit();
			this.close();
			return true;
		}
		this.close();
		return false;
	}

	@Override
	public Fee selFeeByFeeID(Fee fee) {
		// TODO Auto-generated method stub
		feeDao = this.getFeeDao();
		return feeDao.selFee(fee);
	}

	@Override
	public boolean delFee(Fee fee) {
		// TODO Auto-generated method stub
		feeDao = this.getFeeDao();
		if(feeDao.delFee(fee)>0){
			session.commit();
			this.close();
			return true;
		}
		this.close();
		return false;
	}

	@Override
	public boolean updateFeeState(Fee fee) {
		// TODO Auto-generated method stub
		feeDao = this.getFeeDao();
		if(feeDao.updateFeeState(fee)>0){
			session.commit();
			this.close();
			return true;
		}
		this.close();
		return false;
	}

}
