package cn.bugstack.service.impl;

import cn.backstack.common.constants.Constants;
import cn.bugstack.dao.IOrderDao;
import cn.bugstack.domain.po.PayOrder;
import cn.bugstack.domain.req.ShopCartReq;
import cn.bugstack.domain.res.PayOrderRes;
import cn.bugstack.domain.vo.ProductVO;
import cn.bugstack.service.IOrderService;
import cn.bugstack.service.rpc.ProductRPC;
import com.sun.xml.internal.bind.v2.TODO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author Aloong
 * @description
 * @since 2025/10/27 下午5:55
 */
@Service
@Slf4j
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private IOrderDao orderDao;

    @Autowired
    private ProductRPC productRPC;

    @Override
    public PayOrderRes createOrder(ShopCartReq shopCartReq) throws Exception {
        //1.查询当前用户是否存在未支付订单或者掉单
        PayOrder payOrder = new PayOrder();
        payOrder.setUserId(shopCartReq.getUserId());
        payOrder.setProductId(shopCartReq.getProductId());

        PayOrder unpaidOrder = orderDao.queryUnpayOrder(payOrder);
        if (unpaidOrder != null && unpaidOrder.getStatus().equals(Constants.OrderStatusEnum.PAY_WAIT.getCode())) {
            log.info("创建订单已经存在，存在未支付订单。userid:{},productId:{},orderId:{}",unpaidOrder.getUserId(),unpaidOrder.getProductId(),unpaidOrder.getOrderId());
            return PayOrderRes.builder()
                    .orderId(unpaidOrder.getOrderId())
                    .payUrl(unpaidOrder.getPayUrl())
                    .build();
        } else if (null != unpaidOrder && unpaidOrder.getStatus().equals(Constants.OrderStatusEnum.CREATE.getCode())) {
            //TODO
        }

        //2.查询商品、创建订单
        ProductVO productVO = productRPC.queryProductByProductId(shopCartReq.getProductId());
        String orderId = RandomStringUtils.randomNumeric(16);
        orderDao.insert(PayOrder.builder()
                .userId(shopCartReq.getUserId())
                .productId(shopCartReq.getProductId())
                .productName(productVO.getProductName())
                .orderId(orderId)
                .totalAmount(productVO.getPrice())
                .orderTime(new Date())
                .status(Constants.OrderStatusEnum.CREATE.getCode())
                .build());

        //3.创建支付单
        //TODO

        return PayOrderRes.builder()
                .orderId(orderId)
                .payUrl("暂无")
                .build();
    }
}
