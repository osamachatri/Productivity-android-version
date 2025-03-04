package com.oussama_chatri.productivity.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.oussama_chatri.productivity.R
import com.oussama_chatri.productivity.ui.theme.ProductivityTheme
import com.oussama_chatri.productivity.ui.theme.dimens

@Composable
fun BottomNavigationBar(
    modifier: Modifier = Modifier,
    onNotesClick: () -> Unit,
    onToDoListsClick: () -> Unit,
    onEventsClick: () -> Unit,
    onPomodoroClick: () -> Unit,
) {

    val navItemColors = NavigationBarItemDefaults.colors(
        unselectedIconColor = MaterialTheme.colorScheme.onBackground,
        selectedTextColor = MaterialTheme.colorScheme.primary,
        indicatorColor = Color.Transparent
    )

    val isNotesSelected by rememberSaveable {
        mutableStateOf(true)
    }
    val isToDoListsSelected by rememberSaveable {
        mutableStateOf(false)
    }
    val isEventsSelected by rememberSaveable {
        mutableStateOf(false)
    }
    val isPomodoroSelected by rememberSaveable {
        mutableStateOf(false)
    }

    androidx.compose.material3.BottomAppBar(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .clip(menuBarShape())
            .clip(
                RoundedCornerShape(
                    topStart = MaterialTheme.dimens.cornerLarge,
                    topEnd = MaterialTheme.dimens.cornerLarge
                )
            ),
        tonalElevation = 8.dp,
    ) {
        NavigationBarItem(
            selected = isNotesSelected,
            onClick = onNotesClick,
            icon = {
                Image(
                    painterResource(
                        if (isNotesSelected) R.drawable.select_note
                        else R.drawable.unselect_note
                    ),
                    contentDescription = null,
                    modifier.size(if (isNotesSelected) MaterialTheme.dimens.iconLarge else MaterialTheme.dimens.iconMedium)
                )
            },
            label = {
                Text(
                    stringResource(R.string.notes),
                    style = MaterialTheme.typography.labelLarge
                )
            },
            alwaysShowLabel = isNotesSelected,
            colors = navItemColors
        )
        NavigationBarItem(
            selected = isToDoListsSelected,
            onClick = onToDoListsClick,
            icon = {
                Image(
                    painterResource(
                        if (isToDoListsSelected) R.drawable.select_to_do_list
                        else R.drawable.unselect_to_do_list
                    ),
                    contentDescription = null,
                    modifier.size(if (isToDoListsSelected) MaterialTheme.dimens.iconLarge else MaterialTheme.dimens.iconMedium)
                )
            },
            label = {
                Text(
                    stringResource(R.string.toDoLists),
                    style = MaterialTheme.typography.labelLarge
                )
            },
            alwaysShowLabel = isToDoListsSelected,
            colors = navItemColors
        )
        NavigationBarItem(
            selected = isEventsSelected,
            onClick = onEventsClick,
            icon = {
                Image(
                    painterResource(
                        if (isEventsSelected) R.drawable.select_event
                        else R.drawable.unselect_event
                    ),
                    contentDescription = null,
                    modifier.size(if (isEventsSelected) MaterialTheme.dimens.iconLarge else MaterialTheme.dimens.iconMedium)
                )
            },
            label = {
                Text(
                    stringResource(R.string.events),
                    style = MaterialTheme.typography.labelMedium
                )
            },
            alwaysShowLabel = isEventsSelected,
            colors = navItemColors
        )
        NavigationBarItem(
            selected = isPomodoroSelected,
            onClick = onPomodoroClick,
            icon = {
                Image(
                    painterResource(
                        if (isPomodoroSelected) R.drawable.select_pomodoro
                        else R.drawable.unselect_pomodoro
                    ),
                    contentDescription = null,
                    modifier.size(if (isPomodoroSelected) MaterialTheme.dimens.iconLarge else MaterialTheme.dimens.iconMedium)
                )
            },
            label = {
                Text(
                    stringResource(R.string.pomodoro),
                    style = MaterialTheme.typography.labelLarge
                )
            },
            alwaysShowLabel = isPomodoroSelected,
            colors = navItemColors
        )
    }
}

private fun menuBarShape() = GenericShape { size, _ ->
    reset()

    moveTo(0f, 0f)

    val width = 180f
    val height = 100f

    val point1 = 60f
    val point2 = 100f

    lineTo(size.width / 2 - width, 0f)

    cubicTo(
        size.width / 2 - point1, 0f,
        size.width / 2 - point2, height,
        size.width / 2, height
    )

    cubicTo(
        size.width / 2 + point2, height,
        size.width / 2 + point1, 0f,
        size.width / 2 + width, 0f
    )

    lineTo(size.width / 2 + width, 0f)

    lineTo(size.width, 0f)
    lineTo(size.width, size.height)
    lineTo(0f, size.height)

    close()
}

@Preview
@Composable
private fun Preview() {
    ProductivityTheme {
        BottomNavigationBar(
            onPomodoroClick = {},
            onNotesClick = {},
            onEventsClick = {},
            onToDoListsClick = {}
        )
    }
}