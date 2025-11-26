package com.coolots.chaton.call.screenshare.util;

/* loaded from: classes.dex */
public class ScreenSharePacket {
    public static final byte NOT_PEN_WRITING_MODE = 0;
    public static final byte PEN_WRITING_MODE = 1;
    public static final int SCREEN_SHARE_CMD_CHANGE_DRAWING_REQ_MODE = 401;
    public static final int SCREEN_SHARE_CMD_CHANGE_DRAWING_RESP_MODE = 402;
    public static final int SCREEN_SHARE_CMD_CHANGE_SHARE_MODE = 403;
    public static final int SCREEN_SHARE_CMD_CHNAGE_REMOTE_END = 406;
    public static final int SCREEN_SHARE_CMD_CHNAGE_REMOTE_REQ_MODE = 404;
    public static final int SCREEN_SHARE_CMD_CHNAGE_REMOTE_RESP_MODE = 405;
    public static final int SCREEN_SHARE_CMD_DOCS_MOVE_PAGE = 414;
    public static final int SCREEN_SHARE_CMD_DOCS_START = 410;
    public static final int SCREEN_SHARE_CMD_DOCS_VIEW_DRAWING_REQ_MODE = 412;
    public static final int SCREEN_SHARE_CMD_DOCS_VIEW_DRAWING_RESP_MODE = 413;
    public static final int SCREEN_SHARE_CMD_DOCS_VIEW_FILE_OPEN = 415;
    public static final int SCREEN_SHARE_CMD_DOCS_VIEW_MODE = 411;
    public static final int SCREEN_SHARE_CMD_DRAWING_CLEARALL = 205;
    public static final int SCREEN_SHARE_CMD_DRAWING_CLEARPAGE = 206;
    public static final int SCREEN_SHARE_CMD_DRAWING_ERASER = 202;
    public static final int SCREEN_SHARE_CMD_DRAWING_POINT = 300;
    public static final int SCREEN_SHARE_CMD_DRAWING_REDO = 204;
    public static final int SCREEN_SHARE_CMD_DRAWING_STROKE = 200;
    public static final int SCREEN_SHARE_CMD_DRAWING_UNDO = 203;
    public static final int SCREEN_SHARE_CMD_EXTERNAL_PAUSE = 603;
    public static final int SCREEN_SHARE_CMD_PAUSE = 600;
    public static final int SCREEN_SHARE_CMD_RESTART = 601;
    public static final int SCREEN_SHARE_CMD_ROTATE = 602;
    public static final int SCREEN_SHARE_CMD_SETTING_MATRIXINFO = 150;
    public static final int SCREEN_SHARE_CMD_SETTING_SCREENSIZE = 151;
    public static final int SCREEN_SHARE_CMD_SETTING_STROKEINFO = 100;
    public static final int SCREEN_SHARE_CMD_START = 400;
    public static final int SCREEN_SHARE_CMD_TEXT_INPUT = 301;
    public static final int SCREEN_SHARE_CMD_TEXT_INPUT_CHANGE = 302;
    public static final int SCREEN_SHARE_DOCS_CMD_PEN_MODE = 210;
    public static final int SCREEN_SHARE_DOCS_CMD_VIEW_MODE = 211;
    public static final int SCREEN_SHARE_REMOTE_DATA = 500;
    private static final short mMajorVer = 1;
    private static final short mMinorVer = 1;
    protected int mCommand;
    protected byte[] mCommandData;
    protected byte mCommandType;
    protected long mEventTime;
    protected short mMajorV;
    protected short mMinorV;

    public int getCommand() {
        return this.mCommand;
    }

    public short getMajorVerion() {
        return this.mMajorV;
    }

    public short getMinorVerion() {
        return this.mMinorV;
    }

    public long getEventTime() {
        return this.mEventTime;
    }

    public byte[] getCommandData() {
        return this.mCommandData;
    }

    public byte getCommandType() {
        return this.mCommandType;
    }

