package com.example.cookingrecipeapplication.adapters;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.cookingrecipeapplication.fragments.ViewDirectionsFragment;
import com.example.cookingrecipeapplication.fragments.ViewIngredientsFragment;
import com.example.cookingrecipeapplication.models.Recipe;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    private static final int TAB_COUNT = 2;
    private final Recipe recipe;
    private String[] tabTitles = {"Ingredients", "Directions"};

    public ViewPagerAdapter(FragmentManager fm, Recipe recipe) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.recipe = recipe;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment frag = null;
        switch (position) {
            case 0:
                frag = ViewIngredientsFragment.newInstance(recipe.getIngredients());
                break;
            case 1:
                frag = ViewDirectionsFragment.newInstance(recipe.getDirections());
                break;
        }
        return frag;
    }

    @Override
    public int getCount() {
        return TAB_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
