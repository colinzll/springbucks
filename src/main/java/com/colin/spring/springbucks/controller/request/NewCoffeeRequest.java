package com.colin.spring.springbucks.controller.request;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;

/**
 * @author Colin
 * @version v1.0
 * @package com.colin.spring.springbucks.controller.request
 * @description 类描述
 * @date 2019年04月16日
 * @copyright 2019 杭州湖畔网络技术有限公司
 **/
@Data
@ToString
public class NewCoffeeRequest {
    @NotEmpty
    public String name;
}
