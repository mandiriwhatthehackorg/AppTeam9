package mandiri.com.carmob.ui.car.detail

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.layout_bottom_sheet.*
import mandiri.com.carmob.R
import mandiri.com.carmob.ui.order.OrderFinalActivity
import mandiri.com.carmob.ui.verification.VerificationActivity

class BottomSheetDialog : BottomSheetDialogFragment(), AdapterView.OnItemSelectedListener
{
    override fun onNothingSelected(p0: AdapterView<*>?) {

    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        if(spinPaymentMethod.selectedItem.equals("Kredit")) {
            layoutAdditional.visibility = View.VISIBLE
        }else {
            layoutAdditional.visibility = View.GONE
        }

        if(!spinAsuransi.selectedItem.equals("Pilih Asuransi")) {
            simulasiDP.visibility = View.VISIBLE
        }else {
            simulasiDP.visibility = View.GONE
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?):
            View =    inflater.inflate(R.layout.layout_bottom_sheet, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        // Create an ArrayAdapter
        val adapter = ArrayAdapter.createFromResource(context,
            R.array.payment_list, android.R.layout.simple_spinner_item)
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // Apply the adapter to the spinner
        spinPaymentMethod.adapter = adapter
        spinPaymentMethod.onItemSelectedListener = this

        // Create an ArrayAdapter
        val bankadapter = ArrayAdapter.createFromResource(context,
            R.array.bank_list, android.R.layout.simple_spinner_item)
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // Apply the adapter to the spinner
        spinBank.adapter = bankadapter

        val asuransiAdaper = ArrayAdapter.createFromResource(context,
            R.array.asuransi_list, android.R.layout.simple_spinner_item)
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // Apply the adapter to the spinner
        spinAsuransi.adapter = asuransiAdaper
        spinAsuransi.onItemSelectedListener = this

        val simulasiAdapter = ArrayAdapter.createFromResource(context,
            R.array.kredit_list, android.R.layout.simple_spinner_item)
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // Apply the adapter to the spinner
        spinSimulasi.adapter = simulasiAdapter

        btnPilih.setOnClickListener {
            if(spinPaymentMethod.selectedItem.equals("Cash")) {
                val orderFinalIntent = Intent(context, OrderFinalActivity::class.java)
                orderFinalIntent.putExtra("paymentType","Cash")
                startActivity(orderFinalIntent)
            }else if (spinPaymentMethod.selectedItem.equals("Kredit")) {
                val verificationIntent = Intent(context, VerificationActivity::class.java)
                startActivity(verificationIntent)
            }
        }
    }
}