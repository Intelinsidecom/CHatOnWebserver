using System.Runtime.CompilerServices;
using Windows.UI.Popups;

namespace ChatON_WoA.Common;

internal class MessageDialogCommand : IUICommand
{
	public object Id { get; set; }

	public UICommandInvokedHandler Invoked { get; set; }

	public string Label { get; set; }

	public MessageDialogCommand(CommandId id, string label, UICommandInvokedHandler handler = null)
	{
		Id = id;
		Label = label;
		Invoked = handler;
	}

	[SpecialName]
	void IUICommand.put_Id(object value)
	{
		Id = value;
	}

	[SpecialName]
	void IUICommand.put_Invoked(UICommandInvokedHandler value)
	{
		Invoked = value;
	}

	[SpecialName]
	void IUICommand.put_Label(string value)
	{
		Label = value;
	}
}
