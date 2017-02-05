package com.sentosh1ne.firechat.register.view;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sentosh1ne.firechat.R;
import com.sentosh1ne.firechat.register.presenter.UniqueUserPresenterImpl;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class UserFragment extends Fragment implements UserFragmentView{

    @BindView(R.id.reg_username_edit_text)
    EditText mUsernameEditText;
    @BindView(R.id.continue_button)
    Button mContinueButton;

    private UniqueUserPresenterImpl mPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user, container, false);
        ButterKnife.bind(this, view);
        return view;
        
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onSuccess() {
        Bundle bundle = new Bundle();
        bundle.putString("username", mUsernameEditText.getText().toString());
        FragmentManager fragmentManager = getActivity().getFragmentManager();
        fragmentManager.beginTransaction()
                .setTransitionStyle(FragmentTransaction.TRANSIT_ENTER_MASK)
                .replace(R.id.register_activity_frame_layout,
                        AvatarFragment.newInstance(bundle),"avatar")
                .addToBackStack("avatar")
                .commit();
    }

    @Override
    public void onFailure() {
        Toast.makeText(getActivity(),R.string.username_taken,Toast.LENGTH_LONG).show();
    }

    @OnClick(R.id.continue_button)
    public void onContinue(){
        Log.i("Supertag","pressed");
        mPresenter.nameExists(mUsernameEditText.getText().toString());
    }
}
