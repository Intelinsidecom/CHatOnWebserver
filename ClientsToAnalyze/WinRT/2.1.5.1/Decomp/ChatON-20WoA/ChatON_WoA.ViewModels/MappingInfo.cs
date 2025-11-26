using Windows.UI.Xaml;

namespace ChatON_WoA.ViewModels;

public class MappingInfo
{
	private string _name;

	private string _modelName;

	private string _OSVersion;

	private string _subInfo;

	private string _chatonId;

	private bool _viewButton;

	private bool _isAsker;

	private string _currentDevice;

	public string Name
	{
		get
		{
			return _name;
		}
		set
		{
			_name = value;
		}
	}

	public string ModelName
	{
		get
		{
			return _modelName;
		}
		set
		{
			_modelName = value;
		}
	}

	public string OSVersion
	{
		get
		{
			return _OSVersion;
		}
		set
		{
			_OSVersion = value;
		}
	}

	public string SubInfo
	{
		get
		{
			return _subInfo;
		}
		set
		{
			_subInfo = value;
		}
	}

	public string ChatonId
	{
		get
		{
			return _chatonId;
		}
		set
		{
			_chatonId = value;
		}
	}

	public bool ViewButton
	{
		get
		{
			return _viewButton;
		}
		set
		{
			_viewButton = value;
		}
	}

	public bool IsAsker
	{
		get
		{
			return _isAsker;
		}
		set
		{
			_isAsker = value;
		}
	}

	public string CurrentDevice
	{
		get
		{
			return _currentDevice;
		}
		set
		{
			_currentDevice = value;
		}
	}

	public Visibility SubInfoVisibility { get; set; }
}
