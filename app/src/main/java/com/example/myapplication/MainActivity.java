package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public RecyclerView rvLista;
    public ListAdapter adp;
    List<ListElement> elements;

    public void abrirBubble(View view){
        Intent intent = new Intent(MainActivity.this, bubble.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

}

    public void init() {
        elements = new ArrayList<>();
        elements.add(new ListElement("#653fe8", "BubbleSort", "Dinámico y fácil", R.drawable.bubbles));
        elements.add(new ListElement("#653fe8", "MergeSort", "Ágil e intuitivo", R.drawable.blender));
        elements.add(new ListElement("#653fe8", "QuickSort", "Velocidad, soy veloz", R.drawable.bolt));
        elements.add(new ListElement("#653fe8", "HeapSort", "Extraño pero listo", R.drawable.heaps));
        elements.add(new ListElement("#653fe8", "CountingSort", "Creativo pero incomprendido", R.drawable.count));


        ListAdapter listAdapter = new ListAdapter(elements, this);
        RecyclerView recyclerView = findViewById(R.id.ListaMetodos);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter);

    }
}