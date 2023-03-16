package com.qrmaster.api.board.common;

import net.minidev.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class JsonResult {

    public JSONObject getData(ErrorCode code){
        JSONObject result = new JSONObject();
        result.put("status", code.getKey());
        result.put("message", code.getValue());
        return result;
    }

    public JSONObject getData(ErrorCode code, String message){
        JSONObject result = new JSONObject();
        result.put("status", code.getKey());
        result.put("message", message);
        return result;
    }

}
