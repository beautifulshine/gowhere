package com.li.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.li.model.Family;
import com.li.model.UserVarietyshow;
import com.li.service.FamilyService;
import com.li.service.UserVarietyshowService;
import com.li.service.VarietyshowService;
import com.li.vo.Page;
import com.li.vo.ResultData;
import com.li.vo.UserVarietyshowVo;
import com.li.vo.VarietyShowQuery;
@Controller
@RequestMapping("/userVarietyshow")
public class UserVarietyshowController {
	 @Resource
	 private UserVarietyshowService userVarietyshowService;
	
	 @Resource
	 private FamilyService familyService;
	 
	 @Resource
	 private VarietyshowService varietyshowService;


	 /**
	     * 获取节目列表
	     * @param page
	     * @return
	     */
	    @RequestMapping(value="/getShowList", method = RequestMethod.GET)
	    @ResponseBody
	    public ResultData getShowList(VarietyShowQuery query){
			Page<UserVarietyshowVo> userVarietyshowPage = varietyshowService.getUserVarietyshowList(query);//java.lang.NullPointerException
			
			if (userVarietyshowPage!=null) {
				for (UserVarietyshowVo userVarietyshow : userVarietyshowPage.getList()) {
					//先通过节目id去查询家庭id集合
					List<Long> familyIdList = userVarietyshowService.getFamilyIdByShowId(userVarietyshow.getId());
					//再通过家庭id集合批量去查出家庭信息集合
					List<Family> familyList = familyService.batchGetFamilyListByIds(familyIdList);
					userVarietyshow.setFamilyList(familyList);
				}
				
				return ResultData.successed(userVarietyshowPage);
			}
	        
			return ResultData.successed();
	    }
	    
    
    @RequestMapping("/userVarietyshow")
    public  @ResponseBody ResponseEntity<Object> userVarietyshow(Model model,HttpServletRequest request,Long id){
    	Map<String, Object> resultMap = new HashMap<String, Object>();
		//HttpHeaders headers = new HttpHeaders();
		//headers.add("Access-Control-Allow-Origin", "*");
		ResponseEntity<Object> re = new ResponseEntity<Object>(resultMap, HttpStatus.OK);
		if (null == id) {
			resultMap.put("result", "Configuration.PARAMETER_ERROR");
			resultMap.put("errorMsg", "neccesarry parameters is missing");
			return re;
		}
		try {
			//int id = Integer.parseInt(request.getParameter("id"));
			//Long l = new Long((long)id);
	    	UserVarietyshow userVarietyshow = userVarietyshowService.selectByPrimaryKey(id);
			if (userVarietyshow != null) {
				resultMap.put("userVarietyshow", userVarietyshow);
				resultMap.put("result", "Configuration.RESULT_OK");
			}
		} catch (Exception e) {
			e.printStackTrace();
			resultMap.put("result", "Configuration.SERVER_ERROR");
			resultMap.put("errorMsg", "server error");
		}
		return re;
    }
	

}
