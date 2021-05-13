package net.shoppingstore.supplyitemsapi.service;

import net.shoppingstore.supplyitemsapi.model.Seller;
import net.shoppingstore.supplyitemsapi.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SellerService {

    private final SellerRepository sellerRepository;

    @Autowired
    public SellerService(SellerRepository sellerRepository){
        this.sellerRepository = sellerRepository;
    }

    public Optional<Seller> findById(Long id){
        return sellerRepository.findById(id);
    }
}
