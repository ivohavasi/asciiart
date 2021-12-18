package asciiArtApp.console.outputs.image.mixed

import asciiArtApp.console.outputs.image.ImageOutput
import asciiArtApp.models.image.grid.GreyscaleImage

/**
 * Outputs {@link GreyscaleImage} to multiple output sources.
 *
 * @param outputs Seq of {@link ImageOutput}s to use
 */
class MixedOutput(outputs: Seq[ImageOutput]) extends ImageOutput {
  override def output(item: GreyscaleImage): Unit =
    outputs.foreach(output => output.output(item))
}
