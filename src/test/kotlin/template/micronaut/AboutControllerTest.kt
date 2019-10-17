package template.micronaut

import io.micronaut.context.ApplicationContext
import io.micronaut.http.client.HttpClient
import io.micronaut.runtime.server.EmbeddedServer
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import kotlin.test.assertEquals

object AboutControllerTest: Spek({

  describe ("AboutController Suite") {
    var embeddedServer : EmbeddedServer = ApplicationContext.run(EmbeddedServer::class.java)
    var client : HttpClient = HttpClient.create(embeddedServer.url)

    it ("test /about responds 'Hello World'") {
      var response : String = client.toBlocking().retrieve("/about")
      assertEquals(response, "About API V.${Application.apiVersion} (/v${Application.apiVersion})")
    }

    afterGroup {
      client.close()
      embeddedServer.close()
    }

  }

})
