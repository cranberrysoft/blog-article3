package com.cranberrysoft.blog.article.trapadvisor.problem2.imperative

import com.cranberrysoft.blog.article.trapadvisor.problem2.SolutionTest
import org.scalatest.Outcome

class ImperativeSolutionTest extends SolutionTest {
  override protected def withFixture(test: OneArgTest): Outcome = test(new ImperativeSolution())
}
