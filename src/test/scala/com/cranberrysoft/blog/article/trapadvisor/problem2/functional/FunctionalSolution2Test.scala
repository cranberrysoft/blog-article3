package com.cranberrysoft.blog.article.trapadvisor.problem2.functional

import com.cranberrysoft.blog.article.trapadvisor.problem2.SolutionTest
import org.scalatest.Outcome

class FunctionalSolution2Test extends SolutionTest {
  override protected def withFixture(test: OneArgTest): Outcome = test(new FunctionalSolution2())
}
