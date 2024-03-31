package nuricanozturk.dev.core.domain.usecase

class FilterOutDigits {
    operator fun invoke(text: String): String = text.filter { it.isDigit() }
}