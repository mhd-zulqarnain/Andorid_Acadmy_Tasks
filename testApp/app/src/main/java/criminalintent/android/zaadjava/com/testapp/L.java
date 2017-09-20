package criminalintent.android.zaadjava.com.testapp;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

/**
 * Created by zulup on 6/1/2017.
 */

public class L {

    public static void showToast(Context context,String message){
        Toast toast= Toast.makeText(context,message,Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER,0,0);
//        toast.setGravity(Gravity.BOTTOM|Gravity.RIGHT,0,0);
        toast.show();
    }
}
