using System;
using System.Collections.Specialized;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Media;
using Microsoft.Phone.Controls.Primitives;

namespace Microsoft.Phone.Controls;

[TemplatePart(Name = "HeadersListElement", Type = typeof(PivotHeadersControl))]
[StyleTypedProperty(Property = "ItemContainerStyle", StyleTargetType = typeof(PivotItem))]
[TemplatePart(Name = "PivotItemPresenter", Type = typeof(ItemsPresenter))]
public class LockablePivot : Pivot
{
	private struct HeaderAnimationInfo
	{
		public double opacity;

		public double originalX;

		public Microsoft.Phone.Controls.OpacityAnimator opacityAnimator;

		public Microsoft.Phone.Controls.TransformAnimator transformAnimator;

		public TranslateTransform transform;
	}

	private const string HeadersListElement = "HeadersListElement";

	private const string PivotItemPresenterElement = "PivotItemPresenter";

	internal const string ItemContainerStyleName = "ItemContainerStyle";

	private const double _animOffset = 20.0;

	private bool _isLocked;

	private bool _isUpdating;

	private PivotItem[] _savedItems;

	private HeaderAnimationInfo[] _animInfo;

	private PivotHeadersControl _header;

	private int _savedIndex;

	private static Duration _animTime = new Duration(TimeSpan.FromMilliseconds(200.0));

	public bool IsLocked
	{
		get
		{
			return _isLocked;
		}
		set
		{
			if (value != _isLocked)
			{
				_isLocked = !_isLocked;
				_isUpdating = true;
				if (_isLocked)
				{
					_savedIndex = base.SelectedIndex;
					FadeOutHeaders();
					SaveAndRemoveItems();
				}
				else
				{
					RestoreItems();
					FadeInHeaders();
				}
				_isUpdating = false;
			}
		}
	}

	public LockablePivot()
	{
		base.SelectionChanged += OnSelectionChanged;
	}

	protected override void OnItemsChanged(NotifyCollectionChangedEventArgs e)
	{
		if (!_isUpdating)
		{
			if (_isLocked)
			{
				throw new InvalidOperationException("Pivot Items cannot be modified when locked");
			}
			_animInfo = null;
			base.OnItemsChanged(e);
		}
	}

	private PivotHeadersControl FindHeader(UIElement start)
	{
		UIElement uIElement = null;
		int childrenCount = VisualTreeHelper.GetChildrenCount(start);
		for (int i = 0; i < childrenCount; i++)
		{
			UIElement uIElement2 = VisualTreeHelper.GetChild(start, i) as UIElement;
			uIElement = ((!(uIElement2 is PivotHeadersControl)) ? FindHeader(uIElement2) : uIElement2);
			if (uIElement != null)
			{
				break;
			}
		}
		return uIElement as PivotHeadersControl;
	}

	private void OnSelectionChanged(object sender, SelectionChangedEventArgs e)
	{
		_animInfo = null;
	}

	private void CreateAnimationInformation()
	{
		if (_animInfo != null)
		{
			return;
		}
		int count = _header.Items.Count;
		_animInfo = new HeaderAnimationInfo[count - 1];
		int num = 0;
		foreach (PivotHeaderItem item in _header.Items)
		{
			if (!item.IsSelected)
			{
				_animInfo[num].opacity = item.Opacity;
				_animInfo[num].opacityAnimator = new Microsoft.Phone.Controls.OpacityAnimator(item);
				_animInfo[num].transform = Microsoft.Phone.Controls.TransformAnimator.GetTranslateTransform(item);
				_animInfo[num].transformAnimator = new Microsoft.Phone.Controls.TransformAnimator(_animInfo[num].transform);
				_animInfo[num].originalX = _animInfo[num].transform.X;
				num++;
			}
		}
	}

	private void SaveAndRemoveItems()
	{
		_savedItems = new PivotItem[base.Items.Count];
		base.Items.CopyTo(_savedItems, 0);
		for (int num = base.Items.Count - 1; num > _savedIndex; num--)
		{
			base.Items.RemoveAt(num);
		}
		for (int i = 0; i < _savedIndex; i++)
		{
			base.Items.RemoveAt(0);
		}
	}

	private void RestoreItems()
	{
		for (int i = 0; i < _savedIndex; i++)
		{
			base.Items.Insert(i, _savedItems[i]);
		}
		for (int j = _savedIndex + 1; j < _savedItems.Length; j++)
		{
			base.Items.Add(_savedItems[j]);
		}
		_savedItems = null;
	}

	private void FadeOutHeaders()
	{
		if (_header == null)
		{
			_header = FindHeader(this);
		}
		CreateAnimationInformation();
		HeaderAnimationInfo[] animInfo = _animInfo;
		for (int i = 0; i < animInfo.Length; i++)
		{
			HeaderAnimationInfo headerAnimationInfo = animInfo[i];
			headerAnimationInfo.opacityAnimator.GoTo(0.0, _animTime);
			headerAnimationInfo.transformAnimator.GoTo(20.0 + headerAnimationInfo.originalX, _animTime);
		}
	}

	private void FadeInHeaders()
	{
		HeaderAnimationInfo[] animInfo = _animInfo;
		for (int i = 0; i < animInfo.Length; i++)
		{
			HeaderAnimationInfo headerAnimationInfo = animInfo[i];
			headerAnimationInfo.opacityAnimator.GoTo(headerAnimationInfo.opacity, _animTime);
			headerAnimationInfo.transformAnimator.GoTo(headerAnimationInfo.originalX, _animTime);
		}
	}
}
