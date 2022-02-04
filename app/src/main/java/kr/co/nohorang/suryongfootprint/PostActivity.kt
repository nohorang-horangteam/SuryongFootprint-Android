package kr.co.nohorang.suryongfootprint

import android.Manifest
import android.app.Activity
import android.app.AlertDialog
import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.constraintlayout.widget.ConstraintLayout
import kr.co.nohorang.suryongfootprint.databinding.ActivityMainBinding
import kr.co.nohorang.suryongfootprint.databinding.ActivityPostBinding
import java.io.IOException
import java.lang.Exception
import java.text.SimpleDateFormat
import android.content.DialogInterface
import android.graphics.Color

class PostActivity : BaseActivity() {
    val PERM_STORAGE = 99
    val PERM_CAMERA = 100
    val REQ_CAMERA = 101
    val REQ_STORAGE = 102

    val binding by lazy { ActivityPostBinding.inflate(layoutInflater) }

    var realUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // 툴바 뒤로가기 버튼 - 액티비티 종료
        binding.backBtn.setOnClickListener {
            finish()
        }

        // EditText 입력 중 외부 터치 시 키보드 내리기
        binding.layout.setOnClickListener {
            hideKeyboard(binding.postContentEditText)
        }
        binding.linear.setOnClickListener {
            hideKeyboard(binding.postContentEditText)
        }

        // 인증 버튼 - 액티비티 종료 (+ DB에 저장)
        binding.postBtn.setOnClickListener {
            Toast.makeText(this, "인증이 업로드되었습니다.", Toast.LENGTH_SHORT).show()
            finish()
        }

        binding.imagePreview.setOnClickListener {
            // 갤러리 또는 카메라 선택
            val items = arrayOf<CharSequence>("카메라", "갤러리")
            val alertDialogBuilder: AlertDialog.Builder = AlertDialog.Builder(this)

            // 알림창 제목 및 선택지 설정
            alertDialogBuilder.setTitle("인증 사진 첨부 방법")
            alertDialogBuilder.setItems(items,
                DialogInterface.OnClickListener { dialog, id ->
                    when (items[id].toString()) {
                        "카메라" -> requirePermissions(
                            arrayOf(Manifest.permission.CAMERA),
                            PERM_CAMERA
                        )
                        "갤러리" -> requirePermissions(
                            arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                            PERM_STORAGE
                        )
                    }
                    dialog.dismiss()
                })

            // 다이얼로그 생성
            val alertDialog: AlertDialog = alertDialogBuilder.create()

            // 다이얼로그 보여주기
            alertDialog.show()
        }
    }

    // 권한 허용 선택
    override fun permissionGranted(requestCode: Int) {
        when (requestCode) {
            PERM_STORAGE -> openGallery()
            PERM_CAMERA -> openCamera()
        }
    }

    // 권한 거부 선택
    override fun permissionDenied(requestCode: Int) {
        when (requestCode) {
            PERM_STORAGE -> Toast.makeText(
                baseContext,
                "갤러리 접근 권한을 승인해야 인증할 수 있습니다.",
                Toast.LENGTH_SHORT
            ).show()
            PERM_CAMERA -> Toast.makeText(
                baseContext,
                "카메라 권한을 승인해야 인증할 수 있습니다.",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    // 갤러리 실행
    fun openGallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = MediaStore.Images.Media.CONTENT_TYPE
        startActivityForResult(intent, REQ_STORAGE)
    }

    // 카메라 실행
    fun openCamera() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

        createImageUri(newFileName(), "image/jpg")?.let { uri ->
            realUri = uri
            intent.putExtra(MediaStore.EXTRA_OUTPUT, realUri)
            startActivityForResult(intent, REQ_CAMERA)
        }
    }

    fun createImageUri(filename: String, mimeType: String): Uri? {
        var values = ContentValues()
        values.put(MediaStore.Images.Media.DISPLAY_NAME, filename)
        values.put(MediaStore.Images.Media.MIME_TYPE, mimeType)
        return contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values)
    }

    fun newFileName(): String {
        val sdf = SimpleDateFormat("yyyyMMdd__HHmmSS")
        val filename = sdf.format(System.currentTimeMillis())
        return "$filename.jpg"
    }

    fun loadBitmap(photoUri: Uri): Bitmap? {
        var image: Bitmap? = null
        try {
            image = if (Build.VERSION.SDK_INT > 27) {
                val source: ImageDecoder.Source =
                    ImageDecoder.createSource(this.contentResolver, photoUri)
                ImageDecoder.decodeBitmap(source)
            } else {
                MediaStore.Images.Media.getBitmap(this.contentResolver, photoUri)
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return image
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK) {
            when (requestCode) {
                REQ_CAMERA -> {
                    realUri?.let { uri ->
                        val bitmap = loadBitmap(uri)
                        binding.imagePreview.setImageBitmap(bitmap)

                        realUri = null
                    }
                }
                REQ_STORAGE -> {
                    data?.data?.let { uri ->
                        binding.imagePreview.setImageURI(uri)
                    }
                }
            }
            binding.postBtn.setBackgroundColor(Color.parseColor("#ACC236"))
            binding.postBtn.isEnabled = true
        }
    }

    // 키보드 비활성화 함수
    fun hideKeyboard(editText: EditText) {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(editText.windowToken, 0)
    }
}