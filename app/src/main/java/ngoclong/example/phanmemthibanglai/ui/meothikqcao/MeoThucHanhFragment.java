package ngoclong.example.phanmemthibanglai.ui.meothikqcao;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import ngoclong.example.phanmemthibanglai.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MeoThucHanhFragment extends Fragment {
    ListView listView;
    private MeoThiDAO mt;
    private ArrayList<MeoThi> arrMeoThi;
    TextView tvNoiDung;
    int count;
    public MeoThucHanhFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mt = new MeoThiDAO(getContext());
        arrMeoThi = new ArrayList<MeoThi>();
        count = mt.getMeoThucHanh();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_meo_thuc_hanh, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listView = view.findViewById(R.id.listTH);
        loadAllMTT();

    }
    private void loadAllMTT() {
        arrMeoThi = mt.getAllMeoThucHanh();
        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);
    }
    private class CustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return arrMeoThi.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int i, View convertView, ViewGroup parent) {
            View view1 = getLayoutInflater().inflate(R.layout.item_meothi, null);
            tvNoiDung = view1.findViewById(R.id.tvMLT);

            tvNoiDung.setText((i + 1) +". "+ arrMeoThi.get(i).getNoiDung());
            return view1;
        }
    }
}
