package eu.duboucher.mtbs0wn;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.util.logging.Logger;

/**
 * Reservation code.
 */
class ReservationCode {
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private final static QRCodeWriter QRCODE_WRITER = new QRCodeWriter();
	private final String _string;
	private final Bitmap _qrcode;

	private ReservationCode() {
		_string = encodeSerial(Serial.generateSerial());
		_qrcode = generateQRCode();
	}

	static ReservationCode createReservationCode() {
		return new ReservationCode();
	}

	private String f(int v) {
		return String.format("%d", v);
	}

	private String f2(int v) {
		return String.format("%02d", v);
	}

	private String f4(int v) {
		return String.format("%04d", v);
	}

	private String encodeSerial(Serial serial) {
		return "C69070" + f4(serial.v1) + "04" + f(serial.c) + f4(serial.id) + "205" + f2(serial.v2) + f(serial.month) + f2(serial.day);
	}

	private Bitmap generateQRCode() {
		LOGGER.info(String.format("Generate QRCode for reservation code %s", _string));

		try {
			BitMatrix __bitMatrix = QRCODE_WRITER.encode(_string, BarcodeFormat.QR_CODE, 512, 512);
			int __width = __bitMatrix.getWidth();
			int __height = __bitMatrix.getHeight();
			Bitmap __bmp = Bitmap.createBitmap(__width, __height, Bitmap.Config.RGB_565);
			for (int __x = 0; __x < __width; __x++) {
				for (int __y = 0; __y < __height; __y++) {
					__bmp.setPixel(__x, __y, __bitMatrix.get(__x, __y) ? Color.BLACK : Color.WHITE);
				}
			}
			return __bmp;

		} catch (WriterException e) {
			LOGGER.warning(e.toString());
			return Bitmap.createBitmap(0, 0, Bitmap.Config.RGB_565);
		}
	}

	void updateTextView(TextView target) {
		target.setText(_string);
	}

	void updateImageView(ImageView target) {
		target.setImageBitmap(_qrcode);
	}
}
