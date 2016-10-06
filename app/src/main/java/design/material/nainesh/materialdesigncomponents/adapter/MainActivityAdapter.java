package design.material.nainesh.materialdesigncomponents.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import design.material.nainesh.materialdesigncomponents.R;
import design.material.nainesh.materialdesigncomponents.models.ChildModel;
import design.material.nainesh.materialdesigncomponents.models.GroupModel;

/**
 * Created by nainesh on 21/09/16.
 */
public class MainActivityAdapter extends BaseExpandableListAdapter {
    LayoutInflater inflater;

    /*list of group */
    private ArrayList<GroupModel> groups;
    public MainActivityAdapter(Context context, ArrayList<GroupModel> groups) {
        super();
        this.groups=groups;
        inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    /**
     * @param child
     * @param group
     *  use for adding item to list view
     */
    public void addItem(ChildModel child, GroupModel group) {
        if(!groups.contains(group)) {
            groups.add(group);
        }
        int index=groups.indexOf(group);
        ArrayList<ChildModel> ch=groups.get(index).getChildrens();
        ch.add(child);
        groups.get(index).setChildrens(ch);
    }
    public ChildModel getChild(int groupPosition, int childPosition) {
        ArrayList<ChildModel> ch=groups.get(groupPosition).getChildrens();
        return ch.get(childPosition);
    }
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }
    @Override
    public int getChildrenCount(int groupPosition) {
        ArrayList<ChildModel> ch=groups.get(groupPosition).getChildrens();
        return ch.size();
    }
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild,
                             View convertView, ViewGroup parent) {
        ChildModel child= (ChildModel) getChild(groupPosition,childPosition);
        TextView childName=null;
        if(convertView==null) {
            convertView=inflater.inflate(R.layout.row_child, null);
        }
        childName=(TextView) convertView.findViewById(R.id.textViewChildName);
        childName.setText(child.getChildName());
        return convertView;
    }
    public GroupModel getGroup(int groupPosition) {
        return groups.get(groupPosition);
    }
    public int getGroupCount() {
        return groups.size();
    }
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView,
                             ViewGroup parent) {
        TextView groupName = null;
        GroupModel group=(GroupModel) getGroup(groupPosition);
        if(convertView==null) {
            convertView=inflater.inflate(R.layout.row_group, null);
        }
        groupName=(TextView) convertView.findViewById(R.id.textViewGroupName);
        groupName.setText(group.getGroupName());
        return convertView;
    }
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
    public boolean hasStableIds() {
        return true;
    }
}
