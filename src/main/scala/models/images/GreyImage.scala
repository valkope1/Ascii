package models.images

import models.pixels.GreyPixel

case class GreyImage(width: Int, height: Int, pixels: Array[Array[GreyPixel]]) extends Image {
  require(pixels.length * pixels(0).length == width * height, Exception("invalid number of pixels"))
  override def getPixel(x: Int, y: Int): GreyPixel = {
    if (x >= height || y >= width || x < 0 || y < 0)
      throw Exception("invalid positions")
    pixels(x)(y)
  }
}
