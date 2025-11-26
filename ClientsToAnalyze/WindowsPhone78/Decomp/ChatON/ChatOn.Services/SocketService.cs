using System;
using System.Collections.Generic;
using System.Net;
using System.Net.Sockets;
using System.Windows;
using System.Windows.Threading;
using ChatOn.Models;
using com.sec.ssm.common;

namespace ChatOn.Services;

public class SocketService
{
	public delegate void SocketEventHandler(object sender, SocketEventArgs e);

	public delegate void SocketMessageHandler(object sender, object arg);

	private const int BUFFER_SIZE = 5242880;

	private static SocketService _instance;

	private SSMServer _svrAddress;

	private UserAccountInfo _account;

	private Socket _socket;

	private DnsEndPoint _endPoint;

	private Chat _chat;

	private byte[] _buffer;

	private int _transferredSize;

	private int _totalSize;

	private bool _forceDisconnect;

	private bool _toEndChat;

	private bool _disconnectRequested;

	private DispatcherTimer _disconnectTimer;

	public static SocketService Instance
	{
		get
		{
			if (_instance == null)
			{
				_instance = new SocketService();
			}
			return _instance;
		}
	}

	public bool DisconnectRequested
	{
		get
		{
			return _disconnectRequested;
		}
		set
		{
			_disconnectRequested = value;
		}
	}

	public Chat Chat
	{
		get
		{
			return _chat;
		}
		set
		{
			_chat = value;
		}
	}

	public bool IsConnected
	{
		get
		{
			if (_socket != null)
			{
				return _socket.Connected;
			}
			return false;
		}
	}

	public bool ToEndChat
	{
		get
		{
			return _toEndChat;
		}
		set
		{
			_toEndChat = value;
		}
	}

	public event SocketEventHandler Connected;

	public event SocketMessageHandler DeliveryChatCompleted;

	public event SocketMessageHandler InitChatReplyReceived;

	public event SocketMessageHandler AllowChatReplyReceived;

	public event SocketMessageHandler ChatReplyReceived;

	public event SocketMessageHandler AnnounceChangeReceived;

	public event SocketMessageHandler EndChatReplyReceived;

	public event SocketMessageHandler AnswerBackReceived;

	public event SocketMessageHandler NickNameReplyReceived;

	public event SocketMessageHandler InviteChatReplyReceived;

	public event SocketMessageHandler OnSocketError;

	private SocketService()
	{
		_svrAddress = SSMService.GetServerInfo();
		_account = RegistrationService.GetUserAccount();
		_socket = new Socket(AddressFamily.InterNetwork, SocketType.Stream, ProtocolType.Tcp);
		_buffer = new byte[5242880];
		_transferredSize = 0;
		_totalSize = 0;
		_disconnectTimer = new DispatcherTimer();
		_disconnectTimer.Tick += _disconnectTimer_Tick;
		_disconnectTimer.Interval = TimeSpan.FromMilliseconds(200.0);
	}

	private void _disconnectTimer_Tick(object sender, EventArgs e)
	{
		if (!_socket.Connected)
		{
			_disconnectTimer.Stop();
		}
		else
		{
			ShutDown();
		}
	}

	private void Connect()
	{
		if (string.IsNullOrEmpty(_chat.Address))
		{
			_endPoint = new DnsEndPoint(_svrAddress.MsgServer.Url, int.Parse(_svrAddress.MsgServer.Port));
		}
		else
		{
			_endPoint = new DnsEndPoint(_chat.Address, _chat.Port);
		}
		SocketAsyncEventArgs e = new SocketAsyncEventArgs();
		e.UserToken = _socket;
		e.RemoteEndPoint = _endPoint;
		e.Completed -= OnSocketEventReceived;
		e.Completed += OnSocketEventReceived;
		_socket = new Socket(AddressFamily.InterNetwork, SocketType.Stream, ProtocolType.Tcp);
		_socket.ConnectAsync(e);
		_forceDisconnect = false;
		_transferredSize = 0;
		_totalSize = 0;
		_disconnectRequested = false;
	}

	public void Disconnect()
	{
		if (!_socket.Connected)
		{
			return;
		}
		_forceDisconnect = true;
		Deployment.Current.Dispatcher.BeginInvoke(delegate
		{
			if (!_disconnectTimer.IsEnabled)
			{
				try
				{
					_disconnectTimer.Start();
				}
				catch (Exception)
				{
				}
			}
		});
	}

