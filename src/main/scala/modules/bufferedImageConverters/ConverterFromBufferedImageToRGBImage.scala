package modules.bufferedImageConverters

import models.images.RGBImage
import models.pixels.RGBPixel

import java.awt.image.BufferedImage

class ConverterFromBufferedImageToRGBImage extends ConverterFromBufferedImageToImage {
  override def convert(image: BufferedImage): RGBImage = {
    var color: Int = 0
    val width: Int = image.getWidth
    val height: Int = image.getHeight
    var pixels: Array[Array[RGBPixel]] = new Array[Array[RGBPixel]](0)
    for(h <- 0 until height)
      var line: Array[RGBPixel] = new Array[RGBPixel](0)
      for(w <- 0 until width)
        try{
          color = image.getRGB(w, h)
        }catch
          case e: Exception =>
            throw Exception("error while converting buffered image")
        val red = (color & 0xff0000) / 65536
        val green = (color & 0xff00) / 256
        val blue = color & 0xff
        line :+= RGBPixel(red, green, blue)
      pixels :+= line
    try{
      RGBImage(width, height, pixels)
    }   catch
      case e: Exception =>
        throw Exception("error while converting buffered image")
  }
}
