package modules.imageConverters
import models.images.{AsciiImage, GreyImage, Image}
import models.pixels.AsciiPixel
import modules.tables.ConversionTable

class ImageConverterToAscii(table: ConversionTable) extends ImageConverter[GreyImage] {
  override def convert(image: GreyImage): AsciiImage = {
    if(image.height <=0 || image.width <= 0)
      throw Exception("cant convert image without size")
    var pixels: Array[Array[AsciiPixel]] = new Array[Array[AsciiPixel]](0)
    for (h <- 0 until image.height)
      var line: Array[AsciiPixel] = new Array[AsciiPixel](0)
      for (w <- 0 until image.width)
        var pixel = AsciiPixel(table.getChar(image.getPixel(h, w).grey))
        if(pixel == null)
          throw Exception("cant convert")
        line :+= pixel
      pixels :+= line
    AsciiImage(image.width, image.height, pixels)
  }
}
