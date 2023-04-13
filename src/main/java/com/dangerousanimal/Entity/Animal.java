package com.dangerousanimal.Entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableName;
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
 * @since 2023-04-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("animal")
public class Animal implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "animal_name", type = IdType.ASSIGN_ID)
    private String animal_name;

    private String animal_scientificname;

    private String morphological_description;

    private String biology;

    private String habitat_information;

    private String domestic_distribution;

    private String economic_significance;

    private String other_information;

    private String protection_level;

    private String remark;

    private String animal_phylum;

    private String animal_class;

    private String animal_order;

    private String animal_family;

    private String img;

    private String change;

    private String class_desc;


}
