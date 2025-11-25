package org.test.service;

import org.test.entity.Resultmsg;

public interface PreductService {
	public Resultmsg PreductRead(String begin,String end);
	
	public Resultmsg PreductShow(String uname,String uIdcard,String userphone,String ubasic,String amount);
	
	public Resultmsg phoneStatusUpdate1(String phone);
	
	public Resultmsg phoneStatusUpdate2(String phone);
	
	public Resultmsg PreductReadMath();
	
	public void PhoneStatusChange();
	
	public Resultmsg KDPreductRead();
	
	public Resultmsg TelInfoRead(String uname,String idcard,String userphone,String KDSpeed,String kfy,String SAddress);
}
