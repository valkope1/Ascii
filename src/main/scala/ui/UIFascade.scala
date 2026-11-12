package ui

import models.images.GreyImage
import modules.bufferedImageConverters.ConverterFromBufferedImageToRGBImage
import modules.exporters.image.AsciiImageExporter
import modules.imageConverters.{ImageConverterToAscii, ImageConverterToGrey}
import modules.imageFilters.ImageFilter
import modules.importers.bufferedImage.BufferedImageImporter
import modules.tables.ConversionTable

class UIFascade(imageImporter: BufferedImageImporter, imageExporters: Array[AsciiImageExporter], 
                filters: Array[ImageFilter[GreyImage]], table: ConversionTable) {
  def convertAndPrint(): Unit = {
    var image = makeGreyImage()
    image = applyFilters(image)
    makeAsciiAndPrint(image)
  }
  
  private def makeGreyImage(): GreyImage = {
    val converterBufToImage = ConverterFromBufferedImageToRGBImage()
    val rgbImage = converterBufToImage.convert(imageImporter.load())
    val converterImageToGrey = ImageConverterToGrey()
    converterImageToGrey.convert(rgbImage)
  }
  
  
  private def applyFilters(greyImage: GreyImage): GreyImage = {
    var newGrey = greyImage
    for (i <- filters.indices)
      newGrey = filters(i).applyFilter(newGrey)
    newGrey  
  }
  
  private def makeAsciiAndPrint(image: GreyImage): Unit = {
    val converterImageToAscii = ImageConverterToAscii(table)
    var asciiImage = converterImageToAscii.convert(image)
    for (i <- imageExporters.indices)
      imageExporters(i).write(asciiImage)
    
  }
}
