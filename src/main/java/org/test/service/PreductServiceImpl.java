package org.test.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.dao.PreductDao;
import org.test.entity.KDInfo;
import org.test.entity.Preduct;
import org.test.entity.Resultmsg;
import org.test.entity.UserPreduct;
@Service
@Transactional(value = "transactionManager", rollbackFor = java.lang.Exception.class)
public class PreductServiceImpl implements PreductService {
	@Resource
	PreductDao pDao;
	public Resultmsg PreductRead(String begin,String end) {
		int e = Integer.valueOf(end);
		int b = Integer.valueOf(begin);
		List<Preduct> l = pDao.PreductRead(b, e);
		Resultmsg rm = new Resultmsg();
		if(l==null){
			rm.setStatus("1");
			rm.setMsg("没有查到任何数据");
		}else{
			rm.setStatus("0");
			rm.setMsg("查询到产品信息");
			rm.setData(l);
		}
		return rm;
	}
	//号码办理
	public Resultmsg PreductShow(String uname,String uIdcard,String userphone,String ubasic,String amount) {
		UserPreduct upreduct = new UserPreduct();
		upreduct.setUsername(uname);
		upreduct.setPhone(userphone);
		upreduct.setIdcard(uIdcard);
		upreduct.setBasic(ubasic);
		upreduct.setAmount(amount);
		pDao.PreductShow(upreduct);
		pDao.UpdatePreduct(userphone);
		Resultmsg rm = new Resultmsg();
		rm.setStatus("0");
		rm.setMsg("办理成功");
		return rm;
	}
	//号码修改
	public Resultmsg TelepUpdate(String phone,String idcard){
		pDao.TelepUpdate(phone, idcard);
		Resultmsg rm = new Resultmsg();
		rm.setStatus("0");
		rm.setMsg("成功");
		return rm;
	}
	public Resultmsg phoneStatusUpdate1(String phone) {
		String status = pDao.PhoneStatusRead(phone);
		Resultmsg rm = new Resultmsg();
		if(status.equals("0")){
			pDao.phoneStatusUpdate1(phone);
			pDao.TimeUpdate(phone);
			rm.setStatus("0");
		}else{
			rm.setStatus("1");
			rm.setMsg("该号码已经处于预定状态，无法选择");
		}
		return rm;
	}
	public Resultmsg phoneStatusUpdate2(String phone) {
		pDao.phoneStatusUpdate2(phone);
		Resultmsg rm = new Resultmsg();
		rm.setStatus("0");
		return rm;
	}
	public Resultmsg PreductReadMath() {
		int row = pDao.PreductReadMath();
		Resultmsg rm = new Resultmsg();
		if(row>0){
			rm.setStatus("0");
			rm.setData(row);
		}
		return rm;
	}
	public Resultmsg KDPreductRead(){
		List<Map<String,String>> KDList = pDao.KDPreductRead();
		Resultmsg rm = new Resultmsg();
		if(KDList.isEmpty()){
			rm.setStatus("1");
			rm.setMsg("没有查到任何宽带数据");
		}else{
			rm.setStatus("0");
			rm.setData(KDList);
		}
		return rm;
	}
	public Resultmsg TelInfoRead(String uname,String idcard,String userphone,String KDSpeed,String kfy,String SAddress){
		KDInfo kdinfo1 = pDao.TelInfoRead(userphone);
		Resultmsg rm = new Resultmsg();
		if(kdinfo1!=null){
			rm.setMsg("该号码已绑定了宽带，无法重复绑定");
			rm.setStatus("1");
		}
		else{
			KDInfo kdinfo = new KDInfo();
			kdinfo.setUsername(uname);
			kdinfo.setIdcard(idcard);
			kdinfo.setPhonenumber(userphone);
			kdinfo.setKdspeed(KDSpeed);
			kdinfo.setKdfy(kfy);
			kdinfo.setAddress(SAddress);
			pDao.KDShow(kdinfo);
			rm.setStatus("0");
			rm.setMsg("办理成功");
		}
		return rm;
	}
	//定时修改
	@Scheduled(cron="0 0/1 * * * ?")
	public void PhoneStatusChange() {
		List<String> timeList = pDao.UpdateTimeRead();
		Iterator<String> it = timeList.iterator();
		while(it.hasNext()){
			String phonetime = it.next();
			//获取系统时间
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			try {
				Date systemTime = df.parse(df.format(new Date()));
				Date phonetime2 = df.parse(phonetime);
				float PdTime = (systemTime.getTime()-phonetime2.getTime())*0.0000167F;
				if(PdTime>1){
					pDao.phonestatusChange();
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
	}

}
