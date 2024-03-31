package nuricanozturk.dev.tracker_presentation.tracker_overview.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import nuricanozturk.dev.core.R.*
import nuricanozturk.dev.tracker_presentation.R
import java.time.LocalDate


@Composable
fun DaySelector(
    date: LocalDate,
    onPrevDayClick: () -> Unit,
    onNextDayClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = onPrevDayClick) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = stringResource(id = string.previous_day)
            )
        }
        Text(
            text = parseDateText(date = date),
            style = MaterialTheme.typography.headlineMedium
        )

        IconButton(onClick = onNextDayClick) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                contentDescription = stringResource(id = string.next_day)
            )
        }
    }

}