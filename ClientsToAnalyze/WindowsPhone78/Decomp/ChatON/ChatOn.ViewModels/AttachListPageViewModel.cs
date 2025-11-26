using System.Collections.Generic;
using ChatOn.Infrastructure;
using ChatOn.Res;
using ChatOn.Services;
using Microsoft.Phone.Controls;

namespace ChatOn.ViewModels;

public class AttachListPageViewModel : NotificationObject
{
	private PhoneApplicationPage _page;

	private List<ToolItem> _attachList;

	public List<ToolItem> AttachList => _attachList;

	public AttachListPageViewModel(PhoneApplicationPage page)
	{
		_page = page;
		LoadAttachList();
	}

	private void LoadAttachList()
	{
		_attachList = new List<ToolItem>();
		ToolItem toolItem = new ToolItem();
		toolItem.Name = ResContainer.IDS_CHATON_HEADER_ANIMATION_MESSAGE;
		toolItem.OnExecute += AttachAnimationMessage;
		_attachList.Add(toolItem);
		toolItem = new ToolItem();
		toolItem.Name = ResContainer.IDS_CHATON_BODY_PHOTO;
		toolItem.OnExecute += AttachPicture;
		_attachList.Add(toolItem);
		toolItem = new ToolItem();
		toolItem.Name = ResContainer.IDS_CHATON_OPT_TAKE_A_PICTURE;
		toolItem.OnExecute += AttachCapturedPicture;
		_attachList.Add(toolItem);
		toolItem = new ToolItem();
		toolItem.Name = ResContainer.IDS_CHATON_SK3_CONTACT;
		toolItem.OnExecute += AttachContact;
		_attachList.Add(toolItem);
		toolItem = new ToolItem();
		toolItem.Name = ResContainer.IDS_CHATON_HEADER_CALENDAR;
		toolItem.OnExecute += AttachCalendar;
		_attachList.Add(toolItem);
		toolItem = new ToolItem();
		toolItem.Name = ResContainer.IDS_CHATON_BUTTON_LOCATION;
		toolItem.OnExecute += AttachLocation;
		_attachList.Add(toolItem);
	}

	private void AttachAnimationMessage()
	{
		AttachmentService.Instance.AttachAnimationMessage(_page);
	}

	private void AttachPicture()
	{
		AttachmentService.Instance.ReturnPage = _page;
		AttachmentService.Instance.AttachPicture();
	}

	private void AttachCapturedPicture()
	{
		AttachmentService.Instance.ReturnPage = _page;
		AttachmentService.Instance.AttachCapturedPicture();
	}

	private void AttachContact()
	{
		AttachmentService.Instance.ReturnPage = _page;
		AttachmentService.Instance.AttachContact();
	}

	private void AttachCalendar()
	{
		AttachmentService.Instance.AttachCalendar(_page);
	}

	private void AttachLocation()
	{
		AttachmentService.Instance.AttachLocation(_page);
	}
}
