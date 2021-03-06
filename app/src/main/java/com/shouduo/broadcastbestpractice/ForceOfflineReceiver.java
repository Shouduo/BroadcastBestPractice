package com.shouduo.broadcastbestpractice;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.view.WindowManager;

import static com.shouduo.broadcastbestpractice.R.style.Theme_AppCompat_DayNight_Dialog;


/**
 * Created by 刘亨俊 on 2016/5/7.
 */
public class ForceOfflineReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(final Context context, Intent intent) {

        System.out.println("接受广播");
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context, Theme_AppCompat_DayNight_Dialog)
                .setTitle("Warning")
                .setMessage("You are forced to be offline. Please try to login again.")
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ActivityCollector.finishAll();
                        Intent intent = new Intent(context, LoginActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);
                    }
                });
        AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_TOAST);
        alertDialog.show();
    }

}
