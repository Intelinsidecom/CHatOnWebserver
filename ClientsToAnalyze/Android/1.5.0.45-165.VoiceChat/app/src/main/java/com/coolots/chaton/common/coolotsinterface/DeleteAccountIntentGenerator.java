package com.coolots.chaton.common.coolotsinterface;

import android.content.Intent;
import com.coolots.chaton.CoolotsChatOn;
import com.coolots.chaton.common.view.DeleteAccountActivity;
import com.sds.coolots.common.coolotsinterface.DeleteAccountIntentGeneratorInterface;

/* loaded from: classes.dex */
public class DeleteAccountIntentGenerator implements DeleteAccountIntentGeneratorInterface {
    @Override // com.sds.coolots.common.coolotsinterface.DeleteAccountIntentGeneratorInterface
    public Intent getDeleteAccountIntent() {
        Intent intent = new Intent(CoolotsChatOn.mContext, (Class<?>) DeleteAccountActivity.class);
        return intent;
    }
}
