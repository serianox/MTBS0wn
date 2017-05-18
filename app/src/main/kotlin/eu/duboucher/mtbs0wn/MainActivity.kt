package eu.duboucher.mtbs0wn

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.MotionEvent
import android.widget.ImageView
import android.widget.TextView

class MainActivity:AppCompatActivity() {
  private fun updateReservationCode() {
    val _newReservationCode = ReservationCode.createReservationCode()
    _newReservationCode.updateTextView(findViewById(R.id.reservation_code) as TextView)
    _newReservationCode.updateImageView(findViewById(R.id.reservation_qrcode) as ImageView)
  }

  override protected fun onCreate(savedInstanceState : Bundle?) {
    super.onCreate(savedInstanceState)

    setContentView(R.layout.activity_main)

    val toolbar = findViewById(R.id.toolbar) as Toolbar
    setSupportActionBar(toolbar)

    updateReservationCode()
  }

  override fun onTouchEvent(event : MotionEvent) : Boolean {
    when (event.getActionMasked()) {
      MotionEvent.ACTION_UP -> updateReservationCode()
    }

    return super.onTouchEvent(event)
  }
}