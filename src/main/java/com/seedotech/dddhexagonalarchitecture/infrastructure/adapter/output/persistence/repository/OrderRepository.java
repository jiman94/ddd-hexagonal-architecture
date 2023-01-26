package com.seedotech.dddhexagonalarchitecture.infrastructure.adapter.output.persistence.repository;

import com.seedotech.dddhexagonalarchitecture.infrastructure.adapter.output.persistence.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
    /**
     * Returns the found order entry by using its name as search criteria.
     * If no order entry is found, this method returns null
     */
    public Optional<OrderEntity> findByName(String name);

    /**
     * Returns true if found the order with the given name, false otherwise
     */
    boolean existsByName(String name);
}
