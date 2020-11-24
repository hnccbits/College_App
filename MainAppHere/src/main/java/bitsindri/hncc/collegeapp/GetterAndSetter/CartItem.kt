package bitsindri.hncc.collegeapp.GetterAndSetter

class CartItem {

    var quantity:Int
        get() {
           return field
        }
    var menu:String
        get() {
            return field
        }
    var price:Int
        get() {
            return  field
        }
    var status:String
        get() {
            return field
        }

    constructor(quantity:Int,menu:String,price:Int){

        this.menu = menu
        this.price = price
        this.quantity=quantity
        this.status="0"//default is 0,1:sipping,2:shipped

    }
}