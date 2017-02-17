package net.yehuang

import io.gatling.core.Predef._
import io.gatling.http.Predef._

object SearchArticle {

  val keyWordFeeder = csv("searchKeyWords.csv").random

  val articleSearchRead = repeat(5, "n") {
    exec(http("get_home_page_for_article_search")
      .get("/"))
      .pause(1)
      .feed(keyWordFeeder)
      .exec(http("search_article")
        .get("?s=${keyword}")
        .check(css("a:contains('Ask HN:')", "href").saveAs("foundArticle"))
      )
      .pause(5)
      .exec(http("get_found_article")
        .get("${foundArticle}")
      ).pause(5)
  }
}
