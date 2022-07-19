package com.example.quanlisinhvien;

import android.database.sqlite.SQLiteDatabase;

public class DAO {
    public static SQLiteDatabase getSQL(String path) {
        SQLiteDatabase db;
        try {
            db = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.CREATE_IF_NECESSARY);
            return db;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    public static void addSinhVien(String mssv, String hoten, String email, String ngaysinh) {

    }
}
