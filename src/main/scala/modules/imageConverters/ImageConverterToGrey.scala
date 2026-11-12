package modules.imageConverters

import models.images.{GreyImage, RGBImage}
import models.pixels.GreyPixel
import modules.pixelConverters.PixelConverterToGrey

class ImageConverterToGrey extends ImageConverter[RGBImage]{
  override def convert(image: RGBImage): GreyImage = {
    val pixelConverter = PixelConverterToGrey()
    var pixels: Array[Array[GreyPixel]] = new Array[Array[GreyPixel]](0)
    for (h <- 0 until image.height)
      var line: Array[GreyPixel] = new Array[GreyPixel](0)
      for (w <- 0 until image.width)
        var pixel = pixelConverter.convert(image.getPixel(h, w))
        line :+= pixel
      pixels :+= line
    GreyImage(image.width, image.height, pixels)
  }

}
