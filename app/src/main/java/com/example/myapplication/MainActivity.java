package com.example.myapplication;

import androidx.databinding.DataBindingUtil;
import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.myapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding activityMainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        Call<ApimoviesResponse>call = Retrofitclient.getInsatance().getApi()
                .getdata("b3070a5d3abfb7c241d2688d066914e7","aa",1);
        call.enqueue(new Callback<ApimoviesResponse>() {
            @Override
            public void onResponse(Call<ApimoviesResponse> call, Response<ApimoviesResponse> response) {
                if (response.isSuccessful())
                {
                    Toast.makeText(MainActivity.this,response.body().total_pages+"",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ApimoviesResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this,t.getMessage()+"errrrrrrrrrrr",Toast.LENGTH_SHORT).show();

            }
        });

    }
}
