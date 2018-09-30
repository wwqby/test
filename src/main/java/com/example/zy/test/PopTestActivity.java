package com.example.zy.test;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

public class PopTestActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "PopTestActivity";
    private View inflate;
    private TextView choosePhoto;
    private TextView takePhoto;
    private Dialog dialog;

    private Button mPopWindowBtn;
    private Button mPopMenuBtn;

    private View mPopWindowView;
    private PopupWindow mPopWindow;
    private PopupMenu mPopMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPopWindowBtn = (Button) findViewById(R.id.button4);
        mPopMenuBtn = (Button) findViewById(R.id.button3);



    }
    public void showDialog(View view){
        dialog = new Dialog(this,R.style.ActionSheetDialogStyle);
        //填充对话框的布局
        inflate = LayoutInflater.from(this).inflate(R.layout.dialog_layout, null);
        //初始化控件
        choosePhoto = (TextView) inflate.findViewById(R.id.choosePhoto);
        takePhoto = (TextView) inflate.findViewById(R.id.takePhoto);
        choosePhoto.setOnClickListener(this);
        takePhoto.setOnClickListener(this);
        //将布局设置给Dialog
        dialog.setContentView(inflate);
        //获取当前Activity所在的窗体
        Window dialogWindow = dialog.getWindow();
        //设置Dialog从窗体底部弹出
        dialogWindow.setGravity( Gravity.BOTTOM);
        //获得屏幕的实例
        Display d=getWindowManager().getDefaultDisplay();
        //获得窗体的属性
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        //设置Dialog距离底部的距离
        lp.y = 20;
//        设置diolog的宽度位屏幕宽度
        lp.width= WindowManager.LayoutParams.MATCH_PARENT;
//       将属性设置给窗体
        dialogWindow.setAttributes(lp);
        dialog.show();//显示对话框


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_popup_window, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId()){
            case R.id.action_settings:
                Toast.makeText(this,"setting clicked",Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_about:
                Toast.makeText(this,"about clicked",Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_out:
                Toast.makeText(this,"out clicked",Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

    public void popMenuBtnOnClick(View view) {
//新建一个popMenu实例
        mPopMenu = new PopupMenu(this, mPopMenuBtn);
//为这个实例的menu加载布局资源
        mPopMenu.getMenuInflater().inflate(R.menu.menu_popup_window, mPopMenu.getMenu());
        mPopMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_settings:
                        Log.i(TAG, "onMenuItemClick: setting");
                        break;
                    case R.id.action_about:
                        Log.i(TAG, "onMenuItemClick: about");
                        break;
                    case R.id.action_out:
                        Log.i(TAG, "onMenuItemClick: out");
                        break;
                }
                return true;
            }
        });
        mPopMenu.show();
    }

    public void popWindowBtnOnClick(View view) {
        mPopWindowView = getLayoutInflater().inflate(R.layout.dialog_layout, null);
// Focusable 为True，PopupWindow的点击事件才会相应
        mPopWindow = new PopupWindow(mPopWindowView, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT, true);
        TextView choosePhoto = (TextView) mPopWindowView.findViewById(R.id.choosePhoto);
        TextView takePhoto = (TextView) mPopWindowView.findViewById(R.id.takePhoto);
        choosePhoto.setOnClickListener(this);
        takePhoto.setOnClickListener(this);
        mPopWindow.showAsDropDown(mPopWindowBtn);
//        mPopWindow.setAnimationStyle(R.style.ActionSheetDialogAnimation);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.takePhoto:
                Toast.makeText(this,"点击了拍照",Toast.LENGTH_SHORT).show();
                Log.i(TAG, "onClick: v.getId="+view.getId());
                break;
            case R.id.choosePhoto:
                Toast.makeText(this,"点击了从相册选择",Toast.LENGTH_SHORT).show();
                Log.i(TAG, "onClick: v.getId="+view.getId());
                break;
        }

        if (dialog!=null){
            dialog.dismiss();
        }
        if (mPopWindow!=null){
            mPopWindow.dismiss();
        }
    }

    public void toMain2(View view) {
        Intent intent=new Intent(this,FragmentTestActivity.class);
        startActivity(intent);
    }
}
