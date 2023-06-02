import { Component } from '@angular/core';
import {WebsocketServiceService} from '../app/websocket-service.service';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'Stock Price';
  stockData:any=[];
  constructor(private ws :WebsocketServiceService) { 
    ws.messages.subscribe(msg => {   
      let a= msg.data.split(";");     
      this.stockData=[];
      a.forEach((e: string) =>{
        let b=e.split(":"); 
       if(b.length>1){
        this.stockData.push({"name":b[0],"price":b[1]});
       }
      });
      //console.log(this.stockData);
      //this.title=""+msg.data;
      
    }, err => console.log('HTTP Error', err));
   
  }
  ngOndestroy(){
    
  }
}
