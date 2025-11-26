package com.sec.chaton.msgsend;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p027e.EnumC1455w;
import com.sec.chaton.p027e.p028a.C1373q;
import com.sec.chaton.util.C3224cl;

/* loaded from: classes.dex */
public class ChatONMsgEntity implements Parcelable {
    private String mChatMsg;
    private String mChatMsgTranslated;
    private long mCreateTime;
    private String mFormattedMsg;
    private int mIsFileUploaded;
    private boolean mIsInProgress;
    private long mLastSendEndTime;
    private long mLastSendTryTime;
    private String mLocalFileUri;
    private Long mMsgId;
    private EnumC1741aa mMsgSendStatus;
    private EnumC1455w mMsgType;
    private int mSendTryCount;
    private static final String TAG = ChatONMsgEntity.class.getSimpleName();
    public static final Parcelable.Creator<ChatONMsgEntity> CREATOR = new C1747g();

    /* renamed from: m */
    private void m7133m() {
        if (this.mSendTryCount <= 1) {
            this.mCreateTime = SystemClock.uptimeMillis();
        }
    }

    /* renamed from: a */
    public void m7136a() {
        this.mMsgSendStatus = EnumC1741aa.SENDING;
        this.mSendTryCount++;
        this.mLastSendTryTime = SystemClock.uptimeMillis();
    }

    /* renamed from: b */
    public void m7140b() {
        this.mLastSendEndTime = SystemClock.uptimeMillis();
    }

    /* renamed from: c */
    public boolean m7141c() {
        switch (this.mMsgSendStatus) {
            case PENDING:
                if (!this.mIsInProgress) {
                    if (this.mSendTryCount <= 720) {
                        break;
                    } else {
                        C1759s.m7260a(TAG, "doesNeedToResend(), Too many retry this msg : %s", this);
                        C1759s.m7260a(TAG, "doesNeedToResend(), Too many retry this msg : %s", this);
                        C1759s.m7260a(TAG, "doesNeedToResend(), WToo many retry this msg : %s", this);
                        this.mMsgSendStatus = EnumC1741aa.FAILED;
                        C1373q.m6187b(GlobalApplication.m11493l().getContentResolver(), this.mMsgId);
                        break;
                    }
                }
                break;
        }
        return false;
    }

    /* renamed from: d */
    String m7142d() {
        String string = "(not completed to send)";
        if (this.mLastSendEndTime >= this.mCreateTime) {
            string = new C1750j(this.mLastSendEndTime, this.mCreateTime).toString();
        }
        return String.format("TryCount(%d), Create(%d)/LastSendTry(%d)/LastSendEnd(%d) --> %s", Integer.valueOf(this.mSendTryCount), Long.valueOf(this.mCreateTime), Long.valueOf(this.mLastSendTryTime), Long.valueOf(this.mLastSendEndTime), string);
    }

    /* renamed from: e */
    public Long m7143e() {
        return this.mMsgId;
    }

    /* renamed from: f */
    public EnumC1455w m7144f() {
        return this.mMsgType;
    }

    /* renamed from: a */
    public void m7137a(String str) {
        this.mChatMsg = str;
    }

    /* renamed from: g */
    public String m7145g() {
        return this.mChatMsg;
    }

    /* renamed from: h */
    public String m7146h() {
        return this.mChatMsgTranslated;
    }

    /* renamed from: i */
    public String m7147i() {
        return this.mLocalFileUri;
    }

    /* renamed from: j */
    public String m7148j() {
        return this.mFormattedMsg;
    }

    /* renamed from: k */
    public int m7149k() {
        return this.mIsFileUploaded;
    }

    /* renamed from: a */
    public void m7138a(boolean z) {
        this.mIsInProgress = z;
    }

    /* renamed from: l */
    public EnumC1741aa m7150l() {
        return this.mMsgSendStatus;
    }

    /* renamed from: a */
    public EnumC1741aa m7135a(EnumC1741aa enumC1741aa) {
        EnumC1741aa enumC1741aa2 = this.mMsgSendStatus;
        this.mMsgSendStatus = enumC1741aa;
        return enumC1741aa2;
    }

    /* renamed from: b */
    public String m7139b(String str) {
        String str2 = this.mFormattedMsg;
        this.mFormattedMsg = str;
        return str2;
    }

    /* renamed from: a */
    public int m7134a(int i) {
        int i2 = this.mIsFileUploaded;
        this.mIsFileUploaded = i;
        return i2;
    }

    public ChatONMsgEntity(long j, EnumC1455w enumC1455w, String str, String str2, String str3, String str4, int i, int i2) {
        this(j, enumC1455w, str, str2, str3, str4, i, EnumC1741aa.m7156a(i2));
    }

    public ChatONMsgEntity(long j, EnumC1455w enumC1455w, String str, String str2, String str3, String str4, int i, EnumC1741aa enumC1741aa) {
        this.mIsInProgress = false;
        this.mSendTryCount = 0;
        this.mCreateTime = 0L;
        this.mLastSendTryTime = 0L;
        this.mLastSendEndTime = 0L;
        this.mMsgSendStatus = enumC1741aa;
        this.mMsgId = Long.valueOf(j);
        this.mMsgType = enumC1455w;
        this.mChatMsg = str;
        this.mChatMsgTranslated = str2;
        this.mLocalFileUri = str3;
        this.mFormattedMsg = str4;
        this.mIsFileUploaded = i;
        m7133m();
    }

    public ChatONMsgEntity(Parcel parcel) {
        this.mIsInProgress = false;
        this.mSendTryCount = 0;
        this.mCreateTime = 0L;
        this.mLastSendTryTime = 0L;
        this.mLastSendEndTime = 0L;
        this.mMsgSendStatus = EnumC1741aa.m7156a(parcel.readInt());
        this.mSendTryCount = parcel.readInt();
        this.mCreateTime = parcel.readLong();
        this.mLastSendTryTime = parcel.readLong();
        this.mMsgId = Long.valueOf(parcel.readLong());
        this.mMsgType = EnumC1455w.m6358a(parcel.readInt());
        this.mChatMsg = parcel.readString();
        this.mChatMsgTranslated = parcel.readString();
        this.mLocalFileUri = parcel.readString();
        this.mFormattedMsg = parcel.readString();
        this.mIsFileUploaded = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mMsgSendStatus.m7157a());
        parcel.writeInt(this.mSendTryCount);
        parcel.writeLong(this.mCreateTime);
        parcel.writeLong(this.mLastSendTryTime);
        parcel.writeLong(this.mMsgId.longValue());
        parcel.writeInt(this.mMsgType.m6364a());
        parcel.writeString(this.mChatMsg);
        parcel.writeString(this.mChatMsgTranslated);
        parcel.writeString(this.mLocalFileUri);
        parcel.writeString(this.mFormattedMsg);
        parcel.writeInt(this.mIsFileUploaded);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return String.format("[MSG] : (%s) MsgSendStatus(%s), msgId(%d), msgType(%s), chatMsg(%s), chatMsgTranslated(%s), DownUri(%s), FormattedMsg(%s), IsFileUploaded(%d)", m7142d(), this.mMsgSendStatus, this.mMsgId, this.mMsgType, C3224cl.m11333a(this.mChatMsg, 3), C3224cl.m11333a(this.mChatMsgTranslated, 3), this.mLocalFileUri, this.mFormattedMsg, Integer.valueOf(this.mIsFileUploaded));
    }

    public int hashCode() {
        return this.mMsgId.hashCode();
    }

    public boolean equals(Object obj) {
        return obj != null && this.mMsgId.equals(((ChatONMsgEntity) obj).mMsgId);
    }
}
