package com.leeper.jordan.rolodex.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.leeper.jordan.rolodex.R;
import com.leeper.jordan.rolodex.datasource.ContactDatabaseHelper;

/**
 * Created by jordan on 10/29/15.
 * This fragment exists to add new contacts to a users list of contacts.
 */
public class AddContactFragment extends Fragment {

    private ContactDatabaseHelper dbHelper;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        dbHelper = new ContactDatabaseHelper(getContext());
        View inflatedView = inflater.inflate(R.layout.add_contact, container, false);
        Button addContactButton = (Button) inflatedView.findViewById(R.id.createContact);
        final EditText firstName = (EditText) inflatedView.findViewById(R.id.firstNameText);
        final EditText lastName = (EditText) inflatedView.findViewById(R.id.lastNameText);

        addContactButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHelper.insertContact(firstName.getText().toString(), lastName.getText().toString());
            }
        });

        return inflatedView;

    }
}
