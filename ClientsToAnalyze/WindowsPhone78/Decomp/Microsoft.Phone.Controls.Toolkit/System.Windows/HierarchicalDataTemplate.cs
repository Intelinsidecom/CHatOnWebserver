using System.Windows.Data;

namespace System.Windows;

public class HierarchicalDataTemplate : DataTemplate
{
	private DataTemplate _itemTemplate;

	private Style _itemContainerStyle;

	public Binding ItemsSource { get; set; }

	internal bool IsItemTemplateSet { get; private set; }

	public DataTemplate ItemTemplate
	{
		get
		{
			return _itemTemplate;
		}
		set
		{
			IsItemTemplateSet = true;
			_itemTemplate = value;
		}
	}

	internal bool IsItemContainerStyleSet { get; private set; }

	public Style ItemContainerStyle
	{
		get
		{
			return _itemContainerStyle;
		}
		set
		{
			IsItemContainerStyleSet = true;
			_itemContainerStyle = value;
		}
	}
}
