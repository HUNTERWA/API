package com.example.rohit.api;

public class Question
{
    private String StatusCode;
    private String Message;

    public Question(String statusCode, String message)
    {
        StatusCode = statusCode;
        Message = message;
    }

    public String getStatusCode()
    {
        return StatusCode;
    }

    public String getMessage()
    {
        return Message;
    }
}
