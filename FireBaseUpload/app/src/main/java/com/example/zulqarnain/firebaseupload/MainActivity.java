package com.example.zulqarnain.firebaseupload;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Message;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

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

public class MainActivity extends AppCompatActivity {

    private final String STORAGE_PATH_UPLOADS = "uploads/";
    private final String DATABASE_PATH_UPLOADS = "uploads";
    private final String TAG = "com.tag.com";
    private final int PICK_IMG_REQUEST = 12;
    private Uri filepath;

    private StorageReference storageReference;
    private DatabaseReference mDatabase;
    private FirebaseAuth auth;

    private Button mSelect;
    private Button mUpload;
    private EditText mName;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSelect = (Button) findViewById(R.id.btn_choice);
        mUpload = (Button) findViewById(R.id.btn_upload);
        mName = (EditText) findViewById(R.id.ed_img_name);
        imageView = (ImageView) findViewById(R.id.img_view);

        storageReference = FirebaseStorage.getInstance().getReference();
        mDatabase = FirebaseDatabase.getInstance().getReference(DATABASE_PATH_UPLOADS);
        filepath =Uri.parse("android.resource://com.example.zulqarnain.firebaseupload/drawable/no_img");
        auth = FirebaseAuth.getInstance();
        auth.signInWithEmailAndPassword("a@gmail.com", "111111");

    }

    public void uploadImage(View v) {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMG_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMG_REQUEST && resultCode == Activity.RESULT_OK && data != null) {
            filepath = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filepath);
                imageView.setImageBitmap(bitmap);
            } catch (IOException e) {
                Log.d(TAG, "onActivityResult: " + e);
            }
        }
    }


    public String getFileExtension(Uri uri) {
        ContentResolver cr = getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        return mime.getMimeTypeFromExtension(cr.getType(uri));
    }

    public void uploadFile(View v) {
        if (filepath != null) {
            final ProgressDialog dialog = new ProgressDialog(this);
            dialog.setTitle("uploading");
            Messege.messege(getBaseContext(),"status: "+filepath);

            dialog.show();

            StorageReference ref = storageReference.child(STORAGE_PATH_UPLOADS + System.currentTimeMillis());
            ref.putFile(filepath).
                    addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            dialog.dismiss();
                            @SuppressWarnings("VisibleForTests")
                            Upload upload = new Upload(mName.getText().toString().trim(), taskSnapshot.getDownloadUrl().toString());
                            String key = mDatabase.push().getKey();
                            mDatabase.child(key).setValue(upload);
                            Messege.messege(MainActivity.this, "Uploaded");
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    dialog.dismiss();
                    Log.d(TAG, "onFailure: " + e);
                }
            }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                   /* @SuppressWarnings("VisibleForTests")
                    double progress = (100.0 * taskSnapshot.getBytesTransferred()) / taskSnapshot.getTotalByteCount();
                    dialog.setMessage("Uploaded " + ((int) progress) + "%...");*/
                }
            });

        } else Toast.makeText(MainActivity.this, "Select an Image ", Toast.LENGTH_SHORT).show();
    }

    public void showDialog(View v) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        DialogFragment dilogFragment = MyDialogFragment.newIntance(43);
        dilogFragment.show(ft, "dilalog");
    }
}
