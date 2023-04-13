package com.dangerousanimal.Entity;


import lombok.Data;

@Data
public class Result {
    private Integer status;
    private String message;
    private Object data;


    public static Result SUCCESS(Object data){
        Result result = new Result();
        result.setStatus(200);
        result.setMessage("success");
        result.setData(data);
        return result;
    }


    public static Result FAIL(String message){
        Result result=new Result();
        result.setStatus(400);
        result.setMessage(message);
        result.setData(null);
        return result;
    }


}
