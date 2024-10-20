package com.github.mbmll.filesync.datasource.repository;

import com.github.mbmll.filesync.datasource.entity.FileMeta;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FileMetaRepository extends JpaRepository<FileMeta, Long> {
    List<FileMeta> findAllByPathStartsWithAndDeletedIsFalse(String path, Sort sort);
}
