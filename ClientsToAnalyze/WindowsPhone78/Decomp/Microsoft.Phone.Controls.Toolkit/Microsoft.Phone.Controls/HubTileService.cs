using System;
using System.Collections.Generic;
using System.Windows.Threading;

namespace Microsoft.Phone.Controls;

public static class HubTileService
{
	private const int WaitingPipelineSteps = 3;

	private const int NumberOfSimultaneousAnimations = 1;

	private const bool TrackResurrection = false;

	private static DispatcherTimer Timer;

	private static Random ProbabilisticBehaviorSelector;

	private static List<WeakReference> EnabledImagesPool;

	private static List<WeakReference> FrozenImagesPool;

	private static List<WeakReference> StalledImagesPipeline;

	static HubTileService()
	{
		Timer = new DispatcherTimer();
		ProbabilisticBehaviorSelector = new Random();
		EnabledImagesPool = new List<WeakReference>();
		FrozenImagesPool = new List<WeakReference>();
		StalledImagesPipeline = new List<WeakReference>();
		Timer.Tick += OnTimerTick;
	}

	private static void RestartTimer()
	{
		if (!Timer.IsEnabled)
		{
			Timer.Interval = TimeSpan.FromMilliseconds(2500.0);
			Timer.Start();
		}
	}

	internal static void InitializeReference(HubTile tile)
	{
		WeakReference tile2 = new WeakReference(tile, trackResurrection: false);
		if (tile.IsFrozen)
		{
			AddReferenceToFrozenPool(tile2);
		}
		else
		{
			AddReferenceToEnabledPool(tile2);
		}
		RestartTimer();
	}

	internal static void FinalizeReference(HubTile tile)
	{
		WeakReference tile2 = new WeakReference(tile, trackResurrection: false);
		RemoveReferenceFromEnabledPool(tile2);
		RemoveReferenceFromFrozenPool(tile2);
		RemoveReferenceFromStalledPipeline(tile2);
	}

	private static void AddReferenceToEnabledPool(WeakReference tile)
	{
		if (!ContainsTarget(EnabledImagesPool, tile.Target))
		{
			EnabledImagesPool.Add(tile);
		}
	}

	private static void AddReferenceToFrozenPool(WeakReference tile)
	{
		if (!ContainsTarget(FrozenImagesPool, tile.Target))
		{
			FrozenImagesPool.Add(tile);
		}
	}

	private static void AddReferenceToStalledPipeline(WeakReference tile)
	{
		if (!ContainsTarget(StalledImagesPipeline, tile.Target))
		{
			StalledImagesPipeline.Add(tile);
		}
	}

	private static void RemoveReferenceFromEnabledPool(WeakReference tile)
	{
		RemoveTarget(EnabledImagesPool, tile.Target);
	}

	private static void RemoveReferenceFromFrozenPool(WeakReference tile)
	{
		RemoveTarget(FrozenImagesPool, tile.Target);
	}

	private static void RemoveReferenceFromStalledPipeline(WeakReference tile)
	{
		RemoveTarget(StalledImagesPipeline, tile.Target);
	}

	private static bool ContainsTarget(List<WeakReference> list, object target)
	{
		for (int i = 0; i < list.Count; i++)
		{
			if (list[i].Target == target)
			{
				return true;
			}
		}
		return false;
	}

	private static void RemoveTarget(List<WeakReference> list, object target)
	{
		for (int i = 0; i < list.Count; i++)
		{
			if (list[i].Target == target)
			{
				list.RemoveAt(i);
				break;
			}
		}
	}

