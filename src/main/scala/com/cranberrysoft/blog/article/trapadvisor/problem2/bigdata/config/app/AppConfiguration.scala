package com.cranberrysoft.blog.article.trapadvisor.problem2.bigdata.config.app

import org.yaml.snakeyaml.Yaml

import scala.beans.BeanProperty

object AppConfiguration{

  def apply():AppConfiguration = {
    new Yaml().loadAs(AppConfiguration.getClass.getResourceAsStream("/config.yml"), classOf[AppConfiguration] )
  }
}

class AppConfiguration {
  // scalastyle:off null
  @BeanProperty var spark: SparkConfiguration = null
  @BeanProperty var cassandra: CassandraConfiguration = null
  @BeanProperty var kafka: KafkaConfiguration  = null
  // scalastyle:on null
}