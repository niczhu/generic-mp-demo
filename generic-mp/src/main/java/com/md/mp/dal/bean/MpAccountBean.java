package com.md.mp.dal.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.md.mp.framwork.base.model.AbstractBean;
import com.md.mp.framwork.base.model.BaseBean;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * MpAccountBean
 *
 * @author zhuhaipeng6 in 2020/5/9 18:18
 * @version 1.0
 **/
@Setter
@Getter
@TableName("mp_account")
public class MpAccountBean extends AbstractBean implements BaseBean {

    private static final long serialVersionUID = -1L;

    /**
     * 逻辑主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String pin;

    private String name;

    private String mobile;

    private String organizationCode;

    private int age;

    private Date birthDay;

    private String status;


}
