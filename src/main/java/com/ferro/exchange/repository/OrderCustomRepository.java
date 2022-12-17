package com.ferro.exchange.repository;

import org.springframework.stereotype.Repository;
import com.ferro.exchange.model.orderbook.Order;

@Repository
public interface OrderCustomRepository extends BaseRepository<Order, Long> {

}
