package com.example.krishanroy.unit_04_assessment;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.krishanroy.unit_04_assessment.controller.AnimalAdapter;
import com.example.krishanroy.unit_04_assessment.fragments.DetailFragment;
import com.example.krishanroy.unit_04_assessment.model.Messages;
import com.example.krishanroy.unit_04_assessment.model.OuterClass;
import com.example.krishanroy.unit_04_assessment.network.GetApi;
import com.example.krishanroy.unit_04_assessment.network.RetrofitSingleton;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "tag";
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.animal_recycler_view);

        Retrofit retrofit = RetrofitSingleton.newInstance();
        GetApi getApi = retrofit.create(GetApi.class);
        Call<OuterClass> outerClassCall = getApi.getOuterClass();
        outerClassCall.enqueue(new Callback<OuterClass>() {
            @Override
            public void onResponse(Call<OuterClass> call, Response<OuterClass> response) {
                Log.d(TAG, "onResponse: " + response.body().getMessage().get(0).getImage());
                List<Messages> messagesList = response.body().getMessage();
                recyclerView.setAdapter(new AnimalAdapter(messagesList));
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            }

            @Override
            public void onFailure(Call<OuterClass> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());

            }
        });
    }

}
