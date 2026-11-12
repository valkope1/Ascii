package models.pixels

import org.scalatest.funsuite.AnyFunSuite

class AsciiPixelTests extends AnyFunSuite{
  test("Creation with H"){
    val asciiPixel: AsciiPixel =  AsciiPixel('H')
    assert(asciiPixel.symbol == 'H')
  }
  
  test("creation with S"){
    val asciiPixel: AsciiPixel = AsciiPixel('S')
    assert(asciiPixel.symbol == 'S')
  }

  test("creation with 1") {
    val asciiPixel: AsciiPixel = AsciiPixel('1')
    assert(asciiPixel.symbol == '1')
  }
  
  

}
