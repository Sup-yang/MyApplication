package baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.utils;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 创建一个ActivityCollector.java，此类用作收集和销毁activity的公共类.
 * Created by lenovo on 2017/4/8.
 */

public class ActivityCollector {
    public static List<Activity> activities = new ArrayList<Activity>();

    public static void addActivity(Activity activity) {
        activities.add(activity);
    }

    public static void removeActivity(Activity activity) {
        activities.remove(activity);
    }

    public static void finishAll() {
        for (Activity activity : activities) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
    }

    public static void finishone() {
        for (Activity activity : activities) {
            if (!activity.isFinishing()) {
//                if (activity )
                activity.finish();
            }
        }
    }

}
