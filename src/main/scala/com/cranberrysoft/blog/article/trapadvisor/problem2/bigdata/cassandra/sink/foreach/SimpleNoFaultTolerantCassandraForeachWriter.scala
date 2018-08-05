package com.cranberrysoft.blog.article.trapadvisor.problem2.bigdata.cassandra.sink.foreach

import org.apache.spark.sql.ForeachWriter

abstract class SimpleNoFaultTolerantCassandraForeachWriter[T] extends ForeachWriter[T] {
  override def open(partitionId: Long, version: Long): Boolean = true;
  override def close(errorOrNull: Throwable): Unit = {}
}
