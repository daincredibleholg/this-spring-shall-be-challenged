package org.fosdem.steinhauer.demo.performance

import io.gatling.core.Predef._
import io.gatling.http.Predef._

import scala.concurrent.duration.DurationInt
import scala.language.postfixOps


class FosdemSimulation extends Simulation {

  val httpProtocol = http.baseUrl("https://app.fosdem21.steinhauer.software")
    .acceptHeader("application/json")
    .acceptEncodingHeader("gzip, deflate")
    .userAgentHeader("Fosdem 2021 - This Spring Shall Be Challenged - Gatling Performance Tester")
    .basicAuth("fosdem", "Fosdem.2021!")

  val scn = scenario("Engage")
    .exec(http("get all articles").get("/article/"))


  setUp(scn.inject(rampUsers(1000) during (1 minutes)).protocols(httpProtocol)).maxDuration(2 minutes)

}
