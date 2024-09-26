package com.example.activity3_adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder>{
    //List of the user
    private List<User> userList;

    //constructor
    public UserAdapter(List<User> ul) {
        this.userList = ul;
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {

        public TextView txtViewName;
        public TextView txtViewAge;
        public TextView txtViewGender;
        public TextView txtViewEmail;
        public TextView txtViewCountry;
        public Button btnDelete;

        //view holder
        public UserViewHolder(View itemView, final UserAdapter adapter) {
            super(itemView);
            txtViewName = itemView.findViewById(R.id.txtViewName);
            txtViewAge = itemView.findViewById(R.id.txtViewAge);
            txtViewGender = itemView.findViewById(R.id.txtViewGender);
            txtViewEmail = itemView.findViewById(R.id.txtViewCountry);
            txtViewCountry = itemView.findViewById(R.id.txtViewEmail);
            btnDelete = itemView.findViewById(R.id.btnDelete);

            btnDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    try {
                        adapter.deleteUser(getAdapterPosition());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            });
        }

    }
          public void deleteUser(int position){
              userList.remove(position);
              notifyItemRemoved(position);  // Notify RecyclerView about the removal
              notifyItemRangeChanged(position, userList.size());
                    }


    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_item, parent, false);

        return new UserViewHolder(view, this);

    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
            User currentUser = userList.get(position);
            holder.txtViewName.setText(currentUser.getName());
            holder.txtViewAge.setText(String.valueOf(currentUser.getAge()));
            holder.txtViewGender.setText(currentUser.getGender());
            holder.txtViewEmail.setText(currentUser.getEmail());
            holder.txtViewCountry.setText(currentUser.getCountry());
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }


}


