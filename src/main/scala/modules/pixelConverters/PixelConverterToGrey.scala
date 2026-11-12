package modules.pixelConverters

import models.pixels.{GreyPixel, Pixel, RGBPixel}

class PixelConverterToGrey extends PixelConverter[RGBPixel]{
  override def convert(pixel: RGBPixel): GreyPixel = {
    var grey = ((0.3 * pixel.red) + (0.59 * pixel.green) + (0.11 * pixel.blue)).toInt 
    GreyPixel(grey)
  }
}
