package com.li.controller;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.li.model.Family;
import com.li.model.UserVarietyshow;
import com.li.model.Varietyshow;
import com.li.service.FamilyService;
import com.li.service.UserVarietyshowService;
import com.li.service.VarietyshowService;

@Controller
@RequestMapping("/userVarietyshow")
public class UserVarietyshowController {
private UserVarietyshowService userVarietyshowService;
	
    public UserVarietyshowService getUserVarietyshowService() {
	return userVarietyshowService;
}
    @Autowired
    public void setUserVarietyshowService(UserVarietyshowService userVarietyshowService) {
	this.userVarietyshowService = userVarietyshowService;
}

private FamilyService familyService;
public FamilyService getFamilyService() {
	return familyService;
}
@Autowired
public void setFamilyService(FamilyService familyService) {
	this.familyService = familyService;
}

private VarietyshowService varietyshowService;
public VarietyshowService getVarietyshowService() {
	return varietyshowService;
}
@Autowired
public void setVarietyshowService(VarietyshowService varietyshowService) {
	this.varietyshowService = varietyshowService;
}


    @RequestMapping("/listUserVarietyshow")
    public @ResponseBody ResponseEntity<Object> listUserVarietyshow(Model model,HttpServletRequest request){
    	Map<String, Object> map = new HashMap<String, Object>();
    	Map<String, Object> mapParam = new HashMap<String, Object>();
    	//int pageSize = 5;
		HttpHeaders headers=new HttpHeaders();
		headers.add("Access-Control-Allow-Origin", "*");
		ResponseEntity<Object> re =	new ResponseEntity<Object>(model, headers, HttpStatus.OK);
		try {
			//节目列表里有节目名称，日期，家庭组名称，人数 可翻页
			int dataCount = userVarietyshowService.getVarietyshowCount();
			int offset = 0;//总页数
			int limit = 10; //当前页面定义为1
			if(request.getParameter("offset") != null)
				offset = Integer.parseInt(request.getParameter("offset"));
			if(request.getParameter("limit") != null)
				limit = Integer.parseInt(request.getParameter("limit"));
			
			mapParam.put("offset", offset);
			mapParam.put("limit", limit);
			List<UserVarietyshow> userVarietyshows = userVarietyshowService.loadVarietyshowList(mapParam);
			if (userVarietyshows!=null) {
				for (UserVarietyshow userVarietyshow : userVarietyshows) {
				System.out.println(userVarietyshow.getFamilyId());	
					Family family = familyService.selectByPrimaryKey(userVarietyshow.getFamilyId());
					String familyName =	family.getName();
					model.addAttribute("familyName",familyName);
					Varietyshow varietyshow = varietyshowService.selectByPrimaryKey(userVarietyshow.getVarietyShowId());
					String varietyshowName = varietyshow.getName();
					varietyshowService.selectByPrimaryKey(userVarietyshow.getId());
					model.addAttribute("varietyshowName", varietyshowName);
				}
				model.addAttribute("userVarietyshows", userVarietyshows);
				}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("result", "error");
		}
        
    return re;
    }
    
    @RequestMapping("/userVarietyshow")
    public  @ResponseBody ResponseEntity<Object> userVarietyshow(Model model,HttpServletRequest request){
    	Map<String, Object> resultMap = new HashMap<String, Object>();
		HttpHeaders headers = new HttpHeaders();
		headers.add("Access-Control-Allow-Origin", "*");
		ResponseEntity<Object> re = new ResponseEntity<Object>(resultMap, headers, HttpStatus.OK);
		if (null == request.getParameter("id")) {
			resultMap.put("result", "Configuration.PARAMETER_ERROR");
			resultMap.put("errorMsg", "neccesarry parameters is missing");
			return re;
		}
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			Long l = new Long((long)id);
	    	UserVarietyshow userVarietyshow = userVarietyshowService.selectByPrimaryKey(l);
			if (userVarietyshow != null) {
				resultMap.put("userVarietyshow", userVarietyshow);
				resultMap.put("result", "Configuration.RESULT_OK");
				return re;
			}
		} catch (Exception e) {
			e.printStackTrace();
			resultMap.put("result", "Configuration.SERVER_ERROR");
			resultMap.put("errorMsg", "server error");
		}
		return re;
    }
	

}
