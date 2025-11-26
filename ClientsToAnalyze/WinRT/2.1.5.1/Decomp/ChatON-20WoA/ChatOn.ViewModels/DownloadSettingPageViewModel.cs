using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Net;
using System.Threading.Tasks;
using ChatON_WoA.DataModel;
using ChatON_WoA.Services;
using ChatON_WoA.Views;
using ChatOn.Infrastructure;
using ChatOn.Models;
using ChatOn.Services;
using Windows.UI.Core;
using Windows.UI.Xaml;

namespace ChatOn.ViewModels;

public class DownloadSettingPageViewModel : NotificationObject
{
	private DownloadSettingPage _page;

	private ObservableCollection<AniconPackage> _packageItems = new ObservableCollection<AniconPackage>();

	private DataService _dataService;

	private SSMService _ssmService;

	public List<OfflineAniconPackage> listOffline = new List<OfflineAniconPackage>();

	private int _selectedIndexComboBox;

	private Visibility _packageVisibility;

	public int SelectedIndexComboBox
	{
		get
		{
			return _selectedIndexComboBox;
		}
		set
		{
			_selectedIndexComboBox = value;
			if (isEnable)
			{
				if (_selectedIndexComboBox == 0)
				{
					SortAnicon("recent");
				}
				else if (_selectedIndexComboBox == 1)
				{
					SortAnicon("name");
				}
				else if (_selectedIndexComboBox == 2)
				{
					SortAnicon("character");
				}
				else if (_selectedIndexComboBox == 3)
				{
					SortAnicon("rank");
				}
				NotifyPropertyChanged(() => SelectedIndexComboBox);
			}
		}
	}

	public bool isEnable { get; set; }

	public ObservableCollection<AniconPackage> PackageItems
	{
		get
		{
			return _packageItems;
		}
		set
		{
			_packageItems = value;
			NotifyPropertyChanged(() => PackageItems);
		}
	}

	public Visibility PackageVisibility
	{
		get
		{
			//IL_0001: Unknown result type (might be due to invalid IL or missing references)
			return _packageVisibility;
		}
		set
		{
			//IL_0001: Unknown result type (might be due to invalid IL or missing references)
			//IL_0002: Unknown result type (might be due to invalid IL or missing references)
			_packageVisibility = value;
			NotifyPropertyChanged(() => PackageVisibility);
		}
	}

	public DownloadSettingPageViewModel(DownloadSettingPage page)
	{
		try
		{
			_page = page;
			isEnable = false;
			SelectedIndexComboBox = 0;
			_dataService = new DataService();
			PackageVisibility = (Visibility)1;
			_page.ShowProgress();
			_ssmService = new SSMService();
			_ssmService.GetAniconPackageListCompleted += _ssmService_GetAniconPackageListCompleted;
			Task.Run(delegate
			{
				try
				{
					_ssmService.GetAniconPackageList();
				}
				catch (Exception)
				{
				}
			});
		}
		catch
		{
		}
	}

	private void _ssmService_GetAniconPackageListCompleted(object sender, SSMCompletedEventArgs e)
	{
		//IL_0027: Unknown result type (might be due to invalid IL or missing references)
		//IL_0031: Expected O, but got Unknown
		((DependencyObject)_page).Dispatcher.RunAsync((CoreDispatcherPriority)0, (DispatchedHandler)delegate
		{
			//IL_0093: Unknown result type (might be due to invalid IL or missing references)
			//IL_0099: Expected O, but got Unknown
			if (e.StatusCode == HttpStatusCode.OK)
			{
				List<AniconPackage> list = AniconService.GetPackageList(e.Xml);
				AniconService.CheckPackageDownloaded(ref list, _dataService);
				using List<AniconPackage>.Enumerator enumerator = list.GetEnumerator();
				while (enumerator.MoveNext())
				{
					DispatchedHandler val = null;
					AniconPackage p = enumerator.Current;
					CoreDispatcher dispatcher = ((DependencyObject)_page).Dispatcher;
					if (val == null)
					{
						val = (DispatchedHandler)delegate
						{
							if (_page.IsLoaded)
							{
								PackageItems.Add(p);
							}
							isEnable = true;
							NotifyPropertyChanged(() => isEnable);
							if (PackageItems.Count == list.Count)
							{
								PackageVisibility = (Visibility)0;
								NotifyPropertyChanged(() => PackageVisibility);
								_page.HideProgress();
							}
						};
					}
					dispatcher.RunAsync((CoreDispatcherPriority)1, val);
				}
				return;
			}
			SSMService.ShowCommonErrorMessage(e);
		});
	}

	public void CancelDownload(AniconPackage package)
	{
		if (package.IsDownloading)
		{
			package.IsEnableButtonCancel = false;
			AniconPackage aniconPackage = _packageItems.FirstOrDefault((AniconPackage c) => c.ID == package.ID.ToString());
			OfflineAniconPackage offlineAniconPackage = listOffline.FirstOrDefault((OfflineAniconPackage x) => x.PackageID == package.ID);
			if (offlineAniconPackage != null)
			{
				offlineAniconPackage.CurrentPackage = aniconPackage;
				offlineAniconPackage.isCancel = true;
			}
			else
			{
				aniconPackage.isCancelDownloadPackage = true;
				aniconPackage.IsDownloading = false;
			}
			aniconPackage.DownloadPercent = 0.0;
			aniconPackage.NotifyProgressChanged();
		}
	}

