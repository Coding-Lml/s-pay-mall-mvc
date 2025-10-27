package cn.bugstack.dao;

import cn.bugstack.domain.po.PayOrder;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Aloong
 * @since 2025/10/27 下午5:09
 */

@Mapper
public interface IOrderDao {
    void insert(PayOrder payOrder);

    PayOrder queryUnpayOrder(PayOrder payOrder);
}
