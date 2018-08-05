package com.cranberrysoft.blog.article.trapadvisor.problem2.bigdata.config.app

import scala.beans.BeanProperty

private[app] class SparkConfiguration {
  @BeanProperty var master: String = "";
  @BeanProperty var checkpoint: String = "";
}
