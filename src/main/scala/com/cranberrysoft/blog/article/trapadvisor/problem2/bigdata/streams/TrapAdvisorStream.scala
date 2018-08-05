package com.cranberrysoft.blog.article.trapadvisor.problem2.bigdata.streams

import com.cranberrysoft.blog.article.trapadvisor.problem2.bigdata.TrapAdvisorCounterApp.configuration
import org.apache.spark.sql.functions.{col, from_json}
import org.apache.spark.sql.types.{StructType}
import org.apache.spark.sql.{DataFrame, Dataset, SparkSession}

object TrapAdvisorStream {

  val schema = new StructType()
    .add("numbers", "array<int>", true)

  def get(spark: SparkSession): Dataset[Int] = {
    import spark.implicits._

    spark
      .readStream
      .format("kafka")
      .option("kafka.bootstrap.servers", configuration.kafka.servers)
      .option("subscribe", configuration.kafka.topic)
      .option("startingOffsets", "earliest")
      .option("failOnDataLoss", false)
      .load()
      .select(
        col("key").cast("string"),
          from_json(col("value").cast("string"), schema).as("parsed_value")
      ).select("parsed_value.numbers").as[Array[Int]]
      .transform(toSortedPairs)
  }

  private def toSortedPairs(df: Dataset[Array[Int]]) ={ //return dataset with column value
    import df.sparkSession.implicits._
    df.map( _.combinations(2).map(_.sum).toList).flatMap(_.iterator)
  }

}
