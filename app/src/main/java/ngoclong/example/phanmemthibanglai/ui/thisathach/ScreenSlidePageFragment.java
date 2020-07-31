package ngoclong.example.phanmemthibanglai.ui.thisathach;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import ngoclong.example.phanmemthibanglai.R;
import ngoclong.example.phanmemthibanglai.ui.caccauhaysai.CacCauHaySai;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScreenSlidePageFragment extends Fragment {
    CauHoi c;
    ArrayList<DapAn> arrDA;

    int position;
    TextView tvCauHoi;
    RadioGroup rdGrp;
    RadioButton dapAn1;
    RadioButton dapAn2;
    RadioButton dapAn3;
    ImageView imageView;
    int tongSoCau;
    int diem = 0;
    LamBaiThiActivity lbt;
    boolean daThiXong;
    String dapAnChon;
    String dapAnDung;


    public ScreenSlidePageFragment() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public ScreenSlidePageFragment(CauHoi c, ArrayList<DapAn> arrDA,int position,int tongSoCau,LamBaiThiActivity lbt, boolean daThiXong,String dapAnChon,String dapAnDung) {
        this.c = c;
        this.arrDA = arrDA;
        this.position = position;
        this.tongSoCau = tongSoCau;
        this.lbt = lbt;
        this.daThiXong = daThiXong;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
            // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_screen_slide_page, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle
            savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvCauHoi = view.findViewById(R.id.tvCauHoi);
        rdGrp = view.findViewById(R.id.grpDapAn);
        dapAn1 = view.findViewById(R.id.rdBtnDapAn1);
        dapAn2 = view.findViewById(R.id.rdBtnDapAn2);
        dapAn3 = view.findViewById(R.id.rdBtnDapAn3);
        imageView = view.findViewById(R.id.imvCauHoi);

        loadCauHoi();
        rdGrp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(dapAn1.isChecked())
                   lbt.updateListDapAnChon(position,1,dapAn1.getText().toString());
                else if(dapAn2.isChecked())
                    lbt.updateListDapAnChon(position,2,dapAn2.getText().toString());
                else if(dapAn3.isChecked())
                    lbt.updateListDapAnChon(position,3,dapAn3.getText().toString());
            }
        });

    }

    private void loadCauHoi()
    {
        if(daThiXong)
        {

            tvCauHoi.setText("Câu "+String.valueOf(position + 1) +": "+c.getNoiDung());
            String url = "file:///android_asset/images/"+c.getHinhAnh();
            Picasso.with(getContext()).load(url).into(imageView);
            for (int i = 0; i < rdGrp.getChildCount(); i++) {
                ((RadioButton) rdGrp.getChildAt(i)).setText(arrDA.get(i).getNoiDung());
            }
        }
        else
        {
            tvCauHoi.setText("Câu "+String.valueOf(position + 1) +": "+c.getNoiDung());
            String url = "file:///android_asset/images/"+c.getHinhAnh();
            Picasso.with(getContext()).load(url).into(imageView);
            for (int i = 0; i < rdGrp.getChildCount(); i++) {
                ((RadioButton) rdGrp.getChildAt(i)).setText(arrDA.get(i).getNoiDung());
            }
        }
    }
    private void setupRadioButton(boolean trueOrFalse)
    {
        for(int i=0 ; i <rdGrp.getChildCount(); i++)
        {
            rdGrp.getChildAt(i).setClickable(trueOrFalse);
        }
    }

}
