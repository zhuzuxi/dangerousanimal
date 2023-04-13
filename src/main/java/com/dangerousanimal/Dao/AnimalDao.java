package com.dangerousanimal.Dao;

import com.dangerousanimal.Entity.Animal;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zzs
 * @since 2023-04-02
 */
@Mapper
public interface AnimalDao{
    @Select("select * from animal where animal_name=#{animal_name}")
    public Animal getAnimalByName(@Param("animal_name") String animal_name);


    @Select("select * from animal")
    public List<Animal> getAllAnimal();


/*
          1.用于根据省份查动物列表
          2.用于获取一个省的动物的数量

*/
    @Select("select * from animal where domestic_distribution LIKE concat('%',#{domestic_distribution},'%')")
    public List<Animal> getAnimalNameListByProvince(@Param("domestic_distribution") String domestic_distribution );


    @Select("select * from animal where animal_class=#{animal_class}")
    public List<Animal> getAnimalListByClass(@Param("animal_class") String animal_class);


    @Select("select * from animal where animal_phylum=#{animal_phylum}")
    public List<Animal> getAnimalListByPhylum(@Param("animal_phylum")String animal_phylum);

    @Select("select * from animal where animal_order=#{animal_order}")
    public List<Animal> getAnimalListByOrder(@Param("animal_order")String animal_order);


    @Select("select * from animal where animal_phylum like concat('%',#{animal_phylum},'%') and animal_class like concat('%',#{animal_class},'%') and animal_order like concat('%',#{animal_order},'%') and animal_family like concat('%',#{animal_family},'%') ")
    public ArrayList<Animal> getAnimalListByClassAndPhylumAndOrderAndFamily(@Param("animal_phylum")String animal_phylum,@Param("animal_class")String animal_class, @Param("animal_order")String animal_order, @Param("animal_family")String animal_family);

    @Select("select animal_name from animal where animal_phylum like concat('%',#{animal_phylum},'%') and animal_class like concat('%',#{animal_class},'%') and animal_order like concat('%',#{animal_order},'%') and animal_family like concat('%',#{animal_family},'%') ")
    public ArrayList<String> getAnimalNameListByClassAndPhylumAndOrderAndFamily(@Param("animal_phylum")String animal_phylum, @Param("animal_class")String animal_class, @Param("animal_order")String animal_order, @Param("animal_family")String animal_family);

    @Select("select * from animal where animal_phylum like concat('%',#{animal_phylum},'%')")
    public List<Animal> getAnimal_ListByPhylum(@Param("animal_phylum")String animal_phylum);

    @Select("select * from animal where animal_class like concat('%',#{animal_class},'%')")
    public List<Animal> getAnimal_ListByClass(@Param("animal_class")String animal_class);

    @Select("select * from animal where animal_order like concat('%',#{animal_order},'%')")
    public List<Animal> getAnimal_ListByOrder(@Param("animal_order")String animal_order);

    @Select("select * from animal where animal_family like concat('%',#{animal_family},'%')")
    public List<Animal> getAnimal_ListByFamily(@Param("animal_family")String animal_family);


//    用于 各个保护等级 的数量
    @Select("select count(*) from animal where protection_level= #{protection_level}")
    public int getCountBYLevel(String protection_level);

    @Select("select count(*) from animal where domestic_distribution like concat('%',#{province},'%')")
    public int getAnimalCountBYProvince(String province);

    @Select("select count(*) from animal where domestic_distribution like concat('%',#{province},'%') and protection_level= #{protection_level}")
    public int getAnimalCountByProvinceandLevel(String province, String protection_level);


    @Select("select protection_level from animal group by  protection_level")
    public ArrayList<String> getLevels();

    @Select("select animal_phylum from animal group by animal_phylum")
    public ArrayList<String> getAnimalPhylums();

    @Select("select animal_class from animal group by animal_class")
    public ArrayList<String> getAnimalClass();

    @Select("select animal_order from animal group by animal_order")
    public ArrayList<String> getAnimalOrder();

    @Select("select animal_family from animal group by animal_family")
    public ArrayList<String> getAnimalFamily();


    @Select("select distinct animal_class from animal where animal_phylum =#{animal_phylum}")
    public ArrayList<String> getAnimalClassByPhylum(String animal_phylum);
    @Select("select distinct animal_order from animal where animal_class like concat('%',#{animal_class},'%')")
    public ArrayList<String> getAnimalOrderByClass(String animal_class);
    @Select("select distinct animal_family from animal where animal_order =#{animal_order}")
    public ArrayList<String> getAnimalFamilyByOrder(String animal_order);

    @Select("select * from animal where animal_class like concat('%',#{animal_class},'%') ")
    public ArrayList<Animal> getAnimalByClass(String animal_class);


//    左上表
//1.通过纲获取 目
//    public ArrayList<String> getAnimalOrderByClass(String animal_class);
// 2.通过目获取动物
    @Select("select * from animal where animal_order like concat('%',#{animal_order},'%')")
    public ArrayList<Animal> getAnimalByOrder(String animal_order);

























}
