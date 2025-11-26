package com.coolots.chaton.common.util;

import android.content.Intent;
import com.sds.coolots.common.util.PopUpCreatorInterface;

/* loaded from: classes.dex */
public interface ChatOnPopupCreatorInterface extends PopUpCreatorInterface {
    Intent getInformationActivity();

    Intent getSendLogActivity();

    Intent getSettingActivity();
}
