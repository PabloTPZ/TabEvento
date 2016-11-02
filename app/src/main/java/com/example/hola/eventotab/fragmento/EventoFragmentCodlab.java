package com.example.hola.eventotab.fragmento;



import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hola.eventotab.R;
import com.example.hola.eventotab.clases.Evento;
import com.example.hola.eventotab.clases.EventoAdapter;
import com.example.hola.eventotab.clases.EventoAdapter2;
import com.example.hola.eventotab.clases.MetodosFunciones;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class EventoFragmentCodlab extends Fragment {
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    MetodosFunciones metodosFunciones;
    String key = "";
    String tituloTarjeta = "Titulo Tarjeta";
    String horaTarjeta = "00:00";
    String expositorTarjeta = "Expositor Tarjeta";
    List<Evento> listaEventos = new ArrayList<>();
    View view;

    //Llenar tarjeta
    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;

    // Firebase
//    DatabaseReference myDataBase = FirebaseDatabase.getInstance().getReference();
  //  DatabaseReference conferencias = myDataBase.child("Conferencias");

    //cargar lista
    private ProgressDialog circular;
    int c=0;

    public EventoFragmentCodlab() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.recycleview, container, false);
        //circular = ProgressDialog.show(view.getContext(), "Cargando","Aguarde un momendo...", true);
        //circular.setProgress(R.color.colorPrimary);

        return view;
    }

    public void usarRecycleView() {
        recycler = (RecyclerView) view.findViewById(R.id.my_recycler_view);
        recycler.setHasFixedSize(true);

        // Usar un administrador para LinearLayout
        lManager = new LinearLayoutManager(getActivity());
        recycler.setLayoutManager(lManager);

        // Crear un nuevo adaptador
        adapter = new EventoAdapter2(listaEventos);
        recycler.setAdapter(adapter);
    }

    @Override
    public void onStart() {
        listaEventos.clear();
        super.onStart();
        listaEventos.add(new Evento("2", "titulo 2", "hora 2", "expositor evento 2", "img"));
        listaEventos.add(new Evento("2", "titulo 2", "hora 2", "expositor evento 2", "img"));
        listaEventos.add(new Evento("2", "titulo 2", "hora 2", "expositor evento 2", "img"));
        listaEventos.add(new Evento("2", "titulo 2", "hora 2", "expositor evento 2", "img"));
        listaEventos.add(new Evento("2", "titulo 2", "hora 2", "expositor evento 2", "img"));
        listaEventos.add(new Evento("2", "titulo 2", "hora 2", "expositor evento 2", "img"));
        usarRecycleView();
        /*if (metodosFunciones.compruebaConexion(getContext())) {
            //Comienza spinner
            conferencias.orderByChild("Hora_inicio").addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                    if (dataSnapshot.hasChildren()) {
                        String key = "key"; String tituloEvento = "titulo"; String horaEvento = "hora";
                        String expositorEvento = "expositor"; String imagenEvento ="https://firebasestorage.googleapis.com/v0/b/elearningday-28334.appspot.com/o/ElearningDay2.jpg?alt=media&token=988ceb0e-3bb5-45aa-a63a-e2a48793c7cd";
                        key = dataSnapshot.getKey();
                        Map<String, Object> dataChild = (Map<String, Object>) dataSnapshot.getValue();
                        if (!dataChild.containsKey("Click")) {
                            if (dataChild.containsKey("Nombre"))
                                tituloEvento = dataChild.get("Nombre").toString();
                            if (dataChild.containsKey("Hora_inicio"))
                                horaEvento = dataChild.get("Hora_inicio").toString();
                            if (dataChild.containsKey("Expositor"))
                                expositorEvento = dataChild.get("Expositor").toString();
                            if (dataChild.containsKey("Imagen")) {
                                imagenEvento = dataChild.get("Imagen").toString();
                                //Toast.makeText(getContext(), imagenEvento, Toast.LENGTH_LONG).show();
                            }
                            listaEventos.add(new Evento(key, tituloEvento, horaEvento, expositorEvento, imagenEvento));
                            usarRecycleView();
                            c++;
                        }
                    }
                    if(c==dataSnapshot.getChildrenCount()){
                        circular.dismiss();
                        c=0;
                    }
                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                }

                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot) {
                }

                @Override
                public void onChildMoved(DataSnapshot dataSnapshot, String s) {
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                }
            });
            //Termina Spinner
        } else {
            /*Toast.makeText(getContext(), "Revisa tu conexion a internet", Toast.LENGTH_LONG).show();
            FragmentManager fragmentManager = getFragmentManager();
            final SinConexionFragment dialogo = new SinConexionFragment();
            dialogo.show(fragmentManager, "tagAlerta");
            dialogo.setOnDismissListener(new DialogInterface.OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialog) {
                    if(dialogo.isVolverCargar()){
                        onStart();
                    }else {
                        Intent refresh = new Intent(getActivity(),MainActivity.class);
                        startActivity(refresh);
                        getActivity().finish();
                    }
                }
            });
        }*/
    }

    //Sets
    public void setKey(String key) {
        this.key = key;
    }

    public void setTituloTarjeta(String tituloTarjeta) {
        this.tituloTarjeta = tituloTarjeta;
    }

    public void setHoraTarjeta(String horaTarjeta) {
        this.horaTarjeta = horaTarjeta;
    }

    public void setExpositorTarjeta(String expositorTarjeta) {
        this.expositorTarjeta = expositorTarjeta;
    }

    //Gets
    public String getTituloTarjeta() {
        return tituloTarjeta;
    }

    public String getHoraTarjeta() {
        return horaTarjeta;
    }

    public String getExpositorTarjeta() {
        return expositorTarjeta;
    }
    @Override
    public void onResume() {
        super.onResume();

       /* getView().setFocusableInTouchMode(true);
        getView().requestFocus();
        getView().setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if (event.getAction() == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_BACK){
                    getActivity().setTitle(R.string.navInicio);
                    fragmentManager = getFragmentManager();
                    fragmentTransaction = fragmentManager.beginTransaction();
                    InicioFragment inicio = new InicioFragment();
                    fragmentTransaction.setCustomAnimations(R.anim.right_in, R.anim.right_out);
                    fragmentTransaction.replace(R.id.contenedor, inicio);
                    //fragmentTransaction.addToBackStack("tag");
                    fragmentTransaction.commit();
                    return true;
                }
                return false;
            }
        });*/
    }

}
