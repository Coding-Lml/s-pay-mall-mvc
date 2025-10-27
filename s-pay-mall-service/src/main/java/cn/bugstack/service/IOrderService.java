package cn.bugstack.service;

import cn.bugstack.domain.req.ShopCartReq;
import cn.bugstack.domain.res.PayOrderRes;

/**
 * @author Aloong
 * @description
 * @since 2025/10/27 下午5:53
 */
public interface IOrderService {
    PayOrderRes createOrder(ShopCartReq shopCartReq) throws Exception;
}
