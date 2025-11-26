package weibo4android;

/* loaded from: classes.dex */
public enum Gender {
    MALE,
    FEMALE;

    /* renamed from: values, reason: to resolve conflict with enum method */
    public static Gender[] valuesCustom() {
        Gender[] genderArrValuesCustom = values();
        int length = genderArrValuesCustom.length;
        Gender[] genderArr = new Gender[length];
        System.arraycopy(genderArrValuesCustom, 0, genderArr, 0, length);
        return genderArr;
    }

    public static String valueOf(Gender gender) {
        return gender.ordinal() == 0 ? "m" : "f";
    }
}
