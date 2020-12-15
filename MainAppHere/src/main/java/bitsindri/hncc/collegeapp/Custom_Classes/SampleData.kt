package bitsindri.hncc.collegeapp.Custom_Classes
//
//import bitsindri.hncc.collegeapp.GetterAndSetter.Food
//import java.util.*
//
//object SampleData {
//
//	val ITEMS = ArrayList<Food>()
//
//    private var COUNT=0
//
////	private var dummy_description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce accumsan quis justo quis hendrerit. Curabitur a ante neque. Fusce nec mauris sodales, auctor sem at, luctus eros. Praesent aliquam nibh neque. Duis ut suscipit justo, id consectetur orci. Curabitur ultricies nunc eu enim dignissim, sed laoreet odio blandit."
//
//
//	fun addFood(item: Food) {
//		item.id = COUNT
//		ITEMS.add(item)
//		COUNT += 1
//	}
//
//	fun getFoodById(id: Int): Food? {
//		for (i in ITEMS.indices) {
//			if (ITEMS[i].id == id) {
//				return ITEMS[i]
//			}
//		}
//
//		return null
//	}
//
//	fun deleteFood(id: Int) {
//		var foodToRemove: Food? = null
//
//		for (i in ITEMS.indices) {
//			if (ITEMS[i].id == id) {
//				foodToRemove = ITEMS[i]
//			}
//		}
//
//		if (foodToRemove != null) {
//			ITEMS.remove(foodToRemove)
//		}
//	}
//
//	fun updateFood(food: Food) {
//		for (i in ITEMS.indices) {
//			if (ITEMS[i].id == food.id) {
//				val foodToUpdate = ITEMS[i]
//
//				foodToUpdate.menu =food.menu
//				foodToUpdate.image_url = food.image_url
//				foodToUpdate.rating = food.rating
//				foodToUpdate.cost_for_one = food.cost_for_one
//				foodToUpdate.description = food.description
//			}
//		}
//	}
//}
