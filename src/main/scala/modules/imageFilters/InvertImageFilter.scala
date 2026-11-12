package modules.imageFilters

import models.images.{GreyImage, Image}
import models.pixels.GreyPixel

class InvertImageFilter extends ImageFilter[GreyImage] {
  override def applyFilter(image: GreyImage): GreyImage = {
    var pixels: Array[Array[GreyPixel]] = new Array[Array[GreyPixel]](0)
    for (h <- 0 until image.height)
      var line: Array[GreyPixel] = new Array[GreyPixel](0)
      for (w <- 0 until image.width)
        val newGrey = 255 - image.getPixel(h, w).grey 
        line :+= GreyPixel(newGrey)
      pixels :+= line
    GreyImage(image.width, image.height, pixels)
  }

}
