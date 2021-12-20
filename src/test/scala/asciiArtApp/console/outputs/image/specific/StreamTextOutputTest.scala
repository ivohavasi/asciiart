package asciiArtApp.console.outputs.image.specific

import asciiArtApp.models.grid.pixel.GreyscaleGrid
import asciiArtApp.models.image.grid.GreyscaleImage
import asciiArtApp.models.pixel.char.GreyscalePixel
import org.scalatest.FunSuite

import java.io.File

class StreamTextOutputTest extends FunSuite {
  test("Test export 2 images") {
    val image =
      GreyscaleImage(2, 3, GreyscaleGrid(2,Array(GreyscalePixel(' ', 255),
        GreyscalePixel('$', 0),
        GreyscalePixel(' ', 255),
        GreyscalePixel('$', 0),
        GreyscalePixel(' ', 255),
        GreyscalePixel('$', 0))))

    val exporter = new FileOutput(new File("src/test/resources/test.out"))

    exporter.output(image)
    assertThrows[Exception](exporter.output(image))
  }

  test("Test export image") {
    val image =
      GreyscaleImage(2, 3, GreyscaleGrid(2, Array(GreyscalePixel(' ', 255),
        GreyscalePixel('$', 0),
        GreyscalePixel(' ', 255),
        GreyscalePixel('$', 0),
        GreyscalePixel(' ', 255),
        GreyscalePixel('$', 0))))

    val exporter = new FileOutput(new File("src/test/resources/test.out"))

    exporter.output(image)

    val loaded = loadFile("src/test/resources/test.out")
    val expected = " $\n $\n $\n"

    assert(expected == loaded)
  }

  private def loadFile(path: String): String = {
    val source = scala.io.Source.fromFile(path)
    try source.mkString finally source.close()
  }
}