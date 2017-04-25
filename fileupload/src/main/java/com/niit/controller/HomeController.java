package com.niit.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.niit.dao.Uploaddao;

@Controller
public class HomeController {
	@Autowired
	private Uploaddao uploaddao;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showUploadForm(HttpServletRequest request) {
	return "Upload";
	����}
	�����
	����@RequestMapping(value = "/doUpload", method = RequestMethod.POST)
	public String handleFileUpload(HttpServletRequest request,
	@RequestParam CommonsMultipartFile[] fileUpload) throws Exception {
	if (fileUpload != null && fileUpload.length > 0) {
	for (CommonsMultipartFile aFile : fileUpload){
	System.out.println("Saving file: " + aFile.getOriginalFilename());
	����������������Upload upload = new Upload();
	����������������upload.setFileName(aFile.getOriginalFilename());
	����������������upload.setData(aFile.getBytes());
	����������������uploaddao.save(upload);���������������
	�����������}}
return "Success";
	����}��
	}
}
}
