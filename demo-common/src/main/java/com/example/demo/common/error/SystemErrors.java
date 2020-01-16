package com.example.demo.common.error;

/**
 * @author linjian
 * @date 2018/9/26
 */
public enum SystemErrors implements ServiceErrors {
    /**
     * 公用错误码
     */
    SYSTEM_ERROR(10001, "系统错误"),
    PERMISSION_ERROR(10002, "无权限访问"),
    PARAM_ERROR(10003, "参数错误"),
    QI_NIU_BUCKET_ILLEGAL(10004, "七牛云bucket非法"),
    OPERATOR_LOGIN_PASSWORD_ERROR(10005, "登录密码错误"),
    OPERATOR_LOGIN_EXPIRE(10006, "登录失效"),
    OPERATOR_IS_DISABLED(10007, "已被禁用，无法登录"),
    OPERATOR_LOGOUT_FAIL(10008, "退出登录失败"),
    QI_NIU_RESOURCE_FETCH_FAIL(10009, "上传失败，请重试！"),

    INSERT_FAIL(11001, "新增失败"),
    UPDATE_FAIL(11002, "修改失败"),
    DELETE_FAIL(11003, "删除失败"),
    SAVE_FAIL(11004, "保存失败"),

    DUPLICATED_DATA(12000, "重复数据");

    private Integer code;
    private String message;

    private SystemErrors(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static String getErrorMsg(Integer code) {
        for (SystemErrors error : values()) {
            if (code.equals(error.code)) {
                return error.message;
            }
        }
        return "";
    }
}
