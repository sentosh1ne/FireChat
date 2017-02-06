package com.sentosh1ne.firechat.adapters.register;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sentosh1ne.firechat.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by sentosh1ne on 10.01.2017.
 */

public class AvatarAdapter extends RecyclerView.Adapter<AvatarAdapter.ViewHolder> {
    private  OnAvatarClickListener listener;
    private  String[] mAvatars = {"\uD83D\uDE00", "\uD83D\uDE08", "\uD83D\uDC7D", "\uD83D\uDCA9", "\uD83D\uDC7B"};

    public AvatarAdapter(OnAvatarClickListener listener) {
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.avatar_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String emoji = mAvatars[position];
        holder.mAvatartTextView.setText(emoji);
    }

    @Override
    public int getItemCount() {
        return mAvatars.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.choose_avatar_text)
        TextView mAvatartTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            mAvatartTextView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            listener.onClick(mAvatartTextView.getText().toString());
        }
    }
}

