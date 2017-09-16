package com.jianan.software.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.jianan.software.pojo.ProjectCheckFile;
import com.jianan.software.service.IHouseContractService;
import com.jianan.software.service.IProjectCheckService;
import com.jianan.software.service.IProjectOuterubeService;
import com.jianan.software.service.IProjectSettlementService;
import com.jianan.software.service.ISummaryService;
import com.jianan.software.util.ResponseUtil;

@Controller
@RequestMapping("/upload")
public class FileUploadController {
	private final Logger LOGGER = LoggerFactory.getLogger(FileUploadController.class);
	
	@Autowired
	private IProjectCheckService projectCheckService;
	
	@Autowired
	private IProjectSettlementService projectSettlementService;
	
	@Autowired
	private IProjectOuterubeService projectOuterubeService;
	
	@Autowired
	private IHouseContractService houseContractService;
	
	final long MAX_SIZE = 10 * 1024 * 1024;// 设置上传文件最大为 10M
	
	// 允许上传的文件格式的列表
	final String[] allowtype = new String[] {"jpg", "jpeg", "gif", "txt", "doc", "docx", "mp3", "wma", "m4a", "xls", "xlsx", "zip", "rar"};

	@RequestMapping("/toupload")
	public ModelAndView toUpload(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = new ModelAndView("/test_up");
		return view;
	}

