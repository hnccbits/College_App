package bitsindri.hncc.collegeapp.activities

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import bitsindri.hncc.collegeapp.R
import bitsindri.hncc.collegeapp.activities.CameraDialog.DialogListener
import yuku.ambilwarna.AmbilWarnaDialog
import java.util.*
import kotlin.properties.Delegates

class FoundFirstActivity : AppCompatActivity(), DialogListener {

    lateinit var btn_next: Button
    lateinit var photo: ImageView
    lateinit var main_fill:Button
    lateinit var second_fill:Button
    lateinit var maincolor:LinearLayout
    lateinit var secondcolor:LinearLayout
    var mDefaultColor by Delegates.notNull<Int>()

    lateinit var  toolbar: Toolbar
    var mDefaultColorSecond by Delegates.notNull<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_found_first)
        btn_next = findViewById(R.id.btn_next)
        photo = findViewById(R.id.photo)
        main_fill = findViewById(R.id.main_fill)
        second_fill = findViewById(R.id.second_fill)
        maincolor = findViewById(R.id.maincolor)
        secondcolor = findViewById( R.id.secondcolor)

        toolbar = findViewById(R.id.toolbar)

        setSupportActionBar(toolbar)
        supportActionBar?.setTitle("Found First Activity")

        mDefaultColor = ContextCompat.getColor(this,R.color.colorPrimary)
        mDefaultColorSecond = ContextCompat.getColor(this,R.color.colorPrimaryDark)

        maincolor.setOnClickListener{
            openColorPicker()
        }
        secondcolor.setOnClickListener{
            openColorPickerSecond()
        }

        btn_next.setOnClickListener(View.OnClickListener { startActivity(Intent(this@FoundFirstActivity, FoundSecondActivity::class.java)) })
        photo.setOnClickListener(View.OnClickListener { openDialog() })
    }

    private fun openColorPickerSecond() {

        val colorPickerDialog = AmbilWarnaDialog(this,mDefaultColorSecond,object:AmbilWarnaDialog.OnAmbilWarnaListener{
            override fun onCancel(dialog: AmbilWarnaDialog?) {

            }

            override fun onOk(dialog: AmbilWarnaDialog?, color: Int) {

                mDefaultColorSecond = color
                second_fill.setBackgroundColor(mDefaultColorSecond)


            }


        })
        colorPickerDialog.show()

    }


    private fun openColorPicker() {
      val colorPickerDialog = AmbilWarnaDialog(this,mDefaultColor,object:AmbilWarnaDialog.OnAmbilWarnaListener{
          override fun onCancel(dialog: AmbilWarnaDialog?) {

          }

          override fun onOk(dialog: AmbilWarnaDialog?, color: Int) {

                  mDefaultColor = color
                  main_fill.setBackgroundColor(mDefaultColor)

          }


      })
        colorPickerDialog.show()
    }

    private fun openDialog() {
        val cameraDialog = CameraDialog()
        cameraDialog.show(supportFragmentManager, "example dialog")
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == RESULT_OK && requestCode == IMAGE_PICK_CODE && data != null) {
            photo.setImageURI(data.data)
        } else if (requestCode == CAMERA_ACTION_CODE && resultCode == RESULT_OK && data != null) {
            val bundle = data.extras
            val finalPhoto = bundle!!["data"] as Bitmap?
            photo.setImageBitmap(finalPhoto)
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

    @SuppressLint("QueryPermissionsNeeded")
    override fun selectOptions(b: Boolean, i: Int) {
        if (b && i == 4) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) { //system is greater than marshmallow
                if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
                    val permissions = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE)
                    requestPermissions(permissions, PERMISSION_CODE)
                } else {
                    pickImageFromGallery()
                }
            } else {
                pickImageFromGallery()
            }
        } else if (b && i == 3) {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) { //system is greater than marshmallow
                if (checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_DENIED ||
                        checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
                    val permissions = arrayOf(Manifest.permission.CAMERA,Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    requestPermissions(permissions, PERMISSION_CODE_CAMERA)
                } else {
                     takePicture()

                }
            } else {

                takePicture()
            }

        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        when (requestCode) {
            PERMISSION_CODE -> {
                if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    pickImageFromGallery()
                } else {
                    Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show()
                }
            }
            PERMISSION_CODE_CAMERA ->{

                if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    takePicture()
                } else {
                    Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show()
                }

            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    private fun pickImageFromGallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, IMAGE_PICK_CODE)
    }
    @SuppressLint("QueryPermissionsNeeded")
    private fun takePicture(){

        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        if (intent.resolveActivity(packageManager) != null) {
            startActivityForResult(intent, CAMERA_ACTION_CODE)
        } else {
            Toast.makeText(this, "There is no app that supports this action", Toast.LENGTH_SHORT).show()
        }

    }

    companion object {
        private const val CAMERA_ACTION_CODE = 6
        private const val PERMISSION_CODE = 5
        private const val IMAGE_PICK_CODE = 2
        private const val PERMISSION_CODE_CAMERA = 7
    }
}