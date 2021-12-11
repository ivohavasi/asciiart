package convertors.pixel

import convertors.Convertor
import asciiArtApp.models.pixel.ascii.ASCIIPixel
import asciiArtApp.models.pixel.rgb.RGBPixel

trait PixelConvertor extends Convertor[RGBPixel, ASCIIPixel] {

}
