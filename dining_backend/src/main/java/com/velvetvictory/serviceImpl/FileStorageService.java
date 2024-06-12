package com.velvetvictory.serviceImpl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileStorageService {

	public final String storagePath = "D:\\Hotel_Management\\Velvet_Victory\\Images";
	
	public FileStorageService()
	{
		File directory = new File(storagePath);
		if(!directory.exists())
		{
			directory.mkdir();
		}
	}
	
	public String storeFile(MultipartFile file) throws IOException
	{
		String fileName = System.currentTimeMillis() + "_" +file.getOriginalFilename();
		Path filePath = Paths.get(storagePath, fileName);
		Files.write(filePath, file.getBytes());
		return filePath.toString();
		
	}
}
