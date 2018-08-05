package com.cranberrysoft.blog.article.trapadvisor.problem2

import org.scalatest.Outcome

class SolSpec extends SolutionTest{
  override protected def withFixture(test: OneArgTest): Outcome = test(Sol())
}
