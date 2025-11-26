using System;
using ChatOn.Models;

namespace ChatON_WoA.Views;

public class ProfileDialogEventArgs : EventArgs
{
	public Buddy Buddy { get; set; }
}
