package com.rest.RestFilePersist.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rest.RestFilePersist.model.Document;
import com.rest.RestFilePersist.model.FileMetaData;
import com.rest.RestFilePersist.repository.FileRepositoryDAO;


@Service
public class PersistService {
	 private static final Logger LOG = Logger.getLogger(PersistService.class);
	    
	 public static final String DIRECTORY = "archive";
	    
	 @PostConstruct
	 public void init() {
	        createDirectory(DIRECTORY);
	    }
	
	@Autowired
	private FileRepositoryDAO fileRepository;
	
	
	
	
	
	
	public List<FileMetaData> getFileList()
	{
		return fileRepository.findAll();
		
	}
	
	@Transactional
	public void deleteByUuid(String uuid)
	{
		fileRepository.deleteByUuid(uuid);
	}
	
	public List<FileMetaData> findByCreatorName(String userName)
	{
		return fileRepository.findByCreatorName(userName);
	}
	
	public FileMetaData findByUuid(String uuid)
	{
		return fileRepository.findByUuid(uuid);
	}

	public FileMetaData upload(Document file)
	{
		//FileMetaData metaData=new FileMetaData(file.getFileName(),file.getCreatorName(),file.getFileDate());
		 try {
	            createDirectory(file);
	            saveFileData(file);
	           
	        } catch (IOException e) {
	            String message = "Error while inserting document";
	            LOG.error(message, e);
	            throw new RuntimeException(message, e);
	        }
		 FileMetaData metaData=new FileMetaData(file.getUuid(),file.getFileName(),file.getCreatorName(),file.getFileDate());
		fileRepository.saveAndFlush(metaData);
		return metaData;
	}
	
	
	 private void saveFileData(Document document) throws IOException {
	        String path = getDirectoryPath(document);
	        BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(new File(path), document.getFileName())));
	        stream.write(document.getFileData());
	        stream.close();
	    }
	 private String createDirectory(Document document) {
	        String path = getDirectoryPath(document);
	        createDirectory(path);
	        return path;
	    }

	    private String getDirectoryPath(Document document) {
	       return getDirectoryPath(document.getUuid());
	    }
	    
	    private String getDirectoryPath(String uuid) {
	        StringBuilder sb = new StringBuilder();
	        sb.append(DIRECTORY).append(File.separator).append(uuid);
	        String path = sb.toString();
	        return path;
	    }

	    private void createDirectory(String path) {
	    	
	        File file = new File(path);
	       
	        file.mkdirs();
	    }


	
	
	

}
