package chatkit.stfalcon.com.asyntaskapp.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Zul Qarnain on 12/26/2017.
 */

public class Messege {
    public static void messege(Context context,String msg){
        Toast.makeText(context,msg,Toast.LENGTH_SHORT).show();
    }
}
