package com.colin.spring.springbucks.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ValidationException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Colin
 * @version v1.0
 * @package com.colin.spring.springbucks.controller
 * @description 全局增强类
 * @date 2019年04月17日
 * @copyright 2019 杭州湖畔网络技术有限公司
 **/
@RestControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(ValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String,String> validationExceptionHandler(ValidationException excetion){
        Map<String,String> map =new HashMap<>();
        map.put("message",excetion.getMessage());
        return  map;
    }
}
