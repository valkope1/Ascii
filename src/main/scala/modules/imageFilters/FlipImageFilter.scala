package modules.imageFilters

import models.images.{GreyImage, Image}
import models.pixels.GreyPixel

class FlipImageFilter(index: String) extends ImageFilter[GreyImage] {
  require(index == "y" || index == "x", Exception("invalid syntax"))
  override def applyFilter(image: GreyImage): GreyImage = {
    check(image)
    if(index == "y")
      flipY(image)
    else if(index == "x")
      flipX(image)
    else
      throw Exception("invalid syntax")
  }

  private def flipY(image: GreyImage) : GreyImage = {
    var pixels: Array[Array[GreyPixel]] = new Array[Array[GreyPixel]](0)
    for (h <- 0 until image.height)
      var line: Array[GreyPixel] = new Array[GreyPixel](0)
      for (w <- 0 until image.width)
        line :+= GreyPixel(image.getPixel(image.height - 1 - h, w).grey)
      pixels :+= line
    GreyImage(image.width, image.height, pixels)
  }
  
  private def flipX(image: GreyImage) : GreyImage = {
    var pixels: Array[Array[GreyPixel]] = new Array[Array[GreyPixel]](0)
    for (h <- 0 until image.height)
      var line: Array[GreyPixel] = new Array[GreyPixel](0)
      for (w <- 0 until image.width)
        line :+= GreyPixel(image.getPixel(h, image.width - 1 - w).grey)
      pixels :+= line
    GreyImage(image.width, image.height, pixels)
  }

}
