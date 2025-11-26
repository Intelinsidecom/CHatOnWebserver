using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;

namespace ChatON_WoA.InfraStructure;

public abstract class DataTemplateSelector : ContentControl
{
	public abstract DataTemplate SelectTemplate(object item, DependencyObject container);

	protected override void OnContentChanged(object oldContent, object newContent)
	{
		((ContentControl)this).OnContentChanged(oldContent, newContent);
		((ContentControl)this).put_ContentTemplate(SelectTemplate(newContent, (DependencyObject)(object)this));
	}
}
