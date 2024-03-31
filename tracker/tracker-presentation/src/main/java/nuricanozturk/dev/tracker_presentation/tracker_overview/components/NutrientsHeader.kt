package nuricanozturk.dev.tracker_presentation.tracker_overview.components

import androidx.compose.animation.core.animateIntAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nuricanozturk.dev.core.R
import nuricanozturk.dev.core_ui.CarbColor
import nuricanozturk.dev.core_ui.FatColor
import nuricanozturk.dev.core_ui.LocalSpacing
import nuricanozturk.dev.core_ui.ProteinColor
import nuricanozturk.dev.tracker_presentation.components.UnitDisplay
import nuricanozturk.dev.tracker_presentation.tracker_overview.TrackerOverviewState

@Composable
fun NutrientsHeader(
    state: TrackerOverviewState,
    modifier: Modifier = Modifier
) {
    val spacing = LocalSpacing.current
    val animatedCalorieCount = animateIntAsState(targetValue = state.totalCalories, label = "total")

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(bottomStart = 50.dp, bottomEnd = 50.dp))
            .background(MaterialTheme.colorScheme.primary)
            .padding(horizontal = spacing.spaceLarge, vertical = spacing.spaceExtraLarge)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            UnitDisplay(
                amount = animatedCalorieCount.value,
                unit = stringResource(R.string.kcal),
                amountColor = MaterialTheme.colorScheme.onPrimary,
                amountTextSize = 40.sp,
                unitColor = MaterialTheme.colorScheme.onPrimary,
                modifier = Modifier.align(Alignment.Bottom)
            )
            Column {
                Text(
                    text = stringResource(R.string.your_goal),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onPrimary
                )

                UnitDisplay(
                    amount = animatedCalorieCount.value,
                    unit = stringResource(R.string.kcal),
                    amountColor = MaterialTheme.colorScheme.onPrimary,
                    amountTextSize = 40.sp,
                    unitColor = MaterialTheme.colorScheme.onPrimary
                )
            }
        }

        Spacer(modifier = Modifier.height(spacing.spaceSmall))
        NutrientsBar(
            state.totalCarbs,
            state.totalProtein,
            state.totalFat,
            state.totalCalories,
            state.caloriesGoal,
            Modifier.fillMaxWidth().height(30.dp)
        )

        Spacer(modifier = Modifier.height(spacing.spaceLarge))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            NutrientBarInfo(
                value = state.totalCarbs,
                goal = state.carbsGoal,
                name = stringResource(R.string.carbs),
                color = CarbColor,
                modifier = Modifier.size(90.dp)
            )

            NutrientBarInfo(
                value = state.totalProtein,
                goal = state.proteinGoal,
                name = stringResource(R.string.protein),
                color = ProteinColor,
                modifier = Modifier.size(90.dp)
            )


            NutrientBarInfo(
                value = state.totalFat,
                goal = state.fatGoal,
                name = stringResource(R.string.fat),
                color = FatColor,
                modifier = Modifier.size(90.dp)
            )
        }
    }

}