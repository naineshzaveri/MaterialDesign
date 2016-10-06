package design.material.nainesh.materialdesigncomponents.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

import design.material.nainesh.materialdesigncomponents.R;

/**
 * Created by nainesh on 25/09/16.
 */
public class Dialogs {
    Context context;
    public Dialogs(Context context){
        this.context = context;
    }

    public void showAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(context,R.style.MyDialogTheme);
        builder.setTitle(context.getString(R.string.dialog_title));
        builder.setMessage(context.getString(R.string.dialog_message));

        String positiveText = context.getString(android.R.string.ok);
        builder.setPositiveButton(positiveText,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // positive button logic
                    }
                });

        String negativeText = context.getString(android.R.string.cancel);
        builder.setNegativeButton(negativeText,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // negative button logic
                    }
                });

        AlertDialog dialog = builder.create();
        // display dialog
        dialog.show();
    }
    public void showConfirmationDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(R.string.dialog_title);

        //list of items
        String[] items = context.getResources().getStringArray(R.array.ringtones);
        builder.setSingleChoiceItems(items, 0,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // item selected logic
                    }
                });

        String positiveText = context.getString(android.R.string.ok);
        builder.setPositiveButton(positiveText,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // positive button logic
                    }
                });

        String negativeText = context.getString(android.R.string.cancel);
        builder.setNegativeButton(negativeText,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // negative button logic
                    }
                });

        AlertDialog dialog = builder.create();
        // display dialog
        dialog.show();
    }
}
