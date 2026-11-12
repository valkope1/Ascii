package ui

import modules.importers.bufferedImage.{BufferedImageImporter, BufferedImageImporterJpg, BufferedImageImporterPng}

import java.io.File

class ImageExporterSetupFascade {
  def setup(str: String): BufferedImageImporter = {
    val dotIndex = str.lastIndexOf(".")
    if (dotIndex > 0 && dotIndex < str.length - 1) {
      str.substring(dotIndex + 1) match
        case "jpg" =>
          BufferedImageImporterJpg(new File(str))
        case "png" =>
          BufferedImageImporterPng(new File(str))
        case _ =>
          throw Exception("invalid format")
    } else {
      throw Exception("invalid format")
    }
  }
}
