//
//package com.example.android_strepapp
//
//import android.Manifest
//import android.content.pm.PackageManager
//import android.widget.Toast
//import androidx.activity.ComponentActivity
//import androidx.activity.result.contract.ActivityResultContracts
//import androidx.camera.core.CameraSelector
//import androidx.camera.core.ImageCapture
//import androidx.camera.core.ImageCaptureException
//import androidx.camera.core.Preview
//import androidx.camera.core.CameraControl
//import androidx.camera.core.CameraInfo
//import androidx.camera.lifecycle.ProcessCameraProvider
//import androidx.camera.view.PreviewView
//import androidx.compose.foundation.Canvas
//import androidx.compose.foundation.background
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.shape.CircleShape
//import androidx.compose.material3.Button
//import androidx.compose.material3.Text
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.graphics.drawscope.DrawScope
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.platform.LocalLifecycleOwner
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.viewinterop.AndroidView
//import androidx.core.content.ContextCompat
//import androidx.lifecycle.LifecycleOwner
//import android.view.ScaleGestureDetector
//import android.view.MotionEvent
//import androidx.activity.compose.rememberLauncherForActivityResult
//import androidx.camera.core.FocusMeteringAction
//import androidx.compose.foundation.BorderStroke
//import androidx.compose.foundation.border
//import androidx.compose.ui.unit.sp
//import java.io.File
//import java.util.concurrent.ExecutorService
//import java.util.concurrent.Executors
//
//@Composable
//fun ImageCaptureScreen() {
//    var showCamera by remember { mutableStateOf(false) }
//    var focusPoint by remember { mutableStateOf<Pair<Float, Float>?>(null) }
//    val context = LocalContext.current as ComponentActivity
//
//    // Request camera permission
//    val requestPermissionLauncher = rememberLauncherForActivityResult(
//        contract = ActivityResultContracts.RequestPermission()
//    ) { isGranted: Boolean ->
//        if (isGranted) {
//            showCamera = true
//        } else {
//            Toast.makeText(context, "Camera permission is required to use the camera.", Toast.LENGTH_SHORT).show()
//        }
//    }
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(16.dp),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        if (showCamera) {
//            // Show the camera preview and focus square
//            CameraPreviewScreen(focusPoint) { point ->
//                focusPoint = point
//            }
//        } else {
//            // Button to request camera permission
//            Button(onClick = {
//                when {
//                    ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED -> {
//                        showCamera = true
//                    }
//                    else -> {
//                        requestPermissionLauncher.launch(Manifest.permission.CAMERA)
//                    }
//                }
//            }) {
//                Text("Open Camera")
//            }
//        }
//    }
//}
//
//@Composable
//fun CameraPreviewScreen(focusPoint: Pair<Float, Float>?, onFocusPointChange: (Pair<Float, Float>) -> Unit) {
//    val context = LocalContext.current as ComponentActivity
//    val lifecycleOwner = LocalLifecycleOwner.current
//    val cameraExecutor = remember { Executors.newSingleThreadExecutor() }
//    var imageCapture: ImageCapture? by remember { mutableStateOf(null) }
//    var cameraControl: CameraControl? by remember { mutableStateOf(null) }
//    var cameraInfo: CameraInfo? by remember { mutableStateOf(null) }
//    val previewView = remember { PreviewView(context) }
//    var cameraSelector by remember { mutableStateOf(CameraSelector.DEFAULT_BACK_CAMERA) }
//
//    LaunchedEffect(Unit) {
//        setupCamera(previewView, lifecycleOwner, context, cameraExecutor, cameraSelector) { imageCaptureObj, cameraControlObj, cameraInfoObj ->
//            imageCapture = imageCaptureObj
//            cameraControl = cameraControlObj
//            cameraInfo = cameraInfoObj
//        }
//    }
//
//    Box(modifier = Modifier.fillMaxSize()) {
//        // Handle touch events for focusing
//        AndroidView(factory = { previewView }, modifier = Modifier.fillMaxSize()) { view ->
//            // Set touch listener for focusing
//            view.setOnTouchListener { _, event ->
//                if (event.action == MotionEvent.ACTION_DOWN) {
//                    // Focus where the user touched
//                    focusOnTouch(event.x, event.y, cameraControl, previewView)
//                    onFocusPointChange(Pair(event.x, event.y))
//                }
//                true
//            }
//            // Add pinch-to-zoom gesture
//            addPinchToZoomGesture(view, cameraControl, cameraInfo)
//        }
//
//        // Draw the focus square if focusPoint is set
//        focusPoint?.let { (x, y) ->
//            DrawFocusSquare(x, y)
//        }
//        // Camera control buttons
//        Box(
//            modifier = Modifier
//                .align(Alignment.BottomCenter)
//                .padding(16.dp)
//        ) {
//            // Centered Capture Image Button
//            Box(
//                modifier = Modifier
//                    .size(70.dp)
//                    .border(BorderStroke(3.dp, Color.LightGray), CircleShape) // Outer light gray border
//                    .padding(3.dp)
//                    .border(BorderStroke(3.dp, Color.White), CircleShape) // Inner white border
//                    .background(Color.White, CircleShape) // Inner circle with white background
//                    .clickable { // Handle click event
//                        captureImage(context, imageCapture)
//                    },
//                contentAlignment = Alignment.Center
//            ) {
//                // Empty center, as per design (plain circular button with no text or icon)
//            }
//        }
//
//        // Switch Camera Button in the Right Corner
//        Box(
//            modifier = Modifier
//                .size(70.dp)
//                .align(Alignment.BottomEnd)
//                .padding(10.dp)
//                .background(Color.DarkGray, CircleShape) // Circular shape with dark gray color
//                .clickable { // Handle click event
//                    cameraSelector = if (cameraSelector == CameraSelector.DEFAULT_BACK_CAMERA) {
//                        CameraSelector.DEFAULT_FRONT_CAMERA
//                    } else {
//                        CameraSelector.DEFAULT_BACK_CAMERA
//                    }
//                    setupCamera(previewView, lifecycleOwner, context, cameraExecutor, cameraSelector) { imageCaptureObj, cameraControlObj, cameraInfoObj ->
//                        imageCapture = imageCaptureObj
//                        cameraControl = cameraControlObj
//                        cameraInfo = cameraInfoObj
//                    }
//                },
//            contentAlignment = Alignment.Center
//        ) {
//            // Refresh/rotate icon (you can replace this with an actual icon in your app)
//            Text("⟳", color = Color.White, fontSize = 34.sp) // Placeholder for rotate icon
//        }
//
//    }
//}
//
//
//@Composable
//fun DrawFocusSquare(x: Float, y: Float) {
//    Canvas(modifier = Modifier.fillMaxSize()) {
//        drawFocusSquare(x, y)
//    }
//}
//
//fun DrawScope.drawFocusSquare(x: Float, y: Float) {
//    val squareSize = 100f
//    val halfSize = squareSize / 2
//    drawRect(
//        color = Color.Yellow,
//        topLeft = androidx.compose.ui.geometry.Offset(x - halfSize, y - halfSize),
//        size = androidx.compose.ui.geometry.Size(squareSize, squareSize),
//        style = androidx.compose.ui.graphics.drawscope.Fill
//    )
//}
//
//fun setupCamera(
//    previewView: PreviewView,
//    lifecycleOwner: LifecycleOwner,
//    context: ComponentActivity,
//    cameraExecutor: ExecutorService,
//    cameraSelector: CameraSelector,
//    onImageCaptureReady: (ImageCapture, CameraControl, CameraInfo) -> Unit
//) {
//    val cameraProviderFuture = ProcessCameraProvider.getInstance(context)
//
//    cameraProviderFuture.addListener({
//        val cameraProvider = cameraProviderFuture.get()
//
//        val preview = Preview.Builder().build().also {
//            it.setSurfaceProvider(previewView.surfaceProvider)
//        }
//
//        val imageCapture = ImageCapture.Builder().build()
//
//        try {
//            cameraProvider.unbindAll()
//
//            // Bind the camera lifecycle
//            val camera = cameraProvider.bindToLifecycle(
//                lifecycleOwner, cameraSelector, preview, imageCapture
//            )
//            val cameraControl = camera.cameraControl
//            val cameraInfo = camera.cameraInfo
//            onImageCaptureReady(imageCapture, cameraControl, cameraInfo)
//
//        } catch (e: Exception) {
//            Toast.makeText(context, "Failed to open camera: ${e.message}", Toast.LENGTH_SHORT).show()
//        }
//
//    }, ContextCompat.getMainExecutor(context))
//}
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
//
//// Focus on touch event
//private fun focusOnTouch(x: Float, y: Float, cameraControl: CameraControl?, previewView: PreviewView) {
//    val pointFactory = previewView.meteringPointFactory
//    val point = pointFactory.createPoint(x / previewView.width, y / previewView.height)
//    val action = FocusMeteringAction.Builder(point).build()
//
//    cameraControl?.startFocusAndMetering(action)?.addListener({
//        // Optional: You can add feedback for successful focus
//    }, ContextCompat.getMainExecutor(previewView.context))
//}
//
//// Zoom functionality
//fun setCameraZoom(cameraControl: CameraControl, zoomRatio: Float) {
//    cameraControl.setZoomRatio(zoomRatio)
//}
//
//fun addPinchToZoomGesture(view: PreviewView, cameraControl: CameraControl?, cameraInfo: CameraInfo?) {
//    val scaleGestureDetector = ScaleGestureDetector(view.context, object : ScaleGestureDetector.SimpleOnScaleGestureListener() {
//        override fun onScale(detector: ScaleGestureDetector): Boolean {
//            val currentZoomRatio = cameraInfo?.zoomState?.value?.zoomRatio ?: 1f
//            val delta = detector.scaleFactor
//            val newZoomRatio = currentZoomRatio * delta
//
//            // Update the camera zoom
//            cameraControl?.setZoomRatio(newZoomRatio)
//            return true
//        }
//    })
//
//    view.setOnTouchListener { _, event ->
//        scaleGestureDetector.onTouchEvent(event)
//        true
//    }
//}