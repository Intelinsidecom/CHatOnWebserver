using ChatOn.Infrastructure;
using ChatOn.Services;
using Windows.UI.Xaml;

namespace ChatOn.ViewModels;

public class PasswordSettingPopupViewModel : NotificationObject
{
	public enum PasswordSettingMode
	{
		NewPassword,
		ChangePassword,
		ChangeHint,
		DisablePassword
	}

	private Visibility _currentPasswordVisibility;

	private Visibility _newPasswordVisibility;

	private Visibility _hintVisibility;

	private PasswordSettingMode _mode;

	private string _errorMessage;

	public string ErrorMessage
	{
		get
		{
			return _errorMessage;
		}
		set
		{
			_errorMessage = value;
			NotifyPropertyChanged(() => ErrorMessage);
		}
	}

	public PasswordSettingMode Mode
	{
		get
		{
			return _mode;
		}
		set
		{
			_mode = value;
			Update();
		}
	}

	public Visibility CurrentPasswordVisibility
	{
		get
		{
			//IL_0001: Unknown result type (might be due to invalid IL or missing references)
			return _currentPasswordVisibility;
		}
		set
		{
			//IL_0001: Unknown result type (might be due to invalid IL or missing references)
			//IL_0002: Unknown result type (might be due to invalid IL or missing references)
			_currentPasswordVisibility = value;
			NotifyPropertyChanged(() => CurrentPasswordVisibility);
		}
	}

	public Visibility NewPasswordVisibility
	{
		get
		{
			//IL_0001: Unknown result type (might be due to invalid IL or missing references)
			return _newPasswordVisibility;
		}
		set
		{
			//IL_0001: Unknown result type (might be due to invalid IL or missing references)
			//IL_0002: Unknown result type (might be due to invalid IL or missing references)
			_newPasswordVisibility = value;
			NotifyPropertyChanged(() => NewPasswordVisibility);
		}
	}

	public Visibility HintVisibility
	{
		get
		{
			//IL_0001: Unknown result type (might be due to invalid IL or missing references)
			return _hintVisibility;
		}
		set
		{
			//IL_0001: Unknown result type (might be due to invalid IL or missing references)
			//IL_0002: Unknown result type (might be due to invalid IL or missing references)
			_hintVisibility = value;
			NotifyPropertyChanged(() => HintVisibility);
		}
	}

	private void Update()
	{
		if (_mode == PasswordSettingMode.NewPassword)
		{
			CurrentPasswordVisibility = (Visibility)1;
		}
		else if (_mode == PasswordSettingMode.DisablePassword)
		{
			NewPasswordVisibility = (Visibility)1;
			HintVisibility = (Visibility)1;
		}
		else if (_mode == PasswordSettingMode.ChangeHint)
		{
			NewPasswordVisibility = (Visibility)1;
			CurrentPasswordVisibility = (Visibility)1;
		}
	}

	internal bool OnSetPassword(string current, string newPass, string confirm, string hint)
	{
		if (Mode == PasswordSettingMode.NewPassword)
		{
			if (newPass != confirm)
			{
				ErrorMessage = Utility.GetResourceString("IDS_CHATON_BODY_INCORRECT_PASSWORD_TRY_AGAIN");
				return false;
			}
			SettingService.SetPassword(newPass);
			SettingService.SetPasswordHint(hint);
		}
		else if (Mode == PasswordSettingMode.ChangePassword)
		{
			if (current != SettingService.GetPassword())
			{
				ErrorMessage = Utility.GetResourceString("IDS_CHATON_BODY_INCORRECT_PASSWORD_TRY_AGAIN");
				return false;
			}
			if (newPass != confirm)
			{
				ErrorMessage = Utility.GetResourceString("IDS_CHATON_BODY_INCORRECT_PASSWORD_TRY_AGAIN");
				return false;
			}
			if (string.IsNullOrEmpty(newPass))
			{
				ErrorMessage = Utility.GetResourceString("IDS_CHATON_BODY_ENTER_NEW_PASSWORD");
				return false;
			}
			SettingService.SetPassword(newPass);
			SettingService.SetPasswordHint(hint);
		}
		else if (Mode == PasswordSettingMode.DisablePassword)
		{
			if (current != SettingService.GetPassword())
			{
				ErrorMessage = Utility.GetResourceString("IDS_CHATON_BODY_INCORRECT_PASSWORD_TRY_AGAIN");
				return false;
			}
			SettingService.SetPassword("");
			SettingService.SetPasswordHint("");
		}
		else if (Mode == PasswordSettingMode.ChangeHint)
		{
			SettingService.SetPasswordHint(hint);
		}
		return true;
	}
}
