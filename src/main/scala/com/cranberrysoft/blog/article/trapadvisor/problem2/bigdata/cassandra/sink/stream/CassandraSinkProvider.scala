package com.cranberrysoft.blog.article.trapadvisor.problem2.bigdata.cassandra.sink.stream

import org.apache.spark.sql.SQLContext
import org.apache.spark.sql.sources.StreamSinkProvider
import org.apache.spark.sql.streaming.OutputMode

class CassandraSinkProvider extends StreamSinkProvider {
  override def createSink(sqlContext: SQLContext,
                          parameters: Map[String, String],
                          partitionColumns: Seq[String],
                          outputMode: OutputMode): SimpleCassandraSink = {
    new SimpleCassandraSink(parameters)
  }
}
