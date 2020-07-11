package safe.safeinsurance;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class New_Policy extends AppCompatActivity {
    ViewPager mviewpager;
    RecyclerView recyclerView;
    Handler handler;
    int initial_position = 0;
    ArrayList<Integer> array_image = new ArrayList<Integer>();
    ArrayList<String> array_head = new ArrayList<String>();
    int[] addimage = {
            R.drawable.safe1, R.drawable.safe2, R.drawable.safe3,R.drawable.safe4, R.drawable.safe5, R.drawable.safe6,R.drawable.safe7};
    private PagerAdapter mPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_policy);
        mviewpager = findViewById(R.id.viewpager);
        recyclerView=findViewById(R.id.rec_view);
        mPagerAdapter = new ScreenSlidePagerAdapter(this);
        handler = new Handler();
        mviewpager.setAdapter(mPagerAdapter);
        setdata();
        adapterClass adapteClassbottom = new adapterClass(this, array_image, array_head);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapteClassbottom);
        gridLayoutManager.canScrollHorizontally();


        /*******************************************************/

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                initial_position++;
                mviewpager.setCurrentItem(initial_position);
                if (initial_position == addimage.length) {
                    initial_position = 0;
                    mviewpager.setCurrentItem(initial_position);
                }
                handler.postDelayed(this, 5000);
            }
        };
        handler.postDelayed(runnable, 2000);

        /*****************************************************/
    }

    class ScreenSlidePagerAdapter extends PagerAdapter {
        Context mcontext;
        LayoutInflater mLayoutInflater;

        public ScreenSlidePagerAdapter(Context context) {
            mcontext = context;
            mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return addimage.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View itemView = mLayoutInflater.inflate(R.layout.pager_child, container, false);
            ImageView imageView = itemView.findViewById(R.id.pager_image);
//            TextView tv_head = (TextView) itemView.findViewById(R.id.txt_head);
//            TextView tv_detail = (TextView) itemView.findViewById(R.id.txtt_detail);
            imageView.setImageResource(addimage[position]);
//            tv_head.setText(array_head.get(position));
//            tv_detail.setText(array_detail.get(position));
            container.addView(itemView);
            return itemView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((LinearLayout) object);
        }
    }


    class adapterClass extends RecyclerView.Adapter<adapterClass.OnBindViewholder> {

        ArrayList<Integer> array_img;
        ArrayList<String> array_imghead;
        Context context;

        public adapterClass(New_Policy activity, ArrayList<Integer> array_img1, ArrayList<String> array_head1) {

            this.context = activity;
            this.array_img = array_img1;
            this.array_imghead = array_head1;
        }

        @Override
        public adapterClass.OnBindViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.newpolicy_child, parent, false);
            return new adapterClass.OnBindViewholder(view);
        }

        @Override
        public void onBindViewHolder(adapterClass.OnBindViewholder holder, final int position) {

            holder.image.setImageResource(array_image.get(position));
            holder.txt_head.setText(array_head.get(position));

        }

        public int getItemCount() {

            return array_image.size();
        }

        public class OnBindViewholder extends RecyclerView.ViewHolder {

            ImageView image;
            TextView txt_head;
            CardView cardview;

            public OnBindViewholder(View view) {

                super(view);
                cardview = itemView.findViewById(R.id.card_view_news);
                image = itemView.findViewById(R.id.imageview1);
                txt_head = itemView.findViewById(R.id.txt_head);

            }
        }
    }


    public void setdata(){

        array_image.add(R.drawable.new_motor);
        array_head.add("MOTOR INSURANCE");
        array_image.add(R.drawable.new_medical);
        array_head.add("MEDICAL INSURANCE");
        array_image.add(R.drawable.new_aviation);
        array_head.add("TRAVEL INSURANCE");
        array_image.add(R.drawable.new_health);
        array_head.add("HEALTH INSURANCE");
        array_image.add(R.drawable.new_fire);
        array_head.add("FIRE INSURANCE");
        array_image.add(R.drawable.new_property);
        array_head.add("PROPERTY INSURANCE");
        array_image.add(R.drawable.new_marain);
        array_head.add("MARINE INSURANCE");
        array_image.add(R.drawable.new_buglary);
        array_head.add("BURGLARY INSURANCE");



    }

}