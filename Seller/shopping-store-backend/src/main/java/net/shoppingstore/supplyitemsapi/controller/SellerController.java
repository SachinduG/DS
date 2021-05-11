package net.shoppingstore.supplyitemsapi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.shoppingstore.supplyitemsapi.exception.ResourceNotFoundException;
import net.shoppingstore.supplyitemsapi.model.Seller;
import net.shoppingstore.supplyitemsapi.repository.SellerRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class SellerController {

    @Autowired
    private SellerRepository sellerRepository;

    //get all sellers
    //@CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/sellers")
    public List<Seller> getAllSellers(){
        return sellerRepository.findAll();
    }

    // create seller rest api
    @PostMapping("/sellers")
    public Seller createSeller(@RequestBody Seller seller) {
        return sellerRepository.save(seller);
    }

    //get seller by id rest api
    @GetMapping("/sellers/{id}")
    public ResponseEntity<Seller> getSellerById(@PathVariable Long id) {
        Seller seller = sellerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Seller not exist with id:" +id));
        return ResponseEntity.ok(seller);
    }

    //update seller rest api
    @PutMapping("/sellers/{id}")
    public ResponseEntity<Seller> updateSeller(@PathVariable Long id, @RequestBody Seller sellerDetails){
        Seller seller = sellerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Seller not exist with id:" +id));
        seller.setSellerName(sellerDetails.getSellerName());
        seller.setSellerEmail(sellerDetails.getSellerEmail());
        seller.setSellerMobile(sellerDetails.getSellerMobile());

        Seller updatedSeller = sellerRepository.save(seller);
        return ResponseEntity.ok(updatedSeller);
    }

    //delete seller rest api
    @DeleteMapping("sellers/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteSeller(@PathVariable Long id){
        Seller seller = sellerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Seller not exist with id:" +id));

        sellerRepository.delete(seller);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}
