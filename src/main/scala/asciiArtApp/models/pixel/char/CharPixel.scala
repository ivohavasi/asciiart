package asciiArtApp.models.pixel.char

import asciiArtApp.models.pixel.Pixel

case class CharPixel(character: Char) extends Pixel {
  override def getInt(): Int = character.toInt

  def get(): Char = character
}
