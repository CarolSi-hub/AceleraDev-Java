package br.com.codenation.service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import br.com.codenation.model.OrderItem;
import br.com.codenation.model.Product;
import br.com.codenation.repository.ProductRepository;
import br.com.codenation.repository.ProductRepositoryImpl;

public class OrderServiceImpl implements OrderService {

	private final ProductRepository productRepository = new ProductRepositoryImpl();

	/**
	 * Calculate the sum of all OrderItems
	 * src=https://www.geeksforgeeks.org/stream-maptodouble-java-examples/
	 */
	@Override
	public Double calculateOrderValue(List<OrderItem> items) {
		double discountValue = 0.8;
		double soma = 0.0;
		for(OrderItem item : items) {
			Optional<Product> product = this.productRepository.findById(item.getProductId());
			double value= item.getQuantity() * product.get().getValue();
			double newValue = product.get().getIsSale() ? (value * discountValue) : value;
			soma = soma + newValue;
		}
		return soma;
	}

	/**
	 * Map from idProduct List to Product Set
	 * src = https://www.geeksforgeeks.org/collectors-toset-in-java-with-examples/
	 */
	@Override
	public Set<Product> findProductsById(List<Long> ids) {
		Stream<Long> existId = ids.stream().filter(id->productRepository.findById(id).isPresent());
		return existId.map(id -> this.productRepository.findById(id).get()).collect(Collectors.toSet());
	}

	/**
	 * Calculate the sum of all Orders(List<OrderIten>)
	 */
	@Override
	public Double calculateMultipleOrders(List<List<OrderItem>> orders) {
		Stream<List<OrderItem>> lists = orders.stream().filter(list -> !list.isEmpty());
		return lists.mapToDouble(this::calculateOrderValue).sum();
	}

	/**
	 * Group products using isSale attribute as the map key
	 */
	@Override
	public Map<Boolean, List<Product>> groupProductsBySale(List<Long> productIds) {
		Stream<Long> existId = productIds.stream().filter(Objects::nonNull);
		List<Product> productList = existId.map(id -> productRepository.findById(id).get()).collect(Collectors.toList());
		return productList.stream().collect(Collectors.groupingBy(Product::getIsSale));
	}

}