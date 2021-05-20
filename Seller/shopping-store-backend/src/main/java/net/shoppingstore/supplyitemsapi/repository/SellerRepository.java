package net.shoppingstore.supplyitemsapi.repository;

import net.shoppingstore.supplyitemsapi.model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Long> {
}