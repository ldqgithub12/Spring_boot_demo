package com.demospring.Springtutorial.services;

import com.demospring.Springtutorial.repositories.FileRepository;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

public class ImageService implements FileRepository {
    @Override
    public String stored(MultipartFile file) {
        return null;
    }

    @Override
    public Stream<Path> loadAll() {
        return null;
    }

    @Override
    public byte[] readFileContent(String filename) {
        return new byte[0];
    }

    @Override
    public void deleteAllFile() {

    }
}
