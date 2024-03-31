package nuricanozturk.dev.core.domain.preferences

import nuricanozturk.dev.core.domain.model.ActivityLevel
import nuricanozturk.dev.core.domain.model.Gender
import nuricanozturk.dev.core.domain.model.GoalType
import nuricanozturk.dev.core.domain.model.UserInfo

interface IPreferences {
    fun saveGender(gender: Gender)
    fun saveAge(age: Int)
    fun saveWeight(weight: Float)
    fun saveHeight(height: Int) // cm
    fun saveActivityLevel(activityLevel: ActivityLevel)
    fun saveGoalType(goalType: GoalType)
    fun saveCarbRatio(ratio: Float)
    fun saveProteinRatio(ratio: Float)
    fun saveFatRatio(ratio: Float)


    fun loadUserInfo(): UserInfo

    fun saveShouldShowOnboarding(shouldShow : Boolean)
    fun loadShouldShowOnboarding(shouldShow : Boolean) : Boolean

    companion object {
        const val KEY_GENDER = "gender"
        const val KEY_AGE = "age"
        const val KEY_WEIGHT = "weight"
        const val KEY_HEIGHT = "height"
        const val KEY_ACTIVITY_LEVEL = "activity_level"
        const val KEY_GOAL_TYPE = "goal_type"
        const val KEY_CARB_RATIO = "carb_ratio"
        const val KEY_PROTEIN_RATIO = "protein_ratio"
        const val KEY_FAT_RATIO = "fat_ratio"
        const val KEY_SHOULD_SHOW_ONBOARDING = "should_show_onboarding"

    }
}