package io.github.michaelbui99.navigationdrawerexercise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    private var appBarConfig: AppBarConfiguration? = null;
    private var navController: NavController? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar);

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navFragmentContainer = supportFragmentManager.findFragmentById(R.id.fragmentContainerView);
        val navigationView: NavigationView = findViewById(R.id.nav_view)

        navController = navFragmentContainer?.findNavController();
        appBarConfig = AppBarConfiguration(setOf(R.id.view_home),drawerLayout )
        NavigationUI.setupActionBarWithNavController(this, navController!!, appBarConfig!!)
        navigationView.setupWithNavController(navController!!)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.appbar_menu, menu);
        return true;
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, navController!!) || super.onOptionsItemSelected(item);
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController!!, appBarConfig!!) || super.onSupportNavigateUp()
    }
}