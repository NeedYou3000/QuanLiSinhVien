package com.example.quanlisinhvien;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class SinhVienInFoActivity extends AppCompatActivity {
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sinh_vien_in_fo);
        findViewById(R.id.add_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mssv = ((TextView)findViewById(R.id.mssv)).getText().toString();
                String hoten = ((TextView)findViewById(R.id.hoten)).getText().toString();
                String email = ((TextView)findViewById(R.id.email)).getText().toString();
                String ngaysinh = ((TextView)findViewById(R.id.ngaysinh)).getText().toString();
                try {
                    db = SQLiteDatabase.openDatabase(getFilesDir() + "/quanlisv", null, SQLiteDatabase.CREATE_IF_NECESSARY);
                    addSinhVien(db, mssv, hoten, email, ngaysinh);
                    Toast.makeText(SinhVienInFoActivity.this, "Thêm thành công", Toast.LENGTH_SHORT).show();

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        findViewById(R.id.back_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

    }

    public void addSinhVien(SQLiteDatabase db, String mssv, String hoten, String email, String ngaysinh) {
        String query = "Insert into SinhVien(mssv, hoten, email, ngaysinh) values ('"+ mssv +"', '" + hoten +"', '" + email + "', '" + ngaysinh + "')";
        db.execSQL(query);
    }
}