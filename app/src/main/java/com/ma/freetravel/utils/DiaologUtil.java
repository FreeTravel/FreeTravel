package com.ma.freetravel.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ma.freetravel.R;

/**
 * @author :ZJF
 * @version : 2016-12-01 下午 5:20
 */

public class DiaologUtil {
    private static boolean canSave = true;
    private static AlertDialog dialog;
    private static DiaologUtil mUtil = new DiaologUtil();

    public static DiaologUtil init(Context context) {
        if (dialog == null) {
            dialog = new AlertDialog.Builder(context).create();
        }
        return mUtil;
    }

    public static DiaologUtil setCustonView(View view, final CallBack callBack) {
        dialog.setView(view);
        final TextInputLayout layout = (TextInputLayout) view.findViewById(R.id.textInputLayout);
        final EditText editText = (EditText) view.findViewById(R.id.dialog_edit);
        Button btnCancel = (Button) view.findViewById(R.id.dialog_cancel);
        Button btnSure = (Button) view.findViewById(R.id.dialog_sure);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() > 6) {
                    layout.setErrorEnabled(true);
                    layout.setError("昵称长度不能超过6个");
                    canSave = false;
                } else {
                    canSave = true;
                    layout.setErrorEnabled(false);
                }
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string = editText.getText().toString();
                callBack.onCancel(string);
                dialog.dismiss();
            }
        });
        btnSure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(canSave){
                    String string = editText.getText().toString();
                    callBack.onSure(string);
                    dialog.dismiss();
                }
            }
        });
        return mUtil;
    }

    public static void showDialog() {
        dialog.show();
    }


    public interface CallBack {
        void onCancel(String s);

        void onSure(String s);
    }
}
