package design.material.nainesh.materialdesigncomponents.models;

import java.util.ArrayList;

/**
 * Created by nainesh on 21/09/16.
 */
public class GroupModel {

    public int groupId;
    public String groupName;
    public ArrayList<ChildModel> childrens;

    public GroupModel(int groupId, String groupName,
                 ArrayList<ChildModel> childrens) {
        super();
        this.groupId = groupId;
        this.groupName = groupName;
        this.childrens = childrens;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public ArrayList<ChildModel> getChildrens() {
        return childrens;
    }

    public void setChildrens(ArrayList<ChildModel> childrens) {
        this.childrens = childrens;
    }
}
