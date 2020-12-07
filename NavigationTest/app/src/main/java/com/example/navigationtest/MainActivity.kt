package com.example.navigationtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.example.navigationtest.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener{
    companion object{
        const val TAG = "MainActivity"
    }
    private val navController by lazy{ Navigation.findNavController(this, R.id.fragment_nav_host)}
    private val vBinding by lazy{ActivityMainBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(vBinding.root)

        setNavComponent()
    }

    private fun setNavComponent(){
        NavigationUI.setupActionBarWithNavController(this, navController, vBinding.drawerLayout)
        vBinding.navView.setNavigationItemSelectedListener(this)    //route to onNavigationItemSelected()

        navController.addOnDestinationChangedListener{ _, _, _ ->
            Log.d(TAG, "backstack size: ${navController.backStack.size}")
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.item_home -> {
                if (isNotCurrentDest(R.id.homeFragment))
                    popUpNavigateTo(R.id.homeFragment)
            }
            R.id.item_1 -> {
                if (isNotCurrentDest(R.id.fragment11))
                    popUpNavigateTo(R.id.fragment11)
            }
            R.id.item_2 -> {
                if (isNotCurrentDest(R.id.fragment21))
                    popUpNavigateTo(R.id.fragment21)
            }
        }

        vBinding.drawerLayout.close()
        return true
    }

    private fun popUpNavigateTo(destId: Int){
        val inclusive = destId == R.id.homeFragment
        NavOptions.Builder()
            .setPopUpTo(R.id.homeFragment, inclusive)   //works only when dest is present in back stack
            .build()
            .let{
                navController.navigate(destId, null, it)
            }
    }

    private fun isNotCurrentDest(destId: Int): Boolean{
        return destId != navController.currentDestination?.id
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController, vBinding.drawerLayout)    //home button(or back button) opens drawer(or navigate backwards)
    }
}