namespace System.Diagnostics.Contracts;

[AttributeUsage(AttributeTargets.Assembly | AttributeTargets.Class | AttributeTargets.Struct | AttributeTargets.Constructor | AttributeTargets.Method | AttributeTargets.Property)]
public class ContractVerificationAttribute : Attribute
{
	public bool Value { get; set; }

	public ContractVerificationAttribute(bool value)
	{
		Value = value;
	}
}
