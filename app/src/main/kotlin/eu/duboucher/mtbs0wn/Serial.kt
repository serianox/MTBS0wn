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

    fun generateSerial() : Serial {
      return Serial(id = RANDOM.nextInt(10000))
    }
  }
}