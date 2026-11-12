package models.pixels

case class RGBPixel(red: Int, green: Int, blue: Int) extends Pixel {
  require(red <= 255 && red >= 0 && green <= 255 && green >= 0 && blue <= 255 && blue >= 0, "R, G, B must be in interval 0-255")
}
