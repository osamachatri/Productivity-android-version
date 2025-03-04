package com.oussama_chatri.productivity.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.oussama_chatri.productivity.R
import com.oussama_chatri.productivity.navigation.MainPaths
import com.oussama_chatri.productivity.ui.theme.ProductivityTheme
import com.oussama_chatri.productivity.ui.theme.dimens

@Composable
fun TopAppBar(
    modifier: Modifier = Modifier,
    fullName: String,
    screen : MainPaths,
    onSearchClick : () -> Unit,
    onAiChatBootClick : () -> Unit,
    onNotificationsClick : () -> Unit,
    onProfileClick : () -> Unit
) {
    Row(
        modifier.fillMaxWidth()
            .padding(MaterialTheme.dimens.paddingSmall),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(stringResource(R.string.hi) + " $fullName,",
                style = MaterialTheme.typography.displaySmall
                )
            Text(
              when(screen){
                  MainPaths.Notes -> stringResource(R.string.notes_screen)
                  MainPaths.ToDoLists -> stringResource(R.string.toDoLists_screen)
                  MainPaths.Events -> stringResource(R.string.events_screen)
                  else -> stringResource(R.string.pomodoro_screen)
              },
                style = MaterialTheme.typography.bodyMedium
            )

        }
        Row {
            IconButton(
                onSearchClick,
                modifier.size(MaterialTheme.dimens.iconLarge)
            ) {
                Icon(painterResource(R.drawable.search), null)
            }
            IconButton(
                onAiChatBootClick,
                modifier.size(MaterialTheme.dimens.iconLarge)
            ) {
                Icon(painterResource(R.drawable.ai_chat_boot), null)
            }
            IconButton(
                onNotificationsClick,
                modifier.size(MaterialTheme.dimens.iconLarge)
            ) {
                Icon(painterResource(R.drawable.notifications), null)
            }
            IconButton(
                onProfileClick,
                modifier.size(MaterialTheme.dimens.iconLarge)
            ) {
                Icon(painterResource(R.drawable.profile), null)
            }
        }
    }
}

@Preview(showBackground = true, uiMode = 1)
@Composable
private fun Preview() {
    ProductivityTheme() {
        TopAppBar(
            fullName = "Mohamed",
            screen = MainPaths.Notes,
            onNotificationsClick = {},
            onSearchClick = {},
            onProfileClick = {},
            onAiChatBootClick = {}
        )
    }
}