	@RequestMapping("/api/scanfiles/flash/up")
	public void ajaxUploadScanFileFlash(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String upType = request.getParameter("upType");
		String id = request.getParameter("upId");
		String serialNum = request.getParameter("serialNum");
		int iId = 0;
		int iUpType = 0;
		try{
			iUpType = Integer.parseInt(upType);
			iId = Integer.parseInt(id);
		} catch(Exception e) {
			e.printStackTrace();
			ResponseUtil.writeResponseFailure(response);
			return;
		}
		
		String path = request.getSession().getServletContext().getRealPath("/") + "\\static_resources\\data\\upType_"+upType+"\\"+id+"_"+serialNum+"\\";
        File dir = new File(path);
        if (!dir.exists()) {
        	dir.mkdirs();
        }
		LOGGER.info(path);
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// 设置内存缓冲区，超过后写入临时文件
		factory.setSizeThreshold(10240000);
		// 设置临时文件存储位置
		String base = "d:/uploadFiles/upType_" + upType + "/" + id+"_"+serialNum;
		File file = new File(base);
		if(!file.exists())
			file.mkdirs();
		factory.setRepository(file);
		ServletFileUpload upload = new ServletFileUpload(factory);
		// 设置单个文件的最大上传值
		upload.setFileSizeMax(10002400000l);
		// 设置整个request的最大值
		upload.setSizeMax(10002400000l);
		upload.setHeaderEncoding("UTF-8");
		
		try {
			List items = upload.parseRequest(request);
			FileItem item = null;
			String fileName = null;
			String saveFileName = null;
			List<String> targetFileNames = new ArrayList<>();
			for (int i = 0 ;i < items.size(); i++){
				item = (FileItem) items.get(i);
				fileName = base + File.separator + item.getName();
				saveFileName = path + item.getName();
				// 保存文件
				if (!item.isFormField() && item.getName().length() > 0) {
					targetFileNames.add(item.getName());
					item.write(new File(fileName));
					item.write(new File(saveFileName));
				}
			}
			
			String downPath = "/upType_" + upType + "/"+id+"_"+serialNum+"/";
			dump2Db(targetFileNames, downPath, iUpType, iId);
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/api/scanfiles/up")
	public void ajaxUploadScanFiles(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			String upType = request.getParameter("upType");
			String id = request.getParameter("upId");
			String serialNum = request.getParameter("serialNum");
			int iId = 0;
			int iUpType = 0;
			try{
				iUpType = Integer.parseInt(upType);
				iId = Integer.parseInt(id);
			} catch(Exception e) {
				e.printStackTrace();
				ResponseUtil.writeResponseFailure(response);
				return;
			}
			
			String path = request.getSession().getServletContext().getRealPath("/") + "\\static_resources\\data\\upType_"+upType+"\\"+id+"_"+serialNum+"\\";
	        File dir = new File(path);
	        if (!dir.exists()) {
	        	dir.mkdirs();
	        }
			LOGGER.info(path);
	        
			List<String> targetFileNames = new ArrayList<>();
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
			List<MultipartFile> fileList = multipartRequest.getFiles("file1");
			for (MultipartFile mf: fileList) {
				LOGGER.info(mf.getName());
				
		        //获取文件
		        String originalFileName = mf.getOriginalFilename();
		        String[] ts = originalFileName.split("\\.");
		        String suffix = ts[ts.length - 1];
		        //String targetFileName = UUID.randomUUID().toString() + "." + suffix;
		        String targetFileName = originalFileName;
		        targetFileNames.add(targetFileName);
		        
		        
		        
		        InputStream instream = mf.getInputStream();
		        FileOutputStream fos = new FileOutputStream(path + targetFileName);
				byte[] buffer = new byte[8192];
				int count = 0;
		
				while ((count = instream.read(buffer)) > 0) {
					fos.write(buffer, 0, count); 
				}
				fos.close();
				instream.close();
			}
			String downPath = "/upType_" + upType + "/"+id+"_"+serialNum+"/";
			dump2Db(targetFileNames, downPath, iUpType, iId);
			JSONObject msgData = new JSONObject();
			msgData.put("filenames", targetFileNames);
			ResponseUtil.writeResponseSuccess(response, msgData);
		} catch (Exception e) {
			e.printStackTrace();
			ResponseUtil.writeResponseFailure(response, e);
		}
	}
	
	private void dump2Db(List<String> fileNames, String filePath, int uploadType, int id) {
		List<ProjectCheckFile> checkFiles = new ArrayList<>();
		for (String filename: fileNames) {
			ProjectCheckFile checkFile = new ProjectCheckFile();
			checkFile.setCheckId(id);
			String fileFullName = filePath + filename;
			checkFile.setFileName(fileFullName);
			checkFile.setName(filename);
			checkFiles.add(checkFile);
		}
		
		if (uploadType == ISummaryService.UPLOAD_TYPE_PROJECTCHECK) {
			projectCheckService.createFiles(checkFiles);
		} else if (uploadType == ISummaryService.UPLOAD_TYPE_PROJECTCHECK_INVOICE) {
			projectCheckService.createInvoiceFiles(checkFiles);
		} else if (uploadType == ISummaryService.UPLOAD_TYPE_PROJECTSettlement) {
			projectSettlementService.createFiles(checkFiles);
		} else if (uploadType == ISummaryService.UPLOAD_TYPE_PROJECTSettlement_INVOICE) {
			projectSettlementService.createInvoiceFiles(checkFiles);
		} else if (uploadType == ISummaryService.UPLOAD_TYPE_PROJECTOuterube) {
			projectOuterubeService.createFiles(checkFiles);
		} else if (uploadType == ISummaryService.UPLOAD_TYPE_PROJECTouterube_INVOICE) {
			projectOuterubeService.createInvoiceFiles(checkFiles);
		} else if (uploadType == ISummaryService.UPLOAD_TYPE_HOUSE_CONTRACT) {
			houseContractService.createFiles(checkFiles);
		} else if (uploadType == ISummaryService.UPLOAD_TYPE_HOUSE_CONTRACT_INVOICE) {
			houseContractService.createInvoiceFiles(checkFiles);
		}
	}
 	
	@RequestMapping("/api/up")
	public void ajaxUpload(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			List<String> targetFileNames = new ArrayList<>();
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
			List<MultipartFile> fileList = multipartRequest.getFiles("file1");
			for (MultipartFile mf: fileList) {
				LOGGER.info(mf.getName());
				
		        //获取文件
		        String originalFileName = mf.getOriginalFilename();
		        String[] ts = originalFileName.split("\\.");
		        String suffix = ts[ts.length - 1];
		        String targetFileName = UUID.randomUUID().toString() + "." + suffix;
		        targetFileNames.add(targetFileName);
		        
		        String path = request.getSession().getServletContext().getRealPath("/") + "\\static_resources\\data\\";
		        LOGGER.info(path);
		        
		        InputStream instream = mf.getInputStream();
		        FileOutputStream fos = new FileOutputStream(path + targetFileName);
				byte[] buffer = new byte[8192];
				int count = 0;
		
				while ((count = instream.read(buffer)) > 0) {
					fos.write(buffer, 0, count); 
				}
				fos.close();
				instream.close();
			}
			JSONObject msgData = new JSONObject();
			msgData.put("filenames", targetFileNames);
			ResponseUtil.writeResponseSuccess(response, msgData);
		} catch (Exception e) {
			e.printStackTrace();
			ResponseUtil.writeResponseFailure(response, e);
		}
	}
}
