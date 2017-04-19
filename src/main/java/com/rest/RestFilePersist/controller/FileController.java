package com.rest.RestFilePersist.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.rest.RestFilePersist.model.Document;
import com.rest.RestFilePersist.model.FileMetaData;
import com.rest.RestFilePersist.repository.FileRepositoryDAO;
import com.rest.RestFilePersist.service.PersistService;


@RestController
@RequestMapping(path="/persist")
public class FileController {

	private static final Logger LOG = Logger.getLogger(FileController.class);
	
	
	@Autowired
	private PersistService persistService;
	
	@RequestMapping(value="uploadFile", method = RequestMethod.POST)
	public FileMetaData uploadFile(@RequestParam(value="file", required=true) MultipartFile newfile ,
			 @RequestParam(value="date", required=true) @DateTimeFormat(pattern="yyyy-MM-dd") Date date,
            @RequestParam(value="creator", required=true) String creatorName){
		Document document;
		try {
			document = new Document(newfile.getBytes(),newfile.getOriginalFilename(),creatorName,date);
			return persistService.upload(document);	
		
		} catch (RuntimeException e) {
            LOG.error("Error while uploading.", e);
            throw e;
        } catch (Exception e) {
            LOG.error("Error while uploading.", e);
            throw new RuntimeException(e);
        }      
		
		
	}
	
	@RequestMapping(value="filesMetaData", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public List<FileMetaData> getFileList(){
		return persistService.getFileList();
	}
	
	@RequestMapping(value="filesMetaData/{creatorName}", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public List<FileMetaData> findByCreatorName(@PathVariable String creatorName){
		return persistService.findByCreatorName(creatorName);
	}
	
	
	@RequestMapping(value="filesMetaData/fileID/{uuid}", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public FileMetaData findByUuid(@PathVariable String uuid){
		return persistService.findByUuid(uuid);
	}
	
}
