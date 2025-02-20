package com.example.android_strepapp

import android.Manifest
import android.content.pm.PackageManager
import android.net.Uri
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.camera.core.*
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import androidx.lifecycle.LifecycleOwner
import android.view.MotionEvent
import android.view.ScaleGestureDetector
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import androidx.camera.core.CameraSelector
import java.io.File

@Composable
fun ImageCapture2(navController: NavController, modifier: Modifier = Modifier) {
    val context = LocalContext.current as ComponentActivity
    val permissionState = remember { mutableStateOf(false) }

    // Check for camera permissions and update state
    LaunchedEffect(Unit) {
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA)
            == PackageManager.PERMISSION_GRANTED
        ) {
            permissionState.value = true
        }
    }

    val requestPermissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { isGranted: Boolean ->
        if (isGranted) {
            permissionState.value = true
        } else {
            Toast.makeText(context, "Camera permission is required.", Toast.LENGTH_SHORT).show()
        }
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // Background Image
        Image(
            painter = painterResource(id = R.drawable.bgimage11),
            contentDescription = "Background Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(80.dp)
        ) {
            Text(
                "Auto",
                color = Color.White,
                fontSize = 18.sp,
                modifier = Modifier.padding(8.dp)
            )
            Switch(checked = true, onCheckedChange = { /* Handle Auto/Manual Toggle */ })
            Text(
                "Manual",
                color = Color.White,
                fontSize = 18.sp,
                modifier = Modifier.padding(8.dp)
            )
        }


        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 35.dp),
            contentAlignment = Alignment.Center
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painter = painterResource(id = R.drawable.backicon),
                    contentDescription = "Go back",
                    modifier = Modifier
                        .size(36.dp)
                        .clickable { navController.navigate("imageCapture") }
                )
                Spacer(modifier = Modifier.weight(1f)) // This spacer helps distribute space
            }

            Text(
                text = "Auto Capture",
                color = Color.White,
                fontSize = 30.sp,
                modifier = Modifier.align(Alignment.Center)
            )
        }

        // Main Content
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            // Check for permission state and act accordingly
            if (permissionState.value) {
                // Show Camera Preview in the Center
                CameraPreviewScreen(
                    focusPoint = null,
                    onFocusPointChange = {},
                    navController = navController
                )
            } else {
                // Request Permissions and show a message
                LaunchedEffect(Unit) {
                    requestPermissionLauncher.launch(Manifest.permission.CAMERA)
                }
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
        ) {
            Image(
                painter = painterResource(id = R.drawable.steps_2), // Replace with your footer image resource
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()

            )
        }
    }
}

@Composable
fun CameraPreviewScreen(focusPoint: Pair<Float, Float>?, onFocusPointChange: (Pair<Float, Float>) -> Unit,navController: NavController) {
    val context = LocalContext.current as ComponentActivity
    val lifecycleOwner = LocalLifecycleOwner.current
    val cameraExecutor = remember { Executors.newSingleThreadExecutor() }
    var imageCapture: ImageCapture? by remember { mutableStateOf(null) }
    var cameraControl: CameraControl? by remember { mutableStateOf(null) }
    var cameraInfo: CameraInfo? by remember { mutableStateOf(null) }
    val previewView = remember { PreviewView(context) }
    var cameraSelector by remember { mutableStateOf(CameraSelector.DEFAULT_BACK_CAMERA) }

    // Camera setup
    LaunchedEffect(Unit) {
        setupCamera(
            previewView,
            lifecycleOwner,
            context,
            cameraExecutor,
            CameraSelector.DEFAULT_BACK_CAMERA
        ) { imageCaptureObj, cameraControlObj, cameraInfoObj ->
            imageCapture = imageCaptureObj
            cameraControl = cameraControlObj
            cameraInfo = cameraInfoObj
        }
    }

    // Centered Camera Preview
    Box(
        modifier = Modifier
            .width(300.dp) // Width of the camera preview
            .height(450.dp) // Height of the camera preview
            .background(Color.Black),
        contentAlignment = Alignment.Center
    ) {
        AndroidView(factory = { previewView }, modifier = Modifier.fillMaxSize()) { view ->
            view.setOnTouchListener { _, event ->
                if (event.action == MotionEvent.ACTION_DOWN) {
                    focusOnTouch(event.x, event.y, cameraControl, previewView)
                    onFocusPointChange(Pair(event.x, event.y))
                }
                true
            }
            addPinchToZoomGesture(view, cameraControl, cameraInfo)
        }

        // Draw a focus square if focusing
        focusPoint?.let { (x, y) ->
            Canvas(modifier = Modifier.fillMaxSize()) {
                drawFocusSquare(x, y)
            }
        }
        // Camera control buttons
        Box(
            modifier = Modifier
                .size(70.dp)
                .offset(y = (-10).dp)
                .border(BorderStroke(3.dp, Color.LightGray), CircleShape) // Outer light gray border
                .padding(5.dp,)
                .align(Alignment.BottomCenter)
                .border(BorderStroke(3.dp, Color.White), CircleShape) // Inner white border
                .background(Color.White, CircleShape) // Inner circle with white background
                .clickable {
                    captureImage(context, imageCapture, navController)  // Pass navController here
                },
            contentAlignment = Alignment.Center
        ) {
            // Empty center, as per design (plain circular button with no text or icon)
        }

        // Switch Camera Button in the Right Corner
        Box(
            modifier = Modifier
                .size(70.dp)
                .align(Alignment.BottomEnd)
                .padding(10.dp, bottom = 10.dp)
               // .background(Color.DarkGray, CircleShape) // Circular shape with dark gray color
                .clickable { // Handle click event
                    cameraSelector = if (cameraSelector == CameraSelector.DEFAULT_BACK_CAMERA) {
                        CameraSelector.DEFAULT_FRONT_CAMERA
                    } else {
                        CameraSelector.DEFAULT_BACK_CAMERA
                    }
                    setupCamera(previewView, lifecycleOwner, context, cameraExecutor, cameraSelector) { imageCaptureObj, cameraControlObj, cameraInfoObj ->
                        imageCapture = imageCaptureObj
                        cameraControl = cameraControlObj
                        cameraInfo = cameraInfoObj
                    }
                },
            contentAlignment = Alignment.Center
        ) {
            // Refresh/rotate icon (you can replace this with an actual icon in your app)
            Text("⟳", color = Color.White, fontSize = 34.sp) // Placeholder for rotate icon
        }

    }
}

