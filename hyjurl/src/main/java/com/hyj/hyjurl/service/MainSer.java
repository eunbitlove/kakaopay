package com.hyj.hyjurl.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import com.hyj.hyjurl.dao.MainDao;
import com.hyj.hyjurl.dto.MainDto;
import com.hyj.hyjurl.form.MainFrm;

import com.hyj.hyjurl.common.Base62EnDecode;

@Service
public class MainSer {
	
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private MainDao mainDao;

	public List<MainDto> getUrlList(MainFrm mainForm) throws Exception {

		return mainDao.getUrlList(mainForm);
	}
	
	@Transactional
	public MainDto insertUrlList(MainFrm mainForm) throws Exception {

		MainDto mainDto = new MainDto();
		Base62EnDecode base62 = new Base62EnDecode();
		
		int result = mainDao.insertUrlList(mainForm);
		
		logger.debug("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx [{}]",result);
		
		if (result > 0) {
					
			//�����ϸ� ȭ���� �ּҷ� f_url �÷��� ã�Ƽ� s_url�� ������Ʈ �Ѵ�.
			
			logger.debug("yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy [{}]",base62.encode(result));
			
			mainForm.setS_url(base62.encode(result));
			
			result = mainDao.updateUrlList(mainForm);
			
			logger.debug("zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz [{}]",result);
			
			if(result > 0)
			{
				mainDto.setS_url(mainForm.getS_url()); //ȭ�鿡 �Ѹ��� ���� Dto�� ��´�.
				mainDto.setResult("SUCCESS");
			} else {
				mainDto.setResult("FAIL");
			}
			
			
		} else {
			mainDto.setResult("FAIL");
		}

		return mainDto;
	}

	
}
