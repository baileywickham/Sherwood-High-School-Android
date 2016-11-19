package com.github.bradypierce.sherwoodhighschool.Student

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import android.util.SparseArray
import android.view.*
import android.widget.TextView
import com.bluelinelabs.conductor.Controller
import com.github.bradypierce.sherwoodhighschool.R
import com.github.bradypierce.sherwoodhighschool.Utils.bindView

/**
 * Created by bradypierce on 9/10/16.
 */

class StudentController: Controller() {

    val surfaceView: SurfaceView by bindView(R.id.surface_student_view)
    val textView: TextView by bindView(R.id.text_student_view)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view: View = inflater.inflate(R.layout.controller_student, container, false)
        return view
    }

    override fun onAttach(view: View) {
        /*var barcodeDetector = BarcodeDetector.Builder(applicationContext).build()
        var cameraSource = CameraSource.Builder(applicationContext, barcodeDetector).setRequestedPreviewSize(640, 480).build()
        surfaceView.holder.addCallback(object : SurfaceHolder.Callback {
            override fun surfaceChanged(holder: SurfaceHolder?, format: Int, width: Int, height: Int) {

            }

            override fun surfaceCreated(holder: SurfaceHolder?) {
                try {
                    cameraSource.start(surfaceView.holder)
                } catch (e: IOException) {

                }
            }

            override fun surfaceDestroyed(holder: SurfaceHolder?) {
                cameraSource.stop()
            }
        })

        barcodeDetector.setProcessor(object : Detector.Processor<Barcode> {
            override fun receiveDetections(detections: Detector.Detections<Barcode>?) {
                var barcodes = detections?.detectedItems
                if (barcodes?.size() != 0) {
                    textView.post {
                        textView.text = barcodes?.valueAt(0)?.displayValue
                    }
                }
            }

            override fun release() {

            }
        })*/
    }

}