	internal async void DownloadPackage(AniconPackage package)
	{
		try
		{
			package.IsDownloading = true;
			package.IsEnableButtonCancel = true;
			package.isCancelDownloadPackage = false;
			SSMService ssmService = new SSMService(_ssmService.Account, _ssmService.SrvAddress);
			AniconDownloaderService aniconDownloaderService = new AniconDownloaderService(ssmService, _page);
			aniconDownloaderService.AniconDownloadCompleted = (AniconDownloaderService.AniconDownloaderServiceEventHandler)Delegate.Combine(aniconDownloaderService.AniconDownloadCompleted, new AniconDownloaderService.AniconDownloaderServiceEventHandler(aniconDownloaderService_AniconDownloadCompleted));
			aniconDownloaderService.DownloadAndInstall(package);
		}
		catch
		{
		}
	}

	private async void aniconDownloaderService_AniconDownloadCompleted(object sender, AniconDownloaderServiceEventArgs args)
	{
		if (args.AniconPackage == null || args == null)
		{
			return;
		}
		AniconPackage currentPackage = _packageItems.FirstOrDefault((AniconPackage c) => c.ID == args.AniconPackage.PackageID.ToString());
		OfflineAniconPackage offlinepackage = new OfflineAniconPackage
		{
			CurrentPackage = currentPackage
		};
		if (args.AniconPackage.isCancel)
		{
			await offlinepackage.Delete();
			await DeletePackage(currentPackage);
			currentPackage.IsNeedDownload = true;
			listOffline.Remove(args.AniconPackage);
		}
		else
		{
			currentPackage.IsNeedDownload = false;
			if (listOffline.Contains(args.AniconPackage))
			{
				listOffline.Remove(args.AniconPackage);
			}
		}
		currentPackage.IsDownloading = false;
		currentPackage.IsEnableButtonCancel = true;
		currentPackage.DownloadPercent = 0.0;
		currentPackage.NotifyProgressChanged();
	}

	private async void ssmService_InstallAniconPackageCompleted(object sender, SSMCompletedEventArgs e)
	{
		DispatchedHandler val = null;
		string id = e.Param as string;
		try
		{
			if (e.StatusCode == HttpStatusCode.OK)
			{
				OfflineAniconPackage package = new OfflineAniconPackage();
				AniconService.GetPackageInfo(package, e.Xml);
				package.CurrentPackage = _packageItems.FirstOrDefault((AniconPackage c) => c.ID == package.PackageID);
				package.ProgressChanged += package_ProgressChanged;
				await Task.Run(async delegate
				{
					ChatOnService.Instance.DownloadingPackages.Add(package.CurrentPackage);
					await package.LoadThumbImageFile();
					await package.Load();
					ChatOnService.Instance.DownloadingPackages.Remove(package.CurrentPackage);
				});
				((DependencyObject)_page).Dispatcher.RunAsync((CoreDispatcherPriority)(-1), (DispatchedHandler)delegate
				{
					package.CurrentPackage.IsDownloading = false;
					package.CurrentPackage.IsNeedDownload = false;
					_dataService.AddAniconPackage(package);
				});
				return;
			}
			CoreDispatcher dispatcher = ((DependencyObject)_page).Dispatcher;
			if (val == null)
			{
				val = (DispatchedHandler)delegate
				{
					AniconPackage aniconPackage = _packageItems.FirstOrDefault((AniconPackage c) => c.ID == id);
					aniconPackage.IsDownloading = false;
					SSMService.ShowCommonErrorMessage(e);
				};
			}
			dispatcher.RunAsync((CoreDispatcherPriority)(-1), val);
		}
		catch (Exception)
		{
		}
	}

	private void package_ProgressChanged(object sender, EventArgs e)
	{
		//IL_0027: Unknown result type (might be due to invalid IL or missing references)
		//IL_0031: Expected O, but got Unknown
		((DependencyObject)_page).Dispatcher.RunAsync((CoreDispatcherPriority)(-1), (DispatchedHandler)delegate
		{
			if (_page.IsLoaded)
			{
				OfflineAniconPackage offlineAniconPackage = null;
				if (sender is OfflineAniconPackage offlineAniconPackage2)
				{
					offlineAniconPackage2.CurrentPackage.NotifyProgressChanged();
				}
			}
		});
	}

	internal async Task DeletePackage(AniconPackage package)
	{
		try
		{
			package.IsEnableButtonUninstall = false;
			OfflineAniconPackage offPackage = _dataService.AninconPackages.FirstOrDefault((OfflineAniconPackage c) => c.PackageID == package.ID);
			await Task.Delay(500);
			_dataService.DeleteAnicon(offPackage);
			package.IsNeedDownload = true;
			package.IsEnableButtonUninstall = true;
		}
		catch
		{
		}
	}

	public void SortAnicon(string by)
	{
		if (PackageItems.Count() <= 0)
		{
			return;
		}
		switch (by)
		{
		case "name":
			PackageItems = new ObservableCollection<AniconPackage>(PackageItems.OrderBy((AniconPackage p) => p.Name));
			break;
		case "rank":
			PackageItems = new ObservableCollection<AniconPackage>(PackageItems.OrderBy((AniconPackage p) => p.DownloadRank));
			break;
		case "character":
			PackageItems = new ObservableCollection<AniconPackage>(from p in PackageItems
				orderby p.Character, p.Name
				select p);
			break;
		case "recent":
			PackageItems = new ObservableCollection<AniconPackage>(PackageItems.OrderByDescending((AniconPackage p) => p.StartDateTime));
			break;
		}
	}

	public void DownloadAllAnicon()
	{
		foreach (AniconPackage packageItem in PackageItems)
		{
			if (packageItem.IsNeedDownload && !packageItem.IsDownloading)
			{
				DownloadPackage(packageItem);
			}
		}
	}
}
