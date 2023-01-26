package com.seedotech.dddhexagonalarchitecture.infrastructure.adapter.output.persistence.repository;

import com.seedotech.dddhexagonalarchitecture.infrastructure.adapter.output.persistence.entity.RestaurantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<RestaurantEntity, Long> {

}
