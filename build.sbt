name := "blog-article3"
organization := "com.cranberrysoft"
version := "0.1"

//In order to have meaningful logs for tests
parallelExecution in Test := false

scalaVersion := "2.11.12"

val sparkVersion = "2.2.2"
lazy val exckudeJpountz = ExclusionRule(organization = "net.jpountz.lz4", name = "lz4")

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % sparkVersion,
  "org.apache.spark" %% "spark-sql" % sparkVersion,
  "org.apache.spark" % "spark-sql-kafka-0-10_2.11" % sparkVersion excludeAll(exckudeJpountz) ,
  "org.apache.spark" %% "spark-streaming-kafka-0-10" % sparkVersion excludeAll(exckudeJpountz) ,
  "com.datastax.spark" %% "spark-cassandra-connector" % "2.3.1",
  "com.typesafe.scala-logging" %% "scala-logging" % "3.9.0",
  "org.yaml" % "snakeyaml" % "1.21",
  "com.typesafe" % "config" % "1.3.3",
  "com.holdenkarau" %% "spark-testing-base" % "2.3.1_0.10.0" % "test"
)