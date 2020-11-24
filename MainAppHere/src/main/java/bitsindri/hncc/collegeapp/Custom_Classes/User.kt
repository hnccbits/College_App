package bitsindri.hncc.collegeapp.Custom_Classes

class User {

    var name:String
        get() {
           return field
        }
    var password:String
    get(){
        return field
    }
    var phone:String get(){
        return field
    }

    constructor(name:String,pass:String,phone:String){

        this.name=name
        this.password = pass
        this.phone=phone


    }

}