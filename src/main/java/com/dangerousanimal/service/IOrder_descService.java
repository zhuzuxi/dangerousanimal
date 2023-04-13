package com.dangerousanimal.service;

import com.dangerousanimal.Entity.Desc;
import com.dangerousanimal.Entity.Order_desc;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.ArrayList;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zzs
 * @since 2023-04-09
 */
public interface IOrder_descService {

    public String getDesc(String animal_order);

    public ArrayList<String> getOrder();

    public ArrayList<Desc> getAllOrderDesc();



}
