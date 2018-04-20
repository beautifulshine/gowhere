package com.test.demo;

import net.sf.json.JSONObject;

public class Test {
	public static void main(String[] args) {
		String s = "{\"name\":\"vox\",\"age\":\"15\"}";
		 JSONObject jsonObject=JSONObject.fromObject(s);
		System.out.println(jsonObject.getString("name"));
	}

}
