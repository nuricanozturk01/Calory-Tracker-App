package nuricanozturk.dev.onboarding_presentation.goal

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.hilt.navigation.compose.hiltViewModel
import nuricanozturk.dev.core.util.UiEvent
import nuricanozturk.dev.core_ui.LocalSpacing
import nuricanozturk.dev.core.R
import nuricanozturk.dev.core.domain.model.ActivityLevel
import nuricanozturk.dev.core.domain.model.GoalType
import nuricanozturk.dev.onboarding_presentation.components.ActionButton
import nuricanozturk.dev.onboarding_presentation.components.SelectableButton

@Composable
fun GoalScreen(
    onNavigate: (UiEvent.Navigate) -> Unit,
    viewModel: GoalViewModel = hiltViewModel()
) {
    val spacing = LocalSpacing.current
    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect { event ->
            when (event) {
                is UiEvent.Navigate -> onNavigate(event)
                else -> Unit
            }
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(spacing.spaceLarge)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.lose_keep_or_gain_weight),
                style = MaterialTheme.typography.headlineSmall
            )
            Spacer(modifier = Modifier.height(spacing.spaceMedium))
            Row {
                SelectableButton(
                    text = stringResource(id = R.string.lose),
                    isSelected = viewModel.selectedGoal is GoalType.LoseWeight,
                    color = MaterialTheme.colorScheme.inversePrimary,
                    selectedTextColor = Color.White,
                    onClick = {
                        viewModel.onGoalTypeClick(GoalType.LoseWeight)
                    },
                    textStyle = MaterialTheme.typography.bodyMedium.copy(
                        fontWeight = FontWeight.Normal
                    )
                )
                Spacer(modifier = Modifier.width(spacing.spaceMedium))
                SelectableButton(
                    text = stringResource(id = R.string.keep),
                    isSelected = viewModel.selectedGoal is GoalType.KeepWeight,
                    color = MaterialTheme.colorScheme.inversePrimary,
                    selectedTextColor = Color.White,
                    onClick = {
                        viewModel.onGoalTypeClick(GoalType.KeepWeight)
                    },
                    textStyle = MaterialTheme.typography.bodyMedium.copy(
                        fontWeight = FontWeight.Normal
                    )
                )

                Spacer(modifier = Modifier.width(spacing.spaceMedium))
                SelectableButton(
                    text = stringResource(id = R.string.gain),
                    isSelected = viewModel.selectedGoal is GoalType.GainWeight,
                    color = MaterialTheme.colorScheme.inversePrimary,
                    selectedTextColor = Color.White,
                    onClick = {
                        viewModel.onGoalTypeClick(GoalType.GainWeight)
                    },
                    textStyle = MaterialTheme.typography.bodyMedium.copy(
                        fontWeight = FontWeight.Normal
                    )
                )
            }
        }
        ActionButton(
            text = stringResource(id = R.string.next),
            onClick = viewModel::onNextClick,
            modifier = Modifier.align(Alignment.BottomEnd)
        )
    }
}