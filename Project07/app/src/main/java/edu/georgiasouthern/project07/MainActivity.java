package edu.georgiasouthern.project07;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    DBHelper helper = new DBHelper(this);
    EditText etID;
    EditText etVal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etID = findViewById(R.id.editTextTextPersonName);
        etVal = findViewById(R.id.editTextTextPersonName2);


    }
    public void onInsert(View view){
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues row = new ContentValues();
        row.put("id", etID.getText().toString());
        row.put("val", etVal.getText().toString());
        db.insert("mytable", null, row);
        db.close();
    }
    public void onSelect(View view){
        SQLiteDatabase db = helper.getReadableDatabase();

        Cursor cursor = db.rawQuery("select * from mytable where id=?",
                new String[] { etID.getText().toString()});
        if (cursor.moveToFirst()){
            etVal.setText(cursor.getString(1));

        } else {
            etVal.setText("[null]");
        }

    }

}