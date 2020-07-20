package com.example.mylisthome;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toolbar;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;


public class MainActivity extends AppCompatActivity implements OnMovieFragmentClickListener {

    private FrameLayout tabletFragmentContainer = null;

    //    public static MoviesService moviesService;
    public MoviesFragment moviesFragment;
    public DetailsFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null)
            moviesFragment = new MoviesFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.ctivity_main_frame, moviesFragment)
                .commit();
    }
    public void pagar() {
        ViewPager pager = findViewById(R.id.activity_main_tablet_frame);
        PagerAdapter pagerAdapter = new SimplePagerAdapter(getSupportFragmentManager(), LoadFragme());
        pager.setAdapter(pagerAdapter);
    }

    public ArrayList<Fragment> LoadFragme() {
        ArrayList<Fragment> fragmentsArray = new ArrayList<>();
        for (int i = 0; i < loadMovies().size(); i++) {
            fragment = DetailsFragment.newInstance(loadMovies().get(i));
            fragmentsArray.add(fragment);
        }
        return fragmentsArray;
    }
    public static ArrayList<MoviesModel> loadMovies() {


        ArrayList<MoviesModel> movies = new ArrayList<>();


        MoviesModel movie1 = new MoviesModel();
        MoviesModel movie2 = new MoviesModel();
        MoviesModel movie3 = new MoviesModel();
        MoviesModel movie4 = new MoviesModel();
        MoviesModel movie5 = new MoviesModel();
        MoviesModel movie6 = new MoviesModel();
        MoviesModel movie7 = new MoviesModel();
        MoviesModel movie8 = new MoviesModel();
        MoviesModel movie9 = new MoviesModel();
        MoviesModel movie10 = new MoviesModel();

        movie1.setName("Breakfast for children");
        movie2.setName("Good Morning . Breakfast");
        movie3.setName("Funny meal for kids");
        movie4.setName("Breakfast");
        movie5.setName("Funny dinner for kids");
        movie6.setName("Happy night");
        movie7.setName("Funny lunch for the kids");
        movie8.setName("happy day");
        movie9.setName("Dinner ");
        movie10.setName("happy day");

        movie1.setImageResourceId(R.drawable.food);
        movie2.setImageResourceId(R.drawable.images);
        movie3.setImageResourceId(R.drawable.food3);
        movie4.setImageResourceId(R.drawable.images1);
        movie5.setImageResourceId(R.drawable.imag2);
        movie6.setImageResourceId(R.drawable.hqdefault);
        movie7.setImageResourceId(R.drawable.images66);
        movie8.setImageResourceId(R.drawable.images56);
        movie9.setImageResourceId(R.drawable.caption);
        movie10.setImageResourceId(R.drawable.food2);
        movie1.setOverview("Egypt Most Egyptians begin the day with a light breakfast. Ful medames (dish of cooked fava beans), one of Egypt's several national dishes, is typical. It is seasoned with salt and cumin, garnished with vegetable oil and optionally with tahini, chopped parsley, chopped tomato, garlic, onion, lemon juice, chili pepper and often served topped with a boiled egg. It is scooped up and eaten with the staple whole wheat pita bread called Eish Masri or Eish Baladi  and usually accompanied by taʿamiya  which is the local variant of falafel made with fava beans, fresh cut homemade French fries and various fresh or pickled vegetables (called torshi). Several kinds of cheeses are popular, including gebna bēḍa or Domyati cheese, gebna rūmi (Roman cheese) which is similar to Pecorino Romano or Manchego, and Istanbuli cheese (a brined white cheese with peppers added to the brine which makes it spicy). Fried eggs with pastirma is also a common breakfast food in Egypt.");
        movie2.setOverview("While breakfast is commonly referred to as the most important meal of the day, some epidemiological research indicates that having breakfast high in rapidly available carbohydrates increases the risk of metabolic syndrome. Present professional opinion is largely in favor of eating breakfast, but some contest the positive implications of its most important status. The influence of breakfast on managing body weight is unclear");
        movie3.setOverview("Three years after…");
        movie4.setOverview("A special meal");
        movie5.setOverview("Three years after…");
        movie6.setOverview("A special meal");
        movie7.setOverview("Three years after…");
        movie8.setOverview("A special meal");
        movie9.setOverview("In many modern usages, the term dinner refers to the evening meal, which is now typically the largest meal of the day in Western cultures. When this meaning is used, the preceding meals are usually referred to as breakfast, lunch and perhaps a tea.[2][12] Supper is now often an alternative term for dinner; originally this was always a later secondary evening meal, after an early dinner.\n" +
                "\n" +
                "The divide between different meanings of \"dinner\" is not cut-and-dried based on either geography or socioeconomic class. However, the use of the term dinner for the midday meal is strongest among working-class people, especially in the English Midlands, North of England and the central belt of Scotland.[12] Even in systems in which dinner is the meal usually eaten at the end of the day, an individual dinner may still refer to a main or more sophisticated meal at any time in the day, such as a banquet, feast, or a special meal eaten on a Sunday or holiday, such as Christmas dinner or Thanksgiving dinner. At such a dinner, the people who dine together may be formally dressed and consume food with an array of utensils. These dinners are often divided into three or more courses. Appetizers consisting of options such as soup or salad, precede the main course, which is followed by the dessert.\n" +
                "\n" +
                "A survey by Jacob's Creek, an Australian winemaker, found the average evening meal time in the U.K. to be 7:47pm");
        movie10.setOverview("Diet food (or \"dietetic food\") refers to any food or beverage whose recipe is altered to reduce fat, carbohydrates, abhor/adhore sugar in order to make it part of a weight loss program or diet. Such foods are usually intended to assist in weight loss or a change in body type, although bodybuilding supplements are designed to aid in gaining weight or muscle.\n" +
                "\n" +
                "The process of making a diet version of a food usually requires finding an acceptable low-food-energy substitute for some high-food-energy ingredient. This can be as simple as replacing some or all of the food's sugar with a sugar substitute as is common with diet soft drinks such as Coca-Cola (for example Diet Coke). In some snacks, the food may be baked instead of fried thus reducing the food energy. In other cases, low-fat ingredients may be used as replacements.\n" +
                "\n" +
                "In whole grain foods, the higher fiber content effectively displaces some of the starch component of the flour. Since certain fibers have no food energy, this results in a modest energy reduction. Another technique relies on the intentional addition of other reduced-food-energy ingredients, such as resistant starch or dietary fiber, to replace part of the flour and achieve a more significant energy reduction.");

        movies.add(movie1);
        movies.add(movie2);
        movies.add(movie3);
        movies.add(movie4);
        movies.add(movie5);
        movies.add(movie6);
        movies.add(movie7);
        movies.add(movie8);
        movies.add(movie9);
        movies.add(movie10);
        return movies;
    }
