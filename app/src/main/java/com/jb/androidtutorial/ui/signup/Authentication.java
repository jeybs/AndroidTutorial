package com.jb.androidtutorial.ui.signup;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.EditText;

import com.jb.androidtutorial.R;
import com.jb.androidtutorial.data.source.local.UserData;
import com.jb.androidtutorial.data.source.local.UserDataSourceHelper;
import com.jb.androidtutorial.dialogs.CustomDialog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class Authentication extends AppCompatActivity {

    private Activity activity;
    private CustomDialog customDialog;
    private UserDataSourceHelper userDataSource;

    @BindView(R.id.edit_username)
    EditText editUsername;

    @BindView(R.id.edit_password)
    EditText editPassword;

    @OnClick(R.id.button_register)
    public void  register() {
        String username = editUsername.getText().toString();
        String password = editPassword.getText().toString();

        if(TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
            customDialog.showBasicDialog(
                    activity.getString(R.string.text_dialog_warning),
                    activity.getString(R.string.text_dialog_message_incomplete));
            return;
        }

        // Check
        boolean isExist = userDataSource.checkUsername(username);
        if(isExist) {
            customDialog.showBasicDialog(
                    activity.getString(R.string.text_dialog_warning),
                    activity.getString(R.string.text_dialog_message_exist));
            return;
        }

        // Insert
        boolean isSuccess = userDataSource.saveUsername(username, password);

        if(isSuccess) {
            customDialog.showBasicDialog(
                    activity.getString(R.string.text_dialog_warning),
                    activity.getString(R.string.text_dialog_message_insert_success));

            editUsername.getText().clear();
            editPassword.getText().clear();
        } else {
            customDialog.showBasicDialog(
                    activity.getString(R.string.text_dialog_warning),
                    activity.getString(R.string.text_dialog_message_insert_failed));
        }
    }

    @OnClick(R.id.button_login)
    public void login() {
        String username = editUsername.getText().toString();
        String password = editPassword.getText().toString();

        if(TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
            customDialog.showBasicDialog(
                    activity.getString(R.string.text_dialog_warning),
                    activity.getString(R.string.text_dialog_message_incomplete));
            return;
        }

        UserData user = userDataSource.login(username, password);

        if(user != null) {
            customDialog.showBasicDialog(
                    activity.getString(R.string.text_dialog_warning),
                    activity.getString(R.string.text_dialog_login_success, user.getUsername()));
        } else {
            customDialog.showBasicDialog(
                    activity.getString(R.string.text_dialog_warning),
                    activity.getString(R.string.text_dialog_login_failed));
        }

    }

    /**
     * Provide intent to start this activity
     * @return
     */
    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, Authentication.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        ButterKnife.bind(this);

        activity = this;

        customDialog = new CustomDialog(activity);
        userDataSource = new UserDataSourceHelper(activity);

    }
}
