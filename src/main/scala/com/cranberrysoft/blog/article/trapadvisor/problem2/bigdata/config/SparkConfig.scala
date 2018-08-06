package com.cranberrysoft.blog.article.trapadvisor.problem2.bigdata.config

import com.cranberrysoft.blog.article.trapadvisor.problem2.bigdata.config.app.{AppConfiguration, SparkConfiguration}
import org.apache.spark.SparkConf

object SparkConfig {
  private val configuration = AppConfiguration()

  def apply() =
      new SparkConf()
        .setAppName("TrapAdvisorCounter")
        .setMaster(configuration.spark.master)
        .set("spark.cassandra.connection.host", configuration.cassandra.server)
        .set("spark.cassandra.auth.username", configuration.cassandra.user)
        .set("spark.cassandra.auth.password", configuration.cassandra.password)
        .set("spark.cassandra.output.consistency.level", "LOCAL_QUORUM")
        .set("spark.sql.shuffle.partitions","4")
}
