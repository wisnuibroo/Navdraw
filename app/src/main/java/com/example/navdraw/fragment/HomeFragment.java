package com.example.navdraw.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.navdraw.R;

public class HomeFragment extends Fragment {

    private CardView berita1Card;
    private CardView berita2Card;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        berita1Card = view.findViewById(R.id.cardBreaking1);
        berita2Card = view.findViewById(R.id.cardBreaking2);

        if (berita1Card != null) {
            berita1Card.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    BreakingNews1Fragment breakingNews1Fragment = new BreakingNews1Fragment();
                    FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragment_container, breakingNews1Fragment);
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
            });
        }

        if (berita2Card != null) {
            berita2Card.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    BreakingNews2Fragment breakingNews2Fragment = new BreakingNews2Fragment();
                    FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragment_container, breakingNews2Fragment);
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
            });
        }


        return view;
    }
}
