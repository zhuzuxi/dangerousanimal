package com.dangerousanimal.service.impl;

import com.dangerousanimal.Dao.AnimalDao;
import com.dangerousanimal.Entity.*;
import com.dangerousanimal.service.IAnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zzs
 * @since 2023-04-02
 */
@Service
public class AnimalServiceImpl implements IAnimalService {
    @Autowired
    private AnimalDao animalDao;

    private static String[] provincelist=new String[]{"河北","山西","黑龙江","吉林","辽宁","江苏","浙江","安徽","福建","江西","山东","河南","湖北","湖南",
            "广东","海南","四川","贵州","云南","陕西","甘肃","青海","台湾",
            "内蒙古","广西","西藏","宁夏","新疆","北京","天津","上海","重庆","香港","澳门"};

    private static String[] levels=new String[]{"一级","二级"};



//    static {
//         String[] provincelist=new String[]{"河北","山西","黑龙江","吉林","辽宁","江苏","浙江","安徽","福建","江西","山东","河南","湖北","湖南",
//                "广东","海南","四川","贵州","云南","陕西","甘肃","青海","台湾",
//                "内蒙古","广西","西藏","宁夏","新疆","北京","天津","上海","重庆","香港","澳门"};
//    }

//    @Autowired
//    private static void initBaseData(AnimalDao animalDao){
//        provincelist=new String[]{"河北","山西","黑龙江","吉林","辽宁","江苏","浙江","安徽","福建","江西","山东","河南","湖北","湖南",
//                "广东","海南","四川","贵州","云南","陕西","甘肃","青海","台湾",
//                "内蒙古","广西","西藏","宁夏","新疆","北京","天津","上海","重庆","香港","澳门"};
//
//        levels=animalDao.getLevels();
//
//    }

    @Override
    public Animal getAnimal(String animal_name) {
        return animalDao.getAnimalByName(animal_name);
    }

    @Override
    public List<Animal> getAnimalList() {
        return animalDao.getAllAnimal();
    }

    @Override
    public HashMap<String,String> getAnimalNameandImgListbyProvince(String province) {
        List<Animal> name_imgList = animalDao.getAnimalNameListByProvince(province);
        HashMap<String,String> name_imgMap=new HashMap<>();
        for (Animal animal : name_imgList) {
            name_imgMap.put(animal.getAnimal_name(),animal.getImg());
        }
        return name_imgMap;

    }

    @Override
    public HashSet<String> getAnimal_phylum() {
        HashSet<String> phylum_set=new HashSet<>();
        for (Animal animal : animalDao.getAllAnimal()) {
            phylum_set.add(animal.getAnimal_phylum());
        }
        return phylum_set;

    }

    @Override
    public HashSet<String> getAnimal_class() {
        HashSet<String> class_set=new HashSet<>();
        for (Animal animal : animalDao.getAllAnimal()) {
            class_set.add(animal.getAnimal_class());
        }
        return class_set;
    }

    @Override
    public HashSet<String> getAnimal_order() {
        HashSet<String> order_set=new HashSet<>();
        for (Animal animal : animalDao.getAllAnimal()) {
            order_set.add(animal.getAnimal_order());
        }
        return order_set;
    }

    @Override
    public HashSet<String> getAnimal_family() {
        HashSet<String> family_set=new HashSet<>();
        for (Animal animal : animalDao.getAllAnimal()) {
            family_set.add(animal.getAnimal_family());
        }
        return family_set;
    }


    @Override
    public List<Animal> getAnimalListByClassAndPhylumAndOrderAndFamily(String animal_class, String animal_phylum, String animal_order, String animal_family) {

        return animalDao.getAnimalListByClassAndPhylumAndOrderAndFamily(animal_phylum,animal_class,animal_order,animal_family);
    }




    @Override
    public HashMap<String, Integer> getLevelAnimalCountAll() {
        HashMap<String,Integer> LevelCount=new HashMap<>();

        for (String level : levels) {
            LevelCount.put(level,animalDao.getCountBYLevel(level));
        }
        return LevelCount;

    }

    @Override
    public HashMap<String, Integer> getProvinceAnimalCountAll() {
        HashMap<String,Integer> ProvinceCount=new HashMap<>();
        for (String province : provincelist) {
            ProvinceCount.put(province, animalDao.getAnimalCountBYProvince(province));
        }

        return ProvinceCount;
    }


    @Override
    public int getLevelCountByProvince(String province) {
        return 0;
    }

