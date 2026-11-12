package models.images

import models.pixels.RGBPixel
import org.scalatest.funsuite.AnyFunSuite

class RGBImageTests extends AnyFunSuite{
  var array: Array[Array[RGBPixel]] = Array(Array(RGBPixel(1, 1, 1)))
  
  test("creation with 0 < width < 1920") {
    assertThrows[Exception] {
      RGBImage(-1, 1, array)
    }
    assertThrows[Exception] {
      RGBImage(2000, 1, array)
    }
    RGBImage(1, 1, array)
  }

  test("creation with 0 < height < 1080") {
    assertThrows[Exception] {
      RGBImage(1, -1, array)
    }
    assertThrows[Exception] {
      RGBImage(1, 2000, array)
    }
    RGBImage(1, 1, array)
  }

  test("number of pixels") {
    assertThrows[Exception] {
      RGBImage(1920, 1080, array)
    }
    RGBImage(1, 1, array)
  }

  test("getPixel") {
    val rgbImage: RGBImage = RGBImage(1, 1, array)
    assertThrows[Exception] {
      rgbImage.getPixel(-1, 0)
      rgbImage.getPixel(0, -1)
      rgbImage.getPixel(10, 0)
      rgbImage.getPixel(0, 10)
    }
    assert(rgbImage.getPixel(0, 0) == array(0)(0))
  }

}
