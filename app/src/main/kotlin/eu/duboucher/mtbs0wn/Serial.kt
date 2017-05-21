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

  private fun f(v : Int) : String {
    return "%01d".format(v)
  }

  private fun f2(v : Int) : String {
    return "%02d".format(v)
  }

  private fun f4(v : Int) : String {
    return "%04d".format(v)
  }

  fun encodeAsString() : String {
    return "C69070${f4(v1)}04${f(c)}${f4(id)}205${f2(v2)}${f(month)}${f2(day)}"
  }

  companion object {
    private val RANDOM = Random()

    fun createNew() : Serial {
      return Serial(id = RANDOM.nextInt(10000))
    }
  }
}