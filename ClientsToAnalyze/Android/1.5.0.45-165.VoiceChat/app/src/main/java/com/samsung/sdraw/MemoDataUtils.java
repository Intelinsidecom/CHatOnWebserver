package com.samsung.sdraw;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import com.samsung.sdraw.StrokeSprite;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class MemoDataUtils {

    /* renamed from: n */
    private AbstractModeContext f1081n;

    /* renamed from: o */
    private LinkedList<AbstractSprite> f1082o;

    /* renamed from: p */
    private LinkedList<SpriteCommand> f1083p;

    /* renamed from: q */
    private LinkedList<SpriteCommand> f1084q;

    /* renamed from: a */
    private static int f1068a = -65536;
    public static int SEPARATOR_VERSION = f1068a | 1;

    /* renamed from: b */
    private static int f1069b = f1068a | 2;

    /* renamed from: c */
    private static int f1070c = f1068a | 3;

    /* renamed from: d */
    private static int f1071d = f1068a | 4;

    /* renamed from: e */
    private static int f1072e = f1068a | 5;

    /* renamed from: f */
    private static int f1073f = f1068a | 6;
    public static int SEPARATOR_COMMAND = f1068a | 7;

    /* renamed from: g */
    private static int f1074g = f1068a | 8;

    /* renamed from: h */
    private static int f1075h = f1068a | 9;

    /* renamed from: i */
    private static int f1076i = f1068a | 10;

    /* renamed from: j */
    private static int f1077j = f1068a | 11;

    /* renamed from: k */
    private static int f1078k = f1068a | 12;

    /* renamed from: l */
    private static int f1079l = f1068a | 13;

    /* renamed from: m */
    private static int f1080m = f1068a | 14;

    public static class StrokePoint {
        public float mPressure;

        /* renamed from: mX */
        public float f1085mX;

        /* renamed from: mY */
        public float f1086mY;
    }

    public MemoDataUtils(AbstractModeContext context) {
        this.f1081n = context;
    }

    public void initializeSprites(byte[] fixedData) {
        this.f1081n.stage.clearStage();
        if (fixedData != null) {
            this.f1081n.stage.m820a(BitmapFactory.decodeByteArray(fixedData, 0, fixedData.length));
        }
    }

    public void parse(byte[] byteData, byte[] fixedData, Vector<ByteBuffer> imageData) {
        this.f1081n.stage.clearStage();
        initializeSprites(fixedData);
        parseByteData(byteData, imageData);
        this.f1081n.onActivate(true);
    }

    public void parseByteData(byte[] data, Vector<ByteBuffer> imageData) {
        int i;
        int i2;
        Layout.Alignment alignment;
        if (data == null) {
            throw new NullPointerException("parseByteData is null");
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(data.length);
        if (byteBufferAllocate != null) {
            byteBufferAllocate.put(data);
            byteBufferAllocate.rewind();
            if (SEPARATOR_VERSION == byteBufferAllocate.getInt()) {
                int i3 = byteBufferAllocate.getInt();
                byteBufferAllocate.get(new byte[i3], 0, i3);
                if (f1069b == byteBufferAllocate.getInt()) {
                    int i4 = byteBufferAllocate.getInt();
                    int i5 = byteBufferAllocate.getInt();
                    byteBufferAllocate.getDouble();
                    if (i4 <= 0) {
                        i4 = 1;
                    }
                    if (i5 <= 0) {
                        i5 = 1;
                    }
                    this.f1081n.changeCanvasSize(new Rect(0, 0, i4, i5));
                }
                StrokeSprite.Type[] typeArrValuesCustom = StrokeSprite.Type.valuesCustom();
                StrokeSprite.ThicknessParameter[] thicknessParameterArrValuesCustom = StrokeSprite.ThicknessParameter.valuesCustom();
                StrokeSprite.InputMethod[] inputMethodArrValuesCustom = StrokeSprite.InputMethod.valuesCustom();
                int i6 = byteBufferAllocate.getInt();
                if (f1070c == i6) {
                    int i7 = 0;
                    int i8 = i6;
                    while (true) {
                        if (byteBufferAllocate.position() >= byteBufferAllocate.capacity() - 3) {
                            i = i8;
                        } else {
                            i = byteBufferAllocate.getInt();
                            if (f1071d == i) {
                                StrokeSprite.Type type = typeArrValuesCustom[byteBufferAllocate.getInt()];
                                int i9 = byteBufferAllocate.getInt();
                                StrokeSprite.ThicknessParameter thicknessParameter = thicknessParameterArrValuesCustom[byteBufferAllocate.getInt()];
                                StrokeSprite.InputMethod inputMethod = inputMethodArrValuesCustom[byteBufferAllocate.getInt()];
                                int i10 = byteBufferAllocate.getInt();
                                boolean z = byteBufferAllocate.getInt() != 0;
                                boolean z2 = byteBufferAllocate.getInt() != 0;
                                int i11 = byteBufferAllocate.getInt();
                                int i12 = byteBufferAllocate.getInt();
                                int i13 = byteBufferAllocate.getInt();
                                int i14 = byteBufferAllocate.getInt();
                                byteBufferAllocate.getDouble();
                                StrokeSprite strokeSpriteMo1401a = this.f1081n.factory.mo1401a(type, thicknessParameter, inputMethod, i10, i9, i12);
                                strokeSpriteMo1401a.objectID = i11;
                                strokeSpriteMo1401a.multiUserID = i13;
                                strokeSpriteMo1401a.multiObjectID = i14;
                                if (inputMethod == StrokeSprite.InputMethod.Hand) {
                                    strokeSpriteMo1401a.m1144a(this.f1081n.setting.m1108b());
                                    strokeSpriteMo1401a.m1149b(this.f1081n.setting.m1113d());
                                } else {
                                    strokeSpriteMo1401a.m1144a(this.f1081n.setting.m1104a(strokeSpriteMo1401a.getType()));
                                    strokeSpriteMo1401a.m1149b(this.f1081n.setting.m1109b(strokeSpriteMo1401a.getType()));
                                }
                                this.f1081n.stage.addSprite(strokeSpriteMo1401a, false, strokeSpriteMo1401a.multiUserID);
                                strokeSpriteMo1401a.m1159e(z2);
                                strokeSpriteMo1401a.setVisible(z);
                                int i15 = byteBufferAllocate.getInt();
                                for (int i16 = 0; i16 < i15; i16++) {
                                    StrokePoint strokePoint = new StrokePoint();
                                    strokePoint.f1085mX = byteBufferAllocate.getFloat();
                                    strokePoint.f1086mY = byteBufferAllocate.getFloat();
                                    strokePoint.mPressure = byteBufferAllocate.getFloat();
                                    if (strokeSpriteMo1401a.m1152b(strokePoint.f1085mX, strokePoint.f1086mY, strokePoint.mPressure, 0L, false)) {
                                        strokeSpriteMo1401a.m1147b(true);
                                    }
                                }
                                if (i15 > 0) {
                                    strokeSpriteMo1401a.m1164i();
                                    strokeSpriteMo1401a.m1157d(true);
                                    this.f1081n.stage.drawBackgroundTheme();
                                    this.f1081n.stage.renderSprite(0, strokeSpriteMo1401a);
                                    i8 = i;
                                } else {
                                    i8 = i;
                                }
                            } else if (f1072e == i) {
                                PointF pointF = new PointF(byteBufferAllocate.getFloat(), byteBufferAllocate.getFloat());
                                PointF pointF2 = new PointF(byteBufferAllocate.getFloat(), byteBufferAllocate.getFloat());
                                int i17 = byteBufferAllocate.getInt();
                                boolean z3 = byteBufferAllocate.getInt() != 0;
                                int i18 = byteBufferAllocate.getInt();
                                int i19 = byteBufferAllocate.getInt();
                                int i20 = byteBufferAllocate.getInt();
                                int i21 = byteBufferAllocate.getInt();
                                int i22 = byteBufferAllocate.getInt();
                                byteBufferAllocate.getDouble();
                                int i23 = byteBufferAllocate.getInt();
                                byte[] bArr = new byte[i23];
                                byteBufferAllocate.get(bArr, 0, i23);
                                String str = new String(bArr);
                                C0989ab c0989abMo1404a = this.f1081n.factory.mo1404a(pointF.x, pointF.y, (int) pointF2.x, (int) pointF2.y, i19, i20);
                                if (i7 > imageData.size() - 1) {
                                    i8 = i;
                                } else {
                                    this.f1081n.stage.addSprite(c0989abMo1404a, false, i21);
                                    ByteBuffer byteBuffer = imageData.get(i7);
                                    byteBuffer.rewind();
                                    Bitmap bitmapCreateBitmap = Bitmap.createBitmap(byteBuffer.getInt(), byteBuffer.getInt(), Bitmap.Config.ARGB_8888);
                                    bitmapCreateBitmap.copyPixelsFromBuffer(byteBuffer);
                                    c0989abMo1404a.m1257a(bitmapCreateBitmap);
                                    c0989abMo1404a.m1260b(i17);
                                    c0989abMo1404a.setVisible(z3);
                                    c0989abMo1404a.objectID = i18;
                                    c0989abMo1404a.multiUserID = i21;
                                    c0989abMo1404a.multiObjectID = i22;
                                    c0989abMo1404a.f1422i = str;
                                    i7++;
                                    i8 = i;
                                }
                            } else if (f1073f == i) {
                                Rect rect = new Rect(byteBufferAllocate.getInt(), byteBufferAllocate.getInt(), byteBufferAllocate.getInt(), byteBufferAllocate.getInt());
                                int i24 = byteBufferAllocate.getInt();
                                int i25 = byteBufferAllocate.getInt();
                                boolean z4 = byteBufferAllocate.getInt() != 0;
                                int i26 = byteBufferAllocate.getInt();
                                int i27 = byteBufferAllocate.getInt();
                                int i28 = byteBufferAllocate.getInt();
                                int i29 = byteBufferAllocate.getInt();
                                int i30 = byteBufferAllocate.getInt();
                                int i31 = byteBufferAllocate.getInt();
                                byte[] bArr2 = new byte[i31];
                                byteBufferAllocate.get(bArr2, 0, i31);
                                String str2 = new String(bArr2);
                                int i32 = byteBufferAllocate.getInt();
                                byte[] bArr3 = new byte[i32];
                                byteBufferAllocate.get(bArr3, 0, i32);
                                String str3 = new String(bArr3);
                                int i33 = byteBufferAllocate.getInt();
                                byte[] bArr4 = new byte[i33];
                                byteBufferAllocate.get(bArr4, 0, i33);
                                String str4 = new String(bArr4);
                                byteBufferAllocate.getDouble();
                                C1040bz c1040bz = new C1040bz(((ModeContext) this.f1081n).view.getContext(), str3);
                                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str2);
                                spannableStringBuilder.setSpan(new ForegroundColorSpan(i25), 0, spannableStringBuilder.length(), 18);
                                spannableStringBuilder.setSpan(new AbsoluteSizeSpan(i24 * 4), 0, spannableStringBuilder.length(), 18);
                                spannableStringBuilder.setSpan(c1040bz, 0, spannableStringBuilder.length(), 18);
                                switch (i26) {
                                    case 1:
                                        spannableStringBuilder.setSpan(new StyleSpan(1), 0, spannableStringBuilder.length(), 18);
                                        break;
                                    case 2:
                                        spannableStringBuilder.setSpan(new StyleSpan(2), 0, spannableStringBuilder.length(), 18);
                                        break;
                                    case 3:
                                        spannableStringBuilder.setSpan(new StyleSpan(1), 0, spannableStringBuilder.length(), 18);
                                        spannableStringBuilder.setSpan(new StyleSpan(2), 0, spannableStringBuilder.length(), 18);
                                        break;
                                    case 4:
                                        spannableStringBuilder.setSpan(new UnderlineSpan(), 0, spannableStringBuilder.length(), 18);
                                        break;
                                    case 5:
                                        spannableStringBuilder.setSpan(new StyleSpan(1), 0, spannableStringBuilder.length(), 18);
                                        spannableStringBuilder.setSpan(new UnderlineSpan(), 0, spannableStringBuilder.length(), 18);
                                        break;
                                    case 6:
                                        spannableStringBuilder.setSpan(new StyleSpan(2), 0, spannableStringBuilder.length(), 18);
                                        spannableStringBuilder.setSpan(new UnderlineSpan(), 0, spannableStringBuilder.length(), 18);
                                        break;
                                    case 7:
                                        spannableStringBuilder.setSpan(new StyleSpan(1), 0, spannableStringBuilder.length(), 18);
                                        spannableStringBuilder.setSpan(new StyleSpan(2), 0, spannableStringBuilder.length(), 18);
                                        spannableStringBuilder.setSpan(new UnderlineSpan(), 0, spannableStringBuilder.length(), 18);
                                        break;
                                }
                                if (str4.equalsIgnoreCase("ALIGN_NORMAL")) {
                                    alignment = Layout.Alignment.ALIGN_NORMAL;
                                } else if (str4.equalsIgnoreCase("ALIGN_CENTER")) {
                                    alignment = Layout.Alignment.ALIGN_CENTER;
                                } else {
                                    alignment = Layout.Alignment.ALIGN_OPPOSITE;
                                }
                                TextSprite textSpriteMo1403a = this.f1081n.factory.mo1403a(rect.width(), rect.height(), alignment, spannableStringBuilder, this.f1081n.setting.getTextFont(), i28);
                                textSpriteMo1403a.objectID = i27;
                                textSpriteMo1403a.multiUserID = i29;
                                textSpriteMo1403a.multiObjectID = i30;
                                this.f1081n.stage.addSprite(textSpriteMo1403a, false, textSpriteMo1403a.multiUserID);
                                textSpriteMo1403a.m1194a(spannableStringBuilder, new PointF(rect.left, rect.top), rect.width(), rect.height(), alignment);
                                textSpriteMo1403a.setVisible(z4);
                                i8 = i;
                            } else {
                                if (SEPARATOR_COMMAND == i || f1080m == i) {
                                }
                                i8 = i;
                            }
                        }
                    }
                } else {
                    i = i6;
                }
                if (SEPARATOR_COMMAND == i) {
                    while (byteBufferAllocate.position() < byteBufferAllocate.capacity() - 3 && f1080m != (i2 = byteBufferAllocate.getInt())) {
                        if (f1078k == i2) {
                            if (byteBufferAllocate.getInt() == f1074g) {
                                int i34 = byteBufferAllocate.getInt();
                                int i35 = byteBufferAllocate.getInt();
                                byteBufferAllocate.getDouble();
                                byteBufferAllocate.getDouble();
                                int size = this.f1081n.stage.getSprites().size();
                                if (i34 != -1 && i34 < size) {
                                    AbstractSprite abstractSprite = this.f1081n.stage.getSprites().get(i34);
                                    if (!this.f1081n.stage.checkHistoryContainKey(i35, abstractSprite.isPublicLayer(), false)) {
                                        this.f1081n.stage.m814a(i35);
                                    }
                                    this.f1081n.stage.getUndoList(i35).add(new SpriteCreateCommand(abstractSprite, this.f1081n.stage));
                                }
                            }
                        } else if (f1079l == i2 && byteBufferAllocate.getInt() == f1074g) {
                            int i36 = byteBufferAllocate.getInt();
                            int i37 = byteBufferAllocate.getInt();
                            byteBufferAllocate.getDouble();
                            byteBufferAllocate.getDouble();
                            int size2 = this.f1081n.stage.getSprites().size();
                            if (i36 != -1 && i36 < size2) {
                                AbstractSprite abstractSprite2 = this.f1081n.stage.getSprites().get(i36);
                                if (!this.f1081n.stage.checkHistoryContainKey(i37, abstractSprite2.isPublicLayer(), true)) {
                                    this.f1081n.stage.m814a(i37);
                                }
                                this.f1081n.stage.getRedoList(i37).add(new SpriteCreateCommand(abstractSprite2, this.f1081n.stage));
                            }
                        }
                    }
                }
                byteBufferAllocate.clear();
                return;
            }
            byteBufferAllocate.clear();
        }
    }

    public static int getAvailableSize(LinkedList<AbstractSprite> sprites, ConcurrentHashMap<Integer, LinkedList<SpriteCommand>> listOfUndos, ConcurrentHashMap<Integer, LinkedList<SpriteCommand>> listOfRedos) {
        int i;
        int length = "smemo ver 1.0".getBytes().length + 40;
        Iterator<AbstractSprite> it = getStrokeSprites(sprites).iterator();
        int length2 = length;
        while (it.hasNext()) {
            length2 += 60;
            int size = ((StrokeSprite) it.next()).f1317f.size();
            if (size > 0) {
                length2 = (size * 12) + length2;
            }
        }
        Iterator<AbstractSprite> it2 = getImageSprites(sprites).iterator();
        while (it2.hasNext()) {
            int i2 = length2 + 64;
            String str = ((C0989ab) it2.next()).f1422i;
            if (str == null) {
                str = "null";
            }
            length2 = i2 + str.getBytes().length;
        }
        Iterator<AbstractSprite> it3 = getTextSprites(sprites).iterator();
        while (true) {
            i = length2;
            if (!it3.hasNext()) {
                break;
            }
            AbstractSprite next = it3.next();
            int i3 = i + 72;
            String string = ((TextSprite) next).m1201h().toString();
            String str2 = string == null ? "null" : string;
            String strM1200g = ((TextSprite) next).m1200g();
            if (strM1200g == null) {
                strM1200g = "null";
            }
            String string2 = ((TextSprite) next).m1199f().toString();
            if (string2 == null) {
                string2 = "null";
            }
            length2 = string2.getBytes().length + strM1200g.getBytes().length + str2.getBytes().length + i3;
        }
        if (listOfUndos != null) {
            int size2 = i;
            for (LinkedList<SpriteCommand> linkedList : listOfUndos.values()) {
                if (linkedList != null && !linkedList.isEmpty()) {
                    size2 = (linkedList.size() * 32) + size2;
                }
            }
            i = size2;
        }
        if (listOfRedos == null) {
            return i;
        }
        int size3 = i;
        for (LinkedList<SpriteCommand> linkedList2 : listOfRedos.values()) {
            if (linkedList2 != null && !linkedList2.isEmpty()) {
                size3 = (linkedList2.size() * 32) + size3;
            }
        }
        return size3;
    }

    public static byte[] makeByteData(int available, LinkedList<AbstractSprite> sprites, ConcurrentHashMap<Integer, LinkedList<SpriteCommand>> listOfUndos, ConcurrentHashMap<Integer, LinkedList<SpriteCommand>> listOfRedos, Rect canvasRect) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(available);
        byteBufferAllocate.putInt(SEPARATOR_VERSION);
        byteBufferAllocate.putInt("smemo ver 1.0".getBytes().length);
        byteBufferAllocate.put("smemo ver 1.0".getBytes());
        byteBufferAllocate.putInt(f1069b);
        byteBufferAllocate.putInt(canvasRect.width());
        byteBufferAllocate.putInt(canvasRect.height());
        byteBufferAllocate.putDouble(0.0d);
        if (!sprites.isEmpty()) {
            byteBufferAllocate.putInt(f1070c);
        }
        Iterator<AbstractSprite> it = sprites.iterator();
        while (it.hasNext()) {
            AbstractSprite next = it.next();
            if (next instanceof StrokeSprite) {
                StrokeSprite strokeSprite = (StrokeSprite) next;
                byteBufferAllocate.putInt(f1071d);
                byteBufferAllocate.putInt(strokeSprite.getType().ordinal());
                byteBufferAllocate.putInt(strokeSprite.m1153c().getColor());
                byteBufferAllocate.putInt(strokeSprite.m1162g().ordinal());
                byteBufferAllocate.putInt(strokeSprite.m1160f().ordinal());
                byteBufferAllocate.putInt((int) (strokeSprite.m1153c().getStrokeWidth() * 2.0f));
                byteBufferAllocate.putInt(strokeSprite.isVisible() ? 1 : 0);
                byteBufferAllocate.putInt(strokeSprite.m1172q() ? 1 : 0);
                byteBufferAllocate.putInt(strokeSprite.objectID);
                byteBufferAllocate.putInt(strokeSprite.getLayerID());
                byteBufferAllocate.putInt(strokeSprite.multiUserID);
                byteBufferAllocate.putInt(strokeSprite.multiObjectID);
                byteBufferAllocate.putDouble(0.0d);
                Vector<C1007at> vector = strokeSprite.f1317f;
                int size = vector.size();
                byteBufferAllocate.putInt(size);
                for (int i = 0; i < size; i++) {
                    C1007at c1007at = vector.get(i);
                    byteBufferAllocate.putFloat(c1007at.f1534a);
                    byteBufferAllocate.putFloat(c1007at.f1535b);
                    byteBufferAllocate.putFloat(c1007at.f1536c * 255.0f);
                }
            } else if (next instanceof C0989ab) {
                C0989ab c0989ab = (C0989ab) next;
                byteBufferAllocate.putInt(f1072e);
                RectF rectFM1264d = c0989ab.m1264d();
                byteBufferAllocate.putFloat(rectFM1264d.left);
                byteBufferAllocate.putFloat(rectFM1264d.top);
                byteBufferAllocate.putFloat(rectFM1264d.width());
                byteBufferAllocate.putFloat(rectFM1264d.height());
                byteBufferAllocate.putInt(c0989ab.f1423j);
                byteBufferAllocate.putInt(c0989ab.isVisible() ? 1 : 0);
                byteBufferAllocate.putInt(c0989ab.objectID);
                byteBufferAllocate.putInt(c0989ab.getLayerID());
                byteBufferAllocate.putInt(c0989ab.m1269h());
                byteBufferAllocate.putInt(c0989ab.multiUserID);
                byteBufferAllocate.putInt(c0989ab.multiObjectID);
                byteBufferAllocate.putDouble(0.0d);
                String str = c0989ab.f1422i;
                if (str == null) {
                    str = "null";
                }
                byteBufferAllocate.putInt(str.getBytes().length);
                byteBufferAllocate.put(str.getBytes());
            } else if (next instanceof TextSprite) {
                TextSprite textSprite = (TextSprite) next;
                byteBufferAllocate.putInt(f1073f);
                byteBufferAllocate.putInt((int) textSprite.f831b.left);
                byteBufferAllocate.putInt((int) textSprite.f831b.top);
                byteBufferAllocate.putInt((int) textSprite.f831b.right);
                byteBufferAllocate.putInt((int) textSprite.f831b.bottom);
                byteBufferAllocate.putInt(textSprite.m1197d());
                byteBufferAllocate.putInt(textSprite.m1195b());
                byteBufferAllocate.putInt(textSprite.isVisible() ? 1 : 0);
                byteBufferAllocate.putInt(textSprite.m1198e());
                byteBufferAllocate.putInt(textSprite.objectID);
                byteBufferAllocate.putInt(textSprite.getLayerID());
                byteBufferAllocate.putInt(textSprite.multiUserID);
                byteBufferAllocate.putInt(textSprite.multiObjectID);
                String string = textSprite.m1201h().toString();
                if (string == null) {
                    string = "null";
                }
                byteBufferAllocate.putInt(string.getBytes().length);
                byteBufferAllocate.put(string.getBytes());
                String strM1200g = textSprite.m1200g();
                if (strM1200g == null) {
                    strM1200g = "null";
                }
                byteBufferAllocate.putInt(strM1200g.getBytes().length);
                byteBufferAllocate.put(strM1200g.getBytes());
                String string2 = textSprite.m1199f().toString();
                if (string2 == null) {
                    string2 = "null";
                }
                byteBufferAllocate.putInt(string2.getBytes().length);
                byteBufferAllocate.put(string2.getBytes());
                byteBufferAllocate.putDouble(0.0d);
            }
        }
        byteBufferAllocate.putInt(SEPARATOR_COMMAND);
        if (listOfUndos != null && !listOfUndos.isEmpty()) {
            Iterator<Integer> it2 = listOfUndos.keySet().iterator();
            while (it2.hasNext()) {
                int iIntValue = it2.next().intValue();
                Iterator<SpriteCommand> it3 = listOfUndos.get(Integer.valueOf(iIntValue)).iterator();
                while (it3.hasNext()) {
                    SpriteCommand next2 = it3.next();
                    if (next2 instanceof SpriteCreateCommand) {
                        byteBufferAllocate.putInt(f1078k);
                        byteBufferAllocate.putInt(f1074g);
                        byteBufferAllocate.putInt(sprites.indexOf(((SpriteCreateCommand) next2).sprite));
                        byteBufferAllocate.putInt(iIntValue);
                        byteBufferAllocate.putDouble(0.0d);
                        byteBufferAllocate.putDouble(0.0d);
                    }
                }
            }
        }
        if (listOfRedos != null && !listOfRedos.isEmpty()) {
            Iterator<Integer> it4 = listOfRedos.keySet().iterator();
            while (it4.hasNext()) {
                int iIntValue2 = it4.next().intValue();
                Iterator<SpriteCommand> it5 = listOfRedos.get(Integer.valueOf(iIntValue2)).iterator();
                while (it5.hasNext()) {
                    SpriteCommand next3 = it5.next();
                    if (next3 instanceof SpriteCreateCommand) {
                        byteBufferAllocate.putInt(f1079l);
                        byteBufferAllocate.putInt(f1074g);
                        byteBufferAllocate.putInt(sprites.indexOf(((SpriteCreateCommand) next3).sprite));
                        byteBufferAllocate.putInt(iIntValue2);
                        byteBufferAllocate.putDouble(0.0d);
                        byteBufferAllocate.putDouble(0.0d);
                    }
                }
            }
        }
        byteBufferAllocate.putInt(f1080m);
        return byteBufferAllocate.array();
    }

    public boolean copyListOfSprites() {
        if (this.f1081n.stage == null) {
            return false;
        }
        if (this.f1082o != null) {
            this.f1082o.clear();
            this.f1082o = null;
        }
        LinkedList<AbstractSprite> sprites = this.f1081n.stage.getSprites();
        if (sprites == null) {
            return false;
        }
        this.f1082o = new LinkedList<>();
        Iterator<AbstractSprite> it = sprites.iterator();
        while (it.hasNext()) {
            AbstractSprite next = it.next();
            if (next instanceof C0989ab) {
                next.dispose();
            }
            this.f1082o.add(next);
        }
        sprites.clear();
        return true;
    }

    public boolean copyListOfUndos() {
        if (this.f1081n.stage == null) {
            return false;
        }
        if (this.f1083p != null) {
            this.f1083p.clear();
            this.f1083p = null;
        }
        LinkedList<SpriteCommand> undoList = this.f1081n.stage.getUndoList();
        if (undoList == null) {
            return false;
        }
        this.f1083p = new LinkedList<>();
        Iterator<SpriteCommand> it = undoList.iterator();
        while (it.hasNext()) {
            this.f1083p.add(it.next());
        }
        return true;
    }

    public boolean copyListOfRedos() {
        if (this.f1081n.stage == null) {
            return false;
        }
        if (this.f1084q != null) {
            this.f1084q.clear();
            this.f1084q = null;
        }
        LinkedList<SpriteCommand> redoList = this.f1081n.stage.getRedoList();
        if (redoList == null) {
            return false;
        }
        this.f1084q = new LinkedList<>();
        Iterator<SpriteCommand> it = redoList.iterator();
        while (it.hasNext()) {
            this.f1084q.add(it.next());
        }
        return true;
    }

    public LinkedList<AbstractSprite> getClonedSprites() {
        return this.f1082o;
    }

    public LinkedList<SpriteCommand> getClonedUndos() {
        return this.f1083p;
    }

    public LinkedList<SpriteCommand> getClonedRedos() {
        return this.f1084q;
    }

    public static LinkedList<AbstractSprite> getStrokeSprites(LinkedList<AbstractSprite> list) {
        LinkedList<AbstractSprite> linkedList = new LinkedList<>();
        Iterator<AbstractSprite> it = list.iterator();
        while (it.hasNext()) {
            AbstractSprite next = it.next();
            if (next instanceof StrokeSprite) {
                linkedList.add(next);
            }
        }
        return linkedList;
    }

    public static LinkedList<AbstractSprite> getImageSprites(LinkedList<AbstractSprite> list) {
        LinkedList<AbstractSprite> linkedList = new LinkedList<>();
        Iterator<AbstractSprite> it = list.iterator();
        while (it.hasNext()) {
            AbstractSprite next = it.next();
            if (next instanceof C0989ab) {
                linkedList.add(next);
            }
        }
        return linkedList;
    }

    public static LinkedList<AbstractSprite> getTextSprites(LinkedList<AbstractSprite> list) {
        LinkedList<AbstractSprite> linkedList = new LinkedList<>();
        Iterator<AbstractSprite> it = list.iterator();
        while (it.hasNext()) {
            AbstractSprite next = it.next();
            if (next instanceof TextSprite) {
                linkedList.add(next);
            }
        }
        return linkedList;
    }

    public void dispose() {
        if (this.f1082o != null) {
            this.f1082o.clear();
            this.f1082o = null;
        }
        if (this.f1083p != null) {
            this.f1083p.clear();
            this.f1083p = null;
        }
        if (this.f1084q != null) {
            this.f1084q.clear();
            this.f1084q = null;
        }
    }
}
