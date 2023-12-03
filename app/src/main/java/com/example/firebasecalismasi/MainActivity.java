package com.example.firebasecalismasi;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("kisiler");


        /*Kisiler kisi1 = new Kisiler("","Mensur",71);
        Kisiler kisi2 = new Kisiler("","Zalim",24);
        Kisiler kisi3 = new Kisiler("","Samaya",51);
        Kisiler kisi4 = new Kisiler("","Ferrux",47);
        Kisiler kisi5 = new Kisiler("","Akif",33);
        Kisiler kisi6 = new Kisiler("","Haci",66);
        Kisiler kisi7 = new Kisiler("","Dinamik",20);


        myRef.push().setValue(kisi1);
        myRef.push().setValue(kisi2);
        myRef.push().setValue(kisi3);
        myRef.push().setValue(kisi4);
        myRef.push().setValue(kisi5);
        myRef.push().setValue(kisi6);
        myRef.push().setValue(kisi7);*/

        //myRef.child("-NX1vHmY3jm57dfWfkmQ").removeValue();

        /*Map<String,Object> info = new HashMap<>();

        info.put("kisi_ad","Qvatemala");
        info.put("kisi_yas",96);

        myRef.child("-NX1vHmFJvrQM7ufEcRE").updateChildren(info);*/


        //Query sorgu = myRef.orderByChild("kisi_ad").equalTo("Dinamik");

        //Query sorgu = myRef.limitToFirst(4);


        /*
        Query sorgu = myRef.orderByChild("kisi_yas").startAt(18).endAt(65);



        sorgu.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot d: snapshot.getChildren()){
                    Kisiler kisi = d.getValue(Kisiler.class);
                    String key = d.getKey();

                    kisi.setKisi_key(key);


                    Log.e("*********","**********");
                    Log.e("kisi_key",kisi.getKisi_key());
                    Log.e("kisi_ad",kisi.getKisi_ad());
                    Log.e("kisi_yas",String.valueOf(kisi.getKisi_yas()));
                    Log.e("*********","**********");

                }



            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


         */





        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                // ilk calisanda butun datalari getirir

                Kisiler kisi = snapshot.getValue(Kisiler.class);
                String key = snapshot.getKey();

                kisi.setKisi_key(key);


                Log.e("*********", "**********");
                Log.e("kisi_key", kisi.getKisi_key());
                Log.e("kisi_ad", kisi.getKisi_ad());
                Log.e("kisi_yas", String.valueOf(kisi.getKisi_yas()));
                Log.e("*********", "**********");

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {


                Kisiler kisi = snapshot.getValue(Kisiler.class);
                String key = snapshot.getKey();

                kisi.setKisi_key(key);


                Log.e("*********", "**********");
                Log.e("kisi_key", kisi.getKisi_key());
                Log.e("kisi_ad", kisi.getKisi_ad());
                Log.e("kisi_yas", String.valueOf(kisi.getKisi_yas()));
                Log.e("*********", "**********");

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {


                Kisiler kisi = snapshot.getValue(Kisiler.class);
                String key = snapshot.getKey();

                kisi.setKisi_key(key);


                Log.e("*********", "**********");
                Log.e("kisi_key", kisi.getKisi_key());
                Log.e("kisi_ad", kisi.getKisi_ad());
                Log.e("kisi_yas", String.valueOf(kisi.getKisi_yas()));
                Log.e("*********", "**********");

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }
}