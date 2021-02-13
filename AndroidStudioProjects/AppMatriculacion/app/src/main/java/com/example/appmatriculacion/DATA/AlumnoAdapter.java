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

public class AlumnoAdapter extends RecyclerView.Adapter<AlumnoAdapter.AlumnoViewHolder> {
    private List<Alumnos> alumnosList;
    private ItemListener itemListener;

    @NonNull
    @Override
    public AlumnoAdapter.AlumnoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AlumnoAdapter.AlumnoViewHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.alumno_item, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull AlumnoAdapter.AlumnoViewHolder holder, int position){
        Alumnos item = alumnosList.get(position);
        holder.bind(item);
    }



    @Override
    public int getItemCount() {
        return alumnosList == null ? 0 : alumnosList.size();
    }

    public void setItems(List<Alumnos> items){
        alumnosList = items;
        notifyDataSetChanged();
    }
    public void setItemListener(AlumnoAdapter.ItemListener listener) {
        itemListener = listener;
    }

    public interface ItemListener{
        void onClick(Alumnos alumnos);
        void onDeleteIconClicked(Alumnos alumnos);
    }

    public class AlumnoViewHolder extends RecyclerView.ViewHolder{
        private final TextView nameAlumno;
        private final ImageView btndelete;
        private final ImageView btnedit;
        private final ImageView btndetalle;

        public AlumnoViewHolder(@NonNull View itemView){
            super(itemView);
            nameAlumno = itemView.findViewById(R.id.name_alumno);
            btndelete = itemView.findViewById(R.id.btndeletealu);
            btnedit = itemView.findViewById(R.id.btneditalu);
            btndetalle = itemView.findViewById(R.id.btnaddalu);

            //Setear eventos
            btndelete.setOnClickListener(this::manageEvents);
        }

         public void manageEvents(View view){
             if (itemListener!=null){
                 Alumnos clickeditem = alumnosList.get(getAdapterPosition());

                 //Manejar eventos de click
                 if (view.getId()== R.id.btndeletealu){
                     itemListener.onDeleteIconClicked(clickeditem);
                     return;
                 }
                 itemListener.onClick(clickeditem);

             }
        }

        public void bind(Alumnos item){
            nameAlumno.setText(item.name_alumno+" "+item.apellidos_alumno+"\n"+item.dni_alumno);
        }
    }
}
