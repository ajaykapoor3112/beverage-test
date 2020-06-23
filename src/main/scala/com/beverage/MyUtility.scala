package com.beverage

object MyUtility {

  def calculateCost(cost: Double, condiments: List[String], ingredientsCount: Int): Double = {
    condiments.length match {
      case n if n >= ingredientsCount => {
        throw new Exception("An order cannot have all the ingredients in exclusion for a menu item.")
      }
      case n if n > 0 => {
        cost - totalExclusion(condiments.toList)
      }
      case n if n == 0 => {
        cost
      }
      case _ => 0
    }
  }

  private def totalExclusion(exclusions: List[String]) = {
    addTotal(exclusionDoubleList(exclusions))
  }

  private def exclusionDoubleList(exclusions: List[String]): List[Double  ] = {
    for (x <- exclusions)
      yield {
        IngredientsCostMap.mapped
          .get(x.trim.substring(1).toLowerCase)
          .getOrElse(0.0)
      }
  }

  private def addTotal(rates: List[Double]): Double = rates match {
    case h :: tail => h + addTotal(tail)
    case Nil => 0.0
  }
}
