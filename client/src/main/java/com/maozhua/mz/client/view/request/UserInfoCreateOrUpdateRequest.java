package com.maozhua.mz.client.view.request;

import lombok.Data;

@Data
public class UserInfoCreateOrUpdateRequest {
    private String openid;
    private String unionid;
    private String nickname;
    private String avatarUrl;
    private Integer gender;
    private String province;
    private String city;
    private String area;
}
