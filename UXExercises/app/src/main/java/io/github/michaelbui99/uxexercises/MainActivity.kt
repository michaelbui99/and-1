package io.github.michaelbui99.uxexercises

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.BaseTransientBottomBar.LENGTH_SHORT
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private var navController: NavController? = null;
    private var appBarConfig: AppBarConfiguration? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        val fab: FloatingActionButton = findViewById(R.id.fab);
        fab.setOnClickListener() {
            Snackbar.make(it, "FAB pressed", LENGTH_SHORT).show();
        }

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView);
        navController = navHostFragment?.findNavController();
        appBarConfig = AppBarConfiguration.Builder(R.id.view_home).build()
        NavigationUI.setupActionBarWithNavController(this, navController!!, appBarConfig!!);
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.actionbar_menu, menu);
        return true;
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val itemId = item.itemId;

        if (itemId == R.id.actionbar_toast) {
            Toast.makeText(this, "Action button pressed", Toast.LENGTH_SHORT).show()
        }
        return NavigationUI.onNavDestinationSelected(
            item,
            navController!!
        ) || super.onOptionsItemSelected(item);
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(
            navController!!,
            appBarConfig!!
        ) || super.onSupportNavigateUp()
    }
}