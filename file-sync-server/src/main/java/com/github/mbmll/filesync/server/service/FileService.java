package com.github.mbmll.filesync.server.service;

import com.github.mbmll.filesync.datasource.entity.FileMeta;
import com.github.mbmll.filesync.datasource.entity.FileMeta_;
import com.github.mbmll.filesync.datasource.repository.FileMetaRepository;
import com.github.mbmll.filesync.server.properties.ConfigProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @Author xlc
 * @Description
 * @Date 2024/10/20 23:54:18
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class FileService {

    private final FileMetaRepository fileMetaRepository;
    private final ConfigProperties configProperties;

    public List<FileMeta> getAllMeta(String path) {
        if (!path.endsWith("/")) {
            path = path + "/";
        }
        return fileMetaRepository.findAllByPathStartsWithAndDeletedIsFalse(path,
                Sort.by(FileMeta_.FILE_PATH).ascending());
    }


    public void upload(MultipartFile multipartFile, String path) throws IOException {
        File target = new File(configProperties.getPath(), path);
        target.mkdirs();
        String originalFilename = multipartFile.getOriginalFilename();
        if (originalFilename == null) {
//            throw new BusinessException("upload file name is null");
        }
        target = new File(target, originalFilename);
        FileUtils.touch(target);
        multipartFile.transferTo(target);
        log.info("upload file success for {}", originalFilename);
    }
}
