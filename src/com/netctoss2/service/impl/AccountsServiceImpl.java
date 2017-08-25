package com.netctoss2.service.impl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.netctoss2.dao.AccountsDao;
import com.netctoss2.entity.Accounts;
import com.netctoss2.entity.Services;
import com.netctoss2.service.AccountsService;

public class AccountsServiceImpl implements AccountsService {
	private AccountsDao accountsDao;
	private SqlSession session;
	//获取dao层操作对象
	public AccountsDao getAccountsDao(){
		InputStream is;
		try {
			//创建输入流读取mybatis_config配置文件内容
			is = Resources.getResourceAsStream("mybatis_config.xml");
			//构建会话工厂
			SqlSessionFactory build = new SqlSessionFactoryBuilder().build(is);
			//打开会话
			session = build.openSession(false);
			//获取admin表的操作对象
			accountsDao = session.getMapper(AccountsDao.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return accountsDao;
	}
	//关闭会话
	public void close(){
		if(session!=null) session.close();
	}
	@Override
	public List<Accounts> getPageAcc(int sIndex,int length) {
		// TODO Auto-generated method stub
		accountsDao = this.getAccountsDao();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("sIndex", sIndex);
		map.put("length", length);
		List<Accounts> lac = accountsDao.selAccounts(map);
		for(Accounts a:lac){
			if("0".equals(a.getAcc_state())){
				a.setAcc_state("暂停");
			}
			if("1".equals(a.getAcc_state())){
				a.setAcc_state("开通");
			}
			if("2".equals(a.getAcc_state())){
				a.setAcc_state("删除");
			}
		}
		return lac;
	}

	@Override
	public boolean insertAcc(Accounts acc) {
		// TODO Auto-generated method stub
		accountsDao = this.getAccountsDao();
		if(accountsDao.insertAccounts(acc)>0){
			session.commit();
			this.close();
			return true;
		}
		this.close();
		return false;
	}
	@Override
	public Accounts getAccByID(Accounts acc) {
		// TODO Auto-generated method stub
		accountsDao = this.getAccountsDao();
		return accountsDao.selAccByID(acc);
	}
	@Override
	public List<Accounts> getAccByCondition(int sIndex, int length, Accounts acc) {
		// TODO Auto-generated method stub
		accountsDao = this.getAccountsDao();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("sIndex", sIndex);
		map.put("length", length);
		map.put("acc", acc);
		List<Accounts> lac = accountsDao.selAccByCondition(map);
		for(Accounts a:lac){
			if("0".equals(a.getAcc_state())){
				a.setAcc_state("暂停");
			}
			if("1".equals(a.getAcc_state())){
				a.setAcc_state("开通");
			}
			if("2".equals(a.getAcc_state())){
				a.setAcc_state("删除");
			}
		}
		return lac;
	}
	@Override
	public boolean updateAcc(Accounts acc) {
		// TODO Auto-generated method stub
		accountsDao = this.getAccountsDao();
		if(accountsDao.updateAcc(acc)>0){
			session.commit();
			this.close();
			return true;
		}
		this.close();
		return false;
	}
	@Override
	public boolean updateAccState(Accounts acc) {
		// TODO Auto-generated method stub
		accountsDao = this.getAccountsDao();
		if(accountsDao.updateAccState(acc)>0){
			List<Services> lser = accountsDao.selAccOfSer(acc);
			int i = 0;
			for(Services s:lser){
				s.setSer_state(acc.getAcc_state());
				accountsDao.updateSerState(s);
				i++;
			}
			if(i==lser.size()){
				session.commit();
				this.close();
				return true;
			}
		}
		this.close();
		return false;
	}
	@Override
	public boolean delAcc(Accounts acc) {
		// TODO Auto-generated method stub
		accountsDao = this.getAccountsDao();
		if(accountsDao.updateAccState(acc)>0){
			session.commit();
			this.close();
			return true;
		}
		this.close();
		return false;
	}

}
