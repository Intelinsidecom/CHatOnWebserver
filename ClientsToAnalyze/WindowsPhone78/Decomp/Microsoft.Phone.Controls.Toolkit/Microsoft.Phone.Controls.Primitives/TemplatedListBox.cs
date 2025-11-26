using System;
using System.Windows;
using System.Windows.Controls;

namespace Microsoft.Phone.Controls.Primitives;

public class TemplatedListBox : ListBox
{
	public DataTemplate ListHeaderTemplate { get; set; }

	public DataTemplate ListFooterTemplate { get; set; }

	public DataTemplate GroupHeaderTemplate { get; set; }

	public DataTemplate GroupFooterTemplate { get; set; }

	public event EventHandler<LinkUnlinkEventArgs> Link;

	public event EventHandler<LinkUnlinkEventArgs> Unlink;

	protected override DependencyObject GetContainerForItemOverride()
	{
		return new TemplatedListBoxItem();
	}

	protected override void PrepareContainerForItemOverride(DependencyObject element, object item)
	{
		base.PrepareContainerForItemOverride(element, item);
		DataTemplate contentTemplate = null;
		if (item is LongListSelector.ItemTuple itemTuple)
		{
			switch (itemTuple.ItemType)
			{
			case LongListSelector.ItemType.ListHeader:
				contentTemplate = ListHeaderTemplate;
				break;
			case LongListSelector.ItemType.ListFooter:
				contentTemplate = ListFooterTemplate;
				break;
			case LongListSelector.ItemType.GroupHeader:
				contentTemplate = GroupHeaderTemplate;
				break;
			case LongListSelector.ItemType.GroupFooter:
				contentTemplate = GroupFooterTemplate;
				break;
			case LongListSelector.ItemType.Item:
				contentTemplate = base.ItemTemplate;
				break;
			}
			TemplatedListBoxItem templatedListBoxItem = (TemplatedListBoxItem)element;
			templatedListBoxItem.Content = itemTuple.Item;
			templatedListBoxItem.Tuple = itemTuple;
			templatedListBoxItem.ContentTemplate = contentTemplate;
			ContentPresenter firstLogicalChildByType = templatedListBoxItem.GetFirstLogicalChildByType<ContentPresenter>(applyTemplates: true);
			EventHandler<LinkUnlinkEventArgs> link = this.Link;
			if (firstLogicalChildByType != null)
			{
				link?.Invoke(this, new LinkUnlinkEventArgs(firstLogicalChildByType));
			}
		}
	}

	protected override void ClearContainerForItemOverride(DependencyObject element, object item)
	{
		if (item is LongListSelector.ItemTuple)
		{
			ContentPresenter firstLogicalChildByType = ((FrameworkElement)element).GetFirstLogicalChildByType<ContentPresenter>(applyTemplates: true);
			EventHandler<LinkUnlinkEventArgs> unlink = this.Unlink;
			if (firstLogicalChildByType != null)
			{
				unlink?.Invoke(this, new LinkUnlinkEventArgs(firstLogicalChildByType));
			}
		}
		base.ClearContainerForItemOverride(element, item);
	}
}
