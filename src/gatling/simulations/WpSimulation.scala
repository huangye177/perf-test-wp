package net.yehuang

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class WpSimulation extends Simulation {

  val httpConf = http
    .baseURL("http://47.89.133.219/")
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
    .doNotTrackHeader("1")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .acceptEncodingHeader("gzip, deflate")
    .userAgentHeader("Mozilla/5.0 (Windows NT 5.1; rv:31.0) Gecko/20100101 Firefox/31.0")

  val adminScn = scenario("AdminSimulation")
    .exec(HomePage.get)

  val editorScn = scenario("EditorSimulation")
    .exec(HomePage.get) // TODO: make article CRUD operation

  val userScn = scenario("UserSimulation")
    .exec(HomePage.get, VisitArticle.articleRead, SearchArticle.articleSearchRead)

  setUp(
    adminScn.inject(atOnceUsers(1)),
//    editorScn.inject(rampUsers(10) over (30 seconds)),
    userScn.inject(rampUsers(200) over (600 seconds))
  ).protocols(httpConf)
}