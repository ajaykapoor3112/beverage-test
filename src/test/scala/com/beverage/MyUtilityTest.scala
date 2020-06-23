package com.beverage

import org.scalatest.FunSuite


class MyUtilityTest extends FunSuite {
  test("fun calculateCost for 'Chai', with cost = 4, condiments = List(\"-sugar\"), ingredientsCount = 4") {
    val totalCost = MyUtility.calculateCost(4, List("-sugar"), 4)
    assert(totalCost == 3.5)
  }

  test("fun calculateCost for 'Chai', with cost = 4, condiments = List(\"-tea\", \"-milk\", \"-sugar\", \"-water\"), ingredientsCount = 4") {
    val thrown = intercept[Exception] {
      MyUtility.calculateCost(4, List("-tea", "-milk", "-sugar", "-water"), 4)
    }
    assert(thrown.getMessage == "An order cannot have all the ingredients in exclusion for a menu item.")
  }
}