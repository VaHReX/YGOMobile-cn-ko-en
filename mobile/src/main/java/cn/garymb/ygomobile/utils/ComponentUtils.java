package cn.garymb.ygomobile.utils;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;

import androidx.annotation.RequiresApi;

import java.util.List;

public class ComponentUtils {
    public static boolean isProcessRunning(Context context, String processName) {
        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> tasks = am.getRunningAppProcesses();
        if (tasks != null) {
            for (ActivityManager.RunningAppProcessInfo taskInfo : tasks) {
                if (context.getApplicationInfo().uid == taskInfo.uid && TextUtils.equals(processName, taskInfo.processName)) {
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean isActivityRunning(Context context, ComponentName componentName) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            return isActivityRunningV21(context, componentName);
        }
        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningTaskInfo> tasks = am.getRunningTasks(255);
        if (tasks != null) {
            for (ActivityManager.RunningTaskInfo taskInfo : tasks) {
                if (componentName.equals(taskInfo.topActivity)) {
                    return true;
                }
            }
        }
        return false;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private static boolean isActivityRunningV21(Context context, ComponentName componentName) {
        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.AppTask> tasks = am.getAppTasks();
        if (tasks != null) {
            for (ActivityManager.AppTask taskInfo : tasks) {
                try {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        if (componentName.equals(taskInfo.getTaskInfo().topActivity)) {
                            return true;
                        }
                    } else {
                        if (componentName.equals(taskInfo.getTaskInfo().baseIntent.getComponent())) {
                            return true;
                        }
                    }
                } catch (Exception e) {
                    //ignore
                }
            }
        }
        return false;
    }
}
