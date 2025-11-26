using System.IO;

namespace Google.ProtocolBuffers;

public sealed class MessageStreamWriter<T> where T : IMessage<T>
{
	private readonly CodedOutputStream codedOutput;

	public MessageStreamWriter(Stream output)
	{
		codedOutput = CodedOutputStream.CreateInstance(output);
	}

	public void Write(T message)
	{
		codedOutput.WriteMessage(1, message);
	}

	public void Flush()
	{
		codedOutput.Flush();
	}
}
