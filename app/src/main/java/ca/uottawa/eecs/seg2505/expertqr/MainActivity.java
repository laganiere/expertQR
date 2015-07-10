/**
 * This file contains material supporting the course
 * SEG2505: Introduction to Software Engineering
 * University of Ottawa.
 * http://wwww.eecs.uottawa.ca/~laganier
 *
 * This program is free software; permission is hereby granted to use, copy, modify,
 * and distribute this source code, or portions thereof, for any purpose, without fee,
 * subject to the restriction that the copyright notice may not be removed
 * or altered from any source or altered source distribution.
 * The software is released on an as-is basis and without any warranties of any kind.
 * In particular, the software is not guaranteed to be fault-tolerant or free from failure.
 * The author disclaims all warranties with regard to this software, any use,
 * and any consequent failure, is purely the responsibility of the user.
 *
 * Hanna Farah 2014
 * Robert Laganiere 2015
 */
package ca.uottawa.eecs.seg2505.expertqr;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import ca.uottawa.eecs.seg2505.expertqr.controlleur.Delegateur;
import ca.uottawa.eecs.seg2505.expertqr.db.MemoireFacade;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Delegateur.setDBFacade(new MemoireFacade());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onLogin(View view) {
        enableUI(true);
    }

    private void enableUI(boolean b) {
        findViewById(R.id.buttonLogin).setEnabled(!b);
        findViewById(R.id.buttonChoisirExpertises).setEnabled(b);
        findViewById(R.id.buttonPoserQuestion).setEnabled(b);
        findViewById(R.id.buttonRepondreQuestion).setEnabled(b);
        findViewById(R.id.buttonLireEvaluerReponse).setEnabled(b);
    }

    public void onChoisirExpertises(View view) {
        Intent intent = new Intent(this, ExpertiseActivity.class);
        startActivity(intent);
    }

    public void onPoserQuestion(View view) {
        Intent intent = new Intent(this, PoserQuestionActivity.class);
        startActivity(intent);
    }

    public void onRepondreQuestion(View view) {
        Intent intent = new Intent(this, RepondreQuestionActivity.class);
        startActivity(intent);
    }

    public void OnLireEvaluerReponse(View view) {
        Intent intent = new Intent(this, LireEvaluerActivity.class);
        startActivity(intent);
    }
}
