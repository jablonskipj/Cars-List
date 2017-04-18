package rx_playground.com.jablonski.rxandroidplayground.utils.images;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;

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
        Resources resources = context.getResources();
        int id = resources.getIdentifier(name, "drawable", context.getPackageName());
        if(id == 0){
            return R.mipmap.ic_launcher_round;
        }else{
            return id;
        }
    }

    public static Drawable getDrawable(Context context, int id){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            return context.getDrawable(id);
        } else {
            return context.getResources().getDrawable(id);
        }
    }
}
