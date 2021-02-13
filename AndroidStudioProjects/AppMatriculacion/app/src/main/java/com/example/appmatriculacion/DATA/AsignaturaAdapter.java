package com.example.appmatriculacion.DATA;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appmatriculacion.R;

import java.util.List;

public class AsignaturaAdapter extends RecyclerView.Adapter<AsignaturaAdapter.AsignaturaViewHolder> {
    private List<Asignaturas> asignaturasList;

    @NonNull
    @Override
    public AsignaturaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AsignaturaViewHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.asignatura_item, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull AsignaturaViewHolder holder, int position){
        Asignaturas item = asignaturasList.get(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return asignaturasList == null ? 0 : asignaturasList.size();
    }

    public void setItems(List<Asignaturas> items){
        asignaturasList = items;
        notifyDataSetChanged();
    }


    public class AsignaturaViewHolder extends RecyclerView.ViewHolder{
        private final TextView nameAsignatura;
        private final ImageView btndelete;
        private final ImageView btnedit;

        public AsignaturaViewHolder(@NonNull View itemView){
            super(itemView);
            nameAsignatura = itemView.findViewById(R.id.name_asignatura);
            btndelete = itemView.findViewById(R.id.btndelete);
            btnedit = itemView.findViewById(R.id.btnedit);
        }

        //Setear eventos

        public void manageEvents(View view){

        }

        public void bind(Asignaturas item){
            nameAsignatura.setText(item.id_asignatura+" "+item.name_asignatura);
        }
    }


}
