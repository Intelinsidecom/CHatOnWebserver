using System.Windows.Media.Imaging;

namespace FunShot.Effects;

public class EffectThermal : EffectBase
{
	private int[] ThermalColors;

	public EffectThermal()
	{
		ThermalColors = new int[64]
		{
			-16753409, -16759297, -16765185, -16771073, -16776961, -15269633, -13762305, -12254977, -10747649, -9240321,
			-7667457, -6160129, -4652801, -3145473, -1638145, -65281, -65305, -65328, -65351, -65374,
			-65397, -65421, -65444, -65467, -65536, -59648, -53760, -47872, -41984, -36096,
			-29952, -24064, -18176, -12288, -6400, -256, -1573120, -3080448, -3080448, -4587776,
			-6095104, -7602432, -9175296, -10682624, -12189952, -13697280, -15204608, -15204608, -16711936, -16711890,
			-16711867, -16711844, -16711821, -16711797, -16711774, -16711751, -16711728, -16711705, -16711681, -16717825,
			-16723713, -16729601, -16735489, -16741377
		};
	}

	public override WriteableBitmap Process(WriteableBitmap wbSource)
	{
		WriteableBitmap writeableBitmap = new WriteableBitmap(wbSource.PixelWidth, wbSource.PixelHeight);
		int pixelWidth = wbSource.PixelWidth;
		int pixelHeight = wbSource.PixelHeight;
		int[] pixels = wbSource.Pixels;
		int[] pixels2 = writeableBitmap.Pixels;
		int num = 0;
		for (int i = 0; i < pixelHeight; i++)
		{
			for (int j = 0; j < pixelWidth; j++)
			{
				int num2 = (pixels[i * pixelWidth + j] & 0xFF0000) >> 16;
				int num3 = (pixels[i * pixelWidth + j] & 0xFF00) >> 8;
				int num4 = pixels[i * pixelWidth + j] & 0xFF;
				num = (num2 + num3 + num4) / 3;
				pixels2[i * pixelWidth + j] = ThermalColors[num / 4];
			}
		}
		return writeableBitmap;
	}
}
