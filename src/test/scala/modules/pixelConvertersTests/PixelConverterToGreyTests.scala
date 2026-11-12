package modules.pixelConvertersTests

import models.pixels.RGBPixel
import modules.pixelConverters.PixelConverterToGrey
import org.scalatest.funsuite.AnyFunSuite

class PixelConverterToGreyTests extends AnyFunSuite{
  private val converter = PixelConverterToGrey()
  test("255red 0green 0blue"){
    var pixel = RGBPixel(255, 0, 0)
    var newPixel = converter.convert(pixel)
    assert(newPixel.grey == 76)
  }

  test("0red 255green 0blue") {
    var pixel = RGBPixel(0, 255, 0)
    var newPixel = converter.convert(pixel)
    assert(newPixel.grey == 150)
  }

  test("0red 0green 255blue") {
    var pixel = RGBPixel(0, 0, 255)
    var newPixel = converter.convert(pixel)
    assert(newPixel.grey == 28)
  }

  test("255red 255green 255blue") {
    var pixel = RGBPixel(255, 255, 255)
    var newPixel = converter.convert(pixel)
    assert(newPixel.grey == 255)
  }

  test("0red 0green 0blue") {
    var pixel = RGBPixel(0, 0, 0)
    var newPixel = converter.convert(pixel)
    assert(newPixel.grey == 0)
  }
}
