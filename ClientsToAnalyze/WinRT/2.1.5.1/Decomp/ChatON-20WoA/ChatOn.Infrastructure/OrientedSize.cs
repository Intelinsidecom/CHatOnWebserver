using Windows.UI.Xaml.Controls;

namespace ChatOn.Infrastructure;

internal struct OrientedSize
{
	private Orientation _orientation;

	private double _direct;

	private double _indirect;

	public Orientation Orientation => _orientation;

	public double Direct
	{
		get
		{
			return _direct;
		}
		set
		{
			_direct = value;
		}
	}

	public double Indirect
	{
		get
		{
			return _indirect;
		}
		set
		{
			_indirect = value;
		}
	}

	public double Width
	{
		get
		{
			//IL_0001: Unknown result type (might be due to invalid IL or missing references)
			//IL_0007: Invalid comparison between Unknown and I4
			if ((int)Orientation != 1)
			{
				return Indirect;
			}
			return Direct;
		}
		set
		{
			//IL_0001: Unknown result type (might be due to invalid IL or missing references)
			//IL_0007: Invalid comparison between Unknown and I4
			if ((int)Orientation == 1)
			{
				Direct = value;
			}
			else
			{
				Indirect = value;
			}
		}
	}

	public double Height
	{
		get
		{
			//IL_0001: Unknown result type (might be due to invalid IL or missing references)
			//IL_0007: Invalid comparison between Unknown and I4
			if ((int)Orientation == 1)
			{
				return Indirect;
			}
			return Direct;
		}
		set
		{
			//IL_0001: Unknown result type (might be due to invalid IL or missing references)
			//IL_0007: Invalid comparison between Unknown and I4
			if ((int)Orientation != 1)
			{
				Direct = value;
			}
			else
			{
				Indirect = value;
			}
		}
	}

	public OrientedSize(Orientation orientation)
		: this(orientation, 0.0, 0.0)
	{
	}//IL_0001: Unknown result type (might be due to invalid IL or missing references)


	public OrientedSize(Orientation orientation, double width, double height)
	{
		//IL_0001: Unknown result type (might be due to invalid IL or missing references)
		//IL_0002: Unknown result type (might be due to invalid IL or missing references)
		_orientation = orientation;
		_direct = 0.0;
		_indirect = 0.0;
		Width = width;
		Height = height;
	}
}
