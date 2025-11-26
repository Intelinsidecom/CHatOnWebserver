using System;
using System.Globalization;

namespace ChatOn.Infrastructure;

public class ContactIndex
{
	private const string CommonGroups = "#abcdefghijklmnopqrstuvwxyz";

	private const string CzechGroups = "#abcčdefghijklmnopqrřsštuvwxyzž@";

	private const string HungarianGroups = "#aábcdeéfghiíjklmnoóöőpqrstuúüűvwxyz@";

	private const string PolishGroups = "#aąbcćdeęfghijklłmnńoóprsśtuwyzźż@";

	private const string DanishGroups = "#abcdefghijklmnopqrstuvwxyzæøå@";

	private const string SwedishGroups = "#abcdefghijklmnopqrstuvwxyzåäö@";

	private const string GreekGroups = "αβγδεζηθικλμνξοπρστυφχψω";

	private const string RussianGroups = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";

	private const string KoreanGroups = "ㄱㄴㄷㄹㅁㅂㅅㅇㅈㅊㅋㅌㅍㅎㅗㅏㅠ";

	private const string JapaneseGroups = "アカサタナハマヤラワ";

	private const string ChineseGroups = "吖八攃咑妸发旮哈丌咔㕇妈乸噢帊七冄仨他屲夕丫帀";

	private const string TiwaneseGroups = "一㐅㐄㓁㐀㐁㐖㐨㐜㑣㐡㐤㐮㒂㒑㒊㒝㒞㒡㒤㒧㒨㒩㕔㒪㔶㦭龞䀍䂅䚖";

	private const string CommonLastChar = "ž";

	private const string DanishLastChar = "å";

	private const string SwedishLastChar = "ø";

	private const string GreekLastChar = "ώ";

	private const string RussianLastChar = "я";

	private const string HungarianLastChar = "ž";

	private const string PolishLastChar = "ż";

	private const string KoreanLastChar = "힣";

	private const string JapaneseLastChar = "ん";

	private string groups;

	private string reversedGroups;

	private string reversedSpacificGroups;

	private string lastChar;

	private string displayLang;

	private CultureInfo ci;

	public ContactIndex()
	{
		displayLang = CultureInfo.CurrentUICulture.ToString();
		Initialize();
	}

	public ContactIndex(IndexType type)
	{
		if (type == IndexType.RegionFormat)
		{
			displayLang = CultureInfo.CurrentCulture.ToString();
		}
		else
		{
			displayLang = CultureInfo.CurrentUICulture.ToString();
		}
		Initialize();
	}

	public string GetIndexChar(string input)
	{
		string key = char.ToLower(input[0]).ToString();
		if (displayLang == "zh-CN")
		{
			return GetChineseKey(key);
		}
		return GetCommonLanguageKey(key);
	}

	public string GetGroups()
	{
		return groups;
	}

	public string ReverseString(string s)
	{
		char[] array = s.ToCharArray();
		Array.Reverse(array);
		return new string(array);
	}

