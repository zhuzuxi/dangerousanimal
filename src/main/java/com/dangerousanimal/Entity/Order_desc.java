package com.dangerousanimal.Entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author zzs
 * @since 2023-04-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Order_desc implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "animal_order", type = IdType.ASSIGN_ID)
    private String animal_order;

    private String desc;


}
