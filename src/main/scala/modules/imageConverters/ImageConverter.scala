package modules.imageConverters

import models.images.Image

trait ImageConverter[T<: Image] {
  def convert(image: T): Image
}
