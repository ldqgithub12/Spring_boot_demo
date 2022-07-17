package com.demospring.Springtutorial.controller;

import com.demospring.Springtutorial.models.ResponseObject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/api/v1/fileUpload/")
public class FileUploadController {
    @PostMapping("/upload/")
    public ResponseEntity<ResponseObject> uploadFiles(@RequestParam("file")MultipartFile file){
        try{

        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}
