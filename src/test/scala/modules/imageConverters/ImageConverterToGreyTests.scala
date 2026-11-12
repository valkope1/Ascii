package modules.imageConverters

import models.images.RGBImage
import models.pixels.RGBPixel
import org.scalatest.funsuite.AnyFunSuite

class ImageConverterToGreyTests extends AnyFunSuite{
  test("small image") {
    val image = RGBImage(2, 2, Array(Array(RGBPixel(100, 0, 0), RGBPixel(0, 100, 0)), Array(RGBPixel(200, 0, 0), RGBPixel(0, 200, 0))))
    val converter = ImageConverterToGrey()
    var imageGrey = converter.convert(image)
    assert(imageGrey.getPixel(0, 0).grey == 30)
    assert(imageGrey.getPixel(0, 1).grey == 59)
    assert(imageGrey.getPixel(1, 0).grey == 60)
    assert(imageGrey.getPixel(1, 1).grey == 118)
  }
  test("big image") {
    val converter = ImageConverterToGrey()
    var pixels: Array[Array[RGBPixel]] = new Array[Array[RGBPixel]](0)
    for (h <- 0 until 100)
      var line: Array[RGBPixel] = new Array[RGBPixel](0)
      for (w <- 0 until 100)
        line :+= RGBPixel(100, 100, 100)
      pixels :+= line
    var image = RGBImage(100, 100, pixels)
    var image2 = converter.convert(image)
    for (h <- 0 until 100)
      for (w <- 0 until 100)
        assert(image2.getPixel(h, w).grey == 100)
  }

}
