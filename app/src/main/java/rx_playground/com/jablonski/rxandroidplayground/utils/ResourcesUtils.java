package rx_playground.com.jablonski.rxandroidplayground.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;

import rx_playground.com.jablonski.rxandroidplayground.R;

/**
 * Created by yabol on 17.04.2017.
 */

public class ResourcesUtils {

    public static Drawable getImageByName(Context context, String name){
        final int resourceID = getDrawableIDByName(context, name);
        if(resourceID > 0) {
            return getDrawable(context, resourceID);
        }else{
            return getDrawable(context, R.mipmap.ic_launcher_round);
        }
    }

    public static int getDrawableIDByName(Context context, String name){
        if(name != null) {
            Resources resources = context.getResources();
            int id = resources.getIdentifier(name.toLowerCase(), "drawable", context.getPackageName());
            if (id != 0) {
                return id;
            }
        }
        return R.mipmap.ic_launcher_round;
    }

    public static Drawable getDrawable(Context context, int id){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            return context.getDrawable(id);
        } else {
            return context.getResources().getDrawable(id);
        }
    }

    public static int getColor(Context context, int colorId){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            return context.getColor(colorId);
        }else{
            return context.getResources().getColor(colorId);
        }
    }

    public static String getText(Context context, int stringId){
        return context.getString(stringId);
    }


}
