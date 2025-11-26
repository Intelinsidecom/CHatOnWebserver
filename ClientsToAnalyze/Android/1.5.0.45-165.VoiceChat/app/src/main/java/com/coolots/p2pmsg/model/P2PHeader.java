package com.coolots.p2pmsg.model;

import com.nuance.nmsp.client.sdk.common.protocols.ProtocolDefines;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class P2PHeader {
    public static final int APP_LEVEL = 2;
    public static final int CDC_RELAY = 10;
    public static final int ENC_RESERVED = 7;
    public static final int KEEP_ALIVE = 6;
    public static final int MAJOR_VERSION = 1;
    public static final int MEDIA_LEVEL = 3;
    public static final int MINOR_VERSION = 0;
    public static final int NETWORK_LEVEL = 1;
    public static final int NO_RELAY = 0;
    public static final int NO_RELAY_ENC_PRIVATE = 9;
    public static final int NO_RELAY_ENC_PUBLIC = 8;
    public static final String P2P_HEADER_PREFIX = "P2P";
    public static final int SIP_RELAY = 5;
    public static final int TCP_RELAY = 1;
    public static final int TCP_UDP_RELAY = 3;
    public static final int UDP_RELAY = 2;
    public static final int UDP_TCP_RELAY = 4;
    private final transient byte[] prefix = P2P_HEADER_PREFIX.getBytes();
    private transient byte version = 10;
    private byte relayType = 0;
    private byte msgLevel = 0;
    private long senderUserNo = 0;
    private short senderDeviceId = 0;
    private long receiverUserNo = 0;
    private short receiverDeviceId = 0;
    private int senderIP = 0;
    private short senderPort = 0;
    private int receiverIP = 0;
    private short receiverPort = 0;
    private int udpRelayServerIP = 0;
    private short udpRelayServerPort = 0;
    private short senderSessionID = 0;
    private short senderChannelID = 0;
    private short receiverSessionID = 0;
    private short receiverChannelID = 0;
    private int transactionKey = 0;
    private byte fragments = 1;
    private byte fragmentsNo = 0;
    private short msgLength = 0;

    public int getSize() {
        return this.prefix.length + 1 + 1 + 1 + 8 + 2 + 8 + 2 + 4 + 2 + 4 + 2 + 4 + 2 + 2 + 2 + 2 + 2 + 4 + 1 + 1 + 2;
    }

    public byte[] getBytes() {
        return makeHeader();
    }

    public byte[] makeHeader() {
        ByteBuffer bfHeader = ByteBuffer.allocate(getSize());
        bfHeader.put(this.prefix);
        bfHeader.put(this.version);
        bfHeader.put(this.relayType);
        bfHeader.put(this.msgLevel);
        bfHeader.putLong(this.senderUserNo);
        bfHeader.putShort(this.senderDeviceId);
        bfHeader.putLong(this.receiverUserNo);
        bfHeader.putShort(this.receiverDeviceId);
        bfHeader.putInt(this.senderIP);
        bfHeader.putShort(this.senderPort);
        bfHeader.putInt(this.receiverIP);
        bfHeader.putShort(this.receiverPort);
        bfHeader.putInt(this.udpRelayServerIP);
        bfHeader.putShort(this.udpRelayServerPort);
        bfHeader.putShort(this.senderSessionID);
        bfHeader.putShort(this.senderChannelID);
        bfHeader.putShort(this.receiverSessionID);
        bfHeader.putShort(this.receiverChannelID);
        bfHeader.putInt(this.transactionKey);
        bfHeader.put(this.fragments);
        bfHeader.put(this.fragmentsNo);
        bfHeader.putShort(this.msgLength);
        return bfHeader.array();
    }

    public void parseHeader(byte[] headerBytes) {
        ByteBuffer bfHeader = ByteBuffer.wrap(headerBytes);
        bfHeader.get(this.prefix);
        this.version = bfHeader.get();
        this.relayType = bfHeader.get();
        this.msgLevel = bfHeader.get();
        this.senderUserNo = bfHeader.getLong();
        this.senderDeviceId = bfHeader.getShort();
        this.receiverUserNo = bfHeader.getLong();
        this.receiverDeviceId = bfHeader.getShort();
        this.senderIP = bfHeader.getInt();
        this.senderPort = bfHeader.getShort();
        this.receiverIP = bfHeader.getInt();
        this.receiverPort = bfHeader.getShort();
        this.udpRelayServerIP = bfHeader.getInt();
        this.udpRelayServerPort = bfHeader.getShort();
        this.senderSessionID = bfHeader.getShort();
        this.senderChannelID = bfHeader.getShort();
        this.receiverSessionID = bfHeader.getShort();
        this.receiverChannelID = bfHeader.getShort();
        this.transactionKey = bfHeader.getInt();
        this.fragments = bfHeader.get();
        this.fragmentsNo = bfHeader.get();
        this.msgLength = bfHeader.getShort();
    }

    public int getVersion() {
        return this.version;
    }

    public int getRelayType() {
        return this.relayType;
    }

    public void setRelayType(int nType) {
        this.relayType = (byte) nType;
    }

    public int getMsgLevel() {
        return this.msgLevel;
    }

    public void setMsgLevel(int nLevel) {
        this.msgLevel = (byte) nLevel;
    }

    public long getSenderUserNo() {
        return this.senderUserNo;
    }

    public void setSenderUserNo(long dwUserNo) {
        this.senderUserNo = dwUserNo;
    }

    public short getSenderDeviceId() {
        return this.senderDeviceId;
    }

    public void setSenderDeviceId(short deviceId) {
        this.senderDeviceId = deviceId;
    }

    public long getReceiverUserNo() {
        return this.receiverUserNo;
    }

    public void setReceiverUserNo(long dwUserNo) {
        this.receiverUserNo = dwUserNo;
    }

    public short getReceiverDeviceId() {
        return this.receiverDeviceId;
    }

    public void setReceiverDeviceId(short deviceId) {
        this.receiverDeviceId = deviceId;
    }

    public String getSenderIP() {
        return toIPString(this.senderIP);
    }

    public void setSenderIP(String strIP) throws UnknownHostException {
        this.senderIP = toIPInt(strIP);
    }

    public void setSenderIP(int dwIP) {
        this.senderIP = dwIP;
    }

    public short getSenderPort() {
        return this.senderPort;
    }

    public void setSenderPort(short nPort) {
        this.senderPort = nPort;
    }

    public String getReceiverIP() {
        return toIPString(this.receiverIP);
    }

    public void setReceiverIP(String strIP) throws UnknownHostException {
        this.receiverIP = toIPInt(strIP);
    }

    public void setReceiverIP(int dwIP) {
        this.receiverIP = dwIP;
    }

    public short getReceiverPort() {
        return this.receiverPort;
    }

    public void setReceiverPort(short nPort) {
        this.receiverPort = nPort;
    }

    public short getSenderSessionID() {
        return this.senderSessionID;
    }

    public void setSenderSessionID(short wSessID) {
        this.senderSessionID = wSessID;
    }

    public short getReceiverSessionID() {
        return this.receiverSessionID;
    }

    public void setReceiverSessionID(short wSessID) {
        this.receiverSessionID = wSessID;
    }

    public short getSenderChannelID() {
        return this.senderChannelID;
    }

    public void setSenderChannelID(short wChID) {
        this.senderChannelID = wChID;
    }

    public short getReceiverChannelID() {
        return this.receiverChannelID;
    }

    public void setReceiverChannelID(short wChID) {
        this.receiverChannelID = wChID;
    }

    public int getTransactionKey() {
        return this.transactionKey;
    }

    public void setTransactionKey(int transactionKey) {
        this.transactionKey = transactionKey;
    }

    public int getFragments() {
        return this.fragments;
    }

    public void setFragments(int nCount) {
        this.fragments = (byte) nCount;
    }

    public int getFragmentsNo() {
        return this.fragmentsNo;
    }

    public void setFragmentsNo(int nNo) {
        this.fragmentsNo = (byte) nNo;
    }

    public int getMsgLength() {
        return this.msgLength;
    }

    public void setMsgLength(short wMsgLength) {
        this.msgLength = wMsgLength;
    }

    public String getUdpRelayServerIP() {
        return toIPString(this.udpRelayServerIP);
    }

    public void setUdpRelayServerIP(String strIP) throws UnknownHostException {
        this.udpRelayServerIP = toIPInt(strIP);
    }

    public void setUdpRelayServerIP(int dwIP) {
        this.udpRelayServerIP = dwIP;
    }

    public short getUdpRelayServerPort() {
        return this.udpRelayServerPort;
    }

    public void setUdpRelayServerPort(short wPort) {
        this.udpRelayServerPort = wPort;
    }

    private String toIPString(int addr) {
        StringBuffer sbIP = new StringBuffer(64);
        sbIP.append((addr >>> 24) & 255);
        sbIP.append('.');
        sbIP.append((addr >>> 16) & 255);
        sbIP.append('.');
        sbIP.append((addr >>> 8) & 255);
        sbIP.append('.');
        sbIP.append(addr & 255);
        return sbIP.toString();
    }

    private int toIPInt(String addr) throws UnknownHostException {
        byte[] btAddr = InetAddress.getByName(addr).getAddress();
        int nIP = 0 | ((btAddr[0] << 24) & (-16777216));
        return nIP | ((btAddr[1] << ProtocolDefines.XMODE_SERVER_SESSION_UUID_SIZE) & 16711680) | ((btAddr[2] << 8) & 65280) | (btAddr[3] & 255);
    }
}
