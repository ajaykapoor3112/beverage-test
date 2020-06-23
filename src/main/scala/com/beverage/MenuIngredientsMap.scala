package com.beverage

object MenuIngredientsMap {

  val mapped: Map[String, (Double, List[String])] =
    Map("coffee" -> (5, List("coffee", "milk", "sugar", "water")),
      "chai" -> (4, List("tea", "milk", "sugar", "water")),
      "banana smoothie" -> (6, List("banana", "milk", "sugar", "water")),
      "strawberry shake" -> (7, List("strawberries,", "sugar", "milk", "water")),
      "mojito" -> (7.5, List("lemon", "sugar", "water", "soda", "mint")))
}