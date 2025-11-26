package com.coolots.p2pmsg.model;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class BinaryMessage {
    private byte[] body;
    private byte[] header;
    private BinaryMessageType type;

    public BinaryMessageType getType() {
        return this.type;
    }

    public void setType(BinaryMessageType type) {
        this.type = type;
    }

    public byte[] getHeader() {
        return this.header;
    }

    public void setHeader(byte[] header) {
        this.header = header;
    }

    public byte[] getBody() {
        return this.body;
    }

    public void setBody(byte[] body) {
        if (body == null) {
            body = new byte[0];
        }
        this.body = body;
    }

    public BinaryMessage(BinaryMessageType type, byte[] messagebytes) {
        this.type = type;
        ByteBuffer buffer = ByteBuffer.wrap(messagebytes);
        int headerLength = buffer.getInt();
        int bodyLength = buffer.getInt();
        if (headerLength > 0) {
            this.header = new byte[headerLength];
            buffer.get(this.header);
        }
        if (bodyLength > 0) {
            this.body = new byte[bodyLength];
            buffer.get(this.body);
        } else {
            this.body = new byte[0];
        }
    }

    public BinaryMessage(BinaryMessageType type, byte[] header, byte[] body) {
        this.type = type;
        this.header = header;
        this.body = body == null ? new byte[0] : body;
    }

    public byte[] get(byte[] message) {
        ByteBuffer buffer = ByteBuffer.allocate(this.type.getLength() + 1 + message.length);
        buffer.put((byte) this.type.getLength());
        buffer.put(this.type.getType());
        buffer.put(message);
        return buffer.array();
    }

    public byte[] getMessageBytes() {
        ByteBuffer buffer = ByteBuffer.allocate(this.header.length + 8 + this.body.length);
        buffer.putInt(this.header.length);
        buffer.putInt(this.body.length);
        buffer.put(this.header);
        buffer.put(this.body);
        return buffer.array();
    }

    public static BinaryMessageType getType(byte[] message) {
        ByteBuffer buffer = ByteBuffer.wrap(message);
        int typeLength = buffer.get();
        if (typeLength <= 0) {
            return null;
        }
        byte[] type = new byte[typeLength];
        buffer.get(type);
        return new BinaryMessageType(type);
    }

    public static byte[] getMessageBytes(byte[] message) {
        ByteBuffer buffer = ByteBuffer.wrap(message);
        int typeLength = buffer.get();
        if (typeLength > 0) {
            byte[] type = new byte[typeLength];
            buffer.get(type);
        }
        byte[] messageBytes = new byte[(message.length - 1) - typeLength];
        buffer.get(messageBytes);
        return messageBytes;
    }
}
