using System.Globalization;
using System.Windows;
using System.Windows.Automation.Peers;
using System.Windows.Controls;
using Microsoft.Phone.Controls.Maps.AutomationPeers;

namespace Microsoft.Phone.Controls.Maps.Overlays;

[TemplatePart(Name = "ErrorMessage", Type = typeof(TextBlock))]
public class LoadingErrorMessage : Overlay
{
	internal const string ErrorMessageElementName = "ErrorMessage";

	private TextBlock container;

	private TextBlock Container
	{
		get
		{
			return container;
		}
		set
		{
			if (value != null)
			{
				SetSetContainer(value);
			}
		}
	}

	public LoadingErrorMessage()
	{
		base.DefaultStyleKey = typeof(LoadingErrorMessage);
		container = new TextBlock();
		container.TextWrapping = TextWrapping.Wrap;
	}

	public void SetConfigurationError(CultureInfo culture)
	{
		OverlayResources.Culture = culture;
		container.Text = string.Format(culture, OverlayResources.LoadingConfigurationErrorMessage);
	}

	public void SetUriSchemeError(CultureInfo culture)
	{
		OverlayResources.Culture = culture;
		container.Text = string.Format(culture, OverlayResources.LoadingUriSchemeErrorMessage);
	}

	public void SetCredentialsError(CultureInfo culture)
	{
		OverlayResources.Culture = culture;
		container.Text = string.Format(culture, OverlayResources.InvalidCredentialsErrorMessage);
	}

	private void SetSetContainer(TextBlock newContainer)
	{
		if (container != null)
		{
			newContainer.Text = container.Text;
		}
		container = newContainer;
	}

	protected override AutomationPeer OnCreateAutomationPeer()
	{
		return new BaseAutomationPeer(this, "LoadingErrorMessage");
	}

	public override void OnApplyTemplate()
	{
		base.OnApplyTemplate();
		Container = GetTemplateChild("ErrorMessage") as TextBlock;
		FireTemplateApplied();
	}
}
