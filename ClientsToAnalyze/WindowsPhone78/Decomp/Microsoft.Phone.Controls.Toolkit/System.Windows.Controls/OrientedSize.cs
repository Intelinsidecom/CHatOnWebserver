namespace System.Windows.Controls;

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
			if (Orientation != Orientation.Horizontal)
			{
				return Indirect;
			}
			return Direct;
		}
		set
		{
			if (Orientation == Orientation.Horizontal)
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
			if (Orientation == Orientation.Horizontal)
			{
				return Indirect;
			}
			return Direct;
		}
		set
		{
			if (Orientation != Orientation.Horizontal)
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
	}

	public OrientedSize(Orientation orientation, double width, double height)
	{
		_orientation = orientation;
		_direct = 0.0;
		_indirect = 0.0;
		Width = width;
		Height = height;
	}
}
