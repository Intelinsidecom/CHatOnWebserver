using System.Windows;
using System.Windows.Input;

namespace Microsoft.Phone.Gestures;

internal class ManipulationGestureHelper : GestureHelper
{
	private class ManipulationBaseArgs : InputBaseArgs
	{
		public ManipulationBaseArgs(ManipulationStartedEventArgs args)
			: base(args.ManipulationContainer, args.ManipulationOrigin)
		{
		}
	}

	private class ManipulationDeltaArgs : InputDeltaArgs
	{
		private ManipulationDeltaEventArgs _args;

		public override Point DeltaTranslation => _args.DeltaManipulation.Translation;

		public override Point CumulativeTranslation => _args.CumulativeManipulation.Translation;

		public override Point ExpansionVelocity => _args.Velocities.ExpansionVelocity;

		public override Point LinearVelocity => _args.Velocities.LinearVelocity;

		public ManipulationDeltaArgs(ManipulationDeltaEventArgs args)
			: base(args.ManipulationContainer, args.ManipulationOrigin)
		{
			_args = args;
		}
	}

	private class ManiulationCompletedArgs : InputCompletedArgs
	{
		private ManipulationCompletedEventArgs _args;

		public override Point TotalTranslation => _args.TotalManipulation.Translation;

		public override Point FinalLinearVelocity
		{
			get
			{
				if (_args.FinalVelocities != null)
				{
					return _args.FinalVelocities.LinearVelocity;
				}
				return new Point(0.0, 0.0);
			}
		}

		public override bool IsInertial => _args.IsInertial;

		public ManiulationCompletedArgs(ManipulationCompletedEventArgs args)
			: base(args.ManipulationContainer, args.ManipulationOrigin)
		{
			_args = args;
		}
	}

	public ManipulationGestureHelper(UIElement target, bool shouldHandleAllDrags)
		: base(target, shouldHandleAllDrags)
	{
	}

	protected override void HookEvents()
	{
		base.Target.ManipulationStarted += Target_ManipulationStarted;
		base.Target.ManipulationDelta += Target_ManipulationDelta;
		base.Target.ManipulationCompleted += Target_ManipulationCompleted;
	}

	private void Target_ManipulationStarted(object sender, ManipulationStartedEventArgs e)
	{
		NotifyDown(new ManipulationBaseArgs(e));
	}

	private void Target_ManipulationDelta(object sender, ManipulationDeltaEventArgs e)
	{
		NotifyMove(new ManipulationDeltaArgs(e));
	}

	private void Target_ManipulationCompleted(object sender, ManipulationCompletedEventArgs e)
	{
		NotifyUp(new ManiulationCompletedArgs(e));
	}
}
