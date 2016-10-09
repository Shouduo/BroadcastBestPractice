package com.shouduo.broadcastbestpractice;

import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 刘亨俊 on 2016/5/7.
 */
public class ActivityCollector {

    public static List<AppCompatActivity> activities = new ArrayList<>();

    public static void addActivity(AppCompatActivity activity) {
        activities.add(activity);
    }

    public static void removeActivity(AppCompatActivity activity) {
        activities.remove(activity);
    }

    public static void finishAll() {
        for (AppCompatActivity activity : activities) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
    }
}
