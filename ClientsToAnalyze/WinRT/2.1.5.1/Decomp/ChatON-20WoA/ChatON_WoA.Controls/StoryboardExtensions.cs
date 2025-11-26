using System;
using System.Runtime.InteropServices.WindowsRuntime;
using System.Threading.Tasks;
using Windows.UI.Xaml.Media.Animation;

namespace ChatON_WoA.Controls;

public static class StoryboardExtensions
{
	public unsafe static async Task BeginAsync(this Storyboard storyboard)
	{
		await EventAsync.FromEvent((Action<EventHandler<object>>)delegate(EventHandler<object> eh)
		{
			WindowsRuntimeMarshal.AddEventHandler(new Func<EventHandler<object>, EventRegistrationToken>(storyboard, (nint)__ldftn(Timeline.add_Completed)), new Action<EventRegistrationToken>(storyboard, (nint)__ldftn(Timeline.remove_Completed)), eh);
		}, (Action<EventHandler<object>>)delegate(EventHandler<object> eh)
		{
			WindowsRuntimeMarshal.RemoveEventHandler(new Action<EventRegistrationToken>(storyboard, (nint)__ldftn(Timeline.remove_Completed)), eh);
		}, (Action)storyboard.Begin);
	}
}
