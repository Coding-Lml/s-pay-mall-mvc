package cn.bugstack.domain.res;

import lombok.Data;


/**
 * @author Aloong
 * @since 2025/10/23 上午12:35
 * @description 获取微信登录二维码响应对象
 */
@Data
public class WeixinQrcodeRes {
    private String ticket;
    private Long expire_seconds;
    private String url;
}
