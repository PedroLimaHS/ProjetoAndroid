package com.example.pedro.motosapi;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.pedro.motosapi.Http.MotoParser;
import com.example.pedro.motosapi.Model.Motos;
import com.example.pedro.motosapi.Ui.Adapter.MotosAdapter;

import java.io.IOException;
import java.util.List;

public class MotosActivity extends AppCompatActivity
        implements SearchView.OnQueryTextListener {

    ListView mListviewMotos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motos);

        mListviewMotos = (ListView)findViewById(R.id.list_moto);

        new MotosSearchTask().execute("MT-07");
    }
    @Override

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_bar, menu);

        MenuItem searchItem = menu.findItem(R.id.menu_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setOnQueryTextListener(this);

        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }

    class MotosSearchTask extends AsyncTask<String, Void, List<Motos>>{

        @Override
        protected List<Motos> doInBackground(String...params) {
            try {
                List<Motos> motos = MotoParser.searchByTitle(params [0]);
                return motos;

            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
        @Override
        protected void onPostExecute(List<Motos> motos){
            super.onPostExecute(motos);
            if(motos != null){
                mListviewMotos.setAdapter(
                        new MotosAdapter(MotosActivity.this, motos));

            }
        }
    }
}
