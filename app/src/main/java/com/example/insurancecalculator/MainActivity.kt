package com.example.insurancecalculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    override fun onNothingSelected(parent: AdapterView<*>?) {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        Toast.makeText(this, "Position = ${spinnerAge.getItemAtPosition(position)}", Toast.LENGTH_SHORT).show()
        //getItemAtPosition is to get the value at the position


        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    //call back method
    //this two will execute
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Associate spiner to the main activity
        spinnerAge.onItemSelectedListener = this
        buttonCalculate.setOnClickListener{
            calculatePremium()
        }


    }

    private fun calculatePremium() {
        var premium: Int =0

        //position = index for an item selected by user
        val age: Int = spinnerAge.selectedItemPosition

        premium += when(age){
            0 -> 60
            1 -> 70
            2 -> 90
            3 -> 120
            4 -> 150
            else -> 150

        }
        //ID of a radiobutton checked by user
        val gender: Int = radioGroupButton.checkedRadioButtonId
        if(gender == R.id.radioButtonMale){

            premium += when(age){
                0 -> 0
                1 -> 50
                2 -> 100
                3 -> 150
                4 -> 200
                else -> 200
            }
        }else{

            premium += 0

        }

        //Boolean value
        val smoker:Boolean = checkBoxSmoker.isChecked
        if(smoker){
            premium += when(age){
                0 -> 0
                1 -> 100
                2 -> 150
                3 -> 200
                4 -> 250
                else -> 300
            }
        }

        textViewPremium.text = String.format("%s : %d", getString(R.string.premium),premium)


    }

     fun resetInput(){
        //TODO Clear all inputs and outputs

         textViewPremium.text = ""
         radioGroupButton.clearCheck()
         spinnerAge.setSelection(0)



    }
}
