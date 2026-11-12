package models.pixels

import org.scalatest.funsuite.AnyFunSuite

class GreyPixelTests extends AnyFunSuite{
  test("good test - value 128"){
    var tmp = GreyPixel(128)
    assert(tmp.grey == 128)
  }
  
  test("good test - value 1") {
    var tmp = GreyPixel(1)
    assert(tmp.grey == 1)
  }
  
  test("good test - value 200") {
    var tmp = GreyPixel(200)
    assert(tmp.grey == 200)
  }
  
  test("creation with grey value < 0"){
    assertThrows[Exception]{
      GreyPixel(-1)
    }
  }
  test("creation with grey value > 255") {
    assertThrows[Exception] {
      GreyPixel(256)
    }
  }
}
