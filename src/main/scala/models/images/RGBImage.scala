package models.images

import models.pixels.RGBPixel

case class RGBImage(width: Int, height: Int, pixels: Array[Array[RGBPixel]]) extends Image {
  require(pixels.length * pixels(0).length == width * height, Exception("invalid number of pixels"))
  override def getPixel(x: Int, y: Int): RGBPixel = {
    if (x >= height || y >= width || x < 0 || y < 0)
      throw Exception("invalid positions")
    pixels(x)(y)
  }
}
