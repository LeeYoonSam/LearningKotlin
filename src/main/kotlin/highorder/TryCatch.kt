package highorder

inline fun tryCatch(block: () -> Unit) {
    try {
        block()
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

fun main() {
    tryCatch {
        println("HighOrder Function - tryCatch block test")
    }

    tryCatch {
        println("HighOrder Function - tryCatch block test start")
        throw RuntimeException()
        println("HighOrder Function - tryCatch block test end")
    }
}