package com.example.top_github.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.top_github.R;
import com.example.top_github.Utils.DataHolder;
import com.example.top_github.service.model.RepoDetails;

public class RepoDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repo_details);

        RepoDetails repoDetails = DataHolder.getInstance().getRepoDetails();

        TextView userName = findViewById(R.id.userName);
        TextView repoName = findViewById(R.id.repoName);
        TextView description = findViewById(R.id.description);
        TextView clone_url = findViewById(R.id.clone_url);

        if (repoDetails.getName() != null)
            userName.setText(repoDetails.getName());

        if (repoDetails.getRepo().getName() != null)
            repoName.setText(repoDetails.getRepo().getName());

        if (repoDetails.getRepo().getDescription() != null)
            description.setText(repoDetails.getRepo().getDescription());

        if (repoDetails.getRepo().getUrl() != null)
            clone_url.setText(repoDetails.getRepo().getUrl());
    }
}
