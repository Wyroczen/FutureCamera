package com.wyroczen.futurecamera.reflection

import android.hardware.camera2.CameraCaptureSession
import android.hardware.camera2.CameraDevice
import android.hardware.camera2.params.InputConfiguration
import android.os.Build
import android.os.Handler
import androidx.annotation.RequiresApi
import java.lang.reflect.Method


class ReflectionHelperKotlin internal constructor() {
    @get:RequiresApi(api = Build.VERSION_CODES.M)
    val customCaptureSessionMethodObject: Method?
        get() {
            var customCaptureSession: Method? = null
            try {
                customCaptureSession = CameraDevice::class.java.getDeclaredMethod(
                    "createCustomCaptureSession", InputConfiguration::class.java, MutableList::class.java, Int::class.javaPrimitiveType, CameraCaptureSession.StateCallback::class.java, Handler::class.java)
                customCaptureSession.isAccessible = true
            } catch (e: NoSuchMethodException) {
                e.printStackTrace()
            }
            return customCaptureSession
        }


}