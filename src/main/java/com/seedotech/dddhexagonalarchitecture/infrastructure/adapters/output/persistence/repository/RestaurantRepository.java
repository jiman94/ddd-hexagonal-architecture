package com.seedotech.dddhexagonalarchitecture.infrastructure.adapters.output.persistence.repository;

import com.seedotech.dddhexagonalarchitecture.infrastructure.adapters.output.persistence.entity.RestaurantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<RestaurantEntity, Long> {

}
