using System;
using System.Reflection;
using System.Text;
using Windows.Security.Cryptography;
using Windows.Security.Cryptography.Core;
using Windows.Storage.Streams;

namespace SDatabase;

public static class SDBUtility
{
	public static byte[] HexStringToByteArray(string hex)
	{
		int length = hex.Length;
		byte[] array = new byte[length / 2];
		for (int i = 0; i < length; i += 2)
		{
			array[i / 2] = Convert.ToByte(hex.Substring(i, 2), 16);
		}
		return array;
	}

	public static byte[] StrToByteArray(string str)
	{
		UTF8Encoding uTF8Encoding = new UTF8Encoding();
		return uTF8Encoding.GetBytes(str);
	}

	private static string Encrypt(string data)
	{
		byte[] array = HexStringToByteArray("eadab49ac802a674214a5265e60c2b9a709a5ebffd2e5eb8c716531d657a82ea");
		byte[] array2 = new byte[16];
		byte[] array3 = new byte[16];
		for (int i = 0; i < 16; i++)
		{
			array2[i] = array[i];
			array3[i] = array[i + 16];
		}
		SymmetricKeyAlgorithmProvider val = SymmetricKeyAlgorithmProvider.OpenAlgorithm("AES_CBC_PKCS7");
		IBuffer val2 = CryptographicBuffer.CreateFromByteArray(array2);
		CryptographicKey val3 = val.CreateSymmetricKey(val2);
		IBuffer val4 = CryptographicBuffer.CreateFromByteArray(array3);
		IBuffer val5 = CryptographicBuffer.CreateFromByteArray(StrToByteArray(data));
		IBuffer val6 = CryptographicEngine.Encrypt(val3, val5, val4);
		return CryptographicBuffer.EncodeToHexString(val6);
	}

	public static string Decrypt(string data)
	{
		byte[] array = HexStringToByteArray("eadab49ac802a674214a5265e60c2b9a709a5ebffd2e5eb8c716531d657a82ea");
		byte[] array2 = new byte[16];
		byte[] array3 = new byte[16];
		for (int i = 0; i < 16; i++)
		{
			array2[i] = array[i];
			array3[i] = array[i + 16];
		}
		SymmetricKeyAlgorithmProvider val = SymmetricKeyAlgorithmProvider.OpenAlgorithm("AES_CBC_PKCS7");
		IBuffer val2 = CryptographicBuffer.CreateFromByteArray(array2);
		CryptographicKey val3 = val.CreateSymmetricKey(val2);
		IBuffer val4 = CryptographicBuffer.CreateFromByteArray(array3);
		IBuffer val5 = CryptographicBuffer.DecodeFromHexString(data);
		IBuffer val6 = CryptographicEngine.Decrypt(val3, val5, val4);
		return CryptographicBuffer.ConvertBinaryToString((BinaryStringEncoding)0, val6);
	}

	public static void SavePropertyValueToDataWriter(DataWriter dataWriter, PropertyInfo property, object value, bool encrypt = false)
	{
		if ((object)property.PropertyType == typeof(int))
		{
			dataWriter.WriteInt32((int)value);
		}
		else if ((object)property.PropertyType == typeof(string))
		{
			string text = value as string;
			if (!string.IsNullOrEmpty(text) && encrypt)
			{
				text = Encrypt(value as string);
			}
			uint num = dataWriter.MeasureString(text);
			dataWriter.WriteUInt32(num);
			dataWriter.WriteString(text);
		}
		else if ((object)property.PropertyType == typeof(ulong))
		{
			dataWriter.WriteUInt64((ulong)value);
		}
		else if ((object)property.PropertyType == typeof(long))
		{
			dataWriter.WriteInt64((long)value);
		}
		else if ((object)property.PropertyType == typeof(bool))
		{
			dataWriter.WriteBoolean((bool)value);
		}
		else if ((object)property.PropertyType == typeof(Guid))
		{
			dataWriter.WriteGuid((Guid)value);
		}
		else if ((object)property.PropertyType == typeof(DateTime))
		{
			dataWriter.WriteDateTime((DateTimeOffset)(DateTime)value);
		}
		else
		{
			dataWriter.WriteInt32((int)value);
		}
	}

	public static void LoadPropertyValueFromDataReader(DataReader dataReader, PropertyInfo property, object instance, bool decrypt = false)
	{
		if ((object)property.PropertyType == typeof(int))
		{
			object value = dataReader.ReadInt32();
			property.SetValue(instance, value);
		}
		else if ((object)property.PropertyType == typeof(string))
		{
			uint num = dataReader.ReadUInt32();
			string text = dataReader.ReadString(num);
			if (decrypt && !string.IsNullOrEmpty(text))
			{
				text = Decrypt(text);
			}
			property.SetValue(instance, text);
		}
		else if ((object)property.PropertyType == typeof(ulong))
		{
			object value2 = dataReader.ReadUInt64();
			property.SetValue(instance, value2);
		}
		else if ((object)property.PropertyType == typeof(long))
		{
			object value3 = dataReader.ReadInt64();
			property.SetValue(instance, value3);
		}
		else if ((object)property.PropertyType == typeof(bool))
		{
			object value4 = dataReader.ReadBoolean();
			property.SetValue(instance, value4);
		}
		else if ((object)property.PropertyType == typeof(Guid))
		{
			object value5 = dataReader.ReadGuid();
			property.SetValue(instance, value5);
		}
		else if ((object)property.PropertyType == typeof(DateTime))
		{
			object obj = dataReader.ReadDateTime();
			property.SetValue(instance, ((DateTimeOffset)obj).DateTime);
		}
		else
		{
			object value6 = dataReader.ReadInt32();
			property.SetValue(instance, value6);
		}
	}
}
