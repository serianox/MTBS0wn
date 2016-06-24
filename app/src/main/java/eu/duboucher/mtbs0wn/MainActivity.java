package eu.duboucher.mtbs0wn;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity {
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	private void updateReservationCode() {
		ReservationCode _newReservationCode = ReservationCode.createReservationCode();

		_newReservationCode.updateTextView((TextView) findViewById(R.id.reservation_code));
		_newReservationCode.updateImageView((ImageView) findViewById(R.id.reservation_qrcode));
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);

		updateReservationCode();
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		switch (event.getActionMasked()) {
			case MotionEvent.ACTION_UP:
				updateReservationCode();
				break;
		}

		return super.onTouchEvent(event);
	}
}
