package modules.imageFilters

import models.images.{GreyImage, Image}
import models.pixels.GreyPixel

class BrightnessImageFilter(brightness: Int) extends ImageFilter[GreyImage] {
  override def applyFilter(image: GreyImage): GreyImage = {
        check(image)
        var pixels: Array[Array[GreyPixel]] = new Array[Array[GreyPixel]](0)
        for (h <- 0 until image.height)
          var line: Array[GreyPixel] = new Array[GreyPixel](0)
          for (w <- 0 until image.width)
            var newGrey = image.getPixel(h, w).grey + brightness
            if (newGrey < 0)
              newGrey = 0
            if (newGrey > 255)
              newGrey = 255
            line :+= GreyPixel(newGrey)
          pixels :+= line
        GreyImage(image.width, image.height, pixels)
  }

}
