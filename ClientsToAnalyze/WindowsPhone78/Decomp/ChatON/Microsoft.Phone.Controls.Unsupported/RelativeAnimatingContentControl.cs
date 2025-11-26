using System;
using System.Collections.Generic;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Media;
using System.Windows.Media.Animation;

namespace Microsoft.Phone.Controls.Unsupported;

public class RelativeAnimatingContentControl : ContentControl
{
	private enum DoubleAnimationDimension
	{
		Width,
		Height
	}

	private abstract class AnimationValueAdapter
	{
		protected double OriginalValue { get; set; }

		public DoubleAnimationDimension Dimension { get; private set; }

		public AnimationValueAdapter(DoubleAnimationDimension dimension)
		{
			Dimension = dimension;
		}

		public abstract void UpdateWithNewDimension(double width, double height);
	}

	private abstract class GeneralAnimationValueAdapter<T> : AnimationValueAdapter
	{
		private double _ratio;

		protected T Instance { get; set; }

		protected double InitialValue { get; private set; }

		protected abstract double GetValue();

		protected abstract void SetValue(double newValue);

		public GeneralAnimationValueAdapter(DoubleAnimationDimension d, T instance)
			: base(d)
		{
			Instance = instance;
			InitialValue = StripMagicNumberOff(GetValue());
			_ratio = InitialValue / 100.0;
		}

		public double StripMagicNumberOff(double number)
		{
			if (base.Dimension != DoubleAnimationDimension.Width)
			{
				return number - 0.2;
			}
			return number - 0.1;
		}

		public static DoubleAnimationDimension? GetDimensionFromMagicNumber(double number)
		{
			double num = Math.Floor(number);
			double num2 = number - num;
			if (num2 >= 0.09999100000000001 && num2 <= 0.100009)
			{
				return DoubleAnimationDimension.Width;
			}
			if (num2 >= 0.199991 && num2 <= 0.20000900000000002)
			{
				return DoubleAnimationDimension.Height;
			}
			return null;
		}

		public override void UpdateWithNewDimension(double width, double height)
		{
			double sizeToUse = ((base.Dimension == DoubleAnimationDimension.Width) ? width : height);
			UpdateValue(sizeToUse);
		}

		private void UpdateValue(double sizeToUse)
		{
			SetValue(sizeToUse * _ratio);
		}
	}

	private class DoubleAnimationToAdapter : GeneralAnimationValueAdapter<DoubleAnimation>
	{
		protected override double GetValue()
		{
			return base.Instance.To.Value;
		}

		protected override void SetValue(double newValue)
		{
			base.Instance.To = newValue;
		}

		public DoubleAnimationToAdapter(DoubleAnimationDimension dimension, DoubleAnimation instance)
			: base(dimension, instance)
		{
		}
	}

	private class DoubleAnimationFromAdapter : GeneralAnimationValueAdapter<DoubleAnimation>
	{
		protected override double GetValue()
		{
			return base.Instance.From.Value;
		}

		protected override void SetValue(double newValue)
		{
			base.Instance.From = newValue;
		}

		public DoubleAnimationFromAdapter(DoubleAnimationDimension dimension, DoubleAnimation instance)
			: base(dimension, instance)
		{
		}
	}

	private class DoubleAnimationFrameAdapter : GeneralAnimationValueAdapter<DoubleKeyFrame>
	{
		protected override double GetValue()
		{
			return base.Instance.Value;
		}

		protected override void SetValue(double newValue)
		{
			base.Instance.Value = newValue;
		}

		public DoubleAnimationFrameAdapter(DoubleAnimationDimension dimension, DoubleKeyFrame frame)
			: base(dimension, frame)
		{
		}
	}

	private const double SimpleDoubleComparisonEpsilon = 9E-06;

	private double _knownWidth;

	private double _knownHeight;

	private List<AnimationValueAdapter> _specialAnimations;

	public RelativeAnimatingContentControl()
	{
		base.SizeChanged += OnSizeChanged;
	}

	private void OnSizeChanged(object sender, SizeChangedEventArgs e)
	{
		if (e != null && e.NewSize.Height > 0.0 && e.NewSize.Width > 0.0)
		{
			_knownWidth = e.NewSize.Width;
			_knownHeight = e.NewSize.Height;
			base.Clip = new RectangleGeometry
			{
				Rect = new Rect(0.0, 0.0, _knownWidth, _knownHeight)
			};
			UpdateAnyAnimationValues();
		}
	}

	private void UpdateAnyAnimationValues()
	{
		if (!(_knownHeight > 0.0) || !(_knownWidth > 0.0))
		{
			return;
		}
		if (_specialAnimations == null)
		{
			_specialAnimations = new List<AnimationValueAdapter>();
			foreach (VisualStateGroup visualStateGroup in VisualStateManager.GetVisualStateGroups(this))
			{
				if (visualStateGroup == null)
				{
					continue;
				}
				foreach (VisualState state in visualStateGroup.States)
				{
					if (state == null)
					{
						continue;
					}
					Storyboard storyboard = state.Storyboard;
					if (storyboard == null)
					{
						continue;
					}
					foreach (Timeline child in storyboard.Children)
					{
						DoubleAnimation doubleAnimation = child as DoubleAnimation;
						DoubleAnimationUsingKeyFrames doubleAnimationUsingKeyFrames = child as DoubleAnimationUsingKeyFrames;
						if (doubleAnimation != null)
						{
							ProcessDoubleAnimation(doubleAnimation);
						}
						else if (doubleAnimationUsingKeyFrames != null)
						{
							ProcessDoubleAnimationWithKeys(doubleAnimationUsingKeyFrames);
						}
					}
				}
			}
		}
		UpdateKnownAnimations();
	}

	private void UpdateKnownAnimations()
	{
		foreach (AnimationValueAdapter specialAnimation in _specialAnimations)
		{
			specialAnimation.UpdateWithNewDimension(_knownWidth, _knownHeight);
		}
	}

	private void ProcessDoubleAnimationWithKeys(DoubleAnimationUsingKeyFrames da)
	{
		foreach (DoubleKeyFrame keyFrame in da.KeyFrames)
		{
			DoubleAnimationDimension? dimensionFromMagicNumber = GeneralAnimationValueAdapter<DoubleKeyFrame>.GetDimensionFromMagicNumber(keyFrame.Value);
			if (dimensionFromMagicNumber.HasValue)
			{
				_specialAnimations.Add(new DoubleAnimationFrameAdapter(dimensionFromMagicNumber.Value, keyFrame));
			}
		}
	}

	private void ProcessDoubleAnimation(DoubleAnimation da)
	{
		if (da.To.HasValue)
		{
			DoubleAnimationDimension? dimensionFromMagicNumber = GeneralAnimationValueAdapter<DoubleAnimation>.GetDimensionFromMagicNumber(da.To.Value);
			if (dimensionFromMagicNumber.HasValue)
			{
				_specialAnimations.Add(new DoubleAnimationToAdapter(dimensionFromMagicNumber.Value, da));
			}
		}
		if (da.From.HasValue)
		{
			DoubleAnimationDimension? dimensionFromMagicNumber2 = GeneralAnimationValueAdapter<DoubleAnimation>.GetDimensionFromMagicNumber(da.To.Value);
			if (dimensionFromMagicNumber2.HasValue)
			{
				_specialAnimations.Add(new DoubleAnimationFromAdapter(dimensionFromMagicNumber2.Value, da));
			}
		}
	}
}
