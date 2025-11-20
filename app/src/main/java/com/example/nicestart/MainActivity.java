package com.example.nicestart;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

public class MainActivity extends AppCompatActivity {
    private SwipeRefreshLayout swipeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        TextView mycontext =findViewById(R.id.main2);
        registerForContextMenu(mycontext);
        swipeLayout= findViewById(R.id.myswipe);
        swipeLayout.setOnRefreshListener(monRefreshListener);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        getMenuInflater().inflate(R.menu.menu_context,menu);
    }
    @Override
    public boolean onContextItemSelected(MenuItem item){
        if (item.getItemId()==R.id.item1){
            Toast toast = Toast.makeText(this,"item copied",
                    Toast.LENGTH_LONG);
            toast.show();
        }else if (item.getItemId()==R.id.item2){
            Toast toast2 = Toast.makeText(this,"Downloading item ...",
                    Toast.LENGTH_LONG);
            toast2.show();
        }
        return false ;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_appbar,menu);
        return true;
    }
   // @Override
   // public boolean onOptionsItemSelected(MenuItem menu){
       // int id = item.getItemId();
   // }
    protected SwipeRefreshLayout.OnRefreshListener
            monRefreshListener= new SwipeRefreshLayout.OnRefreshListener() {
       @Override
       public void onRefresh() {
           Toast toast0= Toast.makeText(MainActivity.this,"Hi there!",Toast.LENGTH_LONG);
           toast0.show();
           swipeLayout.setRefreshing(false);
       }
   };
}