using System;

namespace ChatOn.Infrastructure;

public class ToolItem
{
	public delegate void ToolCommandHandler();

	private string _name;

	private Uri _icon;

	private object _tag;

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

	public Uri Icon
	{
		get
		{
			return _icon;
		}
		set
		{
			_icon = value;
		}
	}

	public object Tag
	{
		get
		{
			return _tag;
		}
		set
		{
			_tag = value;
		}
	}

	public event ToolCommandHandler OnExecute;

	public void Execute()
	{
		if (this.OnExecute != null)
		{
			this.OnExecute();
		}
	}
}
