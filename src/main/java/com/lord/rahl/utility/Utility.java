package com.lord.rahl.utility;

import java.util.HashMap;

/**
 * Created by lordrahl on 12/10/2017.
 */
public class Utility {

    public Utility(){};

    public static HashMap<String, String> response(String status, String desc, String message){
        HashMap<String, String> map=new HashMap<>();
        map.put("status",status);
        map.put("description",desc);
        map.put("message",message);
        return map;
    }
}