    @Override
    public ArrayList<animal_phylum> getAnimalTree() {
        ArrayList<animal_phylum> phylums=new ArrayList<>();
        for (String phylum : animalDao.getAnimalPhylums()) {
            if (phylum!=null)
            phylums.add(new animal_phylum(phylum));
        }





        for (animal_phylum phylum : phylums) {
            ArrayList<animal_class> classes=new ArrayList<>();
            for (String s : animalDao.getAnimalClassByPhylum(phylum.getName())) {
                classes.add(new animal_class(s));
            }
            phylum.setChildren(classes);
        }

//        System.out.println(phylums);

//        设置classes中的 orders

        for (animal_phylum phylum : phylums) {
            for (animal_class aClass : phylum.getChildren()) {
                ArrayList<animal_order> orders=new ArrayList<>();
                for (String order : animalDao.getAnimalOrderByClass(aClass.getName())) {
                    orders.add(new animal_order(order));
                }
                aClass.setChildren(orders);
            }
        }
//        System.out.println(phylums);


//        设置orders 下的 families
        for (animal_phylum phylum : phylums) {
            for (animal_class aClass : phylum.getChildren()) {
                for (animal_order order : aClass.getChildren()) {
                    ArrayList<animal_family> families=new ArrayList<>();
                    for (String family : animalDao.getAnimalFamilyByOrder(order.getName())) {
                        families.add(new animal_family(family));
                    }
                    order.setChildren(families);
                }
            }
        }
//        System.out.println(phylums);



//        设置 family 下 的animal
        for (animal_phylum phylum : phylums) {
            for (animal_class aClass : phylum.getChildren()) {
                for (animal_order order : aClass.getChildren()) {
                    for (animal_family family : order.getChildren()) {
//                        ArrayList<Animal> animals =new ArrayList<>();
//                        animals = animalDao.getAnimalListByClassAndPhylumAndOrderAndFamily(phylum.getName(), aClass.getName(), order.getName(), family.getName());
                        ArrayList<String> animals =new ArrayList<>();
                        ArrayList<AnimalOnlyName> animalsOnly =new ArrayList<>();
                        animals= animalDao.getAnimalNameListByClassAndPhylumAndOrderAndFamily(phylum.getName(),aClass.getName(), order.getName(), family.getName());
                        for (String animal : animals) {
                            animalsOnly.add(new AnimalOnlyName(animal));
                        }
                        family.setChildren(animalsOnly);
                    }
                }
            }
        }
        System.out.println(phylums);

        return phylums;
    }

    @Override
    public ArrayList<AnimalOrderAndLevel> getOrderLevelCountByClass(String animal_class) {
        ArrayList<String> orders = animalDao.getAnimalOrderByClass(animal_class);
        ArrayList<AnimalOrderAndLevel> animalOrderAndLevels=new ArrayList<>();
        for (String order : orders) {
            HashMap<String,Integer> LevelCount=new HashMap<>();
            ArrayList<Animal> animals = animalDao.getAnimalByOrder(order);
            for (Animal animal : animals) {
                if (!LevelCount.containsKey(animal.getProtection_level())){
                    LevelCount.put(animal.getProtection_level(),1);
                }else{
                    int count=LevelCount.get(animal.getProtection_level());
                    count++;
                    LevelCount.put(animal.getProtection_level(),count);
                }
            }
            animalOrderAndLevels.add(new AnimalOrderAndLevel(order,LevelCount.get("一级"),LevelCount.get("二级")));
        }
        return animalOrderAndLevels;

    }

    @Override
    public ArrayList<Change> getChangeCountByClass(String animal_class) {
        ArrayList<Animal> animals= animalDao.getAnimalByClass(animal_class);
        HashMap<String,Integer> changeMap=new HashMap<String,Integer>();
        for (Animal animal : animals) {
            if (!changeMap.containsKey(animal.getChange())){
                changeMap.put(animal.getChange(),1);
            }else {
                int count=changeMap.get(animal.getChange());
                count++;
                changeMap.put(animal.getChange(),count);
            }
        }

        ArrayList<Change> changes=new ArrayList<>();
        Set<String> keys = changeMap.keySet();
        for (String key : keys) {
            changes.add(new Change(key,changeMap.get(key)));
        }
        return changes;
    }


    /*
      先获取所有省份 和 所有保护动物等级
      再遍历所有省份 具体 根据省份查询该省中 各保护等级数量
  */
    public HashMap<String,HashMap<String,Integer>> getPerProvincePerLevelCount(){
        HashMap<String,HashMap<String,Integer>> Province_Level_AnimalCount=new HashMap<>();

        for (String province : provincelist) {
            HashMap<String,Integer> Level_AnimalCount=new HashMap<>();
            for (String level : levels) {
                Level_AnimalCount.put(level,animalDao.getAnimalCountByProvinceandLevel(province,level));
            }
            Level_AnimalCount.put("总数",Level_AnimalCount.get("一级")+Level_AnimalCount.get("二级"));
            Province_Level_AnimalCount.put(province,Level_AnimalCount);

        }

        return Province_Level_AnimalCount;
    }


}

