import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Seller } from '../../model/seller';
import { SellerService } from '../../service/seller.service';

@Component({
  selector: 'app-add-seller',
  templateUrl: './add-seller.component.html',
  styleUrls: ['./add-seller.component.css']
})
export class AddSellerComponent implements OnInit {

  seller: Seller = new Seller();
  constructor(private sellerService: SellerService,
              private router: Router) { }

  ngOnInit(): void {
  }

  saveSeller(){
    this.sellerService.addSeller(this.seller).subscribe( data =>{
        console.log(data);
        this.goToSellerList();
      },
      error => console.log(error));
  }

  goToSellerList(){
    this.router.navigate(['/sellers']);
  }

  onSubmit(){
    console.log(this.seller);
    this.saveSeller();
  }

}
