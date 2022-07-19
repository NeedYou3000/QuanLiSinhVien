package com.example.quanlisinhvien;

import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ItemAdapter extends BaseAdapter {
    Cursor cs;

    public ItemAdapter(Cursor cs) {
        this.cs = cs;
    }

    @Override
    public int getCount() {
        return cs.getCount();
    }

    @Override
    public Object getItem(int i) {
        return cs.moveToPosition(i);
    }

    @Override
    public long getItemId(int i) {
        cs.moveToPosition(i);
        return cs.getInt(0);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (view == null)
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_item, viewGroup, false);

        TextView textMSSV = view.findViewById(R.id.mssv_tv);
        TextView textHoten = view.findViewById(R.id.hoten_tv);
        TextView textEmail = view.findViewById(R.id.email_tv);
        TextView textNgaySinh = view.findViewById(R.id.ngaysinh_tv);

        cs.moveToPosition(i);

        String mssv = cs.getString(1);
        String hoten = cs.getString(2);
        String email = cs.getString(3);
        String ngaysinh = cs.getString(4);

        textMSSV.setText(mssv);
        textHoten.setText(hoten);
        textEmail.setText(email);
        textNgaySinh.setText(ngaysinh);

        return view;
    }
}
