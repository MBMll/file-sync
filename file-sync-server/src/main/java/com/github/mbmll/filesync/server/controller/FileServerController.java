package com.github.mbmll.filesync.server.controller;

import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController()
@RequestMapping("/")
public class FileServerController {

    /**
     * 获取所有文件元数据
     *
     * @return
     */
    @GetMapping("/meta/all")
    public String getAllMeta() {
        return "Hello World!";
    }
}

