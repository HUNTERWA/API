package com.example.rohit.api;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity 
{
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=findViewById(R.id.textView1);

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(ApiBase.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiBase apiBase=retrofit.create(ApiBase.class);

        Call<Question> call=apiBase.getQuestionList();
        call.enqueue(new Callback<Question>()
        {
            @Override
            public void onResponse(Call<Question> call, Response<Question> response)
            {
                List<Question> quelist= Collections.singletonList(response.body());

                for(Question q:quelist)
                {
                    Log.d("Status Code:",q.getStatusCode());
                    Log.d("Message:",q.getMessage());
                }
            }

            @Override
            public void onFailure(Call<Question> call, Throwable t)
            {
                Log.d("error is:",t.getMessage());
            }
        });

    }


}
