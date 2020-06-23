package com.beverage

class BananaSmoothie(condiments: Array[String]) extends Beverage {
  val (costBeverage, ingredients): (Double, List[String]) = MenuIngredientsMap.mapped.get("banana smoothie")
    .getOrElse(0.0, List.empty[String])

  override val cost: Double = costBeverage

  override def totalCost(): Double = MyUtility.calculateCost(cost, condiments.toList, ingredients.length)
}
