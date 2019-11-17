package com.example.android.android_me.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.android.android_me.R;


public class MainActivity extends AppCompatActivity implements MasterListFragment.OnImageClickListener {

    private int mHeadIndex = 0;
    private int mBodyIndex = 0;
    private int mLegIndex = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onImageSelected(int position) {
        // Toast.makeText(this, "Position clicked: " + position, Toast.LENGTH_SHORT).show();
        int bodyPartNumber = position / 12;

        int listIndex = position - 12 * bodyPartNumber;


        switch (bodyPartNumber) {
            case 0:
                mHeadIndex = listIndex;
                break;
            case 1:
                mBodyIndex = listIndex;
                break;
            case 2:
                mLegIndex = mLegIndex;
                break;
            default:
                break;
        }

        Bundle bundle = new Bundle();

        bundle.putInt("headIndex", mHeadIndex);
        bundle.putInt("bodyIndex", mBodyIndex);
        bundle.putInt("legIndex", mLegIndex);

        final Intent intent = new Intent(this, AndroidMeActivity.class);
        intent.putExtras(bundle);

        Button button = (Button) findViewById(R.id.next_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
    }
}
