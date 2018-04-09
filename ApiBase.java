package com.example.rohit.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiBase
{
    String ROOT_URL="http://192.168.0.110:9000";


    //@GET("question/2/FindAll")
    @GET("/question/2/FindAll")
    Call<Question>getQuestionList();


    /*@GET("{_id}")  //this is used for dynamic accessing of data
    Call<Doc>getQuestionById(@Path("_id") String id);*/

}
