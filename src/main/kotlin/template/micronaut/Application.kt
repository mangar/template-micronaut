package template.micronaut

import io.micronaut.runtime.Micronaut

object Application {

    const val apiVersion = "1"

    @JvmStatic
    fun main(args: Array<String>) {
        Micronaut.build()
                .packages("template.micronaut")
                .mainClass(Application.javaClass)
                .start()
    }
}
