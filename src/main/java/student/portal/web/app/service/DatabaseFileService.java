package student.portal.web.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import student.portal.web.app.exception.FileNotFoundException;
import student.portal.web.app.exception.FileStorageException;
import student.portal.web.app.model.DatabaseFile;
import student.portal.web.app.repository.DatabaseFileRepository;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

@Service
public class DatabaseFileService {
    private final Path root = Paths.get("uploads");
    @Autowired
    private DatabaseFileRepository dbFileRepository;
    public void init() {
        try {
            Files.createDirectory(root);
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize folder for upload!");
        }
    }
    public DatabaseFile storeFile(MultipartFile file) throws FileStorageException, IOException {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        //check directory
        if(!Files.isDirectory(root)){
            this.init();
        }

        // Check if the file's name contains invalid characters
        if (fileName.contains("..")) {
            throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
        }
        Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));
        DatabaseFile dbFile = new DatabaseFile(fileName, file.getContentType());

        return dbFileRepository.save(dbFile);
    }

    public Optional<DatabaseFile> getFile(String fileId) {
        return dbFileRepository.findById(fileId);
//                .orElseThrow(()- > new FileNotFoundException("File not found with id " + fileId));
    }

}
