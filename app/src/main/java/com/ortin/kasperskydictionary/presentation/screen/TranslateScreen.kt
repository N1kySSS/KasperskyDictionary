package com.ortin.kasperskydictionary.presentation.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ortin.kasperskydictionary.R
import com.ortin.kasperskydictionary.presentation.utils.clickableWithoutIndication
import com.ortin.kasperskydictionary.presentation.viewModel.TranslateScreenViewModel
import com.ortin.kasperskydictionary.ui.theme.Purple40

@Composable
fun TranslateScreen() {
    val viewModel: TranslateScreenViewModel = hiltViewModel()

    val focusManager = LocalFocusManager.current

    LaunchedEffect(viewModel.searchText.value) {
        viewModel.meaningText.value = ""
        viewModel.isOnFavouriteClicked.value = false
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .clickableWithoutIndication{ focusManager.clearFocus() },
        contentAlignment = Alignment.Center
    ) {
        Text(
            modifier = Modifier
                .padding(top = 20.dp)
                .align(Alignment.TopCenter),
            text = "Перевод",
            style = TextStyle(
                color = Color.Black,
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium,
                letterSpacing = 0.sp,
            ),
        )
        Column(
            modifier = Modifier
                .heightIn(min = 250.dp)
                .fillMaxWidth()
                .padding(16.dp)
                .clip(RoundedCornerShape(14.dp))
                .background(
                    shape = RoundedCornerShape(14.dp),
                    color = Color.LightGray
                )
                .padding(8.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                modifier = Modifier.offset(y = 10.dp, x = 16.dp),
                text = if (viewModel.isFromRussianToEnglish.value) "Русский" else "Английский(США)",
                style = TextStyle(
                    color = Purple40,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    letterSpacing = 0.sp,
                ),
            )
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = viewModel.searchText.value,
                singleLine = true,
                onValueChange = { viewModel.searchText.value = it },
                placeholder = {
                    Text(
                        text = if (viewModel.isFromRussianToEnglish.value) "Введите слово" else "Enter word",
                        style = TextStyle(
                            color = Color.Gray,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Medium,
                            letterSpacing = 0.sp,
                        ),
                    )
                },
                textStyle = TextStyle(
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                    letterSpacing = 0.sp,
                ),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                )
            )
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                HorizontalDivider(
                    modifier = Modifier.padding(vertical = 20.dp),
                    thickness = 1.dp,
                    color = Color.Black
                )
                IconButton(
                    modifier = Modifier
                        .size(24.dp)
                        .clip(CircleShape),
                    onClick = {
                        viewModel.isFromRussianToEnglish.value =
                            !viewModel.isFromRussianToEnglish.value
                    },
                    colors = IconButtonDefaults.iconButtonColors(containerColor = Color.Black)
                ) {
                    Icon(
                        modifier = Modifier.fillMaxSize(),
                        imageVector = ImageVector.vectorResource(R.drawable.ic_autorenew),
                        contentDescription = "Change language",
                        tint = Color.White
                    )
                }
            }
            Text(
                modifier = Modifier.offset(x = 16.dp),
                text = if (viewModel.isFromRussianToEnglish.value) "Перевод на Английский(США)" else "Перевод на Русский:",
                style = TextStyle(
                    color = Purple40,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    letterSpacing = 0.sp,
                ),
            )
            Text(
                modifier = Modifier
                    .padding(vertical = 6.dp)
                    .offset(x = 16.dp),
                text = viewModel.meaningText.value,
                overflow = TextOverflow.Ellipsis,
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                    letterSpacing = 0.sp,
                ),
            )
            if (viewModel.meaningText.value.isNotEmpty()) {
                IconButton(
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .size(30.dp),
                    onClick = {
                        viewModel.isOnFavouriteClicked.value = true
                        viewModel.addToFavourite()
                    },
                    colors = IconButtonDefaults.iconButtonColors(containerColor = Color.Transparent)
                ) {
                    Icon(
                        modifier = Modifier.fillMaxSize(),
                        imageVector = ImageVector.vectorResource(
                            if (viewModel.isOnFavouriteClicked.value) R.drawable.ic_star
                            else R.drawable.ic_star_border
                        ),
                        contentDescription = "Make favourite",
                        tint = Color.Yellow
                    )
                }
            }
        }
        Button(
            modifier = Modifier
                .padding(bottom = 10.dp)
                .align(Alignment.BottomCenter),
            shape = RoundedCornerShape(20.dp),
            border = BorderStroke(
                width = 2.dp,
                color = Purple40
            ),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent
            ),
            onClick = {
                if (viewModel.searchText.value.isNotEmpty()) {
                    viewModel.getMeaning()
                }
            }
        ) {
            Text(
                text = "Перевести",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Normal,
                    letterSpacing = 0.sp,
                ),
            )
        }
    }
}
