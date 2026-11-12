import models.images.GreyImage
import modules.importers.bufferedImage.{BufferedImageImporter, BufferedImageImporterRandomImage}
import modules.imageFilters.{BrightnessImageFilter, FlipImageFilter, ImageFilter, InvertImageFilter}
import modules.exporters.image.{AsciiImageExporter, ConsoleAsciiImageExporter, FileAsciiImageExporter}
import modules.tables.ConversionTable
import modules.tables.linear.{CustomTable, PaulBourkesTable}
import ui.{ImageExporterSetupFascade, TableSetupFascade, UIFascade}

import java.io.File

@main def main(): Unit = {

  while(true) {
    val tableSetuper = TableSetupFascade()
    val imageExporterSetuper = ImageExporterSetupFascade()
    var imageImporter: BufferedImageImporter = new BufferedImageImporterRandomImage
    var imageExporters: Array[AsciiImageExporter] = Array()
    var filters: Array[ImageFilter[GreyImage]] = Array()
    var table: ConversionTable = PaulBourkesTable()

    var tookImage = false

    val input = scala.io.StdIn.readLine()
    val commands = input.split(" ")
    var i = 0
    while (i < commands.length)
      commands(i) match
        case "--image" =>
          if (tookImage)
            throw Exception("multiple images")
          imageImporter = imageExporterSetuper.setup(commands(i+1).substring(1, commands(i+1).length - 1))
          i += 2
          tookImage = true
        case "--image-random" =>
          if (tookImage)
            throw Exception("multiple images")
          imageImporter = new BufferedImageImporterRandomImage
          i += 1
          tookImage = true
        case "--table" =>
          table = tableSetuper.setupTable(commands(i + 1))
          i += 2
        case "--custom-table" =>
          table = CustomTable(commands(i + 1))
          i += 2
        case "--invert" =>
          filters :+= InvertImageFilter()
          i += 1
        case "--flip" =>
          filters :+= FlipImageFilter(commands(i + 1).trim)
          i += 2
        case "--brightness" =>
          filters :+= BrightnessImageFilter(commands(i + 1).toInt)
          i += 2
        case "--output-file" =>
          imageExporters :+= FileAsciiImageExporter(new File(commands(i+1).substring(1, commands(i+1).length - 1)))
          i += 2
        case "--output-console" =>
          imageExporters :+= ConsoleAsciiImageExporter()
          i += 1
        case _ => throw Exception("invalid argument" + commands(i))
    if(!tookImage)
      throw Exception("didnt specify image")

    val uiFascade = UIFascade(imageImporter, imageExporters, filters, table)
    uiFascade.convertAndPrint()
  }
}





