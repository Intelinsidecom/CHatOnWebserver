using System;
using System.Linq;
using System.Net;
using System.Threading.Tasks;
using ChatON_WoA.DataModel;
using ChatON_WoA.Views;
using ChatOn.Models;
using ChatOn.Services;
using Windows.UI.Core;
using Windows.UI.Xaml;

namespace ChatON_WoA.Services;

public class AniconDownloaderService
{
	public delegate void AniconDownloaderServiceEventHandler(object sender, AniconDownloaderServiceEventArgs e);

	private readonly SSMService _ssmService;

	private readonly DataService _dataService;

	private AniconPackage _package;

	public AniconDownloaderServiceEventHandler AniconDownloadCompleted;

	private DownloadSettingPage _page;

	public AniconDownloaderService(SSMService ssmService, DownloadSettingPage page)
	{
		_dataService = new DataService();
		_page = page;
		_ssmService = ssmService;
		_ssmService.InstallAniconPackageCompleted += ssmService_InstallAniconPackageCompleted;
	}

	internal void DownloadAndInstall(AniconPackage package)
	{
		_package = package;
		Task.Run(delegate
		{
			try
			{
				_ssmService.InstallAniconPackage(_package.ID);
			}
			catch (Exception)
			{
			}
		});
	}

	private async void ssmService_InstallAniconPackageCompleted(object sender, SSMCompletedEventArgs e)
	{
		_ = e.Param;
		((DependencyObject)_page).Dispatcher.RunAsync((CoreDispatcherPriority)0, (DispatchedHandler)async delegate
		{
			try
			{
				if (!_package.isCancelDownloadPackage)
				{
					_ssmService.InstallAniconPackageCompleted -= ssmService_InstallAniconPackageCompleted;
					if (e.StatusCode == HttpStatusCode.OK)
					{
						OfflineAniconPackage package = new OfflineAniconPackage();
						AniconService.GetPackageInfo(package, e.Xml);
						package.CurrentPackage = _package;
						package.ProgressChanged += package_ProgressChanged;
						if (_page.ViewModel != null && _page.ViewModel.listOffline != null && !_page.ViewModel.listOffline.Select((OfflineAniconPackage x) => x.PackageID).Contains(package.PackageID))
						{
							_page.ViewModel.listOffline.Add(package);
							ChatOnService.Instance.DownloadingPackages.Add(package.CurrentPackage);
							await package.LoadThumbImageFile();
							await package.Load();
							ChatOnService.Instance.DownloadingPackages.Remove(package.CurrentPackage);
							_dataService.AddAniconPackage(package);
							AniconDownloaderServiceEventArgs args = new AniconDownloaderServiceEventArgs
							{
								AniconPackage = package
							};
							if (AniconDownloadCompleted != null)
							{
								AniconDownloadCompleted(this, args);
							}
						}
					}
					else
					{
						_package.IsDownloading = false;
						_package.IsEnableButtonCancel = false;
						_package.isCancelDownloadPackage = true;
						SSMService.ShowCommonErrorMessage(e);
					}
				}
				else
				{
					_ssmService.InstallAniconPackageCompleted -= ssmService_InstallAniconPackageCompleted;
				}
			}
			catch (Exception error)
			{
				AniconDownloaderServiceEventArgs e2 = new AniconDownloaderServiceEventArgs
				{
					AniconPackage = null,
					Error = error
				};
				AniconDownloadCompleted(this, e2);
			}
		});
	}

	private void package_ProgressChanged(object sender, EventArgs e)
	{
		if (sender is OfflineAniconPackage)
		{
			(sender as OfflineAniconPackage).CurrentPackage.NotifyProgressChanged();
		}
	}
}
