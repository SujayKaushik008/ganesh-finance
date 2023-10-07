package com.oracle.finance.dao;

import org.springframework.web.multipart.MultipartFile;

public interface DocumentDao {
	public String uploadfile(MultipartFile File);
}
