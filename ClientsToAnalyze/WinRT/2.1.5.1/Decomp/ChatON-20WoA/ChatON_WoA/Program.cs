using System.CodeDom.Compiler;
using System.Diagnostics;
using Windows.UI.Xaml;

namespace ChatON_WoA;

public static class Program
{
	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	[DebuggerNonUserCode]
	private static void Main(string[] args)
	{
		//IL_000e: Unknown result type (might be due to invalid IL or missing references)
		//IL_0018: Expected O, but got Unknown
		Application.Start((ApplicationInitializationCallback)delegate
		{
			new App();
		});
	}
}
