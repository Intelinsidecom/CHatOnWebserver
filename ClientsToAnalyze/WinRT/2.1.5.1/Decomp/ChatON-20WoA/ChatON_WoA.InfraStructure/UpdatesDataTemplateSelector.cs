using ChatON_WoA.DataModel;
using Windows.UI.Xaml;

namespace ChatON_WoA.InfraStructure;

public class UpdatesDataTemplateSelector : DataTemplateSelector
{
	public DataTemplate UpdatesTemplateOneLine { get; set; }

	public DataTemplate UpdatesTemplateTwoLine { get; set; }

	public override DataTemplate SelectTemplate(object item, DependencyObject container)
	{
		NewUpdate newUpdate = null;
		if (item is NewUpdate newUpdate2)
		{
			if (newUpdate2.additional == null)
			{
				return UpdatesTemplateOneLine;
			}
			return UpdatesTemplateTwoLine;
		}
		return UpdatesTemplateOneLine;
	}
}
