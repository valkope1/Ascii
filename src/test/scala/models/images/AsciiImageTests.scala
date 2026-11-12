package models.images

import models.pixels.AsciiPixel
import org.scalatest.funsuite.AnyFunSuite

class AsciiImageTests extends AnyFunSuite{
  var array: Array[Array[AsciiPixel]] = Array(Array(AsciiPixel('H')))

  test("creation with 0 < width < 1920"){
    assertThrows[Exception]{
      AsciiImage(-1, 1, array)
    }
    assertThrows[Exception] {
      AsciiImage(2000, 1, array)
    }
    AsciiImage(1, 1, array)
  }

  test("creation with 0 < height < 1080") {
    assertThrows[Exception] {
      AsciiImage(1, -1, array)
    }
    assertThrows[Exception] {
      AsciiImage(1, 2000, array)
    }
    AsciiImage(1, 1, array)
  }
  
  test("number of pixels") {
    assertThrows[Exception]{
      AsciiImage(1920, 1080, array)
    }
    AsciiImage(1, 1, array)
  }
  
  test("getPixel"){
    val asciiImage: AsciiImage = AsciiImage(1, 1, array)
    assertThrows[Exception]{
      asciiImage.getPixel(-1 , 0)
      asciiImage.getPixel(0, -1)
      asciiImage.getPixel(10, 0)
      asciiImage.getPixel(0, 10)
    }
    assert(asciiImage.getPixel(0, 0) == array(0)(0))
  }
}
