package com.panca_nugraha.uts_mobile5;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class fragmentMenu extends Fragment {

    View v;
    RecyclerView recyclerView;
    List<ModalClass> mList;
    CustomAdapter customAdapter;

    public fragmentMenu() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_menu, container, false);
        recyclerView = v.findViewById(R.id.recycleViewId);

        // Tambahkan parameter orientation (RecyclerView.HORIZONTAL)
        customAdapter = new CustomAdapter(mList, getContext(), RecyclerView.HORIZONTAL);

        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mList = new ArrayList<>();
        mList.add(new ModalClass(R.drawable.book1, "TERE LIYE BUMI"));
        mList.add(new ModalClass(R.drawable.book2, "TERE LIYE MATAHARI"));
        mList.add(new ModalClass(R.drawable.book3, "TERE LIYE BULAN"));
        mList.add(new ModalClass(R.drawable.book4, "TERE LIYE NEBULA"));
        mList.add(new ModalClass(R.drawable.book5, "TERE LIYE SELENA"));
    }
}
