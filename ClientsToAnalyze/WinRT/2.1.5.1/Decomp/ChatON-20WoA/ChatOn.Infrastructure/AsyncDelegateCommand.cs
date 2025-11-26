using System;
using System.Threading.Tasks;
using System.Windows.Input;

namespace ChatOn.InfraStructure;

public class AsyncDelegateCommand<T> : ICommand
{
	private Func<T, bool> canExecute;

	private Func<T, Task> execute;

	private bool isRunning;

	public event EventHandler CanExecuteChanged;

	public AsyncDelegateCommand(Func<T, Task> execute, Func<T, bool> canExecute = null)
	{
		this.execute = execute;
		this.canExecute = canExecute ?? ((Func<T, bool>)((T x) => true));
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
		if (!isRunning)
		{
			return canExecute((T)parameter);
		}
		return false;
	}

	public async void Execute(object parameter)
	{
		isRunning = true;
		try
		{
			RaiseCanExecuteChange();
			await execute((T)parameter);
		}
		finally
		{
			isRunning = false;
			RaiseCanExecuteChange();
		}
	}
}
public class AsyncDelegateCommand : ICommand
{
	private Func<bool> canExecute;

	private Func<Task> execute;

	private bool isRunning;

	public event EventHandler CanExecuteChanged;

	public AsyncDelegateCommand(Func<Task> execute, Func<bool> canExecute = null)
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
		if (!isRunning)
		{
			return canExecute();
		}
		return false;
	}

	public async void Execute(object parameter)
	{
		isRunning = true;
		try
		{
			RaiseCanExecuteChange();
			await execute();
		}
		finally
		{
			isRunning = false;
			RaiseCanExecuteChange();
		}
	}
}
