package com.dangerousanimal.Controller;


import com.baomidou.mybatisplus.extension.api.R;
import com.dangerousanimal.Entity.Result;
import com.dangerousanimal.service.IOrder_descService;
import com.dangerousanimal.service.impl.Order_descServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zzs
 * @since 2023-04-09
 */
@RestController
@RequestMapping("/order_desc")
@CrossOrigin("*")
public class Order_descController {
    @Autowired
    IOrder_descService orderDescService;

    @GetMapping("/getdesc/{animal_order}")
    public Result getDescByAnimalOrder(@PathVariable("animal_order") String animal_order){
        if(animal_order==null){
            return Result.FAIL("检查输入的值是否符合要求");
        }
        return Result.SUCCESS(orderDescService.getDesc(animal_order));
    }

    @GetMapping("/getalldesc")
    public Result getAllDesc(){
        return Result.SUCCESS(orderDescService.getAllOrderDesc());

    }

    @GetMapping("/getorder")
    public Result getOrder(){
        return Result.SUCCESS(orderDescService.getOrder());
    }

}

