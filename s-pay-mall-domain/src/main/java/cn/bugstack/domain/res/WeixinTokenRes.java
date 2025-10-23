package cn.bugstack.domain.res;

import lombok.Data;

/*
*  获取access_token DTO 对象
* */

@Data
public class WeixinTokenRes {

    private String access_token;
    private int expires_in;
    private String errcode;
    private String errmsg;

}
