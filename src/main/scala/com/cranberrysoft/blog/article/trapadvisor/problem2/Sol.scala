package com.cranberrysoft.blog.article.trapadvisor.problem2

import scala.collection.mutable

object Sol {
  def apply(): Sol = new Sol()

  def main(args: Array[String]): Unit = {
    val s = new mutable.HashSet[Array[Int]];
    s.add(Array(1,2))
    s.add(Array(1,2))
    print(s)
    println(List(1,2).equals((List(1,2))));
    println(Seq(1,2).combinations(2).toList)
  }
}

class Sol extends Solution {



  override def find(a: Array[Int], n: Int): Long = {
    a
      .filter(_ <= n)
      .combinations(2).toSeq
      .distinct //because List(1,2).equals(List(1,2)) is TRUE
      .filter(_.sum == n)
      .size
  }
}