	private void Initialize()
	{
		ci = new CultureInfo(displayLang);
		if (displayLang.Contains("el"))
		{
			lastChar = "ώ";
			groups = "αβγδεζηθικλμνξοπρστυφχψω#abcdefghijklmnopqrstuvwxyz";
			reversedGroups = ReverseString("αβγδεζηθικλμνξοπρστυφχψω") + ReverseString("#abcdefghijklmnopqrstuvwxyz");
		}
		else if (displayLang.Contains("cs"))
		{
			groups = "#abcčdefghijklmnopqrřsštuvwxyzž@";
			lastChar = "ž";
			reversedGroups = ReverseString("#abcčdefghijklmnopqrřsštuvwxyzž@");
		}
		else if (displayLang.Contains("hu"))
		{
			groups = "#aábcdeéfghiíjklmnoóöőpqrstuúüűvwxyz@";
			lastChar = "ž";
			reversedGroups = ReverseString("#aábcdeéfghiíjklmnoóöőpqrstuúüűvwxyz@");
		}
		else if (displayLang.Contains("pl"))
		{
			groups = "#aąbcćdeęfghijklłmnńoóprsśtuwyzźż@";
			lastChar = "ż";
			reversedGroups = ReverseString("#aąbcćdeęfghijklłmnńoóprsśtuwyzźż@");
		}
		else if (displayLang.Contains("sv") || displayLang.Contains("fi"))
		{
			groups = "#abcdefghijklmnopqrstuvwxyzåäö@";
			lastChar = "ø";
			reversedGroups = ReverseString("#abcdefghijklmnopqrstuvwxyzåäö@");
		}
		else if (displayLang.Contains("da") || displayLang.Contains("nb"))
		{
			groups = "#abcdefghijklmnopqrstuvwxyzæøå@";
			lastChar = "å";
			reversedGroups = ReverseString("#abcdefghijklmnopqrstuvwxyzæøå@");
		}
		else if (displayLang.Contains("ru"))
		{
			lastChar = "я";
			groups = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя#abcdefghijklmnopqrstuvwxyz";
			reversedGroups = ReverseString("абвгдеёжзийклмнопрстуфхцчшщъыьэюя") + ReverseString("#abcdefghijklmnopqrstuvwxyz");
		}
		else if (displayLang.Contains("ko"))
		{
			lastChar = "힣";
			groups = "ㄱㄴㄷㄹㅁㅂㅅㅇㅈㅊㅋㅌㅍㅎㅗㅏㅠ#abcdefghijklmnopqrstuvwxyz";
			reversedGroups = ReverseString("ㄱㄴㄷㄹㅁㅂㅅㅇㅈㅊㅋㅌㅍㅎㅗㅏㅠ") + ReverseString("#abcdefghijklmnopqrstuvwxyz");
		}
		else if (displayLang.Contains("ja"))
		{
			lastChar = "ん";
			groups = "アカサタナハマヤラワ#abcdefghijklmnopqrstuvwxyz";
			reversedGroups = ReverseString("アカサタナハマヤラワ") + ReverseString("#abcdefghijklmnopqrstuvwxyz");
		}
		else if (displayLang == "zh-CN")
		{
			groups = "#abcdefghijklmnopqrstuvwxyz";
			lastChar = "ž";
			reversedGroups = ReverseString("#abcdefghijklmnopqrstuvwxyz");
			reversedSpacificGroups = ReverseString("吖八攃咑妸发旮哈丌咔㕇妈乸噢帊七冄仨他屲夕丫帀");
		}
		else
		{
			groups = "#abcdefghijklmnopqrstuvwxyzㄱㄴㄷㄹㅁㅂㅅㅇㅈㅊㅋㅌㅍㅎㅗㅏㅠ";
			lastChar = "힣";
			reversedGroups = ReverseString("ㄱㄴㄷㄹㅁㅂㅅㅇㅈㅊㅋㅌㅍㅎㅗㅏㅠ") + ReverseString("#abcdefghijklmnopqrstuvwxyz");
		}
	}

	private string GetCommonLanguageKey(string key)
	{
		if (ci.CompareInfo.Compare(key, lastChar) <= 0)
		{
			string text = reversedGroups;
			for (int i = 0; i < text.Length; i++)
			{
				char c = text[i];
				if (c != '@' && c != '#' && ci.CompareInfo.Compare(key, c.ToString()) >= 0)
				{
					if (c == 'z' && ci.CompareInfo.Compare(key, "ž") > 0)
					{
						return "#";
					}
					return c.ToString();
				}
			}
			key = "#";
		}
		else
		{
			string text2 = reversedGroups;
			for (int j = 0; j < text2.Length; j++)
			{
				char c2 = text2[j];
				if (key[0] == c2)
				{
					return c2.ToString();
				}
			}
			key = "#";
		}
		return key;
	}

	private string GetChineseKey(string key)
	{
		string text = "abcdefghjklmnopqrstwxyz";
		int num = "吖八攃咑妸发旮哈丌咔㕇妈乸噢帊七冄仨他屲夕丫帀".Length;
		string text2 = reversedSpacificGroups;
		foreach (char c in text2)
		{
			num--;
			if (ci.CompareInfo.Compare(key, c.ToString()) >= 0)
			{
				return text[num].ToString();
			}
		}
		key = GetCommonLanguageKey(key);
		return key;
	}
}
