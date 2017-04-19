package com.rest.RestFilePersist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.rest.RestFilePersist.model.Document;
import com.rest.RestFilePersist.model.FileMetaData;
import com.rest.RestFilePersist.model.FilePK;

@Repository
public interface FileRepositoryDAO extends JpaRepository<FileMetaData, FilePK>{
	
	

	public FileMetaData findByUuid(String uuid);
	
	public List<FileMetaData> findByCreatorName(String creatorName);
	
	public void deleteByUuid(String uuid);



	
	
	

}
