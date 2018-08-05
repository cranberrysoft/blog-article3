package com.cranberrysoft.blog.article.trapadvisor.problem2.bigdata.cassandra

import com.datastax.spark.connector.cql.CassandraConnector
import org.apache.spark.sql.SparkSession
package object common {
  val connector = CassandraConnector(SparkSession.getDefaultSession.get.sparkContext.getConf)
}
