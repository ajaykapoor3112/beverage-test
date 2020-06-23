package com.beverage

object Main extends App {

  def placeOrder(orders: Array[String]): Double = {
    val costs = orders.length match {
      case n if n > 0 => {
        for (order <- orders)
          yield {
            val condiments = order.split(",")
            condiments(0).toLowerCase match {
              case "chai" => {
                new Chai(condiments.tail).totalCost()
              }
              case "coffee" => {
                new Coffee(condiments.tail).totalCost()
              }
              case "banana smoothie" => {
                new BananaSmoothie(condiments.tail).totalCost()
              }
              case "strawberry shake" => {
                new StrawberryShake(condiments.tail).totalCost()
              }
              case "mojito" => {
                new Mojito(condiments.tail).totalCost()
              }
              case _ => {
                throw new Exception("Please select exact name of item from menu list.")
              }
            }
          }
      }
      case n if n == 0 => {
        throw new Exception("Please, add one item from menu list.")
      }
    }
    costs.sum
  }
}
