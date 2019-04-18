package com.colin.spring.springbucks;

import com.colin.spring.springbucks.mapper.CoffeMapper;
import com.colin.spring.springbucks.model.Coffe;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@SpringBootApplication
@Slf4j
@MapperScan("com.colin.spring.springbucks.mapper")
@EnableAspectJAutoProxy
public class SpringbucksApplication {

   /* @Autowired
    private CoffeMapper coffeMapper;*/

	public static void main(String[] args) {
		SpringApplication.run(SpringbucksApplication.class, args);
	}


   /* @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {

       // Coffe coffe =Coffe.builder().name("colin").build();
        //coffeMapper.save(coffe);
        Coffe coffe1 = coffeMapper.findById(1L);
        log.info(coffe1.toString());
    }*/
}
