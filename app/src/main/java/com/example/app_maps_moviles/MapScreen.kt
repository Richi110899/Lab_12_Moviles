package com.example.lab12_maps

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.app_maps_moviles.R
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.rememberCameraPositionState
import com.google.maps.android.compose.rememberMarkerState
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.Marker

@Composable
fun MapScreen() {
  val ArequipaLocation = LatLng(-16.4040102, -71.559611) // Arequipa, Perú
  val cameraPositionState = rememberCameraPositionState {
    position = com.google.android.gms.maps.model.CameraPosition.fromLatLngZoom(ArequipaLocation, 12f)
  }

  Box(modifier = Modifier.fillMaxSize()) {
    // Añadir GoogleMap al layout
    GoogleMap(
      modifier = Modifier.fillMaxSize(),
      cameraPositionState = cameraPositionState
    ) {
      // Obtener el Bitmap desde los recursos
      val bitmap = BitmapFactory.decodeResource(LocalContext.current.resources, R.drawable.volcan)

      // Redimensiona la imagen a un tamaño más pequeño (por ejemplo 50x50 píxeles)
      val scaledBitmap: Bitmap = Bitmap.createScaledBitmap(bitmap, 70, 70, false)

      // Usar la imagen redimensionada para el marcador
      Marker(
        state = rememberMarkerState(position = ArequipaLocation),
        icon = BitmapDescriptorFactory.fromBitmap(scaledBitmap), // Usando la imagen redimensionada
        title = "Arequipa, Perú"
      )
    }
  }
}
