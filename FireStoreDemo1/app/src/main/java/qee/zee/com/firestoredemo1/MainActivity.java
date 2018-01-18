package qee.zee.com.firestoredemo1;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;

import qee.zee.com.firestoredemo1.model.Users;

public class MainActivity extends AppCompatActivity {

    FirebaseFirestore mFireStore;
    EditText edName;
    EditText edSemister;
    Users user;
    private RecyclerView recyclerView;
    final String TAG = "tag.test";
    private ArrayList<Users> usersList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edName = (EditText) findViewById(R.id.ed_name);
        edSemister= (EditText) findViewById(R.id.ed_semister);

        usersList = new ArrayList<>();
        mFireStore = FirebaseFirestore.getInstance();
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        final DetailAdapter adapter = new DetailAdapter(this, usersList);
        recyclerView.setAdapter(adapter);
        mFireStore.collection("users").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(QuerySnapshot documentSnapshots, FirebaseFirestoreException e) {
                if (e != null) {
                    Log.d(TAG, "Exception occured " + e);
                } else {
                    for (DocumentChange doc : documentSnapshots.getDocumentChanges()) {
                        if (doc.getType() == DocumentChange.Type.ADDED) {
                            user = doc.getDocument().toObject(Users.class).withID(doc.getDocument().getId());
                            usersList.add(user);
                            adapter.notifyDataSetChanged();
                        }
                    }

                }

            }
        });


    }

    public void saveData(View v){
        String name=edName.getText().toString();
        String sem=edSemister.getText().toString();
        Users user = new Users(name,sem);
        mFireStore.collection("users").add(user).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
            @Override
            public void onComplete(@NonNull Task<DocumentReference> task) {
                edName.setText("");
                edSemister.setText("");
                Toast.makeText(getBaseContext(),"Data stored",Toast.LENGTH_LONG).show();
            }
        });
    }
}