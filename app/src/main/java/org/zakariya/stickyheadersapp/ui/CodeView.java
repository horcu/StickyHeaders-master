package org.zakariya.stickyheadersapp.ui;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import org.zakariya.stickyheadersapp.R;
import org.zakariya.stickyheadersapp.custom.constants;
import org.zakariya.stickyheadersapp.model.Lesson;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import eu.fiskur.syntaxview.SyntaxView;

public class CodeView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code_view);
     //   Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
      //  setSupportActionBar(toolbar);

     //   toolbar.setVisibility(View.GONE);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        fab.hide();
        Lesson lesson = null;
        String code = "No code for this section";
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            lesson = (Lesson) extras.get(constants.LESSON);
        }

        final SyntaxView syntaxView = (SyntaxView) findViewById(R.id.syntaxview);

        final String[] themes = syntaxView.themes();
        int rand = 0;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            rand = ThreadLocalRandom.current().nextInt(0, themes.length);
        }

        syntaxView.setLoadingColor(Color.parseColor("#83BA30"));
        final String themeName = themes[rand];
        syntaxView.loadString(lesson == null ? code : lesson.getSolution(), "java", themeName);
        final Snackbar snack =  Snackbar.make(fab, "this theme is called: " + themeName, Snackbar.LENGTH_INDEFINITE);
                snack.setAction("random", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            int randx = ThreadLocalRandom.current().nextInt(0, themes.length);
                            String theme = themes[randx];
                            syntaxView.setTheme(theme);
                            snack.setText( "this theme is called: " + theme);
                        }

                    }
                });

        snack.show();
    }

}
