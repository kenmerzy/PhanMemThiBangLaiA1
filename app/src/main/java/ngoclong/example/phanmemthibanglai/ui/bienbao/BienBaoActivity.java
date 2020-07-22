package ngoclong.example.phanmemthibanglai.ui.bienbao;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;

import ngoclong.example.phanmemthibanglai.R;

public class BienBaoActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private  TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bien_bao);

        assert  getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Biển báo đường bộ");
        initView();
    }

    private void initView() {
        viewPager = findViewById(R.id.vPager);
        tabLayout =findViewById(R.id.tabLayout);
        viewPager.setAdapter(new BienBaoAdapter(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);
    }

    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_tra_cuu_luat, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onSupportNavigateUp()
    {
        finish();
        return true;
    }
}
