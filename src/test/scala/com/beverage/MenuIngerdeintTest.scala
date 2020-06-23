package com.beverage

import org.scalatest.FunSuite


class MenuIngerdeintTest extends FunSuite {

  test("Placing an order with single item, 'Chai' Array(\"Chai \")") {
    val totalCost = Main.placeOrder(Array("Chai"))
    assert(totalCost == 4)
  }


  test("Placing an order with single item with exclusion Array(\"Chai, -sugar\")") {
    val totalCost = Main.placeOrder(Array("Chai, -sugar"))
    assert(totalCost == 3.5)
  }

  test("Placing an order with items with exclusions as well.") {
    val totalCost = Main.placeOrder(Array("Chai, -sugar", "Chai", "strawberry shake"))
    assert(totalCost == 14.5)
  }


  //  Exception test cases
  test("Placing an order with empty Array()") {
    val thrown = intercept[Exception] {
      Main.placeOrder(Array())
    }
    assert(thrown.getMessage == "Please, add one item from menu list.")
  }

  test("Placing an order with item not present in menu list.") {
    val thrown = intercept[Exception] {
      Main.placeOrder(Array("no item"))
    }
    assert(thrown.getMessage == "Please select exact name of item from menu list.")
  }

  test("Placing an order have all the ingredients in exclusion for a menu item.") {
    val thrown = intercept[Exception] {
      Main.placeOrder(Array("Chai, -tea, -milk, -sugar, -water"))
    }
    assert(thrown.getMessage == "An order cannot have all the ingredients in exclusion for a menu item.")
  }


}