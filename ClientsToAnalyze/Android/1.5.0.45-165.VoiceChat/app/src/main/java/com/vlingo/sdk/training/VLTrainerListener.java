package com.vlingo.sdk.training;

import com.vlingo.sdk.training.VLTrainer;
import java.util.HashMap;

/* loaded from: classes.dex */
public interface VLTrainerListener {
    void onError(VLTrainerErrors vLTrainerErrors, String str);

    void onUpdateReceived(HashMap<VLTrainer.TrainerItemType, Integer> map);
}
