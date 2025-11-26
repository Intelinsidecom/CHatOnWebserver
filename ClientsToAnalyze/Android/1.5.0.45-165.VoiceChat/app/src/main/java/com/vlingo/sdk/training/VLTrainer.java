package com.vlingo.sdk.training;

import com.vlingo.sdk.VLComponent;

/* loaded from: classes.dex */
public interface VLTrainer extends VLComponent {

    public enum TrainerItemType {
        CONTACT,
        SONG,
        PLAYLIST;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static TrainerItemType[] valuesCustom() {
            TrainerItemType[] trainerItemTypeArrValuesCustom = values();
            int length = trainerItemTypeArrValuesCustom.length;
            TrainerItemType[] trainerItemTypeArr = new TrainerItemType[length];
            System.arraycopy(trainerItemTypeArrValuesCustom, 0, trainerItemTypeArr, 0, length);
            return trainerItemTypeArr;
        }
    }

    void clearAllItems(String str, VLTrainerListener vLTrainerListener);

    void clearContactItems(String str, VLTrainerListener vLTrainerListener);

    void clearMusicItems(String str, VLTrainerListener vLTrainerListener);

    void sendFullUpdate(VLTrainerUpdateList vLTrainerUpdateList, String str, VLTrainerListener vLTrainerListener);

    void sendPartialUpdate(VLTrainerUpdateList vLTrainerUpdateList, String str, VLTrainerListener vLTrainerListener);

    void updateTrainerModelLanguage(String str, VLTrainerListener vLTrainerListener);
}
