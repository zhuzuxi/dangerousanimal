package com.dangerousanimal.Controller;


import com.baomidou.mybatisplus.extension.api.R;
import com.dangerousanimal.Dao.AnimalDao;
import com.dangerousanimal.Entity.Animal;
import com.dangerousanimal.Entity.Result;
import com.dangerousanimal.service.IAnimalService;
import com.dangerousanimal.service.impl.AnimalServiceImpl;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zzs
 * @since 2023-04-02
 */
@RestController
@CrossOrigin(origins = "*")
public class AnimalController {
    @Autowired
    private AnimalServiceImpl animalService;



    @GetMapping("/animal/{animal_name}")

    public Result getAnimaOne(@PathVariable("animal_name") String animal_name) {
        Animal animal=animalService.getAnimal(animal_name);
        if (animal!=null){
            return Result.SUCCESS(animal);
        }
        else{
            return Result.FAIL("数据库中不存在这个动物,请检查动物名字是否正确");
        }

    }

    @GetMapping("/animal")
    public Result getAnimalAll(){
        return Result.SUCCESS(animalService.getAnimalList());
    }

    @GetMapping("/animal_list/{province}")
    public Result getAnimalNameandImg(@PathVariable("province") String province){
        HashMap name_imgMap=animalService.getAnimalNameandImgListbyProvince(province);
        if (name_imgMap!=null){
            return Result.SUCCESS(name_imgMap);
        }else {
            return Result.FAIL("数据库中不存在该省");
        }

    }


    @GetMapping("animal_phylum")
    public Result getAnimalAllPhylum(){
        HashSet<String> animalPhylum = animalService.getAnimal_phylum();
        return Result.SUCCESS(animalPhylum);
    }

    @GetMapping("/animal_class")
    public Result getAnimalAllClass(){
        HashSet<String> animal_class = animalService.getAnimal_class();
        return Result.SUCCESS(animal_class);
    }



    @GetMapping("/animal_order")
    public Result getAnimalAllOrder(){
        HashSet<String> animalOrder = animalService.getAnimal_order();
        return Result.SUCCESS(animalOrder);
    }

    @GetMapping("/animal_family")
    public Result getAnimalAllFamily(){
        HashSet<String> animalFamily=animalService.getAnimal_family();
        return Result.SUCCESS(animalFamily);
    }

    @GetMapping("/animal/{animal_phylum}/{animal_class}/{animal_order}/{animal_family}")
    public Result getAnimalByType(@PathVariable String animal_class,
                                  @PathVariable String animal_phylum,
                                  @PathVariable String animal_order,
                                  @PathVariable String animal_family) {

        List<Animal> animal = animalService.getAnimalListByClassAndPhylumAndOrderAndFamily(animal_phylum, animal_class, animal_order, animal_family);
        if (animal!=null){
            return Result.SUCCESS(animal);
        }
        else {
            return Result.FAIL("输入的数据有误");
        }

    }



    @GetMapping("/level_animalcount")
    public Result getLevel_AnimalCount(){
        return Result.SUCCESS(animalService.getLevelAnimalCountAll());
    }


//    各省保护动物占比
    @GetMapping("/province_animalcount")
    public Result getProvince_AnimalCount(){
        return Result.SUCCESS(animalService.getProvinceAnimalCountAll());
    }



    @GetMapping("/perprovinceanimalcount")
    public Result getPerProvincePerLevelCount(){
        return Result.SUCCESS(animalService.getPerProvincePerLevelCount());
    }


    @GetMapping("/animaltree")
    public Result getAnimalTree(){
        return Result.SUCCESS(animalService.getAnimalTree());
    }


    @GetMapping("/getOrderProtection/{animal_class}")
    public Result getOrderProtectionLevelByClass(@PathVariable String animal_class){
        if (animal_class==null){
            return Result.FAIL("输入信息有误");
        }
        return Result.SUCCESS(animalService.getOrderLevelCountByClass(animal_class));
    }

    @GetMapping("/getChange/{animal_class}")
    public Result getChangeCountByClass(@PathVariable String animal_class){
        if (animal_class==null){
            return Result.FAIL("输入信息有误");
        }
        else {
            return Result.SUCCESS(animalService.getChangeCountByClass(animal_class));
        }
    }

    @GetMapping("/getOrderLevelCount/{animal_class}")
    public Result getOrderLevelCountByClass(@PathVariable String animal_class){
        return Result.SUCCESS(animalService.getOrderLevelCountByClass(animal_class));
    }










}

