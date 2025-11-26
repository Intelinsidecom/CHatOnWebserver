using System.Collections;
using System.Collections.ObjectModel;
using System.Collections.Specialized;
using System.Text;
using System.Windows;
using System.Windows.Automation.Peers;
using Microsoft.Phone.Controls.Maps.AutomationPeers;
using Microsoft.Phone.Controls.Maps.Core;

namespace Microsoft.Phone.Controls.Maps.Overlays;

[TemplatePart(Name = "CopyrightContainer", Type = typeof(ShadowText))]
public class Copyright : Overlay
{
	internal const string CopyrightContainerElementName = "CopyrightContainer";

	private const int maxLine = 60;

	private const string spacesBetween = "   ";

	private const char nonBreakingSpace = '\u00a0';

	private ObservableCollection<AttributionInfo> attributions;

	private ShadowText container;

	private ModeBackground setForBackground;

	public ObservableCollection<AttributionInfo> Attributions
	{
		get
		{
			return attributions;
		}
		internal set
		{
			if (attributions != null)
			{
				attributions.CollectionChanged -= Attributions_CollectionChanged;
			}
			if (value != null)
			{
				attributions = value;
				attributions.CollectionChanged += Attributions_CollectionChanged;
			}
		}
	}

	internal ModeBackground SetForBackground
	{
		get
		{
			return setForBackground;
		}
		set
		{
			setForBackground = value;
			if (setForBackground == ModeBackground.Light)
			{
				container.SetForegroundColorsForLightBackground();
			}
			else
			{
				container.SetForegroundColorsForDarkBackground();
			}
		}
	}

	private ShadowText Container
	{
		get
		{
			return container;
		}
		set
		{
			if (value != null)
			{
				SetContainer(value);
			}
		}
	}

	public Copyright()
	{
		base.DefaultStyleKey = typeof(Copyright);
		container = new ShadowText();
		Attributions = new ObservableCollection<AttributionInfo>();
	}

	private void SetContainer(ShadowText newContainer)
	{
		if (container != null)
		{
			newContainer.Text = container.Text;
		}
		container = newContainer;
	}

	private void Attributions_CollectionChanged(object sender, NotifyCollectionChangedEventArgs e)
	{
		OnAttributionsChanged(e.OldItems, e.NewItems);
	}

	private void OnAttributionsChanged(IList oldItems, IList newItems)
	{
		int num = 0;
		StringBuilder stringBuilder = new StringBuilder();
		foreach (AttributionInfo attribution in Attributions)
		{
			if (num > 0)
			{
				if (num + attribution.Text.Length > 60)
				{
					stringBuilder.AppendLine();
					num = 0;
				}
				else
				{
					stringBuilder.Append("   ");
					num += "   ".Length;
				}
			}
			AddNonBreakingString(stringBuilder, attribution.Text);
			num += attribution.Text.Length;
		}
		container.Text = stringBuilder.ToString();
	}

	private static void AddNonBreakingString(StringBuilder sb, string s)
	{
		for (int i = 0; i < s.Length; i++)
		{
			char c = s[i];
			if (' ' == c)
			{
				c = '\u00a0';
			}
			sb.Append(c);
		}
	}

	protected override AutomationPeer OnCreateAutomationPeer()
	{
		return new BaseAutomationPeer(this, "Copyright");
	}

	public override void OnApplyTemplate()
	{
		base.OnApplyTemplate();
		Container = GetTemplateChild("CopyrightContainer") as ShadowText;
		FireTemplateApplied();
	}
}
