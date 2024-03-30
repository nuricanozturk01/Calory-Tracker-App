package nuricanozturk.dev.core.domain.model

sealed class Gender(val name: String) {
    data object Male : Gender("male")
    data object Female : Gender("female")

    companion object {
        fun fromString(name: String) = when (name) {
            "male" -> Male
            "female" -> Female
            else -> Male
        }
    }
}