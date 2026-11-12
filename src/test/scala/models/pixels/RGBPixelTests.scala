package models.pixels

import org.scalatest.funsuite.AnyFunSuite

class RGBPixelTests extends AnyFunSuite{
  test("creation with R: 100, G: 120, B: 140") {
    var tmp =RGBPixel(100, 120, 140)
    assert(tmp.red == 100)
    assert(tmp.green == 120)
    assert(tmp.blue == 140)
  }
  
  test("creation with red < 0"){
    assertThrows[Exception] {
      RGBPixel(-1, 123, 123)
    }
  }
  
  test("creation with red > 255") {
    assertThrows[Exception] {
      RGBPixel(256, 123, 123)
    }
  }
  
  test("creation with green < 0") {
    assertThrows[Exception] {
      RGBPixel(123, -1, 123)
    }
  }

  test("creation with green > 255") {
    assertThrows[Exception] {
      RGBPixel(123, 256, 123)
    }
  }

  test("cretion with blue < 0") {
    assertThrows[Exception] {
      RGBPixel(123, 123, -1)
    }
  }

  test("cretion with blue > 255") {
    assertThrows[Exception] {
      RGBPixel(123, 123, 256)
    }
  }



}
