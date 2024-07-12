package com.example.kotlin_portfolio.screens.camera

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.kotlin_portfolio.ui.theme.Kotlin_PortfolioTheme

@Composable
fun CameraScreen(modifier: Modifier = Modifier, navController: NavHostController) {
    Text("CameraScreen")
    /*val localContext = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    val cameraProviderFuture = remember {
        ProcessCameraProvider.getInstance(localContext)
    }
    AndroidView(
        modifier = Modifier.fillMaxSize(),
        factory = { context ->
            val preview = Preview.Builder().build()
            val cameraProvider = cameraProviderFuture.get()

            preview.setSurfaceProvider(previewView.surfaceProvider)

            runCatching {
                cameraProvider.bindToLifecycle(
                    lifecycleOwner,
                    CameraSelector.DEFAULT_BACK_CAMERA,
                    preview
                )
            }.onFailure {
                Log.e("CAMERA", "Camera bind error ${it.localizedMessage}", it)
            }
            previewView
        }
    )*/
}

@Preview(showBackground = true)
@Composable
fun PreviewCameraScreen() {
    val navController = rememberNavController()
    Kotlin_PortfolioTheme {
        CameraScreen(navController = navController)
    }
}