	private void ShutDown()
	{
		_socket.Shutdown(SocketShutdown.Both);
		_socket.Close();
	}

	private void OnSocketEventReceived(object sender, SocketAsyncEventArgs e)
	{
		if (e.SocketError == SocketError.Success)
		{
			switch (e.LastOperation)
			{
			case SocketAsyncOperation.Connect:
				HandleConnect(e);
				break;
			case SocketAsyncOperation.Receive:
				HandleReceive(e);
				break;
			case SocketAsyncOperation.Send:
				if (e.ConnectSocket != null)
				{
					e.ConnectSocket.Shutdown(SocketShutdown.Both);
					e.ConnectSocket.Close();
				}
				break;
			default:
				throw new Exception("Invalid operation completed");
			}
		}
		else if (!_forceDisconnect)
		{
			if (this.OnSocketError != null)
			{
				this.OnSocketError(this, null);
			}
			_forceDisconnect = false;
		}
	}

	private void HandleConnect(SocketAsyncEventArgs context)
	{
		if (context.SocketError != SocketError.Success)
		{
			if (this.OnSocketError != null)
			{
				this.OnSocketError(this, null);
			}
		}
		else if (_socket.Connected && !_forceDisconnect)
		{
			if (this.Connected != null)
			{
				this.Connected(this, new SocketEventArgs(""));
			}
			if (_chat.IsChanged && !_toEndChat && _chat.ChatType != ChatType.BROADCAST)
			{
				SendAllowChatRequestMsg();
			}
			StartReceiving();
		}
	}

	internal void SendAllowChatRequestMsg()
	{
		SendMsg(SocketMessage.AllowChatRequestMsg(_chat.Sender, _account.MSISDN, _account.Uid, _account.IMEI, _chat.SessionID, _svrAddress.Key, _chat.ChatType));
	}

	private void StartReceiving()
	{
		if (!_socket.Connected)
		{
			return;
		}
		byte[] array = new byte[5242880];
		SocketAsyncEventArgs e = new SocketAsyncEventArgs();
		e.SetBuffer(array, 0, array.Length);
		e.UserToken = _socket;
		e.RemoteEndPoint = _endPoint;
		e.Completed -= OnSocketEventReceived;
		e.Completed += OnSocketEventReceived;
		try
		{
			if (!_socket.ReceiveAsync(e))
			{
				HandleReceive(e);
			}
		}
		catch (Exception)
		{
			e.Dispose();
			if (this.OnSocketError != null)
			{
				this.OnSocketError(this, null);
			}
		}
	}

	public void SendMsg(byte[] sendByte)
	{
		if (!_socket.Connected)
		{
			Connect();
		}
		SocketAsyncEventArgs e = new SocketAsyncEventArgs();
		e.UserToken = _socket;
		e.RemoteEndPoint = _endPoint;
		e.SetBuffer(sendByte, 0, sendByte.Length);
		e.Completed -= OnSocketEventReceived;
		e.Completed += OnSocketEventReceived;
		try
		{
			_socket.SendAsync(e);
		}
		catch (Exception)
		{
			if (this.OnSocketError != null)
			{
				this.OnSocketError(this, null);
			}
		}
	}

