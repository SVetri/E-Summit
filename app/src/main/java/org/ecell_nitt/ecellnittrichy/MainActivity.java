package org.ecell_nitt.ecellnittrichy;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.util.Calendar;


public class MainActivity extends ActionBarActivity {

    private WebView webview;
    private ProgressBar progress;
    private String url = "http://www.ecell-nitt.org/";
    private PendingIntent pendingIntent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_PROGRESS);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
        Intent myIntent = new Intent(MainActivity.this, MyReceiver.class);

        //1

        pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 1, myIntent,0);

        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.MONTH, 2);
        calendar.set(Calendar.YEAR, 2015);
        calendar.set(Calendar.DAY_OF_MONTH, 7);

        calendar.set(Calendar.HOUR_OF_DAY, 15);
        calendar.set(Calendar.MINUTE, 00);
        calendar.set(Calendar.SECOND, 0);

        alarmManager.set(AlarmManager.RTC, calendar.getTimeInMillis(), pendingIntent);

        //2

        pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 2, myIntent,0);

        Calendar calendar2 = Calendar.getInstance();

        calendar2.set(Calendar.MONTH, 2);
        calendar2.set(Calendar.YEAR, 2015);
        calendar2.set(Calendar.DAY_OF_MONTH, 8);

        calendar2.set(Calendar.HOUR_OF_DAY, 14);
        calendar2.set(Calendar.MINUTE, 45);
        calendar2.set(Calendar.SECOND, 0);

        alarmManager.set(AlarmManager.RTC, calendar2.getTimeInMillis(), pendingIntent);

        //3

        pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 3, myIntent,0);

        Calendar calendar3 = Calendar.getInstance();

        calendar3.set(Calendar.MONTH, 2);
        calendar3.set(Calendar.YEAR, 2015);
        calendar3.set(Calendar.DAY_OF_MONTH, 7);

        calendar3.set(Calendar.HOUR_OF_DAY, 16);
        calendar3.set(Calendar.MINUTE, 30);
        calendar3.set(Calendar.SECOND, 0);

        alarmManager.set(AlarmManager.RTC, calendar3.getTimeInMillis(), pendingIntent);

        //4

        pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 4, myIntent,0);

        Calendar calendar4 = Calendar.getInstance();

        calendar4.set(Calendar.MONTH, 2);
        calendar4.set(Calendar.YEAR, 2015);
        calendar4.set(Calendar.DAY_OF_MONTH, 7);

        calendar4.set(Calendar.HOUR_OF_DAY, 17);
        calendar4.set(Calendar.MINUTE, 00);
        calendar4.set(Calendar.SECOND, 0);

        alarmManager.set(AlarmManager.RTC, calendar4.getTimeInMillis(), pendingIntent);

        //5

        pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 5, myIntent,0);

        Calendar calendar5 = Calendar.getInstance();

        calendar5.set(Calendar.MONTH, 2);
        calendar5.set(Calendar.YEAR, 2015);
        calendar5.set(Calendar.DAY_OF_MONTH, 8);

        calendar5.set(Calendar.HOUR_OF_DAY, 10);
        calendar5.set(Calendar.MINUTE, 30);
        calendar5.set(Calendar.SECOND, 0);

        alarmManager.set(AlarmManager.RTC, calendar5.getTimeInMillis(), pendingIntent);

        //6

        pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 6, myIntent,0);

        Calendar calendar6 = Calendar.getInstance();

        calendar6.set(Calendar.MONTH, 2);
        calendar6.set(Calendar.YEAR, 2015);
        calendar6.set(Calendar.DAY_OF_MONTH, 8);

        calendar6.set(Calendar.HOUR_OF_DAY, 13);
        calendar6.set(Calendar.MINUTE, 30);
        calendar6.set(Calendar.SECOND, 0);

        alarmManager.set(AlarmManager.RTC, calendar6.getTimeInMillis(), pendingIntent);

        //7

        pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 7, myIntent,0);

        Calendar calendar7 = Calendar.getInstance();

        calendar.set(Calendar.MONTH, 2);
        calendar.set(Calendar.YEAR, 2015);
        calendar.set(Calendar.DAY_OF_MONTH, 7);

        calendar.set(Calendar.HOUR_OF_DAY, 15);
        calendar.set(Calendar.MINUTE, 13);
        calendar.set(Calendar.SECOND, 0);

        alarmManager.set(AlarmManager.RTC, calendar.getTimeInMillis(), pendingIntent);

        Log.i("----------------", "FINISHED THE ALARM STUFF!");

        webview = (WebView) findViewById(R.id.wv1);
        progress = (ProgressBar) findViewById(R.id.progressBar);

        webview.setWebChromeClient(new MyWebViewClient());

        progress.setMax(100);

        webview.getSettings().setJavaScriptEnabled(true);
        webview.getSettings().setBuiltInZoomControls(true);

        webview.loadUrl(url);

        MainActivity.this.progress.setProgress(0);




        /*final Activity activity = this;
        webview.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {
                // Activities and WebViews measure progress with different scales.
                // The progress meter will automatically disappear when we reach 100%
                activity.setProgress(progress * 100);
            }
        });*/
        webview.setWebViewClient(new WebViewClient() {
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Toast.makeText(MainActivity.this, "Oh no! " + description, Toast.LENGTH_SHORT).show();
            }
        });


    }

    private class MyWebViewClient extends WebChromeClient {
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            MainActivity.this.setValue(newProgress);
            super.onProgressChanged(view, newProgress);
            if(newProgress==100)
            {
                newProgress=0;
            }
        }
    }

    public void setValue(int progress) {
        this.progress.setProgress(progress);
    }

    @Override
    public void onBackPressed() {
        if (webview.canGoBack()) {
            webview.goBack();
        } else {
            super.onBackPressed();
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
        if (scanResult != null) {
            // handle scan result
            //Toast.makeText(MainActivity.this, scanResult.getContents().toString(), Toast.LENGTH_SHORT).show();
            if(scanResult.getContents()!=null) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
                // set title
                alertDialogBuilder.setTitle("Scanned Message");

                // set dialog message
                alertDialogBuilder
                        .setMessage(scanResult.getContents())
                        .setCancelable(false)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // if this button is clicked, close
                                // current activity
                                dialog.cancel();
                            }
                        });

                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
                alertDialog.show();
            }
        }
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
        /*if (id == R.id.action_settings) {
            return true;
        }*/

        if(id==R.id.action_reload)
        {
            webview.loadUrl(url);
        }
        if(id==R.id.action_scan)
        {
            IntentIntegrator intentIntegrator = new IntentIntegrator(this);
            //intentIntegrator.setResultDisplayDuration(10);
            intentIntegrator.initiateScan(); // `this` is the current Activity
        }
        if(id==R.id.action_fb)
        {
            webview.loadUrl("https://www.facebook.com/ecell.nit.trichy");
        }

        return super.onOptionsItemSelected(item);
    }
}
