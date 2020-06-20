package highorder

import org.slf4j.Logger
import org.slf4j.LoggerFactory

// Log Interface 선언
interface Log {
    val logger: Logger get() = LoggerFactory.getLogger(this.javaClass)
}

// Logger 사용 방법
class Logging{
    companion object : Log

    fun sampleFunction() {
        logger.info("Hello Kotlin")
    }

    fun debug(s: () -> String) = logger.info("[id/type]: ${s()}")
}

fun main() {
    val logging = Logging()
    logging.sampleFunction()
    logging.debug { "debug test" }
}




