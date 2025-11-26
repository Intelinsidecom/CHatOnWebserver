using System;
using ChatOn.Controls;
using ChatOn.Services;
using Windows.UI.Xaml.Media.Imaging;

namespace ChatON_WoA.InfraStructure;

public class ChatBubbleProvider
{
	private static ChatBubbleProvider _instance;

	private BitmapImage _defaultBuddyImage;

	private BitmapImage _defaultMeImage;

	public static ChatBubbleProvider Instance
	{
		get
		{
			if (_instance == null)
			{
				_instance = new ChatBubbleProvider();
			}
			return _instance;
		}
	}

	public BitmapImage DefaultBuddyImage => _defaultBuddyImage;

	public BitmapImage DefaultMeImage => _defaultMeImage;

	private ChatBubbleProvider()
	{
		LoadBubble();
	}

	public void LoadBubble()
	{
		//IL_0026: Unknown result type (might be due to invalid IL or missing references)
		//IL_0030: Expected O, but got Unknown
		//IL_0056: Unknown result type (might be due to invalid IL or missing references)
		//IL_0060: Expected O, but got Unknown
		int bubbleType = SettingService.GetBubbleType();
		_defaultBuddyImage = new BitmapImage(new Uri(ChatBubble.SavedBaseUri, "Images/ChatBubbles/buddy_bubble_0" + bubbleType + ".png"));
		bubbleType = SettingService.GetMyBubbleType();
		_defaultMeImage = new BitmapImage(new Uri(ChatBubble.SavedBaseUri, "Images/ChatBubbles/me_bubble_0" + bubbleType + ".png"));
	}
}
