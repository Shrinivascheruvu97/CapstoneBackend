package com.example.demo.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Notice;
import com.example.demo.service.NoticeService;

@RestController
@RequestMapping("/notice")
@CrossOrigin(origins="http://localhost:3000/")
public class NoticeController {

	
	@Autowired
	NoticeService noticeService;
	
	
	
	
	
//	@PostMapping("/add")
//	public ResponseEntity<Notice> addNotice(
//	        @RequestParam("heading") String heading,
//	        @RequestParam("notice") String notice,
//	        @RequestParam(value = "file", required = false) MultipartFile file
//	) {
//	    byte[] document = null;
//	    if (file != null && !file.isEmpty()) {
//	        try {
//	            document = file.getBytes();
//	        } catch (IOException e) {
//	            // Handle file upload exception
//	        }
//	    }
//
//	    Notice addedNotice = noticeService.addNotice(heading, notice,file);
//
//	    return new ResponseEntity<>(addedNotice, HttpStatus.CREATED);
//	}
	
	
//	@PostMapping("/add")
//	public ResponseEntity<Notice> addNotice(@RequestBody Notice notice)
//	{
//		Notice addNotice = noticeService.addNotice(String,String,MultipartFile);
//		
//	}

	 @PostMapping("/add")
	    public ResponseEntity<Notice> addNotice(@RequestBody Notice notice) {
	        Notice addedNotice = noticeService.addNotice(notice);
	        return new ResponseEntity<>(addedNotice, HttpStatus.CREATED);
	    }
	
	

    @GetMapping("/all")
    public ResponseEntity<List<Notice>> getAllNotices() {
        List<Notice> notices = noticeService.getAllNotices();
        return new ResponseEntity<>(notices, HttpStatus.OK);
    }
	
	

}
