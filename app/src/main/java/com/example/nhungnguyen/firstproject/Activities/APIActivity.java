package com.example.nhungnguyen.firstproject.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.nhungnguyen.firstproject.API.ApiUtils;
import com.example.nhungnguyen.firstproject.Adapters.AnswersAdapter;
import com.example.nhungnguyen.firstproject.Interface.SOService;
import com.example.nhungnguyen.firstproject.Models.Item;
import com.example.nhungnguyen.firstproject.Models.SOAnswersResponse;
import com.example.nhungnguyen.firstproject.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class APIActivity extends AppCompatActivity implements AnswersAdapter.PostItemListener {
    private RecyclerView mRecyclerView;
    private SOService mService;
    private AnswersAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api);
        mService = ApiUtils.getSOService();
        mRecyclerView = (RecyclerView) findViewById(R.id.recycleview);
        mAdapter = new AnswersAdapter(this, new ArrayList<Item>(), this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        mRecyclerView.addItemDecoration(itemDecoration);
        loadAnswers();
    }

    public void loadAnswers() {
        mService.getAnswers().enqueue(new Callback<SOAnswersResponse>() {
            @Override
            public void onResponse(Call<SOAnswersResponse> call, Response<SOAnswersResponse> response) {
                if (response.isSuccessful()) {
                    mAdapter.updateAnswers(response.body().getItems());
                } else {
                    int statusCode = response.code();
                }
            }

            @Override
            public void onFailure(Call<SOAnswersResponse> call, Throwable t) {

            }
        });
    }

    @Override
    public void onPostClick(long id) {

    }
}
