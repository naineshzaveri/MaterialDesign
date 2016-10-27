package design.material.nainesh.materialdesigncomponents.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ExpandableListView;

import java.util.ArrayList;

import design.material.nainesh.materialdesigncomponents.R;
import design.material.nainesh.materialdesigncomponents.adapter.MainActivityAdapter;
import design.material.nainesh.materialdesigncomponents.models.ChildModel;
import design.material.nainesh.materialdesigncomponents.models.GroupModel;
import design.material.nainesh.materialdesigncomponents.utils.Dialogs;
import design.material.nainesh.materialdesigncomponents.utils.HeaderConstants;

public class MainActivity extends AppCompatActivity {

    ArrayList<GroupModel> listDataHeader;
    private String[] groups = {"ButtonsActivity", "Bottom Sheets", "Cards", "Chips", "Dialogs", "Menus","Progress",
            "RatingBar","Selection controls", "SnackBar","Co-ordinate layout"};

    private String[][] children = {
            {"Raised Button", "Flat Button", "Floating Action Button"},// buttons
            {
                    // bottom sheets
            },
            {
                    //cards
            },
            {
                    // chips
            },
            {
                    "Alerts", "Confirmation dialogs", "Full Screen dialogs" // dialogs
            },
            {
                    // Menus
            },
            {
                    // PROGRESS
            },
            {
                    // RATING
            },
            {
                    "Checkbox", "Radio Button", "Switch" // selection controls
            },
            {
                    // Snackbar
            },
            {
                    // co-ordinate layout
            }


    };
    private ExpandableListView mExpandableListView;
    private MainActivityAdapter mainActivityAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        prepareListData();
        /*set adapter to list view*/
        mainActivityAdapter = new MainActivityAdapter(this, listDataHeader);
        mExpandableListView.setAdapter(mainActivityAdapter);

        mExpandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {

                showNextActivity(groupPosition, -1);
            }
        });

        mExpandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                showNextActivity(groupPosition, childPosition);
                return false;
            }
        });
    }

    private void init() {
        mExpandableListView = (ExpandableListView) findViewById(R.id.expandablelist);
    }

    private void prepareListData() {
        listDataHeader = new ArrayList<>();

        for (int i = 0; i < groups.length; i++) {
            ArrayList<ChildModel> arrchChildModels = new ArrayList<>();
            ChildModel chilChildModel;
            for (int j = 0; j < children[i].length; j++) {

                chilChildModel = new ChildModel(j, children[i][j]);
                arrchChildModels.add(chilChildModel);
            }
            GroupModel groupModel = new GroupModel(i, groups[i], arrchChildModels);
            listDataHeader.add(groupModel);
        }

    }

    private void showNextActivity(int groupPosition, int childPosition) {
        Intent intent = null;
        switch (groupPosition) {
            case HeaderConstants.GROUPHEADERS.BUTTONS:
                intent = new Intent(MainActivity.this, ButtonsActivity.class);
                break;
            case HeaderConstants.GROUPHEADERS.BOTTOM_SHEETS:
                intent = new Intent(MainActivity.this, BottomSheetsActivity.class);
                break;
            case HeaderConstants.GROUPHEADERS.CARDS:
                intent = new Intent(MainActivity.this, CardViewActivity.class);
                break;
            case HeaderConstants.GROUPHEADERS.DIALOG:
                switch (childPosition) {
                    case 0:
                        new Dialogs(this).showAlertDialog();
                        break;
                    case 1:
                        new Dialogs(this).showConfirmationDialog();
                        break;
                    case 2:
                }
            case HeaderConstants.GROUPHEADERS.MENU:
                intent = new Intent(MainActivity.this, MenuActivity.class);
                break;
            case HeaderConstants.GROUPHEADERS.PROGRESS:

                intent = new Intent(MainActivity.this, ProgressBarActivity.class);
                break;
            case HeaderConstants.GROUPHEADERS.RATING:

                intent = new Intent(MainActivity.this, RatingBarActivity.class);
                break;
            case HeaderConstants.GROUPHEADERS.SELECTION_CONTROL:

                intent = new Intent(MainActivity.this, SelectionControlActivity.class);
                break;
            case HeaderConstants.GROUPHEADERS.SNACKBAR:

                intent = new Intent(MainActivity.this, SnackBarActivity.class);
                break;
            case HeaderConstants.GROUPHEADERS.CO_ORDINATE_LAYOUT:
                intent = new Intent(MainActivity.this, CoOrdinateLayoutActivity.class);
                break;

        }
        if (intent != null)
            startActivity(intent);

    }
}
