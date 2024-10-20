package com.github.mbmll.filesync.server.properties;

import lombok.Data;

import java.util.List;

@Data
public class ConfigProperties {
    private List<String> types;
    private String path;
    private RootProperties root;
    private String username;
    private String password;
}
