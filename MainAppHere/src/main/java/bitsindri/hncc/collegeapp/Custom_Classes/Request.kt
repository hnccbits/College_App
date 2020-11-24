package bitsindri.hncc.collegeapp.Custom_Classes

import bitsindri.hncc.collegeapp.GetterAndSetter.OrderItem

class Request {

    val phone:String
        get() {
           return field
        }
    val name:String
        get() {
            return field
        }
    val address:String
        get() {
            return field
        }
    val total:String
    val list:List<OrderItem>
        get() {
         return field
        }

    constructor(phone:String,name:String,address:String,total:String,list:List<OrderItem>){
        this.address = address
        this.list = list
        this.name = name
        this.phone = phone
        this.total = total
    }
}