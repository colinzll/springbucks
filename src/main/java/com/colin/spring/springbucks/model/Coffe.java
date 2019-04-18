package com.colin.spring.springbucks.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author Colin
 * @version v1.0
 * @package com.colin.spring.mybatisDemo.model
 * @description 咖啡类
 * @date 2019年03月06日
 * @copyright 2019 杭州湖畔网络技术有限公司
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Coffe {
    private Long id;
    private String name;
    private Date createTime;
    private Date updateTime;
}
