package bitsindri.hncc.collegeapp.GetterAndSetter

class OrderItem {

    var order_id:String
    var order_phone:String
    var order_address:String
    var order_status:String

    constructor(id:String, phone:String, address:String, status: String){

        this.order_address = address
        this.order_id = id
        this.order_phone = phone
        this.order_status = status
    }
}