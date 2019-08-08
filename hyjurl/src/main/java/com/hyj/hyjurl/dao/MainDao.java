package com.hyj.hyjurl.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.hyj.hyjurl.dto.MainDto;
import com.hyj.hyjurl.form.MainFrm;

@Repository
public class MainDao {

	@Resource(name = "sqlSession")
	private SqlSession sqlSession;

	private static final String NAMESPACE = "com.hyj.hyjurl.Main";

	public List<MainDto> getUrlList(MainFrm mainForm) throws Exception {

		return sqlSession.selectList(NAMESPACE + ".getUrlList", mainForm);
	}
	
	public int insertUrlList(MainFrm mainForm) throws Exception {
		
		//auto_increment �� u_no���� �޾ƿͼ� �����Ѵ�.
		int result = sqlSession.insert(NAMESPACE + ".insertUrlList", mainForm);
		
		if(result > 0)
		{
			return mainForm.getU_no();
		} else {
			return result;
		}
				
	}
	
	public int updateUrlList(MainFrm mainForm) throws Exception {
		
		//auto_increment �� u_no���� �޾ƿͼ� �����Ѵ�.
		return sqlSession.update(NAMESPACE + ".updateUrlList", mainForm);
	}

}
