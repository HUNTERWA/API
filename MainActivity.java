package com.example.rohit.api;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity 
{

    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(ApiBase.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiBase apiBase=retrofit.create(ApiBase.class);

        Call<List<Question>> call=apiBase.getQuestionList();
        call.enqueue(new Callback<List<Question>>()
        {
            @Override
            public void onResponse(Call<List<Question>> call, Response<List<Question>> response)
            {
                List<Question> quelist= response.body();

                for(Question q:quelist)
                {
                    Log.d("Status Code:",q.getStatusCode());
                    Log.d("Message:",q.getMessage());
                }
            }

            @Override
            public void onFailure(Call<List<Question>> call, Throwable t)
            {
                Log.d("error is:",t.getMessage());
            }
        });

    }


}
