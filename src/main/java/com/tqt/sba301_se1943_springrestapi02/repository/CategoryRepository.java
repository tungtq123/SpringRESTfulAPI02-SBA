package com.tqt.sba301_se1943_springrestapi02.repository;


import com.tqt.sba301_se1943_springrestapi02.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
