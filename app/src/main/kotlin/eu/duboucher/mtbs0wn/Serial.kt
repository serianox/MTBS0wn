package eu.duboucher.mtbs0wn

import java.util.Random

/**
* Serial. Checksum implementation left to the user. :)
*/
internal data class Serial constructor(
    val v1 : Int = 9183,
    val v2 : Int = 53,
    val month : Int = 9,
    val day : Int = 30,
    val id : Int,
    val c : Int = 0
  ) {

  companion object {
    private val RANDOM = Random()

    private fun f(v : Int) : String {
      return "%01d".format(v)
    }

    private fun f2(v : Int) : String {
      return "%02d".format(v)
    }

    private fun f4(v : Int) : String {
      return "%04d".format(v)
    }

    fun encodeSerial(serial : Serial) : String {
      return "C69070${f4(serial.v1)}04${f(serial.c)}${f4(serial.id)}205${f2(serial.v2)}${f(serial.month)}${f2(serial.day)}"
    }

    fun generateSerial() : Serial {
      return Serial(id = RANDOM.nextInt(10000))
    }
  }
}