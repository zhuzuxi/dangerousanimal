package com.dangerousanimal.Dao;

import com.dangerousanimal.Entity.Order_desc;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zzs
 * @since 2023-04-09
 */
@Mapper
public interface Order_descDao  {

//    为什么不可以 是因为text不能用String直接接吗
//    @Select("select desc from order_desc where animal_order =#{animal_order}")
//    public String getDescByOrder(@Param("animal_order") String animal_order);

    @Select("select * from order_desc where animal_order =#{animal_order}")
    public Order_desc getOrderByName(@Param("animal_order") String animal_order);


    @Select("select animal_order from order_desc")
    public ArrayList<String> getAnimalOrder();

    @Select("select * from order_desc")
    public ArrayList<Order_desc> getOrderDesc();

}
