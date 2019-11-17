/*
* Copyright (C) 2017 The Android Open Source Project
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*  	http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package com.example.android.android_me.ui;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

// This activity will display a custom Android image composed of three body parts: head, body, and legs
public class AndroidMeActivity extends AppCompatActivity {
    private BodyPartFragment mHeadFragment;
    private BodyPartFragment mBodyFragment;
    private BodyPartFragment mLegFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_me);
        if (savedInstanceState == null){
            // Add the fragment to its container using a FragmentManager and a Transaction
            FragmentManager fragmentManager = getSupportFragmentManager();

            // Create a new head BodyPartFragment
            mHeadFragment = new BodyPartFragment();
            // Set the list of image id's for the head fragment and set the position to the second image in the list
            mHeadFragment.setImageIds(AndroidImageAssets.getHeads());
            mHeadFragment.setListIndex(getIntent().getIntExtra("headIndex", 0));


            fragmentManager.beginTransaction()
                    .add(R.id.head_container, mHeadFragment)
                    .commit();

            // Create and display the body and leg BodyPartFragments

            mBodyFragment = new BodyPartFragment();
            mBodyFragment.setImageIds(AndroidImageAssets.getBodies());
            mBodyFragment.setListIndex(getIntent().getIntExtra("bodyIndex", 0));
            fragmentManager.beginTransaction()
                    .add(R.id.body_container, mBodyFragment)
                    .commit();

            mLegFragment = new BodyPartFragment();
            mLegFragment.setImageIds(AndroidImageAssets.getLegs());
            mLegFragment.setListIndex(getIntent().getIntExtra("legIndex", 0));
            fragmentManager.beginTransaction()
                    .add(R.id.leg_container, mLegFragment)
                    .commit();
        }
    }
}
