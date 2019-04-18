package com.colin.spring.springbucks.controller;

import com.colin.spring.springbucks.controller.exception.FormValidationException;
import com.colin.spring.springbucks.controller.request.NewCoffeeRequest;
import com.colin.spring.springbucks.model.Coffe;
import com.colin.spring.springbucks.service.CoffeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import javax.validation.ValidationException;
import java.util.List;

/**
 * @author Colin
 * @version v1.0
 * @package com.colin.spring.springbucks.controller
 * @description 类描述
 * @date 2019年04月09日
 * @copyright 2019 杭州湖畔网络技术有限公司
 **/
@Controller
@RequestMapping("/coffee")
@Slf4j
public class CoffeeController {
    @Autowired
    private CoffeeService coffeeService;
    @RequestMapping("/")
    @ResponseBody
    public Coffe getCoffee(){
        return coffeeService.getCoffeeById(1L);
    }

    @GetMapping(path = "/{id}")
    public Coffe getCoffeById(@PathVariable Long id){
        return coffeeService.getCoffeeById(id);
    }

    @ModelAttribute
    public List<Coffe> coffeeList(){
        List<Coffe> list = coffeeService.getAllCoffe();
        return list;
    }

    @GetMapping(path = "/order")
    public ModelAndView showForm(){
        return new ModelAndView("create-order-form");
    }

    @PostMapping(path = "/save",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String save(@Valid NewCoffeeRequest newCoffeeRequest, BindingResult result, ModelMap map){
        if (result.hasErrors()) {
            log.warn("Binding Result: {}", result);
           /* map.addAttribute("message", result.toString());
            return "create-order-form";*/
           throw new ValidationException(result.toString());
        }
        Coffe coffe =new Coffe();
        coffe.setName(newCoffeeRequest.getName());
        coffeeService.saveCoffee(coffe);
        return "redirect:/coffee/order" ;
    }

    @PostMapping(path = "/save/json",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Coffe saveReturnJson(@Valid NewCoffeeRequest newCoffeeRequest, BindingResult result, ModelMap map){
        if (result.hasErrors()) {
            log.warn("Binding Result: {}", result);
            throw new ValidationException(result.toString());
        }
        Coffe coffe =new Coffe();
        coffe.setName(newCoffeeRequest.getName());
        coffeeService.saveCoffee(coffe);
        return coffe;
    }

    @PostMapping(path = "/save/json1",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Coffe saveReturnJson1(@Valid NewCoffeeRequest newCoffeeRequest, BindingResult result, ModelMap map){
        if (result.hasErrors()) {
            log.warn("Binding Result: {}", result);
            throw new FormValidationException(result);
        }
        Coffe coffe =new Coffe();
        coffe.setName(newCoffeeRequest.getName());
        coffeeService.saveCoffee(coffe);
        return coffe;
    }


}
