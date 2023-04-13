package com.dangerousanimal;

import com.dangerousanimal.Dao.AnimalDao;
import com.dangerousanimal.Dao.Order_descDao;
import com.dangerousanimal.Entity.*;
import com.dangerousanimal.service.IAnimalService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;

@SpringBootTest
class DangerousanimalApplicationTests {
    @Autowired
    private AnimalDao animalDao;

    @Autowired
    private Order_descDao orderDescDao;

    @Autowired
    private IAnimalService animalService;


    @Test
    void contextLoads() {
    }

    @Test
    void testGetUserById() {
        ArrayList<Animal> animals= animalDao.getAnimalByClass("鸟纲 AVES");
        HashMap<String,Integer> changeMap=new HashMap<String,Integer>();
        for (Animal animal : animals) {
            if (!changeMap.containsKey(animal.getChange())){
                changeMap.put(animal.getChange(),0);
            }else {
                int count=changeMap.get(animal.getChange());
                count++;
                changeMap.put(animal.getChange(),count);
            }
        }
        System.out.println(changeMap);

    }

    @Test
    void TestgetLevels() {

        for (String level : animalDao.getLevels()) {
            System.out.println(level);
        }
//        System.out.println(animalService.levels);
    }

}
