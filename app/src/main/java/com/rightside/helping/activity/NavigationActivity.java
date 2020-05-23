package com.rightside.helping.activity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.rightside.helping.R;
import com.rightside.helping.fragments.MarketplaceFragment;
import com.rightside.helping.fragments.PerfilFragment;
import com.rightside.helping.fragments.PromocoesFragment;
import com.rightside.helping.fragments.VotosFragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;


import butterknife.BindView;
import butterknife.ButterKnife;

public class NavigationActivity extends AppCompatActivity {

    private BottomNavigationView navView;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.fragment_marketplace:
                    inflaFragment(new MarketplaceFragment(), "marketplace");
                    return true;
                case R.id.fragment_votos:
                    inflaFragment(new VotosFragment(), "votos");
                    return true;
                case R.id.fragment_promocoes:
                    inflaFragment(new PromocoesFragment(), "promocoes");
                    return true;
                case R.id.fragment_perfil:
                    inflaFragment(new PerfilFragment(), "perfil");
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        ButterKnife.bind(this);

        navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        inflaFragment(new MarketplaceFragment(), "marketplace");
    }

    public void inflaFragment(Fragment fragment, String tag){
        getSupportFragmentManager().beginTransaction().replace(R.id.layout_container, fragment, tag).commit();
    }

}
