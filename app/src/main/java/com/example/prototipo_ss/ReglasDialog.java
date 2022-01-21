package com.example.prototipo_ss;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

public class ReglasDialog extends AppCompatDialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder =  new AlertDialog.Builder(getActivity());
        builder.setTitle("Regals Importantes");
        String messageText = "Regla 1. Lorem  ipsum  dolor sit  amet,  consectetur adipisicing  elit, sed  do eiusmod tempor incididunt  ut labore  et dolore magna aliqua. Ut  enim  ad  minim  veniam, quis  nostrud exercitation  ullamco laboris  nisi  ut  aliquip  ex  ea  commodo  consequat.  Duis  aute irure dolor  in  reprehenderit  in  voluptate  velit  esse  cillum  dolore eu fugiat nulla pariatur. Excepteur  sint  occaecat cupidatat non  proident, sunt  in  culpa qui  officia deserunt  mollit anim id  est  laborum.   "+
                            "\n\nRegla 2. Lorem  ipsum  dolor sit  amet,  consectetur adipisicing  elit, sed  do eiusmod tempor incididunt  ut labore  et dolore magna aliqua. Ut  enim  ad  minim  veniam, quis  nostrud exercitation  ullamco laboris  nisi  ut  aliquip  ex  ea  commodo  consequat.  Duis  aute irure dolor  in  reprehenderit  in  voluptate  velit  esse  cillum  dolore eu fugiat nulla pariatur. Excepteur  sint  occaecat cupidatat non  proident, sunt  in  culpa qui  officia deserunt  mollit anim id  est  laborum."+
                            "\n\nRegla 3. Lorem  ipsum  dolor sit  amet,  consectetur adipisicing  elit, sed  do eiusmod tempor incididunt  ut labore  et dolore magna aliqua. Ut  enim  ad  minim  veniam, quis  nostrud exercitation  ullamco laboris  nisi  ut  aliquip  ex  ea  commodo  consequat.  Duis  aute irure dolor  in  reprehenderit  in  voluptate  velit  esse  cillum  dolore eu fugiat nulla pariatur. Excepteur  sint  occaecat cupidatat non  proident, sunt  in  culpa qui  officia deserunt  mollit anim id  est  laborum."+
                            "\n\nRegla 4.";
        builder.setMessage(messageText);
               builder.setPositiveButton("Entendido", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
        return builder.create();
    }
}
