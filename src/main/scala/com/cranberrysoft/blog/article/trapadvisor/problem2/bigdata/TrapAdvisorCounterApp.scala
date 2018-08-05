package com.cranberrysoft.blog.article.trapadvisor.problem2.bigdata

import com.cranberrysoft.blog.article.trapadvisor.problem2.bigdata.cassandra.sink.foreach.SimpleNoFaultTolerantCassandraSumWriter
import com.cranberrysoft.blog.article.trapadvisor.problem2.bigdata.config.SparkConfig
import com.cranberrysoft.blog.article.trapadvisor.problem2.bigdata.config.app.AppConfiguration
import com.cranberrysoft.blog.article.trapadvisor.problem2.bigdata.streams.TrapAdvisorStream
import com.typesafe.scalalogging.StrictLogging
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.streaming.OutputMode

object TrapAdvisorCounterApp extends StrictLogging{
  lazy val configuration = AppConfiguration()

  def main(args: Array[String]): Unit = {
    System.setProperty("hadoop.home.dir", "C:\\Users\\Mariusz\\Downloads\\winutils-master\\winutils-master\\hadoop-2.8.3\\")

    val spark = SparkSession
      .builder
      .config(SparkConfig.apply())
      .getOrCreate()

    val trapAdvisorStream = TrapAdvisorStream.get(spark);
    //Get data from Kafka in the following format
/*   +-----+
|value|
+-----+
|    6|
|    7|
|    5|
|    6|
|    7|
+-----+
*/

    //Our business logic
    //functional way
/*    import spark.implicits._
    val sumStream =
        trapAdvisorStream.filter(_ == 5).groupByKey(identity).count() //business logic
      .select($"value" as "sum", $"count(1)" as "count" )*/

    //SQL way

    // Register the DataFrame as a SQL temporary view
    trapAdvisorStream.createOrReplaceTempView("sums")
    val sumStream =
      spark.sql("SELECT value as sum, count(value) as count FROM sums WHERE value = 5 GROUP BY value") //business logic

    //sumStream example
/*    +---+-----+
    |sum|count|
    +---+-----+
    |  5|   16|
      +---+-----+*/

   //Append stream
    sumStream
          .writeStream
          .format("com.cranberrysoft.blog.article.trapadvisor.problem2.cassandra.sink.stream.CassandraSinkProvider")
          .options(Map("table" -> "sums_counter", "keyspace" -> "trap"))
          .outputMode(OutputMode.Update) //this mode is ignored in a downstream sink
          .queryName("KafkaToCassandraStreamSinkProvider")
          .option("checkpointLocation", configuration.spark.checkpoint)
          .start()

    //Update stream
    sumStream
      .writeStream
      .outputMode(OutputMode.Update)
      .format("console")
      .start()

    //Update stream
    sumStream
      .writeStream
      .outputMode(OutputMode.Update)
      .foreach(SimpleNoFaultTolerantCassandraSumWriter)
      .start()

    spark.streams.awaitAnyTermination()
  }

}
