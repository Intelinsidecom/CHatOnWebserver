using System.Collections.Generic;
using Google.ProtocolBuffers.DescriptorProtos;

namespace Google.ProtocolBuffers.Descriptors;

public sealed class ServiceDescriptor : IndexedDescriptorBase<ServiceDescriptorProto, ServiceOptions>
{
	private readonly IList<MethodDescriptor> methods;

	public IList<MethodDescriptor> Methods => methods;

	public ServiceDescriptor(ServiceDescriptorProto proto, FileDescriptor file, int index)
		: base(proto, file, DescriptorBase<ServiceDescriptorProto, ServiceOptions>.ComputeFullName(file, null, proto.Name), index)
	{
		ServiceDescriptor parent = this;
		IList<MethodDescriptorProto> methodList = proto.MethodList;
		DescriptorUtil.IndexedConverter<MethodDescriptorProto, MethodDescriptor> converter = (MethodDescriptorProto method, int i) => new MethodDescriptor(method, file, parent, i);
		methods = DescriptorUtil.ConvertAndMakeReadOnly(methodList, converter);
		file.DescriptorPool.AddSymbol(this);
	}

	public MethodDescriptor FindMethodByName(string name)
	{
		return base.File.DescriptorPool.FindSymbol<MethodDescriptor>(base.FullName + "." + name);
	}

	internal void CrossLink()
	{
		foreach (MethodDescriptor method in methods)
		{
			method.CrossLink();
		}
	}

	internal override void ReplaceProto(ServiceDescriptorProto newProto)
	{
		base.ReplaceProto(newProto);
		for (int i = 0; i < methods.Count; i++)
		{
			methods[i].ReplaceProto(newProto.GetMethod(i));
		}
	}
}
