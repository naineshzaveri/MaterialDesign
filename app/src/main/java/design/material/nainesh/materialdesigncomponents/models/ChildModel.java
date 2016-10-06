package design.material.nainesh.materialdesigncomponents.models;

/**
 * Created by nainesh on 21/09/16.
 */
public class ChildModel {

    private String childName;
    public int chiledId;

    public ChildModel(int chiledId, String childName) {
        super();
        this.chiledId = chiledId;
        this.childName = childName;
    }

    public String getChildName() {
        return childName;
    }

    public void setChildName(String childName) {
        this.childName = childName;
    }

    public int getChiledId() {
        return chiledId;
    }

    public void setChiledId(int chiledId) {
        this.chiledId = chiledId;
    }
}

