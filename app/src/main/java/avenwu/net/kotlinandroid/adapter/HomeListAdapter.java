package avenwu.net.kotlinandroid.adapter;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import avenwu.net.kotlinandroid.R;
import avenwu.net.kotlinandroid.pojo.HomeListData;

/**
 * Created by chaobin on 7/1/15.
 */
public class HomeListAdapter extends RecyclerView.Adapter<HomeListAdapter.Holder> {

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
    float mWidth = 0;

    @Override
    public Holder onCreateViewHolder(ViewGroup viewGroup, int position) {
        View view = View.inflate(viewGroup.getContext(), R.layout.home_item, null);
        if (mWidth == 0) {
            final int outerMargin = viewGroup.getResources().getDimensionPixelSize(R.dimen.activity_horizontal_margin);
            mWidth = (viewGroup.getResources().getDisplayMetrics().widthPixels - outerMargin * 3) / 2.0f;
        }

        RecyclerView.LayoutParams params = new RecyclerView.LayoutParams((int) mWidth, (int) (1.29f * mWidth));
        final int margin = viewGroup.getResources().getDimensionPixelSize(R.dimen.item_margin);
        params.leftMargin = margin;
        params.rightMargin = margin;
        params.topMargin = margin;
        params.bottomMargin = margin;
        view.setLayoutParams(params);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        HomeListData.Data data = mData.get(position);
        holder.label.setText(data.title);
        holder.pic.setImageURI(Uri.parse(data.image));
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

    public void setData(List<HomeListData.Data> data) {
        mData = data;
    }

}
