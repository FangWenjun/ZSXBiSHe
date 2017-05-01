package com.zsx.servlets;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zsx.Daos.LikePostbarDaoImpl;
import com.zsx.servlets.base.BaseServletFactory;

import net.sf.json.JSONArray;

public class LikePostbar extends BaseServletFactory {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3963620366874678549L;

	@Override
	protected Map<String, String> dataModel(HttpServletRequest request, HttpServletResponse response) {
		String userPhone=request.getParameter("userPhone");
		String token=request.getParameter("token");
		boolean effectToken=tokenChecked(userPhone, token);
		if(!effectToken){
			return getJsonMap();
		}
		String postBarId=request.getParameter("postBarId");
//		String flag=request.getParameter("flag");
		LikePostbarDaoImpl likeImpl=new LikePostbarDaoImpl();
		boolean result=likeImpl.like(postBarId, userPhone);
		Map<String,String> map=new HashMap<>();
		if(!result){
			map.put("result", "fail");
			map.put("data", "����ʧ��");
		}else{
			map.put("result", "success");
			map.put("data", "�����ɹ�");
		}
		return map;
	}

}
