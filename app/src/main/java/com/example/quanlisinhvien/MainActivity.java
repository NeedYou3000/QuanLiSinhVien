package com.example.quanlisinhvien;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase db;
    ListView listSV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String path = getFilesDir() + "/quanlisv";
        try {
            db = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.CREATE_IF_NECESSARY);
//            addSinhVien();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        listSV = findViewById(R.id.listview);
        String[] columns = {"id", "mssv", "hoten", "email", "ngaysinh"};
        Cursor cs = db.query("SinhVien", columns, null, null, null, null, null);
        ItemAdapter adapter = new ItemAdapter(cs);
        listSV.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.addSV:
                showAddActivity();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void showAddActivity() {
        Intent intent = new Intent(this, SinhVienInFoActivity.class);
        startActivity(intent);
    }

    private void createTable() {
        db.beginTransaction();
        try {
            db.execSQL("create table SinhVien ("
                    + " id integer PRIMARY KEY autoincrement, "
                    + " mssv text, "
                    + " hoten text,"
                    + " email text,"
                    + " ngaysinh date); " );

            db.setTransactionSuccessful();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();
        }
    }

    private void addSinhVien() {

        db.beginTransaction();
        try {
            db.execSQL("Insert into SinhVien(mssv, hoten, email, ngaysinh) VALUES ('20194213', 'Nguyen Quang Vu', 'nguyenquangvu@gmail.com', '2001-05-04')");

            db.setTransactionSuccessful();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();
        }
    }

    @Override
    protected void onDestroy() {
        db.close();
        super.onDestroy();
    }
}