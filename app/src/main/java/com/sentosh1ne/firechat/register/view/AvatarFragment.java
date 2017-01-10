package com.sentosh1ne.firechat.register.view;

import android.app.FragmentTransaction;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sentosh1ne.firechat.R;
import com.sentosh1ne.firechat.adapters.register.AvatarAdapter;

import butterknife.BindView;


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

    private void toEmail(String emoji) {
        Bundle data = this.getArguments();
        data.putString("emoji", emoji);
        FragmentManager manager = getActivity().getSupportFragmentManager();
        manager.beginTransaction()
                .replace(R.id.register_activity_frame_layout, EmailFragment.newInstance(data), "email")
                .addToBackStack("email").commit();
    }

    private void setList(){
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 5));
    }

}

