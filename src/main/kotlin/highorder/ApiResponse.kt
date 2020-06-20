package highorder

enum class ResponseStatus(val code: String, val message: String) {
    OK("OK", "ok"),
    FAIL("FAIL", "fail"),
    ERROR("ERROR", "error"),
}

data class ApiResponse<T>(
    val status: String,
    val error: String? = null,
    val data: T?
) {
    companion object {
        fun <T> ok() = ApiResponse<T>(
            status = ResponseStatus.OK.code,
            data = null
        )

        fun <T> ok(data: T) = ApiResponse<T>(
            status = ResponseStatus.OK.code,
            data = data
        )

        /**
         * 블록을 실행시키고 예외에 걸리면 실패 처리
         */
        inline fun <T> runCatching(block: () -> T): ApiResponse<T> =
            try {
                ok(block())
            } catch (e: Throwable) {
                failure(e)
            }

        /**
         * 예외처리를 하지 않고 무조건 ok 로 리턴
         */
        inline fun <T> run(block: () -> T): ApiResponse<T> = ok(block())

        fun <T> failure(t: Throwable) = ApiResponse<T>(
            ResponseStatus.ERROR.code,
            t.message,
            null
        )
    }
}