	private static void OnTimerTick(object sender, EventArgs e)
	{
		Timer.Stop();
		for (int i = 0; i < StalledImagesPipeline.Count; i++)
		{
			if ((StalledImagesPipeline[i].Target as HubTile)._stallingCounter-- == 0)
			{
				AddReferenceToEnabledPool(StalledImagesPipeline[i]);
				RemoveReferenceFromStalledPipeline(StalledImagesPipeline[i]);
				i--;
			}
		}
		if (EnabledImagesPool.Count > 0)
		{
			for (int j = 0; j < 1; j++)
			{
				int index = ProbabilisticBehaviorSelector.Next(EnabledImagesPool.Count);
				switch ((EnabledImagesPool[index].Target as HubTile).State)
				{
				case ImageState.Expanded:
					if ((EnabledImagesPool[index].Target as HubTile)._canDrop || (EnabledImagesPool[index].Target as HubTile)._canFlip)
					{
						if (!(EnabledImagesPool[index].Target as HubTile)._canDrop && (EnabledImagesPool[index].Target as HubTile)._canFlip)
						{
							(EnabledImagesPool[index].Target as HubTile).State = ImageState.Flipped;
						}
						else if (!(EnabledImagesPool[index].Target as HubTile)._canFlip && (EnabledImagesPool[index].Target as HubTile)._canDrop)
						{
							(EnabledImagesPool[index].Target as HubTile).State = ImageState.Semiexpanded;
						}
						else if (ProbabilisticBehaviorSelector.Next(2) == 0)
						{
							(EnabledImagesPool[index].Target as HubTile).State = ImageState.Semiexpanded;
						}
						else
						{
							(EnabledImagesPool[index].Target as HubTile).State = ImageState.Flipped;
						}
					}
					break;
				case ImageState.Semiexpanded:
					(EnabledImagesPool[index].Target as HubTile).State = ImageState.Collapsed;
					break;
				case ImageState.Collapsed:
					(EnabledImagesPool[index].Target as HubTile).State = ImageState.Expanded;
					break;
				case ImageState.Flipped:
					(EnabledImagesPool[index].Target as HubTile).State = ImageState.Expanded;
					break;
				}
				(EnabledImagesPool[index].Target as HubTile)._stallingCounter = 3;
				AddReferenceToStalledPipeline(EnabledImagesPool[index]);
				RemoveReferenceFromEnabledPool(EnabledImagesPool[index]);
			}
		}
		else if (StalledImagesPipeline.Count == 0)
		{
			return;
		}
		Timer.Interval = TimeSpan.FromMilliseconds(ProbabilisticBehaviorSelector.Next(1, 31) * 100);
		Timer.Start();
	}

	public static void FreezeHubTile(HubTile tile)
	{
		WeakReference tile2 = new WeakReference(tile, trackResurrection: false);
		AddReferenceToFrozenPool(tile2);
		RemoveReferenceFromEnabledPool(tile2);
		RemoveReferenceFromStalledPipeline(tile2);
	}

	public static void UnfreezeHubTile(HubTile tile)
	{
		WeakReference tile2 = new WeakReference(tile, trackResurrection: false);
		AddReferenceToEnabledPool(tile2);
		RemoveReferenceFromFrozenPool(tile2);
		RemoveReferenceFromStalledPipeline(tile2);
		RestartTimer();
	}

	public static void FreezeGroup(string group)
	{
		for (int i = 0; i < EnabledImagesPool.Count; i++)
		{
			if ((EnabledImagesPool[i].Target as HubTile).GroupTag == group)
			{
				(EnabledImagesPool[i].Target as HubTile).IsFrozen = true;
				i--;
			}
		}
		for (int j = 0; j < StalledImagesPipeline.Count; j++)
		{
			if ((StalledImagesPipeline[j].Target as HubTile).GroupTag == group)
			{
				(StalledImagesPipeline[j].Target as HubTile).IsFrozen = true;
				j--;
			}
		}
	}

	public static void UnfreezeGroup(string group)
	{
		for (int i = 0; i < FrozenImagesPool.Count; i++)
		{
			if ((FrozenImagesPool[i].Target as HubTile).GroupTag == group)
			{
				(FrozenImagesPool[i].Target as HubTile).IsFrozen = false;
				i--;
			}
		}
		RestartTimer();
	}
}
