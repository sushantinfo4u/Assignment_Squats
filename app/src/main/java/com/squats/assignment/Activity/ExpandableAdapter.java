package com.squats.assignment.Activity;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.squats.assignment.Activity.API.Model.PostDetails;
import com.squats.assignment.R;
import java.util.HashMap;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ExpandableAdapter extends BaseExpandableListAdapter {

    private Context _context;
    private List<String> _listDataHeader;
    private HashMap<String, List<PostDetails>> _listDataChild;

    public ExpandableAdapter(Context context, List<String> listDataHeader,
                                 HashMap<String, List<PostDetails>> listChildData) {
        this._context = context;
        this._listDataHeader = listDataHeader;
        this._listDataChild = listChildData;
    }

    @Override
    public Object getChild(int groupPosition, int childPosititon) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition))
                .get(childPosititon);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {

        final PostDetails postDetail = (PostDetails) getChild(groupPosition, childPosition);

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_item, null);
        }

        TextView txtUserName = (TextView) convertView.findViewById(R.id.lblListItem);
        TextView txtDesc = (TextView) convertView.findViewById(R.id.txtDesc);
        CircleImageView profileImage =convertView.findViewById(R.id.imgeView);

        Glide.with(_context).load(postDetail.getImage_url())
                .thumbnail(0.5f)
                .error(R.drawable.image_not_available)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(profileImage);


         txtDesc.setText(postDetail.getDescription());
        txtUserName.setText(postDetail.getName());
        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this._listDataHeader.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return this._listDataHeader.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {

        String headerTitle = (String) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_group, null);
        }

        ImageView imageView=convertView.findViewById(R.id.imgGroupIndicator);

        if (isExpanded) {
            imageView.setImageResource(R.drawable.ic_drop_up);
        } else {
            imageView.setImageResource(R.drawable.ic_drop_down);
        }

        TextView lblListHeader = (TextView) convertView
                .findViewById(R.id.lblListHeader);

        lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setText(headerTitle);

        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

}
