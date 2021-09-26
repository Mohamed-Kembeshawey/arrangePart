package com.sam.android.arrangepart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.view.WindowManager;

import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView answerRecycler;
    RecyclerView choiceRecycler;
    ArrAdapter answerAdapter;
    ArrAdapter choiceAdapter;

    String sentence = "What/is/your/name?/my/name/is/mohamed";

    List<String> correctArray;
    List<String> answerArray;
    List<String> choicesArray;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        correctArray = Arrays.asList(sentence.split("/").clone());
        choicesArray=new ArrayList<>(correctArray) ;
        answerArray = new ArrayList<>();
        Collections.shuffle(choicesArray);
        for (int i=0;i<correctArray.size();i++)
            System.out.println(correctArray.get(i));
        System.out.println("8888888888888888888888888888888888888888888");
        for (int i=0;i<choicesArray.size();i++)
            System.out.println(choicesArray.get(i));

        answerRecycler = findViewById(R.id.answer_rc);
        choiceRecycler = findViewById(R.id.choice_rc);

        answerRecycler.setEnabled(false);
        choiceRecycler.setEnabled(false);

        answerAdapter = new ArrAdapter(answerArray,choicesArray);
        choiceAdapter = new ArrAdapter(choicesArray,answerArray);

        answerAdapter.setOppositeAdapter(choiceAdapter);
        choiceAdapter.setOppositeAdapter(answerAdapter);

       // RecyclerView.LayoutManager answerLayoutManager = new StaggeredGridLayoutManager(4,StaggeredGridLayoutManager.VERTICAL);
       // RecyclerView.LayoutManager answerLayoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        FlexboxLayoutManager flexboxLayoutManager = new FlexboxLayoutManager(getApplicationContext());
        flexboxLayoutManager.setFlexDirection(FlexDirection.ROW);
        flexboxLayoutManager.setJustifyContent(JustifyContent.FLEX_START);
        answerRecycler.setLayoutManager(flexboxLayoutManager);
       // RecyclerView.LayoutManager choiceLayoutManager = new StaggeredGridLayoutManager(2,RecyclerView.HORIZONTAL);
        //RecyclerView.LayoutManager choiceLayoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        FlexboxLayoutManager flexboxLayoutManager2 = new FlexboxLayoutManager(getApplicationContext());
        flexboxLayoutManager2.setFlexDirection(FlexDirection.ROW);
        flexboxLayoutManager2.setJustifyContent(JustifyContent.FLEX_START);
        choiceRecycler.setLayoutManager(flexboxLayoutManager2);


       /* answerRecycler.setNestedScrollingEnabled(false);
        choiceRecycler.setNestedScrollingEnabled(false);*/

        answerRecycler.setAdapter(answerAdapter);
        choiceRecycler.setAdapter(choiceAdapter);

    }
}