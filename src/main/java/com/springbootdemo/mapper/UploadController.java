package com.springbootdemo.mapper;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {
	@RequestMapping("/uploadPage")
	public String uploadPage() {
		return "uploadPage";
	}
	public String upload(HttpServletRequest req,@RequestParam("file") MultipartFile file,Model m) {
		String fileName = System.currentTimeMillis() + file.getOriginalFilename();
		String destFilename = req.getServletContext().getRealPath("")+"upload" + File.separator+fileName;
		File destFile = new File(destFilename);
		destFile.getParentFile().mkdirs();
		try {
			file.transferTo(destFile);
			 m.addAttribute("fileName",fileName);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			 return "上传失败," + e.getMessage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			 return "上传失败," + e.getMessage();
		}
		
		return "showImg";
	}
}
