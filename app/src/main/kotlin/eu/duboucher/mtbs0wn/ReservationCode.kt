package eu.duboucher.mtbs0wn

import android.graphics.Bitmap
import android.graphics.Color
import android.widget.ImageView
import android.widget.TextView
import com.google.zxing.BarcodeFormat
import com.google.zxing.WriterException
import com.google.zxing.common.BitMatrix
import com.google.zxing.qrcode.QRCodeWriter
import java.util.logging.Logger

/**
* Reservation code.
*/
internal class ReservationCode private constructor() {
  private val _string : String
  private val _qrcode : Bitmap

  init {
    _string = Serial.createNew().encodeAsString()
    _qrcode = generateQRCode()
  }

  private fun generateQRCode() : Bitmap {
    LOGGER.info("Generate QRCode for reservation code $_string")

    try
    {
      val __bitMatrix = QRCODE_WRITER.encode(_string, BarcodeFormat.QR_CODE, 512, 512)
      val __width = __bitMatrix.getWidth()
      val __height = __bitMatrix.getHeight()
      val __bmp = Bitmap.createBitmap(__width, __height, Bitmap.Config.RGB_565)

      for (__x in 0..__width - 1)
      {
        for (__y in 0..__height - 1)
        {
          __bmp.setPixel(__x, __y, if (__bitMatrix.get(__x, __y)) Color.BLACK else Color.WHITE)
        }
      }

      return __bmp
    }
    catch (e : WriterException) {
      LOGGER.warning(e.toString())

      return Bitmap.createBitmap(0, 0, Bitmap.Config.RGB_565)
    }
  }

  fun updateTextView(target : TextView) {
    target.setText(_string)
  }

  fun updateImageView(target : ImageView) {
    target.setImageBitmap(_qrcode)
  }

  companion object {
    private val LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME)
    private val QRCODE_WRITER = QRCodeWriter()

    fun createReservationCode() : ReservationCode {
      return ReservationCode()
    }
  }
}