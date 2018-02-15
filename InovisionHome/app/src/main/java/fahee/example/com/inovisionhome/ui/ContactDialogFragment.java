package fahee.example.com.inovisionhome.ui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;

import fahee.example.com.inovisionhome.R;

/**
 * Created by Zul Qarnain on 2/14/2018.
 */

public class ContactDialogFragment extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState)
    {
        /*View view = LayoutInflater.from(getActivity()).inflate(R.layout.contacts_dialog_view, null);
        Dialog dialogView = new AlertDialog.Builder(getActivity())
                .setView(view)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dismiss();
                    }
                }).create();
        dialogView.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));*/

        Dialog alertDialog = new Dialog(getActivity());
        alertDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        alertDialog.setContentView(R.layout.contacts_dialog_view);
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        return alertDialog;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

}
