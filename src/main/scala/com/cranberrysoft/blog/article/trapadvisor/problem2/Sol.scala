package com.cranberrysoft.blog.article.trapadvisor.problem2

object Sol {
  def apply(): Sol = new Sol()
}

class Sol extends Solution {

  override def find(a: Array[Int], n: Int): Long = {
    a
      .distinct
      .filter(_ <= n)
      .combinations(2)
      .filter(_.sum == n)
      .size
  }
}
