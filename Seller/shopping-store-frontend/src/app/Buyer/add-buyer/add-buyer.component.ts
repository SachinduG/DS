import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Buyer } from '../../model/buyer';
import { BuyerService } from '../../service/buyer.service';

@Component({
  selector: 'app-add-buyer',
  templateUrl: './add-buyer.component.html',
  styleUrls: ['./add-buyer.component.css']
})
export class AddBuyerComponent implements OnInit {

  buyer: Buyer = new Buyer();
  constructor(private buyerService: BuyerService,
              private router: Router) { }

  ngOnInit(): void {
  }

  saveBuyer(){
    this.buyerService.addBuyer(this.buyer).subscribe( data =>{
        console.log(data);
        this.goToBuyerList();
      },
      error => console.log(error));
  }

  goToBuyerList(){
    this.router.navigate(['/buyers']);
  }

  onSubmit(){
    console.log(this.buyer);
    this.saveBuyer();
  }

}
