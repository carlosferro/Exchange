package com.ferro.exchange.model.orderbook;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@RequiredArgsConstructor
@Data
@Entity
@Table(name = "orders")
//@Builder

public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private @NonNull Long price;
	private @NonNull Long volume;
	private @NonNull OrderSide side;
//    private User user;
}
