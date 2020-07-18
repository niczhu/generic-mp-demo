package com.md.mp.framwork.base.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * AbstractBean
 *
 * @author zhuhaipeng6 in 2020/7/14 14:17
 * @version 1.0
 **/
@Getter
@Setter
public abstract class AbstractBean {

    /**
     * 更新人
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String modifiedBy;

    /**
     * 更新时间
     */
    //@TableField(fill = FieldFill.INSERT_UPDATE)
    private Date modifiedTime;

    /**
     * 创建人
     */
    @TableField(fill = FieldFill.INSERT)
    private String createdBy;

    /**
     * 创建时间
     */
//    @TableField(fill = FieldFill.INSERT)
    private Date createdTime;

    /**
     * 版本号
     */
    @Version
    private Integer version;

    /**
     * 逻辑删除标记
     */
    @TableLogic
    private Integer deleteFlag;


}
