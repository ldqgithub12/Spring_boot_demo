package com.demospring.Springtutorial.repositories;

import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

public interface FileRepository {
    public String stored(MultipartFile file);
    public Stream<Path> loadAll();
    public byte[] readFileContent(String filename);
    public void deleteAllFile();
}
