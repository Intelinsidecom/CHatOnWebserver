package com.coolots.chaton.common.coolotsinterface;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import com.coolots.chaton.C0000R;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.coolotsinterface.CreditNotificationInterface;
import com.sds.coolots.common.model.EventCode;
import com.sds.coolots.common.util.StrUtil;

/* loaded from: classes.dex */
public class CreditNotification implements CreditNotificationInterface {
    private NotificationManager notificationManager = null;

    @Override // com.sds.coolots.common.coolotsinterface.CreditNotificationInterface
    public void deleteCallNotification() {
        if (this.notificationManager == null) {
            this.notificationManager = (NotificationManager) MainApplication.mContext.getSystemService("notification");
        }
        this.notificationManager.cancel(1005);
    }

    @Override // com.sds.coolots.common.coolotsinterface.CreditNotificationInterface
    public void showCreditNotification(int notificationId) {
        Intent creditNotiIntent = new Intent(MainApplication.mContext, (Class<?>) Object.class);
        creditNotiIntent.putExtra(EventCode.EVENT_IDENTIFIER, EventCode.EVENT_AUTO_CHARGE_NOTI_CLICK);
        creditNotiIntent.addFlags(268435456);
        creditNotiIntent.addFlags(536870912);
        String title = StrUtil.getString(C0000R.string.credit_notification_autocharge_title);
        String message = "";
        switch (notificationId) {
            case 2001:
                message = StrUtil.getString(C0000R.string.credit_notification_autocharge_success);
                break;
            case 2002:
                message = StrUtil.getString(C0000R.string.credit_notification_autocharge_unknown);
                break;
            case 2003:
                message = StrUtil.getString(C0000R.string.credit_notification_autocharge_fail);
                break;
        }
        if (this.notificationManager == null) {
            this.notificationManager = (NotificationManager) MainApplication.mContext.getSystemService("notification");
        }
        Notification notification = new Notification(MainApplication.mResources.getDrawableLuncher(), message, System.currentTimeMillis());
        notification.setLatestEventInfo(MainApplication.mContext, title, message, PendingIntent.getActivity(MainApplication.mContext, 0, creditNotiIntent, 0));
        notification.flags = 16;
        this.notificationManager.notify(notificationId, notification);
    }
}
