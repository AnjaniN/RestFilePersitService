# RestFilePersistService
Rest API call to upload file with few metadata fields.
- Persisting metadata in In-Memory persistence store(h2).
- Storing the content on the file system.



#To Upload a file
Use the following URL - http://localhost:8080/persist/uploadFile   (POST)
- ![Alt text](/images/post.png?raw=true "Post example")

#To Get the metadata of the files
Use the following URL - http://localhost:8080/persist/filesMetaData   (GET)

#To get the metadata of the files using the file id
Use the following URL - http://localhost:8080/persist/filesMetaData/fileID/{uuid}    (GET)
