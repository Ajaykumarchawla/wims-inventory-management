package com.ajayk.wims.item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


public interface ItemRepository extends JpaRepository<Item, Long> {
}
