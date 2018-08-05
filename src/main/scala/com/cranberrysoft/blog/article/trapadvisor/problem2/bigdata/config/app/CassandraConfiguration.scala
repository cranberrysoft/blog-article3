package com.cranberrysoft.blog.article.trapadvisor.problem2.bigdata.config.app

import scala.beans.BeanProperty

private[app] class CassandraConfiguration {
  @BeanProperty var server: String = "";
  @BeanProperty var user: String = "";
  @BeanProperty var password: String = "";
}
