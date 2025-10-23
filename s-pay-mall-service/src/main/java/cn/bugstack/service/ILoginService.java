package cn.bugstack.service;

import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author Aloong
 * @since 2025/10/23 上午12:42
 */

public interface ILoginService {
    String createQrCodeTicket() throws Exception;

    String checkLogin(String ticket);

    void saveLoginState(String ticket, String openid) throws IOException;
}
