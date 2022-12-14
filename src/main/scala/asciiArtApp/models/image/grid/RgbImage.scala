package asciiArtApp.models.image.grid

import asciiArtApp.models.grid.pixel.RgbGrid
import asciiArtApp.models.pixel.Pixel
import asciiArtApp.models.pixel.rgb.RGBPixel

case class RgbImage(width: Int, height: Int, grid: RgbGrid) extends PixelGridImage {
  override def getHeight(): Int = height

  override def getWidth(): Int = width

  def getData(): RgbGrid = grid

  def foreach(func: RGBPixel => Unit): Unit = {
    grid.foreach(func)
  }

  override def getPixel(x: Int, y: Int): Pixel = {
    grid.get(x, y)
  }
}
