package com.example.provider.repository;

import com.example.provider.model.Product;

import com.sun.media.sound.SF2Soundbank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

    SF2Soundbank findFirstByProductStartsWith(char b);
}
