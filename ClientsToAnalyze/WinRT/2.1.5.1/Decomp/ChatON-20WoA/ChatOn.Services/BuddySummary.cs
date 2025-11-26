using ChatOn.Infrastructure;
using ChatOn.Models;
using Windows.UI;
using Windows.UI.Xaml.Media;

namespace ChatOn.Services;

public class BuddySummary : NotificationObject, IVariableSizedWrapGridItem
{
	public enum ItemType
	{
		Index,
		Buddy,
		Group,
		Me,
		BuddyProfile,
		GroupProfile
	}

	private int _count;

	private string _keyword;

	private SolidColorBrush _nameForeground = new SolidColorBrush(Colors.Black);

	private SolidColorBrush _background;

	public int ItemIndex { get; set; }

	public int RowSpan { get; set; }

	public int ColSpan { get; set; }

	public bool IsSpecialBuddy { get; set; }

	public ItemType Type { get; set; }

	public BuddyListHeaderType HeaderType { get; set; }

	public string HeaderName { get; set; }

	public Buddy Buddy { get; set; }

	public BuddyGroup Group { get; set; }

	public bool IsSelected { get; set; }

	public int Count
	{
		get
		{
			return _count;
		}
		set
		{
			_count = value;
			NotifyPropertyChanged(() => Count);
		}
	}

	public string Keyword
	{
		get
		{
			return _keyword;
		}
		set
		{
			_keyword = value;
			NotifyPropertyChanged(() => Keyword);
		}
	}

	public SolidColorBrush NameForeground
	{
		get
		{
			return _nameForeground;
		}
		set
		{
			//IL_0076: Unknown result type (might be due to invalid IL or missing references)
			//IL_0080: Expected O, but got Unknown
			//IL_003e: Unknown result type (might be due to invalid IL or missing references)
			//IL_0048: Expected O, but got Unknown
			//IL_00ea: Unknown result type (might be due to invalid IL or missing references)
			//IL_00f4: Expected O, but got Unknown
			//IL_00b2: Unknown result type (might be due to invalid IL or missing references)
			//IL_00bc: Expected O, but got Unknown
			if (_nameForeground != value)
			{
				_nameForeground = value;
				if (Type == ItemType.Buddy && _nameForeground.Color == Colors.White)
				{
					Buddy.StatusForeground = (Brush)new SolidColorBrush(Colors.White);
					IsSelected = true;
				}
				else if (Type == ItemType.Buddy)
				{
					Buddy.StatusForeground = (Brush)new SolidColorBrush(Color.FromArgb(byte.MaxValue, 33, 146, 151));
					IsSelected = false;
				}
				if (Type == ItemType.Group && _nameForeground.Color == Colors.White)
				{
					Group.StatusForeground = (Brush)new SolidColorBrush(Colors.White);
					IsSelected = true;
				}
				else if (Type == ItemType.Group)
				{
					Group.StatusForeground = (Brush)new SolidColorBrush(Color.FromArgb(byte.MaxValue, 33, 146, 151));
					IsSelected = false;
				}
				NotifyPropertyChanged(() => NameForeground);
				NotifyPropertyChanged(() => IsSelected);
			}
		}
	}

	public SolidColorBrush Background
	{
		get
		{
			return _background;
		}
		set
		{
			if (_background != value)
			{
				_background = value;
				NotifyPropertyChanged(() => Background);
			}
		}
	}

	public BuddySummary()
	{
		//IL_0006: Unknown result type (might be due to invalid IL or missing references)
		//IL_0010: Expected O, but got Unknown
		Count = 0;
		RowSpan = 1;
		ColSpan = 1;
		ItemIndex = 0;
	}

	public void ResetColor()
	{
		//IL_0006: Unknown result type (might be due to invalid IL or missing references)
		//IL_0010: Expected O, but got Unknown
		NameForeground = new SolidColorBrush(Colors.Black);
	}

	internal void Unhilight()
	{
		try
		{
			Background = null;
			if (Buddy != null)
			{
				Buddy.Background = null;
			}
		}
		catch
		{
		}
	}

	public bool IsNormalBuddyType()
	{
		return HeaderType == BuddyListHeaderType.Normal;
	}
}
