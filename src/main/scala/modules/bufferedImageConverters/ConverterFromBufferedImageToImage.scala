package modules.bufferedImageConverters

import models.images.Image
import java.awt.image.BufferedImage

trait ConverterFromBufferedImageToImage{
  def convert(image: BufferedImage): Image
}
