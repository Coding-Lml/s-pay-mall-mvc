package cn.bugstack.domain.res;

import cn.backstack.common.constants.Constants;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Aloong
 * @description 订单类
 * @since 2025/10/27 下午5:24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
//谁下单的，订单号是什么，付款url，订单状态
public class PayOrderRes {
    private String userId;
    private String orderId;
    private String payUrl;
    private Constants.OrderStatusEnum orderStatusEnum;
    //订单状态的枚举
}
