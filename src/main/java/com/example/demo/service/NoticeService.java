package com.example.demo.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Notice;

public interface NoticeService {
	
	Notice addNotice(Notice notice );

	    List<Notice> getAllNotices();

}
