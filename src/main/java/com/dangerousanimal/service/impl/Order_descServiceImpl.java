package com.dangerousanimal.service.impl;

import com.dangerousanimal.Entity.Desc;
import com.dangerousanimal.Entity.Order_desc;
import com.dangerousanimal.Dao.Order_descDao;
import com.dangerousanimal.service.IOrder_descService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zzs
 * @since 2023-04-09
 */
@Service
public class Order_descServiceImpl implements IOrder_descService {
    @Autowired
    Order_descDao orderDescDao;

    @Override
    public String getDesc(String animal_order) {
        return orderDescDao.getOrderByName(animal_order).getDesc();
    }

    @Override
    public ArrayList<String> getOrder() {
        return orderDescDao.getAnimalOrder();
    }

    @Override
    public ArrayList<Desc> getAllOrderDesc() {
        ArrayList<Order_desc> orderDesc = orderDescDao.getOrderDesc();
        ArrayList<Desc> descs=new ArrayList<>();
        for (Order_desc order_desc : orderDesc) {
            descs.add(new Desc(order_desc.getAnimal_order(),order_desc.getDesc()));
        }
        return descs;

    }

}
