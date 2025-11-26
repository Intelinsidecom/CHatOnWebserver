using System;
using System.Windows.Input;

namespace ChatOn.InfraStructure;

public class DelegateCommand : ICommand
{
	private Func<bool> canExecute;

	private Action execute;

	public event EventHandler CanExecuteChanged;

	public DelegateCommand(Action execute, Func<bool> canExecute = null)
	{
		this.execute = execute;
		this.canExecute = canExecute ?? ((Func<bool>)(() => true));
	}

	public void RaiseCanExecuteChange()
	{
		if (this.CanExecuteChanged != null)
		{
			this.CanExecuteChanged(this, EventArgs.Empty);
		}
	}

	public bool CanExecute(object parameter)
	{
		return canExecute();
	}

	public void Execute(object parameter)
	{
		execute();
	}
}
