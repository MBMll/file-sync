package com.github.mbmll.filesync.server.controller;

import com.github.mbmll.filesync.datasource.entity.FileMeta;
import com.github.mbmll.filesync.server.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController()
@RequestMapping("/")
@RequiredArgsConstructor
public class FileServerController {
    private final FileService fileService;

    /**
     * 获取所有文件元数据
     *
     * @return
     */
    @GetMapping("/meta/all")
    public List<FileMeta> getAllMeta(String path) {

        return fileService.getAllMeta(path);
    }

    @PutMapping("/upload")
    public void upload(MultipartFile file, String path) throws IOException {

        fileService.upload(file, path);
    }
}

