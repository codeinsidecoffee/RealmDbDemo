package com.mrlonewolfer.realmdbdemo;

import androidx.appcompat.app.AppCompatActivity;
import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;

import android.app.Application;
import android.app.Person;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Realm realm;
    EditText etid,edtFName,edtLName;
    ListView listResult;
    Context context;

    Button btnSave,btnDelete,btnCancel;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        realm=Realm.getDefaultInstance();
        context=this;
        listResult=findViewById(R.id.listView);
        etid=findViewById(R.id.etId);
        edtFName=findViewById(R.id.etFirstName);
        edtLName=findViewById(R.id.etLastName);
        btnSave=findViewById(R.id.btnSave);

       fetchPersonData();

        listResult.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                PersonBean personBean=realm.where(PersonBean.class).equalTo("id",id).findFirst();


                edtFName.setText(personBean.getFirstName());
                edtLName.setText(personBean.getLastName());
                btnSave.setText("Update");
                btnDelete.setVisibility(View.VISIBLE);
                btnCancel.setVisibility(View.VISIBLE);
            }
        });




    }

    private void fetchPersonData() {
       RealmResults<PersonBean> persons=realm.where(PersonBean.class).findAll();
        setAdapter(persons);

       persons.addChangeListener(new RealmChangeListener<RealmResults<PersonBean>>() {
           @Override
           public void onChange(RealmResults<PersonBean> personBeans) {
               setAdapter(personBeans);
           }
       });
    }

    private void setAdapter(RealmResults<PersonBean> persons) {

        ArrayAdapter<PersonBean> adapter=new ArrayAdapter<>(context,android.R.layout.simple_list_item_1,persons);
        listResult.setAdapter(adapter);

    }

    public void savePerson(View view) {

        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                String myButtonValue=btnSave.getText().toString();
                if(myButtonValue=="Save") {
                    int id = Integer.parseInt(etid.getText().toString());
                    PersonBean personBean = realm.createObject(PersonBean.class, id);
                    personBean.setFirstName(edtFName.getText().toString());
                    personBean.setLastName(edtLName.getText().toString());
                }
                else{
                    int id=Integer.parseInt(etid.getText().toString());
                    PersonBean personBean=realm.where(PersonBean.class).equalTo("id",id).findFirst();
                    personBean.setFirstName(edtFName.getText().toString());
                    personBean.setLastName(edtLName.getText().toString());

                }

            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show();


            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                Toast.makeText(context, error.toString(), Toast.LENGTH_SHORT).show();
            }
        });


    }
}
