package com.amthuc.congthuc.ui.screen.main

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.core.os.bundleOf
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.amthuc.congthuc.R
import com.amthuc.congthuc.data.model.Category
import com.amthuc.congthuc.databinding.ActivityMainBinding
import com.amthuc.congthuc.ui.base.BaseActivity
import com.amthuc.congthuc.ui.screen.recipe.RecipeFragment
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navController: NavController
    private lateinit var drawerLayout: DrawerLayout

    override val viewModel: MainViewModel by viewModel()

    override val layoutId: Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        drawerLayout = findViewById(R.id.drawer_layout)
        val adapter = CategoryDrawerAdapter(::openCategoryDetail)
        val host: NavHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment?
                ?: return
        navController = host.navController

        setSupportActionBar(toolbar)
        setupActionBar()
        setupRecyclerCategoryDrawer(adapter)

        findViewById<View>(R.id.nav_favorite).setOnClickListener {
            findNavController(R.id.nav_host_fragment).navigate(R.id.favorite_dest)
            drawerLayout.closeDrawer(GravityCompat.START)
        }

        findViewById<View>(R.id.nav_search).setOnClickListener {
            findNavController(R.id.nav_host_fragment).navigate(R.id.search_dest)
            drawerLayout.closeDrawer(GravityCompat.START)
        }

        viewModel.categories.observe(this, Observer {
            adapter.submitList(it)
        })
        viewModel.fillDb()
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    private fun setupActionBar() {
        appBarConfiguration = AppBarConfiguration(navController.graph, drawerLayout)
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    private fun setupRecyclerCategoryDrawer(adapter: CategoryDrawerAdapter) {
        recycler_category_drawer.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            addItemDecoration(
                DividerItemDecoration(
                    this@MainActivity,
                    DividerItemDecoration.VERTICAL
                )
            )
            this.adapter = adapter
        }
    }

    private fun openCategoryDetail(category: Category) {
        val title = category.title + " (" + category.recipes.toString() + " món)"
        findNavController(R.id.nav_host_fragment).navigate(
            R.id.recipe_dest,
            bundleOf(
                RecipeFragment.ARGUMENT_CATEGORY to category,
                RecipeFragment.ARGUMENT_TITLE to title
            )
        )
        drawerLayout.closeDrawer(GravityCompat.START)
    }
}