package com.md.mp.dal.enums;

import com.md.mp.framwork.base.enums.TableFieldEnum;
import org.apache.commons.lang3.StringUtils;

/**
 * MpAccountStatus
 *
 * @author zhuhaipeng6 in 2020/7/13 23:15
 * @version 1.0
 **/
public enum MpAccountStatusEnum implements TableFieldEnum {

    /**
     * 全部
     */
    ALL("","全部"),

    /**
     * 正常 01
     */
    OK("1","正常"),

    /**
     * 异常 11
     */
    OFF("2","受限");


    /**
     * 枚举码
     */
    private String code;

    /**
     * 描述
     */
    private String desc;


    private MpAccountStatusEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    @Override
    public String getCode() {
        return null;
    }

    @Override
    public String getDesc() {
        return null;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * code转枚举
     *
     * @param code
     * @return
     */
    public static MpAccountStatusEnum getByCode(String code) {
        if (StringUtils.isBlank(code)) {
            return null;
        }
        for (MpAccountStatusEnum item : values()) {
            if (StringUtils.equals(item.getCode(), code)) {
                return item;
            }
        }
        return null;
    }
}
