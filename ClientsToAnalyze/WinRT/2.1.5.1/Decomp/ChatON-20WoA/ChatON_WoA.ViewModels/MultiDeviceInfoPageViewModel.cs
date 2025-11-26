using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Net;
using System.Xml.Linq;
using ChatON_WoA.Views;
using ChatOn.Controls;
using ChatOn.Infrastructure;
using ChatOn.InfraStructure;
using ChatOn.Services;
using Windows.Storage;
using Windows.UI.Popups;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;

namespace ChatON_WoA.ViewModels;

public class MultiDeviceInfoPageViewModel : NotificationObject
{
	private MultiDeviceInfoPage _page;

	private SSMService _ssmService;

	private ObservableCollection<MappingInfo> _mappingList;

	private string _selectIdDevice;

	public ObservableCollection<MappingInfo> MappingList
	{
		get
		{
			return _mappingList;
		}
		set
		{
			_mappingList = value;
			NotifyPropertyChanged(() => MappingList);
		}
	}

	public MultiDeviceInfoPageViewModel(MultiDeviceInfoPage page)
	{
		_page = page;
		_selectIdDevice = string.Empty;
		_ssmService = new SSMService();
		if (SettingService.GetSignedOnSamsungAccount())
		{
			_ssmService.GetMappingInfoCompleted += _ssmService_GetMappingInfoCompleted;
			_ssmService.DeregisterOtherDeviceCompleted += _ssmService_DeregisterOtherDeviceCompleted;
			_ssmService.DeRegisterUserCompleted += _ssmService_DeRegisterUserCompleted;
			_ssmService.GetMappingInfoAsync();
			SettingsPage.ActiveInstance.ShowLoading();
		}
		else
		{
			((Page)PivotPage.ActiveInstance).Frame.Navigate(typeof(SyncIntroPage));
		}
	}

	private async void _ssmService_GetMappingInfoCompleted(object sender, SSMCompletedEventArgs e)
	{
		SettingsPage.ActiveInstance.StopLoading();
		if (e.StatusCode == HttpStatusCode.OK && e.Xml != null)
		{
			MappingList = ParseFromXml(e.Xml);
		}
		else
		{
			SSMService.ShowCommonErrorMessage(e);
		}
	}

	private async void _ssmService_DeregisterOtherDeviceCompleted(object sender, SSMCompletedEventArgs e)
	{
		SettingsPage.ActiveInstance.ShowLoading();
		if (e.StatusCode == HttpStatusCode.OK)
		{
			MappingInfo item = MappingList.Where((MappingInfo x) => x.ChatonId == _selectIdDevice).FirstOrDefault();
			MappingList.Remove(item);
		}
		else if (e.ErrorMessage.Contains("CCS-11202"))
		{
			MessageDialog val = new MessageDialog(Utility.GetResourceString("IDS_CHATON_POP_FAILED_TO_DELETE_ACCOUNT"));
			val.ShowAsync();
		}
		else
		{
			SSMService.ShowCommonErrorMessage(e);
		}
		_selectIdDevice = string.Empty;
	}

	private async void _ssmService_DeRegisterUserCompleted(object sender, SSMCompletedEventArgs e)
	{
		LoadingIndicator.StopLoading();
		try
		{
			bool isInvalidUser = false;
			if (!string.IsNullOrEmpty(e.ErrorMessage) && (e.ErrorMessage.Contains("CCS-00012") || e.ErrorMessage.Contains("CCS-00011")))
			{
				await SSMService.ShowCommonErrorMessage(e);
				isInvalidUser = true;
			}
			else if (!string.IsNullOrEmpty(e.ErrorMessage) && e.ErrorMessage.Contains("CCS-00013"))
			{
				await Utility.ShowCloseMessageDialog(Utility.GetResourceString("IDS_CHATON_POP_THIS_DEVICE_WAS_RESET_OVER_THE_WEB_REGISTER_IT_AGAIN_TO_USE_IT"));
				isInvalidUser = true;
			}
			if (e.StatusCode == HttpStatusCode.OK || isInvalidUser)
			{
				Utility.UpdateMainTileCount(0);
				try
				{
					await ApplicationData.Current.ClearAsync((ApplicationDataLocality)0);
				}
				catch (Exception)
				{
				}
				try
				{
					string oldGuid = await Utility.GetDeviceUniqueID();
					StorageFolder folder = ApplicationData.Current.LocalFolder;
					FileIOHelper.WriteToFiles(await (await folder.CreateFolderAsync("ChatON", (CreationCollisionOption)3)).CreateFileAsync("guid.txt", (CreationCollisionOption)3), oldGuid);
				}
				catch (Exception)
				{
				}
				MessageDialog dialog = new MessageDialog(Utility.GetResourceString("IDS_CHATON_POP_APPLICATION_WILL_BE_CLOSED"));
				await dialog.ShowAsync();
				Application.Current.Exit();
			}
			else
			{
				await SSMService.ShowCommonErrorMessage(e);
			}
		}
		catch (Exception)
		{
		}
	}

	private ObservableCollection<MappingInfo> ParseFromXml(XElement xe)
	{
		ObservableCollection<MappingInfo> observableCollection = new ObservableCollection<MappingInfo>();
		IEnumerable<XElement> enumerable = from item in xe.Descendants("MappingInfo")
			orderby (item.Attribute("isAsker") != null) ? 1 : 0 descending
			orderby item.Attribute("model").Value.Equals("web") descending
			select (item);
		foreach (XElement item in enumerable)
		{
			MappingInfo mappingInfo = new MappingInfo();
			mappingInfo.ViewButton = false;
			mappingInfo.ModelName = item.Attribute("model").Value;
			if (mappingInfo.ModelName == "web")
			{
				mappingInfo.ViewButton = true;
				mappingInfo.SubInfo = "www.chaton.com";
			}
			if (item.Attribute("os") != null)
			{
				mappingInfo.OSVersion = item.Attribute("os").Value;
			}
			if (item.Attribute("phoneNumber") != null)
			{
				mappingInfo.SubInfo = "+" + item.Attribute("phoneNumber").Value;
			}
			if (item.Attribute("chatonid") != null)
			{
				mappingInfo.ChatonId = item.Attribute("chatonid").Value;
			}
			if (item.Attribute("isAsker") != null)
			{
				mappingInfo.IsAsker = true;
			}
			mappingInfo.SubInfoVisibility = (Visibility)(string.IsNullOrEmpty(mappingInfo.SubInfo) ? 1 : 0);
			observableCollection.Add(mappingInfo);
		}
		return observableCollection;
	}

	public async void Deregister(MappingInfo device)
	{
		if (await Utility.ShowOKCancleMessageDialog(Utility.GetResourceString("IDS_CHATON_BODY_ALL_YOUR_CHATON_DATA_WILL_BE_DELETED_FROM_THIS_DEVICE_HOWEVER_YOU_CAN_RESTORE_ALL_YOUR_BUDDIES_NOTI_MSG"), showCancel: true, Utility.GetResourceString("IDS_CHATON_HEADER_DEREGISTER_DEVICE")))
		{
			SettingsPage.ActiveInstance.ShowLoading();
			if (device.IsAsker)
			{
				await _ssmService.DeRegisterUserAsync();
				return;
			}
			_selectIdDevice = device.ChatonId;
			await _ssmService.DeregisterOtherDevice(_selectIdDevice);
		}
	}
}
