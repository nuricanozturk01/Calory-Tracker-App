package nuricanozturk.dev.core.data.preferences

import android.content.SharedPreferences
import nuricanozturk.dev.core.domain.preferences.IPreferences
import nuricanozturk.dev.core.domain.model.ActivityLevel
import nuricanozturk.dev.core.domain.model.Gender
import nuricanozturk.dev.core.domain.model.GoalType
import nuricanozturk.dev.core.domain.model.UserInfo
import java.util.prefs.Preferences

class DefaultPreferences(private val sharedPreferences: SharedPreferences) : IPreferences {

    override fun saveGender(gender: Gender) = sharedPreferences.edit()
        .putString(IPreferences.KEY_GENDER, gender.name)
        .apply()

    override fun saveAge(age: Int) = sharedPreferences.edit()
        .putInt(IPreferences.KEY_AGE, age)
        .apply()

    override fun saveWeight(weight: Float) = sharedPreferences.edit()
        .putFloat(IPreferences.KEY_WEIGHT, weight)
        .apply()

    override fun saveHeight(height: Int) = sharedPreferences.edit()
        .putInt(IPreferences.KEY_HEIGHT, height)
        .apply()

    override fun saveActivityLevel(activityLevel: ActivityLevel) = sharedPreferences.edit()
        .putString(IPreferences.KEY_ACTIVITY_LEVEL, activityLevel.name)
        .apply()

    override fun saveGoalType(goalType: GoalType) = sharedPreferences.edit()
        .putString(IPreferences.KEY_GOAL_TYPE, goalType.name)
        .apply()

    override fun saveCarbRatio(ratio: Float) = sharedPreferences.edit()
        .putFloat(IPreferences.KEY_CARB_RATIO, ratio)
        .apply()

    override fun saveProteinRatio(ratio: Float) = sharedPreferences.edit()
        .putFloat(IPreferences.KEY_PROTEIN_RATIO, ratio)
        .apply()

    override fun saveFatRatio(ratio: Float) = sharedPreferences.edit()
        .putFloat(IPreferences.KEY_FAT_RATIO, ratio)
        .apply()

    override fun loadUserInfo(): UserInfo {
        val age = sharedPreferences.getInt(IPreferences.KEY_AGE, -1)
        val height = sharedPreferences.getInt(IPreferences.KEY_HEIGHT, -1)
        val weight = sharedPreferences.getFloat(IPreferences.KEY_WEIGHT, -1f)
        val genderString = sharedPreferences.getString(IPreferences.KEY_GENDER, null)
        val activityLevelString = sharedPreferences
            .getString(IPreferences.KEY_ACTIVITY_LEVEL, null)
        val goalType = sharedPreferences.getString(IPreferences.KEY_GOAL_TYPE, null)
        val carbRatio = sharedPreferences.getFloat(IPreferences.KEY_CARB_RATIO, -1f)
        val proteinRatio = sharedPreferences.getFloat(IPreferences.KEY_PROTEIN_RATIO, -1f)
        val fatRatio = sharedPreferences.getFloat(IPreferences.KEY_FAT_RATIO, -1f)

        return UserInfo(
            gender = Gender.fromString(genderString ?: "male"),
            age = age,
            weight = weight,
            height = height,
            activityLevel = ActivityLevel.fromString(activityLevelString ?: "medium"),
            goalType = GoalType.fromString(goalType ?: "keep_weight"),
            carbRatio = carbRatio,
            proteinRatio = proteinRatio,
            fatRatio = fatRatio
        )
    }

    override fun saveShouldShowOnboarding(shouldShow: Boolean) {
        sharedPreferences.edit().putBoolean(IPreferences.KEY_SHOULD_SHOW_ONBOARDING, shouldShow)
            .apply()
    }

    override fun loadShouldShowOnboarding(shouldShow: Boolean): Boolean {
        return sharedPreferences.getBoolean(IPreferences.KEY_SHOULD_SHOW_ONBOARDING, true)
    }
}