package com.oussama_chatri.productivity.features.notes.presentation.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.oussama_chatri.productivity.R
import com.oussama_chatri.productivity.features.notes.presentation.ui.theme.makeNoteColorByType
import com.oussama_chatri.productivity.ui.theme.ProductivityTheme
import com.oussama_chatri.productivity.ui.theme.dimens

@Composable
fun NoteCard(
    modifier: Modifier,
    title: String,
    content: String,
    type: String,
    isPinned: Boolean,
    onClickPinnedIcon: () -> Unit,
) {

    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val cardWidth = (screenWidth - 32.dp) / 2

    var isPinnedFlow by rememberSaveable {
        mutableStateOf(isPinned)
    }

    Card(
        modifier = modifier
            .width(cardWidth)
            .heightIn(min = 60.dp, max = 256.dp)
            .padding(MaterialTheme.dimens.paddingSmall),
        shape = RoundedCornerShape(MaterialTheme.dimens.cornerLarge),
        colors = CardDefaults.cardColors(
            containerColor = makeNoteColorByType(type)
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
    ) {
        Column(
            modifier = modifier.padding(
                top = MaterialTheme.dimens.paddingExtraSmall,
                bottom = MaterialTheme.dimens.paddingExtraSmall,
                start = MaterialTheme.dimens.paddingExtraSmall,
                end = MaterialTheme.dimens.paddingExtraSmall
            )
        ) {
            Text(
                title, style = MaterialTheme.typography.titleSmall,
                modifier = modifier.padding(bottom = MaterialTheme.dimens.paddingExtraSmall),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                content,
                style = MaterialTheme.typography.labelMedium,
                modifier = modifier.padding(bottom = MaterialTheme.dimens.paddingExtraSmall),
                maxLines = 8,
                overflow = TextOverflow.Ellipsis,
                color = Color.DarkGray
            )
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier.fillMaxWidth()
            ) {
                Text(type, style = MaterialTheme.typography.labelLarge)
                IconButton(
                    onClick = {
                        isPinnedFlow = !isPinnedFlow
                        onClickPinnedIcon
                    },
                    modifier = modifier.size(MaterialTheme.dimens.iconSmall)
                ) {
                    var res : Int = R.drawable.unpinned
                    if (isPinnedFlow) res = R.drawable.pinned
                    Image(painterResource(res), contentDescription = isPinnedFlow.toString())
                }
            }

        }
    }

}

@Preview
@Composable
private fun Preview() {
    ProductivityTheme {
        NoteCard(
            modifier = Modifier,
            title = "Sample Note",
            content = "This is a preview of a note card in Jetpack Compose.\n"
                    + "This is a preview of a note card in Jetpack Compose."
                    + "This is a preview of a note card in Jetpack Compose."

                    + "This is a preview of a note card in Jetpack Compose."

                    + "This is a preview of a note card in Jetpack Compose.",
            type = "Work \uD83D\uDCBC",
            onClickPinnedIcon = {},
            isPinned = true,
        )
    }
}
