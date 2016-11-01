package com.traffics_marster.ui.ada;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.traffics_marster.misc.utils.ContextUtils;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Litao-pc on 2016/6/15.
 */
public class CommonRecyclerAdapter<T> extends RecyclerView.Adapter<BaseHolder<T>> {
    private List<T> mDatas;
    private int mResLayout;
    private Class<? extends BaseHolder<T>> mClazz;


    public void setmDatas(List<T> mDatas) {
        this.mDatas = mDatas;
        notifyDataSetChanged();
    }

    public void addAll(List<T> mDatas) {
        this.mDatas.addAll(mDatas);
        notifyItemRangeInserted(this.mDatas.size() - mDatas.size(), this.mDatas.size());
    }

    public void add(T data) {
        this.mDatas.add(data);
        notifyItemInserted(this.mDatas.size() - 1);
    }

    public T getItem(int position) {
        try {
            return this.mDatas.get(position);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public HashMap<Integer, Object> tags = new HashMap<>();

    public CommonRecyclerAdapter setTag(int tag, Object mObject) {
        if (mObject != null) {
            tags.put(tag, mObject);
        }
        return this;
    }

    public CommonRecyclerAdapter(int mResLayout, Class<? extends BaseHolder<T>> mClazz) {
        if (mClazz == null) {
            throw new RuntimeException("clazz is null,please check your params !");
        }
        if (mResLayout == 0) {
            throw new RuntimeException("res is null,please check your params !");
        }

        this.mResLayout = mResLayout;
        this.mClazz = mClazz;

        if (mDatas == null) {
            this.mDatas = new ArrayList<>();
        }
    }

    public CommonRecyclerAdapter(List<T> mDatas, int mResLayout, Class<? extends BaseHolder<T>> mClazz) {
        this(mResLayout, mClazz);
        this.mDatas = mDatas;
    }

    private OnItemClickListener mOnItemClickListener;

    @Override
    public BaseHolder<T> onCreateViewHolder(ViewGroup parent, int viewType) {
        View view =
                ContextUtils.inflate(mResLayout);
        if (tags != null && tags.size() > 0) {
            for (int tag : tags.keySet()) {
                view.setTag(tag, tags.get(tag));
            }
        }
        try {
            Constructor<? extends BaseHolder<T>> mClazzConstructor = mClazz.getConstructor(View.class);
            if (mClazzConstructor != null) {

                return mClazzConstructor.newInstance(view);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void onBindViewHolder(final BaseHolder holder, final int position) {
        if (mOnItemClickListener != null) {
            holder.mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickListener.onItemClick(holder.itemView, position);
                }
            });
        }

        holder.setData(mDatas.get(position));
    }

    @Override
    public int getItemCount() {
        return 15;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }
}
