package com.vlingo.sdk.internal.lmtt;

/* loaded from: classes.dex */
public abstract class LMTTItem {
    private static /* synthetic */ int[] $SWITCH_TABLE$com$vlingo$sdk$internal$lmtt$LMTTItem$ChangeType;
    public ChangeType changeType;
    public LmttItemType type;
    public int uid;

    public enum ChangeType {
        UPDATE,
        INSERT,
        DELETE,
        NOCHANGE;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static ChangeType[] valuesCustom() {
            ChangeType[] changeTypeArrValuesCustom = values();
            int length = changeTypeArrValuesCustom.length;
            ChangeType[] changeTypeArr = new ChangeType[length];
            System.arraycopy(changeTypeArrValuesCustom, 0, changeTypeArr, 0, length);
            return changeTypeArr;
        }
    }

    public enum LmttItemType {
        TYPE_CONTACT,
        TYPE_SONG,
        TYPE_PLAYLIST,
        TYPE_UNKNOWN;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static LmttItemType[] valuesCustom() {
            LmttItemType[] lmttItemTypeArrValuesCustom = values();
            int length = lmttItemTypeArrValuesCustom.length;
            LmttItemType[] lmttItemTypeArr = new LmttItemType[length];
            System.arraycopy(lmttItemTypeArrValuesCustom, 0, lmttItemTypeArr, 0, length);
            return lmttItemTypeArr;
        }
    }

    public abstract void getDelXML(StringBuilder sb);

    public abstract void getInsXML(StringBuilder sb);

    public abstract void getUpXML(StringBuilder sb);

    static /* synthetic */ int[] $SWITCH_TABLE$com$vlingo$sdk$internal$lmtt$LMTTItem$ChangeType() {
        int[] iArr = $SWITCH_TABLE$com$vlingo$sdk$internal$lmtt$LMTTItem$ChangeType;
        if (iArr == null) {
            iArr = new int[ChangeType.valuesCustom().length];
            try {
                iArr[ChangeType.DELETE.ordinal()] = 3;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[ChangeType.INSERT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[ChangeType.NOCHANGE.ordinal()] = 4;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[ChangeType.UPDATE.ordinal()] = 1;
            } catch (NoSuchFieldError e4) {
            }
            $SWITCH_TABLE$com$vlingo$sdk$internal$lmtt$LMTTItem$ChangeType = iArr;
        }
        return iArr;
    }

    public LMTTItem(LmttItemType type, int uid, ChangeType changeType) {
        this.type = LmttItemType.TYPE_UNKNOWN;
        this.type = type;
        this.uid = uid;
        this.changeType = changeType;
    }

    public void setChangeType(ChangeType type) {
        this.changeType = type;
    }

    public String getXML() {
        StringBuilder sb = new StringBuilder();
        switch ($SWITCH_TABLE$com$vlingo$sdk$internal$lmtt$LMTTItem$ChangeType()[this.changeType.ordinal()]) {
            case 1:
                getUpXML(sb);
                break;
            case 2:
                getInsXML(sb);
                break;
            case 3:
                getDelXML(sb);
                break;
        }
        return sb.toString();
    }
}
