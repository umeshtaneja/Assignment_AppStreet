package com.example.top_github.service.model;

import com.google.gson.annotations.SerializedName;

public class RepoDetails {

    @SerializedName("username")
    private String userName;
    @SerializedName("name")
    private String name;
    @SerializedName("type")
    private String type;
    @SerializedName("url")
    private String url;
    @SerializedName("avatar")
    private String thumbnailUrl;
    @SerializedName("repo")
    private Repo repo;

    public String getUserName() {
        return userName;
    }

    public String getName() {
        return name;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public Repo getRepo() {
        return repo;
    }

}