    public static byte[] makePacket(int command, byte[] Data) {
        byte[] packetData = new byte[(Data == null ? 0 : Data.length) + 25];
        packetData[0] = 83;
        packetData[1] = 80;
        packetData[2] = 69;
        packetData[3] = 78;
        packetData[4] = isPenWritingMode(command);
        byte[] tmpArr = PenWriteNetwork.shortToByte((short) 1);
        System.arraycopy(tmpArr, 0, packetData, 5, 2);
        int pos = 5 + 2;
        byte[] tmpArr2 = PenWriteNetwork.shortToByte((short) 1);
        System.arraycopy(tmpArr2, 0, packetData, pos, 2);
        int pos2 = pos + 2;
        long cureventTime = System.currentTimeMillis();
        byte[] tmpArr3 = PenWriteNetwork.longToByte(cureventTime);
        System.arraycopy(tmpArr3, 0, packetData, pos2, 8);
        int pos3 = pos2 + 8;
        byte[] tmpArr4 = PenWriteNetwork.intToByte(command);
        System.arraycopy(tmpArr4, 0, packetData, pos3, 4);
        int pos4 = pos3 + 4;
        byte[] tmpArr5 = PenWriteNetwork.intToByte(Data == null ? 0 : Data.length);
        System.arraycopy(tmpArr5, 0, packetData, pos4, 4);
        int pos5 = pos4 + 4;
        if (Data != null) {
            System.arraycopy(Data, 0, packetData, pos5, Data.length);
            int i = pos5 + 4;
        }
        return packetData;
    }

    public static ScreenSharePacket parserPacket(byte[] Data) {
        if (Data[0] == 83 && Data[1] == 80 && Data[2] == 69 && Data[3] == 78) {
            ScreenSharePacket packet = new ScreenSharePacket();
            packet.mCommandType = Data[4];
            byte[] shortData = new byte[2];
            System.arraycopy(Data, 5, shortData, 0, 2);
            packet.mMajorV = (short) PenWriteNetwork.byteToShort(shortData);
            int pos = 5 + 2;
            System.arraycopy(Data, pos, shortData, 0, 2);
            packet.mMinorV = (short) PenWriteNetwork.byteToShort(shortData);
            int pos2 = pos + 2;
            byte[] longData = new byte[8];
            System.arraycopy(Data, pos2, longData, 0, 8);
            packet.mEventTime = PenWriteNetwork.byteToLong(longData);
            int pos3 = pos2 + 8;
            byte[] intData = new byte[4];
            System.arraycopy(Data, pos3, intData, 0, 4);
            packet.mCommand = PenWriteNetwork.byteToInt(intData);
            int pos4 = pos3 + 4;
            System.arraycopy(Data, pos4, intData, 0, 4);
            int commandDataSize = PenWriteNetwork.byteToInt(intData);
            int pos5 = pos4 + 4;
            if (commandDataSize != 0) {
                packet.mCommandData = new byte[commandDataSize];
                System.arraycopy(Data, pos5, packet.mCommandData, 0, commandDataSize);
                return packet;
            }
            return packet;
        }
        return null;
    }

    public static byte isPenWritingMode(int command) {
        switch (command) {
            case 200:
            case 202:
            case SCREEN_SHARE_CMD_DRAWING_UNDO /* 203 */:
            case SCREEN_SHARE_CMD_DRAWING_REDO /* 204 */:
            case SCREEN_SHARE_CMD_DRAWING_CLEARALL /* 205 */:
            case SCREEN_SHARE_DOCS_CMD_PEN_MODE /* 210 */:
            case 301:
                return (byte) 1;
            default:
                return (byte) 0;
        }
    }

    public static byte[] makeStringPacket(String data) {
        byte[] stringByte = data.getBytes();
        byte[] packetData = new byte[stringByte.length + 4];
        byte[] tmpArr = PenWriteNetwork.intToByte(stringByte.length);
        System.arraycopy(tmpArr, 0, packetData, 0, 4);
        System.arraycopy(stringByte, 0, packetData, 4, stringByte.length);
        return packetData;
    }

    public static String parserStringPacket(byte[] Data) {
        byte[] intData = new byte[4];
        System.arraycopy(Data, 0, intData, 0, 4);
        int stringLen = PenWriteNetwork.byteToInt(intData);
        byte[] stringData = new byte[stringLen];
        System.arraycopy(Data, 4, stringData, 0, stringLen);
        return new String(stringData, 0, stringLen);
    }
}
