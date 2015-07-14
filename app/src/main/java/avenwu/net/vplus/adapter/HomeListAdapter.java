package avenwu.net.vplus.adapter;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import avenwu.net.vplus.view.DetailActivity;
import avenwu.net.vplus.R;
import avenwu.net.vplus.pojo.HomeListData;

/**
 * Created by chaobin on 7/1/15.
 */
public class HomeListAdapter extends RecyclerView.Adapter<HomeListAdapter.Holder> implements View.OnClickListener {

    public static class Holder extends RecyclerView.ViewHolder {
        public TextView label;
        public SimpleDraweeView pic;

        public Holder(View itemView) {
            super(itemView);
            label = (TextView) itemView.findViewById(R.id.tv_info);
            pic = (SimpleDraweeView) itemView.findViewById(R.id.iv_pic);
        }
    }

    List<HomeListData.Data> mData;
    int mWidth = 0;

    @Override
    public Holder onCreateViewHolder(ViewGroup viewGroup, int position) {
        View view = View.inflate(viewGroup.getContext(), R.layout.home_item, null);
        if (mWidth == 0) {
            final int outerMargin = viewGroup.getResources().getDimensionPixelSize(R.dimen.activity_horizontal_margin);
            mWidth = (int) ((viewGroup.getResources().getDisplayMetrics().widthPixels -
                    outerMargin * 3) / 2.0f);
        }
        view.setLayoutParams(new RecyclerView.LayoutParams(mWidth, (int) (1.29f * mWidth)));
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        HomeListData.Data data = mData.get(position);
        holder.label.setText(data.title);
        holder.pic.setImageURI(Uri.parse(data.image));
        holder.itemView.getLayoutParams().width = mWidth;
        float percent = 1;
        switch (position % 3) {
            case 0:
                percent = 1.29f;
                break;
            case 1:
                percent = 1.20f;
                break;
            case 2:
                percent = 1.16f;
                break;
        }
        holder.itemView.getLayoutParams().height = (int) (percent * mWidth);
        holder.itemView.setTag(R.id.tv_info, encodeTag(data));
        holder.itemView.setOnClickListener(this);
    }

    private String encodeTag(HomeListData.Data data) {
        return data.title + ":" + data.postid;
    }

    private String[] decodeTag(String tag) {
        return tag.split(":");
    }

    @Override
    public void onClick(View v) {
        String[] info = decodeTag((String) v.getTag(R.id.tv_info));
        DetailActivity.launch(v.getContext(), info[0], info[1]);
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

    public void setData(List<HomeListData.Data> data) {
        mData = data;
    }

}
