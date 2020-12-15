package bitsindri.hncc.collegeapp.GetterAndSetter

import kotlin.properties.Delegates

class FoodSecond {

    var id:Int

    var menu:String

    var rating:String

    var cost_for_one:String

    var description:String

    var image_url:String


    constructor(menu:String,rating:String,cost_for_one:String,image_url:String,desc:String,id:Int){
        this.id = id
        this.menu=menu
        this.cost_for_one = cost_for_one
        this.rating = rating
        this.image_url = image_url
        this.description = desc
    }
}