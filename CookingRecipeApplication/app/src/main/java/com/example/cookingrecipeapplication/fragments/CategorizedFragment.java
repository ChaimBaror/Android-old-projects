package com.example.cookingrecipeapplication.fragments;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pair;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cookingrecipeapplication.R;
import com.example.cookingrecipeapplication.adapters.DatabaseAdapter;
import com.example.cookingrecipeapplication.adapters.RecipeAdapter;

import com.example.cookingrecipeapplication.models.Recipe;

import java.util.ArrayList;
import java.util.List;

public abstract class CategorizedFragment extends Fragment {



    private CategorizedFragmentListener categorizedFragmentListener;
    protected RecyclerView recipeRecyclerView;
    private TextView emptyView;
    protected RecipeAdapter recipeAdapter;
    protected DatabaseAdapter databaseAdapter;
    protected String currentCategory;
    protected List<Recipe> recipes;


    public CategorizedFragment() {
        // Required empty public constructor
        recipes = new ArrayList<>();
        databaseAdapter = DatabaseAdapter.getInstance(getActivity());
    }

    public static Fragment newInstance(String category) {
        Fragment fragment;
        switch (category) {
            case "American":
                fragment = new AmericanFragment();
                break;
            case "Asian":
                fragment = new AsianFragment();
                break;
            case "European":
                fragment = new EuropeanFragment();
                break;
            case "Mediterranean":
                fragment = new MediterraneanFragment();
                break;
            default:
                fragment = new VeganFragment();
                break;
        }

        Bundle args = new Bundle();
        args.putString("category", category);
        fragment.setArguments(args);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View View = inflater.inflate(getFragmentLayout(), container, false);

        Bundle args = getArguments();
        currentCategory = args.getString("category");

        recipeRecyclerView = View.findViewById(R.id.recyclerView);
        emptyView = View.findViewById(R.id.empty_view);
        recipeRecyclerView.setHasFixedSize(true);
        recipeRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return View;
    }

    @Override
    public void onStart() {
        super.onStart();
        refresh();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof CategorizedFragmentListener)
        try {
            categorizedFragmentListener = (CategorizedFragmentListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException( " must implement CategorizedFragmentListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        categorizedFragmentListener = null;
    }

    public void refresh() {
        recipes = databaseAdapter.getAllRecipesByCategory(currentCategory);
        toggleEmptyView();
        recipeAdapter = new RecipeAdapter(getActivity(), recipes);
        recipeAdapter.setRecipeListener(new RecipeAdapter.RecipeListener() {
            @Override
            public void onShowRecipe(Recipe recipe, Pair<View, String>[] pairs) {

            }

            @Override
            public void onEditRecipe(Recipe recipe) {

            }

            @Override
            public void onDeleteRecipe(long recipeId) {

            }
        });

        recipeRecyclerView.setAdapter(recipeAdapter);
    }

    private void toggleEmptyView() {
        if (recipes.size() == 0) {
            emptyView.setVisibility(View.VISIBLE);
            recipeRecyclerView.setVisibility(View.GONE);
        } else {
            emptyView.setVisibility(View.GONE);
            recipeRecyclerView.setVisibility(View.VISIBLE);
        }
    }

    protected abstract @LayoutRes
    int getFragmentLayout();


    public interface CategorizedFragmentListener {

        void onShowRecipe(Recipe recipe, Pair<View, String>[] pairs);

        void onEditRecipe(Recipe recipe);

        void onDeleteRecipe(long recipeId);
    }

}
