package com.gearshop.ShoppingProject.RestfullAPI;

import com.gearshop.ShoppingProject.Service.FileManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class FileUploadController {
    @Autowired
    FileManagerService fileService;

    @GetMapping("/files/{folder}/{file}")
    public byte[] downloadImg(@PathVariable("folder") String folder, @PathVariable("file") String file) {
        return fileService.read(folder, file);
    }

    @PostMapping("/files/{folder}")
    public List<String> uploadImg(@PathVariable("folder") String folder, @PathParam("files") MultipartFile[] files) {
        return fileService.save(folder, files);
    }

    @DeleteMapping("/files/{folder}/{file}")
    public void deleteImg(@PathVariable("folder") String folder, @PathVariable("file") String file) {
        fileService.delete(folder, file);
    }

    @GetMapping("/files/{folder}")
    public List<String> listImg(@PathVariable("folder") String folder) {
        return fileService.list(folder);
    }
}
