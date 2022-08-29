package bibliotheque.controllers;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class BaseController<T> {
    private Hashtable response = new Hashtable();
    
    public Hashtable send(String status, String message, T data){
        response.put("status", status);
        response.put("message", message);
        response.put("data", data);
        return response; 
    }
    
    public Hashtable send(String status, String message, List<T> data){
        response.put("status", status); 
        response.put("message", message); 
        response.put("data", data);
        return response;
    }
    public Hashtable send(String status, String message, long data){
        response.put("status", status);
        response.put("message", message);
        response.put("data", data);
        return response;
    }
    public Hashtable send(String status, String message, String data){
        response.put("status", status);
        response.put("message", message);
        response.put("data", data);
        return response;
    }
    public Hashtable send(String status, String message){
        response.put("status", status);
        response.put("message", message);
        response.put("data", "null");
        return response;
    }
}
