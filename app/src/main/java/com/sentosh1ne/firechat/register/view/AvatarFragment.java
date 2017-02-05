package com.sentosh1ne.firechat.register.view;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.v7.app.AlertDialog;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sentosh1ne.firechat.R;
import com.sentosh1ne.firechat.adapters.register.AvatarAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;


public class AvatarFragment extends Fragment implements AvatarFragmentView {
    @BindView(R.id.avatars_list)
    RecyclerView mRecyclerView;

    private AvatarAdapter mAvatarAdapter;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        setList();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_avatar, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void showDialog(String username, String email, String password, final String avatar) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("You chose: " + avatar + " , continue?");
        builder.setPositiveButton("Yeah!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                toEmail(avatar);
            }
        });
        builder.setNegativeButton("Go back!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void toEmail(String avatar) {
        Bundle data = this.getArguments();
        data.putString("avatar", avatar);
        FragmentManager manager = getActivity().getFragmentManager();
        manager.beginTransaction()
                .replace(R.id.register_activity_frame_layout, EmailFragment.newInstance(data), "email")
                .addToBackStack("email")
                .commit();
    }

    private void setList(){
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 5));
    }


    public static Fragment newInstance(Bundle args) {
        AvatarFragment fragment = new AvatarFragment();
        fragment.setArguments(args);
        return fragment;
    }
}

