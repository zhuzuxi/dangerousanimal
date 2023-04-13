package com.dangerousanimal.service;

import com.dangerousanimal.Entity.Animal;
import com.dangerousanimal.Entity.AnimalOrderAndLevel;
import com.dangerousanimal.Entity.Change;
import com.dangerousanimal.Entity.animal_phylum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zzs
 * @since 2023-04-02
 */
public interface IAnimalService  {
    public Animal getAnimal(String animal_name);

    public List<Animal> getAnimalList();

    public HashMap<String,String> getAnimalNameandImgListbyProvince(String province);



//    动物 门纲目科
    public HashSet<String> getAnimal_phylum();
    public HashSet<String> getAnimal_class();
    public HashSet<String> getAnimal_order();
    public HashSet<String> getAnimal_family();

    public List<Animal> getAnimalListByClassAndPhylumAndOrderAndFamily(String animal_class, String animal_phylum, String animal_order, String animal_family);




    public HashMap<String,Integer> getLevelAnimalCountAll();

    public HashMap<String,Integer> getProvinceAnimalCountAll();

    public int getLevelCountByProvince(String province);

    public ArrayList<animal_phylum> getAnimalTree();

    public ArrayList<AnimalOrderAndLevel> getOrderLevelCountByClass(String animal_class);

    public ArrayList<Change> getChangeCountByClass(String animal_class);











}
