package com.example.jasonchi.firechat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddContact extends AppCompatActivity {

    DatabaseReference reference;
    EditText name, addr, phone;
    Button commit;
    Intent it;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        reference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://firechat-7e5df.firebaseio.com/contact");
        it = getIntent();

        init();
    }

    void init(){
        name = (EditText) findViewById(R.id.input_name);
        addr = (EditText) findViewById(R.id.input_addr);
        phone = (EditText) findViewById(R.id.input_phone);
        commit = (Button) findViewById(R.id.btn_commit);
        commit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Contact newContact = new Contact();
                newContact.setId(Integer.parseInt(it.getStringExtra("SizeOfList")));
                newContact.setName(name.getText().toString().trim());
                newContact.setAddr(addr.getText().toString().trim());
                newContact.setPhone(phone.getText().toString().trim());
                reference.child(it.getStringExtra("SizeOfList")).setValue(newContact);
                finish();
            }
        });
    }
}
