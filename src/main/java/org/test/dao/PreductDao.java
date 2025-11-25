package org.test.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.test.entity.KDInfo;
import org.test.entity.Preduct;
import org.test.entity.UserPreduct;
@Repository
public interface PreductDao {
	public List<Preduct> PreductRead(int begin,int end);
	
	public void PreductShow(UserPreduct uPreduct);
	
	public String PhoneStatusRead(String phone);
	
	public void UpdatePreduct(String pnumber);
	
	public void TelepUpdate(String phone,String idcard);
	
	public void phoneStatusUpdate1(String phone);
	
	public void TimeUpdate(String phone);
	
	public void phoneStatusUpdate2(String phone);
	
	public int PreductReadMath();
	
	public void phonestatusChange();
	
	public List<String> UpdateTimeRead();
	
	public List<Map<String,String>> KDPreductRead();
	
	public KDInfo TelInfoRead(String phone);
	
	public void KDShow(KDInfo kdinfo);
}
