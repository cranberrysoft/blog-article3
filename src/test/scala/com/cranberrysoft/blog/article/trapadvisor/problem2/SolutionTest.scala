package com.cranberrysoft.blog.article.trapadvisor.problem2

import org.scalatest.{GivenWhenThen, fixture}

trait SolutionTest extends fixture.FlatSpec with GivenWhenThen  {
  override type FixtureParam = Solution

  "example array" should "return number of pairs which sum to 5" in { (sol: Solution) =>
    Given("one element array")
    val sum = 5;
    var array = Array(1)

    When("calling method")
    var pairs = sol.find(array, sum)

    Then("return 0 pairs")
    assert(pairs === 0)

    Given("empty array")
    array = Array()

    When("calling method")
    pairs = sol.find(array, sum)

    Then("return 0 pairs")
    assert(pairs === 0)

    Given("one elements array")
    array = Array(1,2)

    When("calling method")
    pairs = sol.find(array, sum)

    Then("return 0 pairs")
    assert(pairs === 0)

    Given("three elements array")
    array = Array(1,2,3)

    When("calling method")
    pairs = sol.find(array, sum)

    Then("return 1 pair")
    assert(pairs === 1)

    Given("four elements array")
    array = Array(0,5,2,3)

    When("calling method")
    pairs = sol.find(array, sum)

    Then("return 2 pairs")
    assert(pairs === 2)

    Given("five elements array")
    array = Array(1,0,3,4,5)

    When("calling method")
    pairs = sol.find(array, sum)

    Then("return 2 pairs")
    assert(pairs === 2)

    Given("five elements array of the same numbers")
    array = Array(1,1,1,1,1)

    When("calling method")
    pairs = sol.find(array, sum)

    Then("return 0 pairs")
    assert(pairs === 0)
  }
}
