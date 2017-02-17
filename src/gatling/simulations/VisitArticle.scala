package net.yehuang

import io.gatling.core.Predef._
import io.gatling.http.Predef._

object VisitArticle {

  val articleFeeder = csv("articles.csv").random

  val articleRead = repeat(5, "n") {
    exec(http("get_home_page_for_article_read")
      .get("/"))
      .pause(1)
      .feed(articleFeeder)
      .exec(http("get_random_article")
        .get("${article}")
//        .check(status.is(200))
      )
      .pause(5)
  }
}
