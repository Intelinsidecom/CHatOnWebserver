using System;
using System.Collections.Generic;

namespace HtmlAgilityPack;

internal class NameValuePairList
{
	internal readonly string Text;

	private List<KeyValuePair<string, string>> _allPairs;

	private Dictionary<string, List<KeyValuePair<string, string>>> _pairsWithName;

	internal NameValuePairList()
		: this(null)
	{
	}

	internal NameValuePairList(string text)
	{
		Text = text;
		_allPairs = new List<KeyValuePair<string, string>>();
		_pairsWithName = new Dictionary<string, List<KeyValuePair<string, string>>>();
		Parse(text);
	}

	internal static string GetNameValuePairsValue(string text, string name)
	{
		NameValuePairList nameValuePairList = new NameValuePairList(text);
		return nameValuePairList.GetNameValuePairValue(name);
	}

	internal List<KeyValuePair<string, string>> GetNameValuePairs(string name)
	{
		int num = 3;
		while (true)
		{
			switch (num)
			{
			default:
				if (true)
				{
				}
				num = ((name == null) ? 2 : 0);
				break;
			case 1:
				return new List<KeyValuePair<string, string>>();
			case 0:
				if (!_pairsWithName.ContainsKey(name))
				{
					num = 1;
					break;
				}
				return _pairsWithName[name];
			case 2:
				return _allPairs;
			}
		}
	}

	internal string GetNameValuePairValue(string name)
	{
		int num = 3;
		List<KeyValuePair<string, string>> nameValuePairs = default(List<KeyValuePair<string, string>>);
		while (true)
		{
			switch (num)
			{
			case 2:
				return string.Empty;
			case 0:
				if (nameValuePairs.Count == 0)
				{
					num = 2;
					continue;
				}
				return nameValuePairs[0].Value.Trim();
			case 1:
				throw new ArgumentNullException();
			}
			if (true)
			{
			}
			if (name == null)
			{
				num = 1;
				continue;
			}
			nameValuePairs = GetNameValuePairs(name);
			num = 0;
		}
	}

	private void Parse(string text)
	{
		switch (0)
		{
		}
		string[] array2 = default(string[]);
		int num2 = default(int);
		string text2 = default(string);
		KeyValuePair<string, string> item = default(KeyValuePair<string, string>);
		string[] array = default(string[]);
		List<KeyValuePair<string, string>> list = default(List<KeyValuePair<string, string>>);
		while (true)
		{
			_allPairs.Clear();
			_pairsWithName.Clear();
			int num = 2;
			while (true)
			{
				switch (num)
				{
				case 2:
				{
					if (text == null)
					{
						num = 14;
						continue;
					}
					string[] array3 = text.Split(';');
					array2 = array3;
					num2 = 0;
					num = 12;
					continue;
				}
				case 14:
					return;
				case 9:
					if (text2.Length != 0)
					{
						num = 6;
						continue;
					}
					goto case 1;
				case 11:
					num = 7;
					continue;
				case 7:
					item = new KeyValuePair<string, string>(array[0].Trim().ToLower(), (array.Length >= 2) ? array[1] : "");
					_allPairs.Add(item);
					if (true)
					{
					}
					num = 0;
					continue;
				case 1:
					num2++;
					num = 3;
					continue;
				case 4:
				case 8:
					list.Add(item);
					num = 1;
					continue;
				case 13:
					list = new List<KeyValuePair<string, string>>();
					_pairsWithName[item.Key] = list;
					num = 4;
					continue;
				case 6:
					array = text2.Split(new char[1] { '=' }, 2);
					num = 15;
					continue;
				case 15:
					if (array.Length != 0)
					{
						num = 11;
						continue;
					}
					goto case 1;
				case 3:
				case 12:
					num = 10;
					continue;
				case 10:
					if (num2 < array2.Length)
					{
						text2 = array2[num2];
						num = 9;
					}
					else
					{
						num = 5;
					}
					continue;
				case 5:
					return;
				case 0:
					if (!_pairsWithName.ContainsKey(item.Key))
					{
						num = 13;
						continue;
					}
					list = _pairsWithName[item.Key];
					num = 8;
					continue;
				}
				break;
			}
		}
	}
}
