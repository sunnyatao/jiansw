package com.jianan.software.util;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ResponseUtil {
	private static final Logger logger = LoggerFactory.getLogger(ResponseUtil.class);
	

	
	public static JSONObject responseJSON(int code ,String reason ){
		JSONObject obj = new JSONObject();
		obj.put("code", code);
		obj.put("reason",reason);
		
		return obj;
	}

	private static JSONObject responseJSON(int code ,String reason, Map msgData ){
		JSONObject obj = new JSONObject();
		obj.put("code", code);
		obj.put("reason",reason);
		obj.put("msg_data",msgData);
		
		return obj;
	}
	
	private static JSONObject responseJSON(int code ,String reason, JSONObject msgData ){
		JSONObject obj = new JSONObject();
		obj.put("code", code);
		obj.put("reason",reason);
		obj.put("msg_data",msgData);
		
		return obj;
	}

	private static JSONObject responseJSON(int code ,String reason, String msgData ){
		JSONObject obj = new JSONObject();
		obj.put("code", code);
		obj.put("reason",reason);
		obj.put("msg_data",msgData);
		
		return obj;
	}
	
	public static void writeResponse(HttpServletResponse response,ResponseCodeEnum codeEnum,  JSONObject msgData) {
		try{

			JSONObject objJson = responseJSON(codeEnum.getCode(), codeEnum.getReason(), msgData);
			String jsonString = objJson.toString();
			response.setContentType("text/html; charset=UTF-8");
			 byte[] resonseBuf = jsonString.getBytes("UTF-8");
			response.setContentLength(resonseBuf.length);
			
			response.getOutputStream().write(resonseBuf);
			

			if (logger.isDebugEnabled()) logger.debug(jsonString);
		} catch (Exception e) {
			logger.error(e.toString(), e);
		}
	}

	public static void writeResponse(HttpServletResponse response,  ResponseCodeEnum codeEnum) {
		try{

			JSONObject objJson = responseJSON(codeEnum.getCode(),codeEnum.getReason());
			String jsonString = objJson.toString();
			response.setContentType("text/html; charset=UTF-8");
			 byte[] resonseBuf = jsonString.getBytes("UTF-8");
			response.setContentLength(resonseBuf.length);
			response.getOutputStream().write(resonseBuf);
		
			if (logger.isDebugEnabled()) logger.debug(jsonString);
		} catch (Exception e) {
			logger.error(e.toString(), e);
		}
	}
	
	public static void writeResponseSuccess(HttpServletResponse response) {
		try{

			JSONObject objJson = responseJSON(ResponseCodeEnum.SuccessCode.getCode(),
					ResponseCodeEnum.SuccessCode.getReason());
			String jsonString = objJson.toString();
			response.setContentType("text/html; charset=UTF-8");
			 byte[] resonseBuf = jsonString.getBytes("UTF-8");
			response.setContentLength(resonseBuf.length);
			response.getOutputStream().write(resonseBuf);
		
			if (logger.isDebugEnabled()) logger.debug(jsonString);
		} catch (Exception e) {
			logger.error(e.toString(), e);
		}
	}
	

	public static void writeResponseSuccess(HttpServletResponse response,JSONObject msgData) {
		try{

			JSONObject objJson = responseJSON(ResponseCodeEnum.SuccessCode.getCode(),
					ResponseCodeEnum.SuccessCode.getReason(),msgData);
			String jsonString = objJson.toString();
			response.setContentType("text/html; charset=UTF-8");
			 byte[] resonseBuf = jsonString.getBytes("UTF-8");
			response.setContentLength(resonseBuf.length);
			response.getOutputStream().write(resonseBuf);
			
			if (logger.isDebugEnabled()) logger.debug(jsonString);
		
		} catch (Exception e) {
			logger.error(e.toString(), e);
		}
	}

	public static void writeJsonpResponseSuccess(HttpServletResponse response,JSONObject msgData, String jsonpName) {
		try{
			
			JSONObject objJson = responseJSON(ResponseCodeEnum.SuccessCode.getCode(),
					ResponseCodeEnum.SuccessCode.getReason(),msgData);
			String jsonString = jsonpName + "(" + objJson.toString() + ")";
			response.setContentType("text/html; charset=UTF-8");
			byte[] resonseBuf = jsonString.getBytes("UTF-8");
			response.setContentLength(resonseBuf.length);
			response.getOutputStream().write(resonseBuf);
			
			if (logger.isDebugEnabled()) logger.debug(jsonString);
			
		} catch (Exception e) {
			logger.error(e.toString(), e);
		}
	}
	
	public static void writeResponseSuccess(HttpServletResponse response,
			Map<String, Object> msg_data) {
		try{

			JSONObject objJson = responseJSON(ResponseCodeEnum.SuccessCode.getCode(),
					ResponseCodeEnum.SuccessCode.getReason(), msg_data);
			String jsonString = objJson.toString();
			response.setContentType("text/html; charset=UTF-8");
			 byte[] resonseBuf = jsonString.getBytes("UTF-8");
			response.setContentLength(resonseBuf.length);
			response.getOutputStream().write(resonseBuf);
			
			if (logger.isDebugEnabled()) logger.debug(jsonString);
		
		} catch (Exception e) {
			logger.error(e.toString(), e);
		}
	}


	public static void writeResponseFailure(HttpServletResponse response) {
		try{

			JSONObject objJson = responseJSON(ResponseCodeEnum.FailureCode.getCode(), 
					ResponseCodeEnum.FailureCode.getReason());
			String jsonString = objJson.toString();
			response.setContentType("text/html; charset=UTF-8");
			 byte[] resonseBuf = jsonString.getBytes("UTF-8");
			response.setContentLength(resonseBuf.length);
			response.getOutputStream().write(resonseBuf);
		
			if (logger.isDebugEnabled()) logger.debug(jsonString);
		} catch (Exception e) {
			logger.error(e.toString(), e);
		}
	}

	public static void writeJsonpResponseFailure(HttpServletResponse response, String jsonpName) {
		try{
			
			JSONObject objJson = responseJSON(ResponseCodeEnum.FailureCode.getCode(), 
					ResponseCodeEnum.FailureCode.getReason());
			String jsonString = jsonpName + "(" + objJson.toString() + ")";
			response.setContentType("text/html; charset=UTF-8");
			byte[] resonseBuf = jsonString.getBytes("UTF-8");
			response.setContentLength(resonseBuf.length);
			response.getOutputStream().write(resonseBuf);
			
			if (logger.isDebugEnabled()) logger.debug(jsonString);
		} catch (Exception e) {
			logger.error(e.toString(), e);
		}
	}

	
	public static void writeResponseFailure(HttpServletResponse response, String errMsg) {
		try{

			JSONObject objJson = responseJSON(ResponseCodeEnum.FailureCode.getCode(), 
					ResponseCodeEnum.FailureCode.getReason(), errMsg);
			String jsonString = objJson.toString();
			response.setContentType("text/html; charset=UTF-8");
			 byte[] resonseBuf = jsonString.getBytes("UTF-8");
			response.setContentLength(resonseBuf.length);
			response.getOutputStream().write(resonseBuf);
		
			if (logger.isDebugEnabled()) logger.debug(jsonString);
		} catch (Exception e) {
			logger.error(e.toString(), e);
		}
	}

	public static void writeResponseFailure(HttpServletResponse response, Exception ex) {
		try{

			JSONObject objJson = responseJSON(ResponseCodeEnum.FailureCode.getCode(), 
					ResponseCodeEnum.FailureCode.getReason());
			String jsonString = objJson.toString();
			response.setContentType("text/html; charset=UTF-8");
			 byte[] resonseBuf = jsonString.getBytes("UTF-8");
			response.setContentLength(resonseBuf.length);
			response.getOutputStream().write(resonseBuf);
		
			if (logger.isDebugEnabled()) logger.debug(jsonString);
		} catch (Exception e) {
			logger.error(e.toString(), e);
		}
	}

	public static void writeJsonpResponseFailure(HttpServletResponse response, Exception ex, String jsonpName) {
		try{
			
			JSONObject objJson = responseJSON(ResponseCodeEnum.FailureCode.getCode(), 
					ResponseCodeEnum.FailureCode.getReason());
			String jsonString = jsonpName + "(" + objJson.toString() + ")";
			response.setContentType("text/html; charset=UTF-8");
			byte[] resonseBuf = jsonString.getBytes("UTF-8");
			response.setContentLength(resonseBuf.length);
			response.getOutputStream().write(resonseBuf);
			
			if (logger.isDebugEnabled()) logger.debug(jsonString);
		} catch (Exception e) {
			logger.error(e.toString(), e);
		}
	}

	public static void writeResponseFailure(HttpServletResponse response,ResponseCodeEnum codeEnum) {
		try{

			JSONObject objJson = responseJSON(codeEnum.getCode(),codeEnum.getReason());
			String jsonString = objJson.toString();
			response.setContentType("text/html; charset=UTF-8");
			 byte[] resonseBuf = jsonString.getBytes("UTF-8");
			response.setContentLength(resonseBuf.length);
			response.getOutputStream().write(resonseBuf);
		
			if (logger.isDebugEnabled()) logger.debug(jsonString);
		} catch (Exception e) {
			logger.error(e.toString(), e);
		}
	}
	
	
	public static void writeEncryptedString(HttpServletResponse response, String resContent) {
		try{
			response.setContentType("text/html; charset=UTF-8");
			 byte[] resonseBuf = resContent.getBytes("UTF-8");
			response.setContentLength(resonseBuf.length);
			response.getOutputStream().write(resonseBuf);
		} catch (Exception e) {
			logger.error(e.toString(), e);
		}
	}
	public static boolean sendImg(HttpServletResponse response, BufferedImage buffImg, String mimeType, String fileName, String extName){
		OutputStream out= null;
		response.setContentType(mimeType);
		response.setHeader("Content-Disposition", String.format("attachment;filename=%s.%s", fileName, extName));
		try {
			out= response.getOutputStream();
			ImageIO.write(buffImg, extName, out);
//			BufferedInputStream buffIn= new BufferedInputStream(in);
//			BufferedOutputStream buffOut= new BufferedOutputStream(out);
//			byte buff[]= new byte[4096];//申请缓冲区
//			int size= buffIn.read(buff);//初始化读取缓冲
//			while (size!= -1) {
//				buffOut.write(buff, 0, size);//输出缓冲数据
//				size= buffIn.read(buff);//继续读取数据
//			}
//			buffIn.close();//关闭输入流
//			buffOut.flush();//清空输出流
//			buffOut.close();//关闭输出流
			return true;
		} catch (IOException e) {
			logger.error("直接推送图片错误", e);
			return false;
		}
	}

}
