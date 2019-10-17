package template.micronaut

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces

@Controller("/about")
class AboutController {

  @Get("/")
  @Produces(MediaType.TEXT_PLAIN)
  fun index(): String {
    return "About API V.${Application.apiVersion} (/v${Application.apiVersion})"
  }
}
