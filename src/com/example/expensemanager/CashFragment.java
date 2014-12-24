package com.example.expensemanager;

import java.util.Calendar;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TimePicker;

public class CashFragment extends Fragment implements View.OnClickListener {

    private Button btnDisplay;
    // Variable for storing current date and time
    private int mYear, mMonth, mDay, mHour, mMinute;
    // Widget GUI
    Button btnCalendar, btnTimePicker;
    EditText txtDate, txtTime;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Get handles to the UI view objects
        View rootView = inflater.inflate(R.layout.fragment_cash, container, false);
        txtTime = (EditText) rootView.findViewById(R.id.txtTime);
        txtDate = (EditText) rootView.findViewById(R.id.txtDate);

        //Add onClick Listener
        this.txtTime.setOnClickListener(this);
        this.txtDate.setOnClickListener(this);

        return rootView;
    }

    @Override
    public void onClick(View view) {
        // Process to get Current Date
        final Calendar c = Calendar.getInstance();
        switch (view.getId()) {
            case R.id.radioCashIn:
                boolean checked1 = ((RadioButton) view).isChecked();
                if (checked1)
                    // Pirates are the best
                    break;
            case R.id.radioCashOut:
                boolean checked2 = ((RadioButton) view).isChecked();
                if (checked2)
                    // Ninjas rule
                    break;
            case R.id.txtDate:


                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);

                // Launch Date Picker Dialog
                DatePickerDialog dpd = new DatePickerDialog(getActivity(),
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // Display Selected date in textbox
                                txtDate.setText(dayOfMonth + "-"
                                        + (monthOfYear + 1) + "-" + year);

                            }
                        }, mYear, mMonth, mDay);
                dpd.show();
                break;
            case R.id.txtTime:
                // Process to get Current Time

                mHour = c.get(Calendar.HOUR_OF_DAY);
                mMinute = c.get(Calendar.MINUTE);

                // Launch Time Picker Dialog
                TimePickerDialog tpd = new TimePickerDialog(getActivity(),
                        new TimePickerDialog.OnTimeSetListener() {

                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay,
                                                  int minute) {
                                // Display Selected time in textbox
                                txtTime.setText(hourOfDay + ":" + minute);
                            }
                        }, mHour, mMinute, false);
                tpd.show();
                break;
        }
    }
}