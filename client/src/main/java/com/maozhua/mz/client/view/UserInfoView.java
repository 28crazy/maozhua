package com.maozhua.mz.client.view;

import lombok.Data;

@Data
public class UserInfoView {
    private Long id;
    private String openid;
    private String unionid;
    private String nickname;
    private String avatarUrl;
    private Integer gender;
    private String province;
    private String city;
    private String area;
    private Long createTime;
    private Long updateTime;
    private String modifyAt;
    private Integer status;
}
