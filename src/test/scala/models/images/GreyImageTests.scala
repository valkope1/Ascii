package models.images

import models.pixels.GreyPixel
import org.scalatest.funsuite.AnyFunSuite

class GreyImageTests extends AnyFunSuite{
  var array: Array[Array[GreyPixel]] = Array(Array(GreyPixel(123)))
  
  test("creation with 0 < width < 1920") {
    assertThrows[Exception] {
      GreyImage(-1, 1, array)
    }
    assertThrows[Exception] {
      GreyImage(2000, 1, array)
    }
    GreyImage(1, 1, array)
  }

  test("creation with 0 < height < 1080") {
    assertThrows[Exception] {
      GreyImage(1, -1, array)
    }
    assertThrows[Exception] {
      GreyImage(1, 2000, array)
    }
    GreyImage(1, 1, array)
  }

  test("number of pixels") {
    assertThrows[Exception] {
      GreyImage(1920, 1080, array)
    }
    GreyImage(1, 1, array)
  }

  test("getPixel") {
    val greyImage: GreyImage = GreyImage(1, 1, array)
    assertThrows[Exception] {
      greyImage.getPixel(-1, 0)
      greyImage.getPixel(0, -1)
      greyImage.getPixel(10, 0)
      greyImage.getPixel(0, 10)
    }
    assert(greyImage.getPixel(0, 0) == array(0)(0))
  }

}
