package cn.bugstack.service;

import cn.bugstack.domain.req.ShopCartReq;
import cn.bugstack.domain.res.PayOrderRes;

import java.util.List;

/**
 * @author Aloong
 * @description
 * @since 2025/10/27 下午5:53
 */
public interface IOrderService {
    PayOrderRes createOrder(ShopCartReq shopCartReq) throws Exception;

    void changeOrderPaySuccess(String orderId);

    List<String> queryNoPayNotifyOrder();

    List<String> queryTimeoutCloseOrderList();

    boolean changeOrderClose(String orderId);
}
