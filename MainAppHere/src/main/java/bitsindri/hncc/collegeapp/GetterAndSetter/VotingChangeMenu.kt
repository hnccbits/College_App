package bitsindri.hncc.collegeapp.GetterAndSetter

class VotingChangeMenu {

    var person:Int
        get() {
         return  field
        }
    var time:String
        get() {
            return field
        }
    var dateAndTime:String
        get() {
            return field
        }
    var old_menu_image:Int
        get() {
            return field
        }
    var new_menu_image:Int
    get() {
        return  field
    }
    var old_menu_name:String
        get() {
            return field
        }
    var new_menu_name:String
        get() {
            return field
        }
    var post_likes:Int
    get(){
        return  field
    }

    constructor(person: Int, time: String, dateAndTime: String, old_menu_image: Int, new_menu_image: Int, old: String, new: String, post_likes: Int){

        this.person = person
        this.time = time
        this.dateAndTime = dateAndTime
        this.old_menu_image = old_menu_image
        this.new_menu_image = new_menu_image
        this.old_menu_name = old
        this.new_menu_name = new
        this.post_likes = post_likes

    }

    fun setPostLikes(postLikes: Int) {
        this.post_likes = postLikes
    }


}