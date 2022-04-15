package com.example.covidtest.pojo;

import lombok.Data;

/**
 * @description:
 * @author: yyc
 * @time: 2022/4/14 16:42
 */
@Data
public class Response {
    private int code;
    private String message;
    private Object data;

    public Response(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Response() {
    }

    public Response(int code, String message) {
        this.code = code;
        this.message = message;
    }
    
    public static Response success(){
        return new Response(1,"success");
    }
    
    public static Response success(String message){
        return new Response(1,message);
    }
    public static Response success(Object data){
        Response success = success();
        success.data = data;
        return success;
    }
    
    public static Response error(String message){
        return new Response(0,message);
    }
}