	private void HandleReceive(SocketAsyncEventArgs e)
	{
		Buffer.BlockCopy(e.Buffer, 0, _buffer, _transferredSize, e.BytesTransferred);
		_transferredSize += e.BytesTransferred;
		if (_totalSize == 0)
		{
			byte[] array = new byte[2];
			array[1] = e.Buffer[38];
			array[0] = e.Buffer[39];
			ushort num = BitConverter.ToUInt16(array, 0);
			_totalSize = num + 40;
		}
		if (_totalSize > _transferredSize)
		{
			StartReceiving();
			return;
		}
		bool disconnect = _forceDisconnect;
		int num2 = 0;
		while (num2 < _transferredSize && !_forceDisconnect)
		{
			byte[] array2 = new byte[2];
			array2[1] = _buffer[num2 + 38];
			array2[0] = _buffer[num2 + 39];
			ushort num3 = BitConverter.ToUInt16(array2, 0);
			if (num3 > _transferredSize - num2)
			{
				_totalSize = num3 + 40;
				_transferredSize -= num2;
				byte[] array3 = new byte[_transferredSize];
				Buffer.BlockCopy(_buffer, num2, array3, 0, _transferredSize);
				Buffer.BlockCopy(array3, 0, _buffer, 0, _transferredSize);
				StartReceiving();
				return;
			}
			SocketMessage.Type type = (SocketMessage.Type)_buffer[num2 + 37];
			byte[] array4 = new byte[num3];
			Buffer.BlockCopy(_buffer, num2 + 40, array4, 0, num3);
			num2 += 40 + num3;
			switch (type)
			{
			case SocketMessage.Type.InitChatReply:
				HandleInitChatReply(array4);
				break;
			case SocketMessage.Type.AllowChatReply:
				HandleAllowChatReply(array4);
				break;
			case SocketMessage.Type.DisconnectRequest:
				HandleDisconnectRequest(array4, ref disconnect);
				break;
			case SocketMessage.Type.AnswerBack:
				HandleAnswerBack(array4);
				break;
			case SocketMessage.Type.ChatReply:
				HandleChatReply(array4);
				break;
			case SocketMessage.Type.DeliveryChat:
				HandleDeliveryChat(array4);
				break;
			case SocketMessage.Type.AnnounceChange:
				HandleAnnounceChange(array4);
				break;
			case SocketMessage.Type.EndChatReply:
				HandleEndChatReply(array4);
				break;
			case SocketMessage.Type.NickNameReply:
				HandleNickNameReply(array4);
				break;
			case SocketMessage.Type.InviteChatReply:
				HandleInviteChatReply(array4);
				break;
			}
		}
		_totalSize = 0;
		_transferredSize = 0;
		if (disconnect)
		{
			Disconnect();
		}
		else
		{
			StartReceiving();
		}
	}

	private byte[] HandleDeliveryChat(byte[] body)
	{
		Utility.Decrypt(_svrAddress.Key, body, out byte[] ret);
		if (ret != null)
		{
			DeliveryChat deliveryChat = DeliveryChat.ParseFrom(ret);
			if (this.DeliveryChatCompleted != null)
			{
				this.DeliveryChatCompleted(this, deliveryChat);
			}
			if (!_forceDisconnect)
			{
				SendDeliveryChatReplyMsg(deliveryChat);
			}
		}
		return ret;
	}

	private void SendDeliveryChatReplyMsg(DeliveryChat chatMsg)
	{
		if (chatMsg.InboxMessageList.Count != 0)
		{
			SendMsg(SocketMessage.DeliveryChatReplyMsg(chatMsg.InboxMessageList, _account.Uid, _svrAddress.Key, _account.MSISDN));
		}
		else
		{
			SendMsg(SocketMessage.DeliveryChatReplyMsg(_account.Uid, _svrAddress.Key));
		}
	}

	private byte[] HandleAnnounceChange(byte[] body)
	{
		Utility.Decrypt(_svrAddress.Key, body, out byte[] ret);
		if (ret != null)
		{
			AnnounceChange announceChange = AnnounceChange.ParseFrom(ret);
			if (this.AnnounceChangeReceived != null)
			{
				this.AnnounceChangeReceived(this, announceChange);
			}
			SendMsg(SocketMessage.AnnounceChangeReply(_account.Uid, _svrAddress.Key, announceChange.MsgID));
		}
		return ret;
	}

	private byte[] HandleNickNameReply(byte[] body)
	{
		Utility.Decrypt(_svrAddress.Key, body, out byte[] ret);
		if (ret != null)
		{
			NicknameReply arg = NicknameReply.ParseFrom(ret);
			if (this.NickNameReplyReceived != null)
			{
				this.NickNameReplyReceived(this, arg);
			}
		}
		return ret;
	}

	private byte[] HandleChatReply(byte[] body)
	{
		Utility.Decrypt(_svrAddress.Key, body, out byte[] ret);
		if (ret != null)
		{
			ChatReply chatReply = ChatReply.ParseFrom(ret);
			_chat.Address = chatReply.ServerInfo.Address;
			_chat.Port = chatReply.ServerInfo.Port;
			if (this.ChatReplyReceived != null)
			{
				this.ChatReplyReceived(this, chatReply);
			}
		}
		return ret;
	}

	private byte[] HandleEndChatReply(byte[] body)
	{
		Utility.Decrypt(_svrAddress.Key, body, out byte[] ret);
		if (ret != null)
		{
			EndChatReply arg = EndChatReply.ParseFrom(ret);
			if (this.EndChatReplyReceived != null)
			{
				this.EndChatReplyReceived(this, arg);
			}
		}
		return ret;
	}

