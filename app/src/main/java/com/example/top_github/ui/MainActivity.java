package com.example.top_github.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.Toast;

import com.example.top_github.R;
import com.example.top_github.Utils.DataHolder;
import com.example.top_github.adapter.OnItemClickListener;
import com.example.top_github.adapter.RepoDetailsAdapter;
import com.example.top_github.service.Repository.GetDataService;
import com.example.top_github.service.Repository.RetrofitClientInstance;
import com.example.top_github.service.model.Repo;
import com.example.top_github.service.model.RepoDetails;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements OnItemClickListener {

    private ProgressDialog progressDialog;
    private RecyclerView recyclerView;
    private RepoDetailsAdapter adapter;
    private List<RepoDetails> repoDetailsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Loading....");
        progressDialog.setCancelable(false);
        progressDialog.show();

        recyclerView = findViewById(R.id.project_list);

        /*Create handle for the RetrofitInstance interface*/
        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<List<RepoDetails>> call = service.getAllRepos("java", "weekly");

        call.enqueue(new Callback<List<RepoDetails>>() {
            @Override
            public void onResponse(Call<List<RepoDetails>> call, Response<List<RepoDetails>> response) {
                progressDialog.dismiss();
                generateDataList(response.body());
            }

            @Override
            public void onFailure(Call<List<RepoDetails>> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }

        });
    }

    /*Method to generate List of data using RecyclerView with custom adapter*/
    private void generateDataList(List<RepoDetails> repoDetails) {
        repoDetailsList = repoDetails;
        adapter = new RepoDetailsAdapter(this, repoDetailsList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(int position) {
        DataHolder.getInstance().setRepoDetails(repoDetailsList.get(position));
        Intent intent = new Intent(this,RepoDetailsActivity.class);
        startActivity(intent);
    }
}

