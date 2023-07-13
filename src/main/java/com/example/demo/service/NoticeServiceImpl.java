package com.example.demo.service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Notice;
import com.example.demo.repositroy.NoticeRepository;

@Service
public class NoticeServiceImpl implements NoticeService {
	
	@Autowired
	NoticeRepository noticeRepository;
	
	
//	@Override
//    public Notice addNotice(Notice notices) {
//        Notice newNotice = new Notice();
//        newNotice.setHeading(heading);
//        newNotice.setNotice(notice);
//        newNotice.setDateIssued(LocalDateTime.now());
//
//        if (file != null && !file.isEmpty()) {
//            try {
//                newNotice.setDocument(file.getBytes());
//            } catch (IOException e) {
//                // Handle file upload exception
//            }
//        }
//
//        return noticeRepository.save(newNotice);
//    }
	
//	 @Override
//	    public Notice addNotice(Notice notice) {
//	        notice.setDateIssued(LocalDateTime.now());
//
//	        MultipartFile file = notice.getDocument();
//	        if (file != null && !file.isEmpty()) {
//	            try {
//	                notice.setDocument(file.getBytes());
//	            } catch (IOException e) {
//	                // Handle file upload exception
//	            }
//	        }
//
//	        return noticeRepository.save(notice);
//	    }
	
	
	 @Override
	    public Notice addNotice(Notice notice) {
	        notice.setDateIssued(LocalDateTime.now());
	        return noticeRepository.save(notice);
	    }

    @Override
    public List<Notice> getAllNotices() {
        return noticeRepository.findAll();
    }
	
	
	

}
