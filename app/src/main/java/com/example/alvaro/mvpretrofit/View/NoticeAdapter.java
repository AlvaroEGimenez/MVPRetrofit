package com.example.alvaro.mvpretrofit.View;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alvaro.mvpretrofit.Model.Notice;
import com.example.alvaro.mvpretrofit.R;
import java.util.ArrayList;

public class NoticeAdapter extends RecyclerView.Adapter<NoticeAdapter.EmployeeViewHolder> {

    private ArrayList<Notice> noticeArrayList;
    private RecyclerItemClickListener recyclerItemClickListener;

    public NoticeAdapter(ArrayList<Notice> noticeArrayList, RecyclerItemClickListener recyclerItemClickListener) {
        this.noticeArrayList = noticeArrayList;
        this.recyclerItemClickListener = recyclerItemClickListener;
    }

    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.single_view_row,viewGroup,false);
        return new EmployeeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder holder,  int posicion) {
        holder.bindNotice(noticeArrayList.get(posicion));
    }

    @Override
    public int getItemCount() {
        return noticeArrayList.size();
    }


    class EmployeeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView txtNoticeTitle, txtNoticeBrief, txtNoticeFilePath;
        Notice mNotice;

        public EmployeeViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNoticeTitle =  itemView.findViewById(R.id.txt_notice_title);
            txtNoticeBrief =  itemView.findViewById(R.id.txt_notice_brief);
            txtNoticeFilePath =  itemView.findViewById(R.id.txt_notice_file_path);
            itemView.setOnClickListener(this);
        }

        public void bindNotice(Notice noticia){
            this.mNotice=noticia;
            txtNoticeTitle.setText(noticia.getTitle());
            txtNoticeBrief.setText(noticia.getContent());
            txtNoticeFilePath.setText(noticia.getSource().getName());
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(v.getContext(), mNotice.getTitle(), Toast.LENGTH_SHORT).show();
            /*Intent inten=new Intent(v.getContext(),MainActivity.class);
            inten.putExtra("NOTICIA",mNotice);
            v.getContext().startActivity(inten);*/
         }
    }


    public interface RecyclerItemClickListener {
        void onItemClick(Notice notice);
    }

}
