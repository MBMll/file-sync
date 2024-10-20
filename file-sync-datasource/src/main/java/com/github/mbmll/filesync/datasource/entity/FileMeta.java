package com.github.mbmll.filesync.datasource.entity;

import com.github.mbmll.concept.fields.MaterialEssential;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "t_file_meta")
public class FileMeta implements MaterialEssential<Long, Date, Boolean> {
    @Id
    private Long id;
    private String name;
    private Date createTime;
    private Date updateTime;
    private Boolean deleted;

    private String filePath;
    private String footprint;
    private Date fileUpdateTime;
    private Boolean uploaded;
    private Boolean downloaded;
}
