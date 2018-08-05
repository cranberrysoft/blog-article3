package com.cranberrysoft.blog.article.trapadvisor.problem2.bigdata.cassandra.sink.foreach

import com.cranberrysoft.blog.article.trapadvisor.problem2.bigdata.cassandra.common._
import org.apache.spark.sql.Row

object SimpleNoFaultTolerantCassandraSumWriter extends SimpleNoFaultTolerantCassandraForeachWriter[Row] {

  override def process(row: Row): Unit = {
    connector.withSessionDo {
      session =>
        session.execute(
          "INSERT INTO trap.sums(sum, count) VALUES (?, ?)"
          ,row.getAs[Integer]("sum"), new java.lang.Long(row.getAs[Long]("count"))//needs Java types
        )
    }
  }
}
