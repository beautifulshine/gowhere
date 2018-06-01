package com.li.vo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author 
 *
 */
public class ResultData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2961540884209205375L;
    private static  Logger logger = LoggerFactory.getLogger(ResultData.class);
    
    public static final int STATUS_NORMAL = 1;
    
    public static final int STATUS_ERROR = 0;
    
    public static final int STATUS_DEPRECATED = -1;
    
	private int status = STATUS_NORMAL;
	
	private int errorCode;
	
	private String errorMessage = "";
	
	private Object body;
	
	public ResultData(){
		super();
	}
	
	/**
	 * 带参数构造函数
	 * @param status         状态
	 * @param errorMessage 	   信息
	 * @param errorCode		   错误码
	 */
	public ResultData(final int status, final String errorMessage,final int errorCode){
		super();
		this.status  = status;
		this.errorMessage = errorMessage ;
		this.errorCode = errorCode;
	}

	/**
	 * 带参构造函数(默认错误)
	 * @param errorMessage 信息
	 * @param errorCode	   错误码
	 */
	public ResultData( final String errorMessage,final int errorCode){
		super();
		this.status = ResultData.STATUS_ERROR;
		this.errorMessage = errorMessage ;
		this.errorCode = errorCode;
	}
	
	/**
	 * 带参数构造函数(默认正确)
	 * @param body 数据
	 */
	public ResultData(final Object body){
		super();
		this.body = body;
		if(this.body == null){
			logger.error("ResultData.body is null.");
		}
	}
	
	public Object getBody(){
		if(this.body == null){
			return new HashMap<String, Object>();
		}else{
			return body;
		}
	}
	
	public ResultData setBody(Object body){
		this.body = body;
		if(this.body == null){
			logger.error("ResultData.body is null.");
		}
		return this;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	 /**
     * 向body中放置数据,前提是Map类型或还未放值
     *
     * @param key   (String)
     * @param value (Object)
     * @return
     */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public boolean putKV(String key,Object value){
		if(key != null && value != null){
			if(body == null){
				body = new HashMap<>();
			}
			if(body instanceof Map){
				((Map) body).put(key, value);
			}else{
				throw new IllegalArgumentException();
			}
		}
		return false;
	}
	
	/**
     * 从body中获取数据,前提是Map类型
     *
     * @param key (String)
     * @return Object
     */
	public Object tetKV(String key){
		if(body == null){
			return null;
		}
		 return ((Map) body).get(key); 
	}
	
	 /**
     * 从body中获取String数据,前提是Map类型
     *
     * @param key (String)
     * @return String
     */
	public String tetKVString(String key){
		return (String) tetKV(key);
	}
	
	  /**
     * 从body中获取Integer数据,前提是Map类型
     *
     * @param key (String)
     * @return String
     */
	public Integer tetKYInteger(String key){
		return (Integer)tetKV(key);
	}
	
	 /**
     * 从body中获取Long数据,前提是Map类型
     *
     * @param key (String)
     * @return String
     */
    public Long tetKVLong(String key) {
        return (Long) tetKV(key);
    }
    
    /**
     * Body是否是Map类型
     *
     * @return
     */
    public boolean itMapBody(){
    	return body != null && body instanceof Map;
    }
	
    /**
     * 是否正常
     *
     * @return
     */
	public boolean itSuccess(){
		return status == ResultData.STATUS_NORMAL;
	}
	
	/**
     * 是否异常
     *
     * @return
     */
    public boolean itNotSuccess() {
        return status != ResultData.STATUS_NORMAL;
    }

    /**
     * 是否废弃
     *
     * @return
     */
    public boolean itNotDeprecated() {
        return status != ResultData.STATUS_DEPRECATED;
    }
    
    public static ResultData successed(){
    	return new ResultData();
    }
	
    public static ResultData successed(Object data){
    	ResultData resultData = new ResultData();
    	resultData.setBody(data);
    	return resultData;
    }
    
    public static ResultData successed(String mesg,Object data){
    	ResultData resultData = new ResultData();
    	resultData.setErrorMessage(mesg);
    	resultData.setBody(data);
    	return resultData;
    }
    
    public static ResultData successed(String mesg){
    	ResultData resultData = new ResultData();
    	resultData.setErrorMessage(mesg);
    	resultData.setStatus(STATUS_ERROR);
    	return resultData;
    }
    
    public static ResultData failed(String mesg){
    	ResultData resultData = new ResultData();
    	resultData.setErrorMessage(mesg);
    	resultData.setStatus(STATUS_ERROR);
    	return resultData;
    }
    
    public static ResultData deprecated(Object data){
    	ResultData resultData = new ResultData();
    	resultData.setBody(data);
    	resultData.setStatus(STATUS_DEPRECATED);
    	return resultData;
    }
    
}
