package com.example.top_github.Utils;

import com.example.top_github.service.model.RepoDetails;

public class DataHolder {

    private static DataHolder instance;
    private RepoDetails repoDetails;

    private DataHolder() {
    }

    public static DataHolder getInstance() {
        if (instance == null)
            return instance = new DataHolder();
        else
            return instance;
    }

    public RepoDetails getRepoDetails() {
        return repoDetails;
    }

    public void setRepoDetails(RepoDetails repoDetails) {
        this.repoDetails = repoDetails;
    }

}
