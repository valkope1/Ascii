package modules.imageConverters

import models.images.GreyImage
import models.pixels.GreyPixel
import modules.tables.linear.PaulBourkesTable
import org.scalatest.funsuite.AnyFunSuite

class ImageConverterToAsciiTests extends AnyFunSuite{
  private val converter = ImageConverterToAscii(PaulBourkesTable())

  test("small image"){
    val image = GreyImage(2, 2, Array(Array(GreyPixel(100), GreyPixel(150)), Array(GreyPixel(200), GreyPixel(250))))
    var imageGrey = converter.convert(image)
    assert(imageGrey.getPixel(0, 0).symbol == 'U')
    assert(imageGrey.getPixel(0, 1).symbol == '\\')
    assert(imageGrey.getPixel(1, 0).symbol == '~')
    assert(imageGrey.getPixel(1, 1).symbol == '.')

  }
  test("big image"){
    var pixels: Array[Array[GreyPixel]] = new Array[Array[GreyPixel]](0)
    for (h <- 0 until 100)
      var line: Array[GreyPixel] = new Array[GreyPixel](0)
      for (w <- 0 until 100)
        line :+= GreyPixel(100)
      pixels :+= line
    var image = GreyImage(100, 100, pixels)
    var image2 = converter.convert(image)
    for (h <- 0 until 100)
      for (w <- 0 until 100)
        assert(image2.getPixel(h, w).symbol == 'U')
  }
}
