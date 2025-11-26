package com.p137vk.sdk;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.p137vk.sdk.api.VKError;
import com.p137vk.sdk.api.httpClient.VKHttpClient;
import com.p137vk.sdk.api.httpClient.VKHttpOperation;
import com.sec.chaton.R;
import org.apache.http.client.methods.HttpGet;

/* loaded from: classes.dex */
public class VKCaptchaDialog {
    static final /* synthetic */ boolean $assertionsDisabled;
    private EditText mCaptchaAnswer;
    private VKError mCaptchaError;
    private ImageView mCaptchaImage;
    private float mDensity;
    private ProgressBar mProgressBar;

    static {
        $assertionsDisabled = !VKCaptchaDialog.class.desiredAssertionStatus();
    }

    public VKCaptchaDialog(VKError vKError) {
        this.mCaptchaError = vKError;
    }

    public void show() {
        Activity topActivity = VKUIHelper.getTopActivity();
        View viewInflate = LayoutInflater.from(topActivity).inflate(R.layout.dialog_vkcaptcha, (ViewGroup) null);
        if (!$assertionsDisabled && viewInflate == null) {
            throw new AssertionError();
        }
        this.mCaptchaAnswer = (EditText) viewInflate.findViewById(R.id.captchaAnswer);
        this.mCaptchaImage = (ImageView) viewInflate.findViewById(R.id.imageView);
        this.mProgressBar = (ProgressBar) viewInflate.findViewById(R.id.progressBar);
        this.mDensity = topActivity.getResources().getDisplayMetrics().density;
        final AlertDialog alertDialogCreate = new AlertDialog.Builder(topActivity).setView(viewInflate).create();
        this.mCaptchaAnswer.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.vk.sdk.VKCaptchaDialog.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    alertDialogCreate.getWindow().setSoftInputMode(5);
                }
            }
        });
        this.mCaptchaAnswer.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.vk.sdk.VKCaptchaDialog.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i != 4) {
                    return false;
                }
                VKCaptchaDialog.this.sendAnswer();
                return true;
            }
        });
        alertDialogCreate.setButton(-2, topActivity.getString(android.R.string.ok), new DialogInterface.OnClickListener() { // from class: com.vk.sdk.VKCaptchaDialog.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                VKCaptchaDialog.this.sendAnswer();
            }
        });
        alertDialogCreate.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.vk.sdk.VKCaptchaDialog.4
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                VKCaptchaDialog.this.mCaptchaError.request.cancel();
            }
        });
        loadImage();
        alertDialogCreate.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendAnswer() {
        this.mCaptchaError.answerCaptcha(this.mCaptchaAnswer.getText() != null ? this.mCaptchaAnswer.getText().toString() : "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadImage() {
        VKHttpOperation vKHttpOperation = new VKHttpOperation(new HttpGet(this.mCaptchaError.captchaImg));
        vKHttpOperation.setHttpOperationListener(new VKHttpOperation.VKHTTPOperationCompleteListener() { // from class: com.vk.sdk.VKCaptchaDialog.5
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.vk.sdk.api.httpClient.VKHttpOperation.VKHTTPOperationCompleteListener, com.vk.sdk.api.httpClient.VKAbstractOperation.VKAbstractCompleteListener
            public void onComplete(VKHttpOperation vKHttpOperation2, byte[] bArr) {
                VKCaptchaDialog.this.mCaptchaImage.setImageBitmap(Bitmap.createScaledBitmap(BitmapFactory.decodeByteArray(bArr, 0, bArr.length), (int) (r0.getWidth() * VKCaptchaDialog.this.mDensity), (int) (r0.getHeight() * VKCaptchaDialog.this.mDensity), true));
                VKCaptchaDialog.this.mCaptchaImage.setVisibility(0);
                VKCaptchaDialog.this.mProgressBar.setVisibility(8);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.vk.sdk.api.httpClient.VKHttpOperation.VKHTTPOperationCompleteListener, com.vk.sdk.api.httpClient.VKAbstractOperation.VKAbstractCompleteListener
            public void onError(VKHttpOperation vKHttpOperation2, VKError vKError) {
                VKCaptchaDialog.this.loadImage();
            }
        });
        VKHttpClient.enqueueOperation(vKHttpOperation);
    }
}
