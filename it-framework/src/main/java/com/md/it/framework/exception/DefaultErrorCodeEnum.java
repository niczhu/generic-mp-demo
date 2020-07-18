package com.md.it.framework.exception;

public enum DefaultErrorCodeEnum implements ErrorCode {

    SUCCESS("0", "成功"),
    NOT_LOGIN("1", "用户未登录"),
    BAD_REQUEST("1001", "非法请求"),
    MISS_PARAMETER("10001", "缺少必须参数"),
    DATA_NOT_FOUND("10002", "操作的数据不存在或已删除"),
    OPERATION_REFUSED("10003", "没有权限进行此操作"),
    DB_ERROR("10004", "数据库操作异常"),
    INVALID_PARAM("10005", "参数错误"),
    INVALID_UPLOAD_FILE("10006", "上传文件损坏"),
    FAIL_STORE_UPLOAD_FILE("10007", "上传文件存储失败"),
    UPLOAD_FILE_NO_EXISTS("10008", "找不到该文件"),
    UPLOAD_FILE_NO_ACCESS("10009", "没有权限访问此文件"),
    NAME_PASSWD_ERROR("10010", "用户名或密码错误"),
    NAME_EXISTS("10011", "用户名已被占用"),
    AUTH_CODE_ERROR("10012", "验证码错误"),
    INVALID_MOBILE_NO("10013", "无效的手机号码"),
    INTEGRATING_PARAM_ERROR("10014", "调用外部服务参数异常"),
    INTEGRATING_SERVICE_FAIL("10015", "外部服务初始化失败"),
    INTEGRATING_SMS_FAIL("10016", "短信发送失败，请稍后重试"),
    INTEGRATING_MAIL_FAIL("10017", "邮件发送失败，请稍后重试"),
    SMS_EXCEED("10018", "短信数量超额，请明天再试"),
    INTEGRATING_INVOKE_FAIL("10019", "外部服务调用失败"),
    DEVICE_CHANGE("10020", "您尝试在新设备登录，请验证手机号"),
    UNKNOWN_DEVICE("10021", "您的设备无法正常使用本站，请更换设备"),
    SMS_CODE_ERROR("10022", "短信验证码错误"),
    AUTH_LOGIN_FAIL("10023", "授权登录失败"),
    UNKNOWN("99999", "未知错误");


    private String code;
    private String msg;

    private DefaultErrorCodeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getMsg() {
        return this.msg;
    }
}
