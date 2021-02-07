package com.example.shoppinglistapp;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import com.example.shoppinglistapp.model.Items;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.text.TextUtils;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton btnAdd;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = findViewById(R.id.btn_add);
        recyclerView = findViewById(R.id.recycler_view);

        //Button Click

        btnAdd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                showDialogAddItem();
            }
        });

    }

    private void showDialogAddItem() {
        Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_add_entry);

        Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCancelable(true);
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(Objects.requireNonNull(dialog.getWindow()).getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        dialog.getWindow().setAttributes(lp);

        ImageButton btnClose = dialog.findViewById(R.id.btn_close);

        btnClose.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                dialog.dismiss();
            }
        });

        EditText edEntry = dialog.findViewById(R.id.ed_entry);
        Button btnAdd = dialog.findViewById(R.id.btn_add);

        btnAdd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(TextUtils.isEmpty(edEntry.getText())){
                    edEntry.setError("This field can't be empty");
                } else {
                    addDataToFirebase(edEntry.getText().toString());
                    dialog.dismiss();
                }
            }
        });

        dialog.show();
    }

    private void addDataToFirebase(String text){
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Item");

        Items items = new Items(myRef.push().getKey(),text,false);

        myRef.push().setValue(items).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(getApplicationContext(), "Successfully added",Toast.LENGTH_SHORT).show();
            }
        });

    }
}