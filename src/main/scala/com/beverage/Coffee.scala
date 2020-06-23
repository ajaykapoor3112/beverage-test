package com.beverage

class Coffee(condiments: Array[String]) extends Beverage {
  val (costBeverage, ingredients): (Double, List[String]) = MenuIngredientsMap.mapped.get("coffee")
    .getOrElse(0.0, List.empty[String])

  override val cost: Double = costBeverage

  override def totalCost(): Double = MyUtility.calculateCost(cost, condiments.toList, ingredients.length)
}
