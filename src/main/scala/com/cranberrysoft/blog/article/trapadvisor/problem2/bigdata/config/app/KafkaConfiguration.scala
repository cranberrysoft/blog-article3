package com.cranberrysoft.blog.article.trapadvisor.problem2.bigdata.config.app

import scala.beans.BeanProperty

private[app] class KafkaConfiguration {
  @BeanProperty var servers: String = "";
  @BeanProperty var topic: String = "";
}
