package models.images

import models.pixels.AsciiPixel

case class AsciiImage(width: Int, height: Int, pixels:Array[Array[AsciiPixel]]) extends Image{
  require(pixels.length * pixels(0).length == width * height, Exception("invalid number of pixels"))
  override def getPixel(x: Int, y: Int): AsciiPixel = {
    if (x >= height || y >= width || x < 0 || y < 0)
      throw Exception("invalid positions")
    pixels(x)(y)
  }
}
