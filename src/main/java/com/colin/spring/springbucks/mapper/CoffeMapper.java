package com.colin.spring.springbucks.mapper;

import com.colin.spring.springbucks.model.Coffe;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author Colin
 * @version v1.0
 * @package com.colin.spring.mybatisDemo.mapper
 * @description 咖啡mapper
 * @date 2019年03月06日
 * @copyright 2019 杭州湖畔网络技术有限公司
 **/
@Mapper
public interface CoffeMapper {
    @Insert("insert into t_coffe (name,create_time,update_time) values(#{name},now(),now())")
    @Options(useGeneratedKeys = true)
    Long save(Coffe coffe);


    /**
     * id 查找
     * @param id
     * @return
     */
    @Select("select * from t_coffe where id=#{id}")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "name",property = "name")
    })
    Coffe findById(@Param("id") Long id);


    @Select("select * from t_coffe ")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "name",property = "name")
    })
    List<Coffe> findAll();

}
