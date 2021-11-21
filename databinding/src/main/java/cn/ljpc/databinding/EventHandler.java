package cn.ljpc.databinding;

import android.content.Context;
import android.view.View;

import androidx.appcompat.app.AlertDialog;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class EventHandler {

    private Context context;

    public EventHandler(Context context) {
        this.context = context;
    }

    public void doLike(View view) {
        AlertDialog dialog = new MaterialAlertDialogBuilder(context)
                .setTitle("提示")
                .setMessage("喜欢吗?")
                .setPositiveButton("确认", (d, which) -> {
                })
                .create();
        dialog.show();
    }
}
