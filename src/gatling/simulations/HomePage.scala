package net.yehuang

import io.gatling.core.Predef._
import io.gatling.http.Predef._

object HomePage {

  val get = tryMax(3) {

    exec(http("get_home_page")
      .get("/")
      .check(status.is(200))
    ).pause(5)

  }.exitHereIfFailed

}