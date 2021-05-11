import { Component, OnInit } from '@angular/core';
import {Seller} from '../../model/seller';
import {SellerService} from '../../service/seller.service';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-update-seller',
  templateUrl: './update-seller.component.html',
  styleUrls: ['./update-seller.component.css']
})
export class UpdateSellerComponent implements OnInit {

  id!: number;
  seller: Seller = new Seller();
  constructor(private sellerService: SellerService,
              private route: ActivatedRoute,
              private router: Router) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.sellerService.getSellerById(this.id).subscribe(data => {
        this.seller = data;
      },
      error => console.log(error));
  }
  onSubmit(){
    this.sellerService.updateSeller(this.id, this.seller).subscribe(data =>{
        this.goToSellerList();
      },
      error => console.log(error));

  }

  goToSellerList(){
    this.router.navigate(['/sellers']);
  }


}

