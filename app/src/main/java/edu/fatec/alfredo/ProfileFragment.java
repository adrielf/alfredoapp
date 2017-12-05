package edu.fatec.alfredo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


public class ProfileFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_profile, container, false);

        String [] values = {"-","Casa","Trabalho","Fatec" };
        Spinner spin1 = (Spinner) v.findViewById(R.id.spinner_gps);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, values);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spin1.setAdapter(adapter);

        return v;
    }



}
