package com.example.zulqarnain.firebaseauth.ui.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.zulqarnain.firebaseauth.Messege;
import com.example.zulqarnain.firebaseauth.R;
import com.example.zulqarnain.firebaseauth.model.Task;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;

/**
 * Created by Zul Qarnain on 10/25/2017.
 */

public class AddDialogFragment extends DialogFragment {

    private EditText mTaskName;
    private ImageView mTaskImage;
    private Button mAddBtn;
    private final int PICK_IMAGE_REQUEST = 11;
    private Uri mImagePath;
    DatabaseReference mDataBase;
    FirebaseAuth auth;
    StorageReference taskPhotoRef;

    public static Fragment newInstance() {
        AddDialogFragment fragment = new AddDialogFragment();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        auth = FirebaseAuth.getInstance();
        String userid = auth.getCurrentUser().getUid();
        mDataBase = FirebaseDatabase.getInstance().getReference(userid).child("task");
        taskPhotoRef = FirebaseStorage.getInstance().getReference().child("photo");
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        setCancelable(false);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();

        final View mainView = inflater.inflate(R.layout.add_dialog_fragment, null);
        mTaskName = mainView.findViewById(R.id.task_name);
        mAddBtn = mainView.findViewById(R.id.add_image_btn);
        mTaskImage = mainView.findViewById(R.id.image_task);

        final Dialog addDialog = builder.setView(mainView)
                .setTitle(getString(R.string.add_task_dialog_title))
                .setPositiveButton("Add", null)
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        AddDialogFragment.this.getDialog().cancel();
                    }
                })
                .create();
        addDialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialogInterface) {

                Button positiveButton = ((AlertDialog) dialogInterface).getButton(AlertDialog.BUTTON_POSITIVE);
                positiveButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Boolean wantToCloseDialog = false;
                        if (!TextUtils.isEmpty(mTaskName.getText())) {
                            submitTask();
                            addDialog.dismiss();
                        } else
                            Messege.messege(getContext(), "Nothing to submit");
                    }
                });
            }
        });

        mAddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
            }
        });
        return addDialog;

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && data != null && resultCode == Activity.RESULT_OK) {
            mImagePath = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContext().getContentResolver(), mImagePath);
                mTaskImage.setImageBitmap(bitmap);


            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void submitTask() {
        if (mImagePath != null) {
            StorageReference ref = taskPhotoRef.child(mImagePath.getLastPathSegment());
            ref.putFile(mImagePath).
                    addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            @SuppressWarnings("VisibleForTests")
                            Uri downloadUrl = taskSnapshot.getDownloadUrl();
                            String key = String.valueOf(mDataBase.push().getKey());
                            Task task = new Task(mTaskName.getText().toString(), key,downloadUrl.toString());
                            mDataBase.child(key).setValue(task);
                        }
                    });
        } else {
            Messege.messege(getContext(), "pubmission failed");
            String key = String.valueOf(mDataBase.push().getKey());
            Task myTask  =new Task(mTaskName.getText().toString(),key,"null");
            mDataBase.child(key).setValue(myTask);

        }

    }
}
