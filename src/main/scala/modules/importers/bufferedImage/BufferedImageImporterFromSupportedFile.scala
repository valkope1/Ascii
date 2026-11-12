package modules.importers.bufferedImage
import java.awt.image.BufferedImage
import javax.imageio.ImageIO
import java.io.File

trait BufferedImageImporterFromSupportedFile extends BufferedImageImporter{
  require(file.exists())
  def file: File
  override def load(): BufferedImage = {
    ImageIO.read(file)
  }
}
