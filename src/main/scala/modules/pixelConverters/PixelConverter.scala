package modules.pixelConverters

import models.pixels.Pixel

trait PixelConverter[T<: Pixel] {
  def convert(pixel: T): Pixel
}
