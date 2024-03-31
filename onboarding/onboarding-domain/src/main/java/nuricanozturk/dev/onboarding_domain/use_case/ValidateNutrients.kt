package nuricanozturk.dev.onboarding_domain.use_case

import nuricanozturk.dev.core.util.UiText
import nuricanozturk.dev.core.R

class ValidateNutrients {

    operator fun invoke(
        carbsRatioText: String,
        proteinRatioText: String,
        fatRatioText: String
    ): Result {
        val carbsRatio = carbsRatioText.toIntOrNull()
        val proteinRatio = proteinRatioText.toIntOrNull()
        val fatRatio = fatRatioText.toIntOrNull()

        if (fatRatio == null || carbsRatio == null || proteinRatio == null)
            return Result.Error(UiText.StringResource(R.string.error_invalid_values))

        if (carbsRatio + proteinRatio + fatRatio != 100) {
            return Result.Error(UiText.StringResource(R.string.error_not_100_percent))
        }

        return Result.Success(carbsRatio / 100f, proteinRatio / 100f, fatRatio / 100f)
    }

    sealed class Result {
        data class Success(val carbsRatio: Float, val proteinRatio: Float, val fatRatio: Float) :
            Result()

        data class Error(val message: UiText) : Result()
    }
}