	private void HandleAnswerBack(byte[] body)
	{
		try
		{
			Utility.Decrypt(_svrAddress.Key, body, out byte[] ret);
			AnswerBack answerBack = AnswerBack.ParseFrom(ret);
			if (this.AnswerBackReceived != null)
			{
				this.AnswerBackReceived(this, answerBack);
			}
			SendMsg(SocketMessage.AnswerBackReplyMsg(answerBack.AnswerbackItemsList, _account.Uid, _svrAddress.Key, _account.MSISDN));
		}
		catch (Exception)
		{
		}
	}

	private byte[] HandleDisconnectRequest(byte[] body, ref bool disconnect)
	{
		Utility.Decrypt(_svrAddress.Key, body, out byte[] ret);
		DisconnectRequest disconnectRequest = DisconnectRequest.ParseFrom(ret);
		SendMsg(SocketMessage.DisconnectReplyMsg(disconnectRequest.MsgID, _account.Uid, _svrAddress.Key));
		disconnect = true;
		_disconnectRequested = true;
		return ret;
	}

	private void HandleInitChatReply(byte[] body)
	{
		Utility.Decrypt(_svrAddress.Key, body, out byte[] ret);
		InitChatReply initChatReply = InitChatReply.ParseFrom(ret);
		_chat.SessionID = initChatReply.SessionID;
		_chat.Address = initChatReply.ServerInfo.Address;
		_chat.Port = initChatReply.ServerInfo.Port;
		if (this.InitChatReplyReceived != null)
		{
			this.InitChatReplyReceived(this, initChatReply);
		}
	}

	private void HandleAllowChatReply(byte[] body)
	{
		Utility.Decrypt(_svrAddress.Key, body, out byte[] ret);
		AllowChatReply.ParseFrom(ret);
		if (this.AllowChatReplyReceived != null)
		{
			this.AllowChatReplyReceived(this, this.AllowChatReplyReceived);
		}
	}

	private void HandleInviteChatReply(byte[] body)
	{
		Utility.Decrypt(_svrAddress.Key, body, out byte[] ret);
		InviteChatReply arg = InviteChatReply.ParseFrom(ret);
		if (this.InviteChatReplyReceived != null)
		{
			this.InviteChatReplyReceived(this, arg);
		}
	}

	public void SendChatMsg(string inputMsg, long msgID, MsgType msgType)
	{
		string body = inputMsg.Replace('\r', '\n');
		if (string.IsNullOrEmpty(_chat.SessionID))
		{
			SendMsg(SocketMessage.InitChatRequestMsg(msgID, _account.MSISDN, _chat.Members, _account.Uid, _account.IMEI, body, _svrAddress.Key, _chat.ChatType, msgType));
		}
		else
		{
			SendMsg(SocketMessage.ChatRequestMsg(msgID, _account.MSISDN, _chat.Members, _account.Uid, _account.IMEI, body, _chat.SessionID, _svrAddress.Key, _chat.ChatType, msgType));
		}
	}

	public void SendCloseMsg()
	{
		if (!string.IsNullOrEmpty(_chat.SessionID))
		{
			SendMsg(SocketMessage.EndChatRequest(_account.MSISDN, _chat.Sender, _account.Uid, _chat.SessionID, _svrAddress.Key, _chat.ChatType));
		}
	}

	public void SendNickNameRequestMsg(string number)
	{
		SendMsg(SocketMessage.NickNameRequest(_account.Uid, _svrAddress.Key, number));
	}

	public void SendInviteChatRequestMsg(long msgid, List<string> newMembers)
	{
		SendMsg(SocketMessage.InviteChatRequest(msgid, _chat.SessionID, _account.MSISDN, _chat.MemberList, newMembers, _svrAddress.Key, _account.Uid));
	}

	internal void Init()
	{
		_transferredSize = 0;
		_totalSize = 0;
		Connect();
	}

	internal void Reset()
	{
		this.Connected = null;
		this.AllowChatReplyReceived = null;
		this.DeliveryChatCompleted = null;
		this.InitChatReplyReceived = null;
		this.ChatReplyReceived = null;
		this.AnnounceChangeReceived = null;
		this.EndChatReplyReceived = null;
		this.AnswerBackReceived = null;
		this.NickNameReplyReceived = null;
		this.InviteChatReplyReceived = null;
		this.OnSocketError = null;
		Disconnect();
		_toEndChat = false;
		_disconnectRequested = false;
	}
}
