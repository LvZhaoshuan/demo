package com.example.demo.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author linjian
 * @date 2019/3/13
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDO {

    /**
     * 自增ID
     */
    private Integer id;

    /**
     * 是否删除（0:未删除 1:已删除）
     */
    private Integer isDeleted;

    /**
     * 记录创建时间
     */
    private java.time.LocalDateTime createTime;

    /**
     * 记录修改时间
     */
    private java.time.LocalDateTime modifyTime;

    /**
     * 创建人,0表示无创建人值
     */
    private Integer creator;

    /**
     * 修改人,如果为0则表示纪录未修改
     */
    private Integer modifier;

    /**
     * 用户昵称
     */
    private String userNick;

    /**
     * 用户头像
     */
    private String userAvatar;

    /**
     * 手机号
     */
    private String userPhone;

    /**
     * 用户性别（1:男 2:女）
     */
    private Integer userSex;

    /**
     * 用户类型（1:普通用户 2:测试用户）
     */
    private Integer userType;

}