//
//    public void onMovieClicked(MoviesModel moviesModel) {
//        fragment = DetailsFragment.newInstance(moviesModel);
//        if (tabletFragmentContainer == null) {
//            getSupportFragmentManager().beginTransaction()
//                    .addToBackStack(null)
//                    .replace(R.id.ctivity_main_frame, fragment)
//                    .commit();
//        }
//        else {
//            getSupportFragmentManager()
//                    .beginTransaction()
//                    .replace(R.id.activity_main_tablet_frame, fragment)
//                    .commit();
//        }
//   }

    public void onMovieClicked(MoviesModel movieModel, ArrayList<MoviesModel> arrayMovies, int position) {

        DetailsFragment fragment = DetailsFragment.newInstance(movieModel);
        if (tabletFragmentContainer == null){
            getSupportFragmentManager().beginTransaction().addToBackStack(null)
                    .replace(R.id.ctivity_main_frame, fragment)
                    .commit();

            ViewPager pager = findViewById(R.id.pagerview);
        PagerAdapter simplePagerAdapter = new SimplePagerAdapter(getSupportFragmentManager(), LoadFragme());
        pager.setAdapter(simplePagerAdapter);
        pager.setCurrentItem(position);
            pager.setVisibility(View.VISIBLE);
        pager.setPageTransformer(true, new ZoomOutPageTransformer());

    }
        else {
//            getSupportFragmentManager().beginTransaction().replace(R.id.activity_main_tablet_frame, fragment).commit();
            ViewPager pager = findViewById(R.id.activity_main_tablet_frame);
            PagerAdapter simplePagerAdapter = new SimplePagerAdapter(getSupportFragmentManager(), LoadFragme());
            pager.setAdapter(simplePagerAdapter);
            pager.setCurrentItem(position);

            pager.setPageTransformer(true, new ZoomOutPageTransformer());

        }
        //    @Override
//    protected void onSaveInstanceState(Bundle savedInstanceState) {
//        savedInstanceState.putInt(STATE_COUNTER, mCounter);
//        super.onSaveInstanceState(savedInstanceState);
//    }
//    @Override
//    protected void onRestoreInstanceState(Bundle savedInstanceState) {
//        if (savedInstanceState != null) {
//            mCounter = savedInstanceState.getInt(STATE_COUNTER);
//            updateCounterValue(mCounter);
//        }
//        super.onRestoreInstanceState(savedInstanceState);
//    }
//    initRecyclerView();
////        ListView mListView =  findViewById(R.id.recyclerView);
//    }
//    private void initRecyclerView() {
//        mRecyclerView = findViewById(R.id.recyclerView);
//        mLayoutManager = new LinearLayoutManager(this);
//        mRecyclerView.setLayoutManager(mLayoutManager);
//        MoviesBaseAdapter adapter = new MoviesBaseAdapter(this, loadMovies(),);
//        mRecyclerView.setAdapter(adapter);
//    }
//        ListView mListView =  findViewById(R.id.item_movie_l);
//        MoviesBaseAdapter adapter = new MoviesBaseAdapter(this,loadMovies());
//        mListView.setAdapter(adapter);

    }
}
