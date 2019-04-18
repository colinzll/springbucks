package com.colin.spring.springbucks.controller.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Colin
 * @version v1.0
 * @package com.colin.spring.springbucks.controller.exception
 * @description 类描述
 * @date 2019年04月17日
 * @copyright 2019 杭州湖畔网络技术有限公司
 **/
@ResponseStatus(HttpStatus.BAD_REQUEST)
@Getter
@AllArgsConstructor
public class FormValidationException extends RuntimeException {
    private BindingResult bindingResult;
}
