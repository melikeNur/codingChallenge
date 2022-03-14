package com.ayrotek.codingchallenge.auth;

import java.util.Base64;
import java.util.Base64.Decoder;
import org.json.JSONObject;

public class TokenCheck {
    public static String checkToken(String jwtToken){
      try{  
        Decoder decoder = Base64.getDecoder();
        String[] chunks = jwtToken.split("\\.");
        String token = new String(decoder.decode(chunks[1]));
        if(token != null) {
            JSONObject obj = new JSONObject(token);
            if(obj.has("sub")){ 
             String email = obj.getString("sub");
             System.out.println("emailoş "+email);
             return email;
            }  
        }
        return null;
      }catch (Exception e) {
        e.printStackTrace();
    }
    return null;    
    }    
    
}
