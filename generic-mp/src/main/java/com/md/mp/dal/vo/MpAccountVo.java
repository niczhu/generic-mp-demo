package com.md.mp.dal.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.md.mp.framwork.base.model.AbstractVo;
import com.md.mp.framwork.base.model.BaseVo;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * MpAccountBean
 *
 * @author zhuhaipeng6 in 2020/5/9 18:18
 * @version 1.0
 **/
@Setter
@Getter
@ToString
public class MpAccountVo extends AbstractVo implements BaseVo {

    private static final long serialVersionUID = -1L;

    private Integer id;

    private String pin;

    private String name;

    private String mobile;

    private String organizationCode;

    private int age;

    private Date birthDay;

    private String status;

    private Integer version;

    private Integer deleteFlag;

    private String modifiedBy;

    private Date modifiedTime;

    private String createdBy;

    private Date createdTime;

}