fun DrawScope.drawFocusSquare(x: Float, y: Float) {
    val size = 100f
    drawRect(
        color = Color.Yellow,
        topLeft = androidx.compose.ui.geometry.Offset(x - size / 2, y - size / 2),
        size = androidx.compose.ui.geometry.Size(size, size),
        style = androidx.compose.ui.graphics.drawscope.Stroke(width = 3f)
    )
}


fun setupCamera(
    previewView: PreviewView,
    lifecycleOwner: LifecycleOwner,
    context: ComponentActivity,
    cameraExecutor: ExecutorService,
    cameraSelector: CameraSelector,
    onImageCaptureReady: (ImageCapture, CameraControl, CameraInfo) -> Unit
) {
    val cameraProviderFuture = ProcessCameraProvider.getInstance(context)

    cameraProviderFuture.addListener({
        val cameraProvider = cameraProviderFuture.get()

        val preview = Preview.Builder().build().also {
            it.setSurfaceProvider(previewView.surfaceProvider)
        }

        val imageCapture = ImageCapture.Builder().build()

        try {
            cameraProvider.unbindAll()

            // Bind the camera lifecycle
            val camera = cameraProvider.bindToLifecycle(
                lifecycleOwner, cameraSelector, preview, imageCapture
            )
            val cameraControl = camera.cameraControl
            val cameraInfo = camera.cameraInfo
            onImageCaptureReady(imageCapture, cameraControl, cameraInfo)

        } catch (e: Exception) {
            Toast.makeText(context, "Failed to open camera: ${e.message}", Toast.LENGTH_SHORT).show()
        }

    }, ContextCompat.getMainExecutor(context))
}
//
//fun captureImage(context: ComponentActivity, imageCapture: ImageCapture?) {
//    val photoFile = File(
//        context.externalMediaDirs.first(),
//        "photo_${System.currentTimeMillis()}.jpg"
//    )
//
//    val outputOptions = ImageCapture.OutputFileOptions.Builder(photoFile).build()
//
//    imageCapture?.takePicture(
//        outputOptions,
//        ContextCompat.getMainExecutor(context),
//        object : ImageCapture.OnImageSavedCallback {
//            override fun onImageSaved(outputFileResults: ImageCapture.OutputFileResults) {
//                Toast.makeText(context, "Image saved to: ${photoFile.absolutePath}", Toast.LENGTH_SHORT).show()
//            }
//
//            override fun onError(exception: ImageCaptureException) {
//                Toast.makeText(context, "Failed to capture image: ${exception.message}", Toast.LENGTH_SHORT).show()
//            }
//        })
//}

// In your captureImage function, modify it to use File URI:
fun captureImage(context: ComponentActivity, imageCapture: ImageCapture?, navController: NavController) {
    val photoFile = File(
        context.externalMediaDirs.first(),
        "photo_${System.currentTimeMillis()}.jpg"
    )

    val outputOptions = ImageCapture.OutputFileOptions.Builder(photoFile).build()

    imageCapture?.takePicture(
        outputOptions,
        ContextCompat.getMainExecutor(context),
        object : ImageCapture.OnImageSavedCallback {
            override fun onImageSaved(outputFileResults: ImageCapture.OutputFileResults) {
                // Use the file path instead of URI
                val filePath = photoFile.absolutePath
                // Encode the file path to make it URL safe
                val encodedPath = Uri.encode(filePath)
                navController.navigate("imagecapturestatus/$encodedPath")
            }

            override fun onError(exception: ImageCaptureException) {
                Toast.makeText(
                    context,
                    "Failed to capture image: ${exception.message}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    )
}

private fun focusOnTouch(x: Float, y: Float, cameraControl: CameraControl?, previewView: PreviewView) {
    val pointFactory = previewView.meteringPointFactory
    val point = pointFactory.createPoint(x / previewView.width, y / previewView.height)
    val action = FocusMeteringAction.Builder(point).build()
    cameraControl?.startFocusAndMetering(action)
}



fun addPinchToZoomGesture(view: PreviewView, cameraControl: CameraControl?, cameraInfo: CameraInfo?) {
    val scaleGestureDetector = ScaleGestureDetector(view.context, object : ScaleGestureDetector.SimpleOnScaleGestureListener() {
        override fun onScale(detector: ScaleGestureDetector): Boolean {
            val currentZoomRatio = cameraInfo?.zoomState?.value?.zoomRatio ?: 1f
            val delta = detector.scaleFactor
            cameraControl?.setZoomRatio(currentZoomRatio * delta)
            return true
        }
    })
    view.setOnTouchListener { _, event ->
        scaleGestureDetector.onTouchEvent(event)
        true
    }
}
