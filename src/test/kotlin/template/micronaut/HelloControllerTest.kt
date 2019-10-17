package template.micronaut

import io.micronaut.context.ApplicationContext
import io.micronaut.http.client.HttpClient
import io.micronaut.runtime.server.EmbeddedServer
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import kotlin.test.assertEquals

object HelloControllerTest: Spek({

  describe ("HelloController Suite") {
    var embeddedServer : EmbeddedServer = ApplicationContext.run(EmbeddedServer::class.java)
    var client : HttpClient = HttpClient.create(embeddedServer.url)

    it ("test /v${Application.apiVersion}/hello responds 'Hello World'") {
      var response : String = client.toBlocking().retrieve("/v${Application.apiVersion}/hello")
      assertEquals(response, "Hello World")
    }

    afterGroup {
      client.close()
      embeddedServer.close()
    }

  }

})
