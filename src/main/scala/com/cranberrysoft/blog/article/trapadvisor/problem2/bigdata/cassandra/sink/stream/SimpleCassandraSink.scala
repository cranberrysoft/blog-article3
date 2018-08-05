package com.cranberrysoft.blog.article.trapadvisor.problem2.bigdata.cassandra.sink.stream

import org.apache.spark.sql._
import org.apache.spark.sql.cassandra._
import org.apache.spark.sql.execution.streaming.Sink
class SimpleCassandraSink(options: Map[String, String]) extends Sink {

  override def addBatch(batchId: Long, data: DataFrame) = {
       data.write.mode(SaveMode.Append)
      .cassandraFormat(options("table"),options("keyspace"))
      .save()
  }

}

