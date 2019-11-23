package com.example.top_github.service.model;
import com.google.gson.annotations.SerializedName;

public class Repo{

    @SerializedName("name")
    private String Name;
    @SerializedName("description")
    private String Description;
    @SerializedName("url")
    private String Url;

    public String getName() {
        return Name;
    }

    public String getDescription() {
        return Description;
    }

    public String getUrl() {
        return Url;
    }

    public Repo(String name, String description, String url) {
        Name = name;
        Description = description;
        Url = url;
    }
}