package cn.bugstack.domain.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Aloong
 * @description 哪个用户下单了哪个产品
 * @since 2025/10/27 下午5:26
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShopCartReq {
    private String userId;

    private String productId;
}
