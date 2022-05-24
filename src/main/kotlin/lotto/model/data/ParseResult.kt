package lotto.model.data

sealed interface ParseResult<T> {
    data class Value<T>(val value: T) : ParseResult<T>
    data class Error<T>(val error: Throwable) : ParseResult<T> {
        constructor(errorMessage: String) : this(IllegalArgumentException(errorMessage))
    }
}
