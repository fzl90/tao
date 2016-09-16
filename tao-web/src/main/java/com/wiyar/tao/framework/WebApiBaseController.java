package com.wiyar.tao.framework;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by fzl on 16/6/20.
 */
public abstract class WebApiBaseController {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> handleSystemException(HttpServletRequest req, Exception e) {
        return new ResponseEntity<Map<String, Object>>("EXCEPTION", "异常", new HashMap<String, Object>());
    }
}
