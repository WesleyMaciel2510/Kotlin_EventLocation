package com.example.kotlin_portfolio.components.snackbar

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarDuration
import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.SnackbarResult
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import kotlinx.coroutines.launch

@SuppressLint("RememberReturnType", "UnusedMaterialScaffoldPaddingParameter")
@Composable
fun QRCodeSnackBar(
    modifier: Modifier = Modifier,
    screenContent: @Composable () -> Unit,
    snackbarTitle: String,
    snackbarAction: String,
    snackbarActionHandler: () -> Unit
) {
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }
    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                text = { Text("Show snackbar") },
                icon = { Icon(Icons.Filled.Info, contentDescription = "") },
                onClick = {
                    scope.launch {
                        val result = snackbarHostState
                            .showSnackbar(
                                message = snackbarTitle,
                                actionLabel = snackbarAction,
                                duration = SnackbarDuration.Indefinite
                            )
                        when (result) {
                            SnackbarResult.ActionPerformed -> {
                                snackbarActionHandler()
                            }
                            SnackbarResult.Dismissed -> {
                                // Handle snackbar dismissed if needed
                            }

                            SnackbarResult.Dismissed -> TODO()
                            SnackbarResult.ActionPerformed -> TODO()
                        }
                    }
                }
            )
        }
    ) {
        screenContent()
    }
}

/*
@Preview(showBackground = true)
@Composable
fun PreviewQRCodeSnackBar() {
    Kotlin_PortfolioTheme {
        QRCodeSnackBar()
    }
}*/
