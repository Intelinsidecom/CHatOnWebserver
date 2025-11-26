using System;

namespace SEC.Media.Effect;

public class ToneMappingParameters
{
	public const int TONEMAPPING_MAX_STAGES = 4;

	public int function_id;

	public int high_saturation;

	public bool info_fast_mode;

	public int low_saturation;

	public Stage[] stage;

	public bool stretch_contrast;

	public Unsharp_Mask unsharp_mask;

	public ToneMappingParameters()
	{
		info_fast_mode = true;
		high_saturation = 100;
		low_saturation = 100;
		stretch_contrast = true;
		function_id = 0;
		stage = new Stage[4];
		stage[0].enabled = true;
		stage[0].power = 30f;
		stage[0].blur = 80f;
		stage[1].enabled = true;
		stage[1].power = 30f;
		stage[1].blur = 80f;
		stage[2].enabled = false;
		stage[2].power = 30f;
		stage[2].blur = 80f;
		stage[3].enabled = false;
		stage[3].power = 30f;
		stage[3].blur = 80f;
		unsharp_mask.enabled = false;
		unsharp_mask.power = 19.1446f;
		unsharp_mask.blur = 4f;
		unsharp_mask.threshold = 9;
	}

	public float get_blur(int nstage)
	{
		return stage[nstage].blur;
	}

	public float get_power(int nstage)
	{
		return (float)Math.Pow(stage[nstage].power / 100f, 1.5) * 100f;
	}

	public float get_unsharp_mask_blur()
	{
		return unsharp_mask.blur;
	}

	public float get_unsharp_mask_power()
	{
		return (float)Math.Pow(unsharp_mask.power / 100f, 3.0) * 10f;
	}
}
