package com.example.appmatriculacion.DATA;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appmatriculacion.R;

import java.util.ArrayList;
import java.util.List;

public class AlumnoAsignaturaAdapter  extends RecyclerView.Adapter<AlumnoAsignaturaAdapter.AlumnoAsignaturaViewHolder> {
    private List<AlumnoAsignatura>  alumnoAsignaturaList;
    private ItemListener itemListener;
    private Alumnos alumnos;


    @NonNull
    @Override
    public AlumnoAsignaturaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        return new AlumnoAsignaturaViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.alumno_asignatura_item,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull AlumnoAsignaturaViewHolder holder, int position){
        AlumnoAsignatura item = alumnoAsignaturaList.get(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount(){
        return alumnoAsignaturaList == null ? 0 : alumnoAsignaturaList.size();
    }

    public void setAlumnos(Alumnos alumnos) {
        this.alumnos = alumnos;
    }

    public void setItems(List<AlumnoAsignatura> items){
        String compara;
        List<AlumnoAsignatura>list = new ArrayList<AlumnoAsignatura>();
        for (AlumnoAsignatura alumnoAsignatura: items){
                compara = alumnoAsignatura.getDni_alumno();
                if (compara.equalsIgnoreCase(alumnos.getDni_alumno())==true){
                    list.add(alumnoAsignatura);
                }
        }

        alumnoAsignaturaList = list;
        notifyDataSetChanged();
    }

    public void setItemListener(ItemListener listener){
        itemListener = listener;
    }

    public interface ItemListener{
        void onClick(AlumnoAsignatura alumnoAsignatura);
        void onDeleteIconClicked(AlumnoAsignatura alumnoAsignatura);
    }

    public class AlumnoAsignaturaViewHolder extends RecyclerView.ViewHolder{
        private final TextView nameAsignatura;
        private final ImageView btndelete;

        public AlumnoAsignaturaViewHolder(@NonNull View itemView){
            super(itemView);
            nameAsignatura = itemView.findViewById(R.id.info_asignatura);
            btndelete = itemView.findViewById(R.id.btndelete_relacion);

            //Setear eventos
            //btndelete.setOnClickListener(this::manageEvents);



        }

        public void manageEvents(View view){
            if(itemListener!=null){
                AlumnoAsignatura clickeditem = alumnoAsignaturaList.get(getAdapterPosition());

                //Manejar eventos de click
                if(view.getId() == R.id.btndelete_relacion){
                    itemListener.onDeleteIconClicked(clickeditem);
                    return;
                }

                itemListener.onClick(clickeditem);
            }

        }

        public void bind(AlumnoAsignatura item){
            nameAsignatura.setText(item.getId_asignatura()+""+item.getName_asignatura());
        }
    }
}
