package com.wiyar.tao.framework;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by fzl on 16/6/20.
 */
@Controller
public abstract class WebApiBaseController {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> handleSystemException(HttpServletRequest req, Exception e) {
        return new ResponseEntity<>("EXCEPTION", StringUtils.isEmpty(e.getMessage()) ? "异常" : e.getMessage(), new HashMap<>());
    }
}
