
import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class RecordedSimulation extends Simulation {

	val httpProtocol = http
		.baseURL("https://www.baidu.com")
		.inferHtmlResources()

	val header = Map(
		"Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8",
		"Upgrade-Insecure-Requests" -> "1"
	)

  val uri = "https://www.baidu.com:443"

	val scn = scenario("RecordedSimulation").exec(

		http("request_0")
		.get("/s?ie=utf-8&f=8&rsv_bp=1&rsv_idx=1&ch=&tn=baidu&bar=&wd=Gatling&oq=Gatling&rsv_pq=d1c2db670007c468&rsv_t=babbXD29BYlr1EXgxcc5Y3sDLeTXUF2TKAB6Ge%2Bkgh5bl8hB%2BdGcO7Y8gBM")
		.headers(header)
		.resources(

			http("request_1")
			.get(uri + "/content-search.xml"),

      http("request_2")
			.get(uri + "/img/baidu.svg"))
		)

	// setUp(
	// 	scn.inject(
	// 		atOnceUsers(10)
	// 	)
	// ).protocols(httpProtocol)

	setUp(
		scn.inject(
			constantUsersPerSec(10) during(3 seconds)
		)
	)
	.protocols(httpProtocol)
	.throttle(
		reachRps(100) in (10 seconds),
	  holdFor(10 seconds)
	)

}
