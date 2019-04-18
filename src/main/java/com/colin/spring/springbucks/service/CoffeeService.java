package com.colin.spring.springbucks.service;

import com.colin.spring.springbucks.mapper.CoffeMapper;
import com.colin.spring.springbucks.model.Coffe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Colin
 * @version v1.0
 * @package com.colin.spring.springbucks.service
 * @description 类描述
 * @date 2019年04月09日
 * @copyright 2019 杭州湖畔网络技术有限公司
 **/
@Service
public class CoffeeService {

    @Autowired
    private CoffeMapper coffeMapper;

    /**
     * 按照ID查找
     * @param id
     * @return
     */
    public Coffe getCoffeeById(Long id){
        return coffeMapper.findById(id);
    }

    /**
     * 查找所有coffe
     * @return
     */
    public List<Coffe> getAllCoffe(){
        return coffeMapper.findAll();
    }

    /**
     * 保存
     * @param coffe
     */
    public void saveCoffee(Coffe coffe){
        coffeMapper.save(coffe);
    }

}
