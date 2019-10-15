//
//  ViewController.swift
//  midterm_1
//
//  Created by Jack Marty on 10/15/19.
//  Copyright © 2019 Jack Marty. All rights reserved.
//

import UIKit

class ViewController: UIViewController, UITextFieldDelegate {

    @IBOutlet weak var labelAmountofGas: UILabel!
    @IBOutlet weak var labelCommuteTime: UILabel!
    @IBOutlet weak var labelGasNeeded: UILabel!
    @IBOutlet weak var textfieldCommute: UITextField!
    @IBOutlet weak var stepperGallonsGas: UIStepper!
    @IBOutlet weak var switchMonthNeeds: UISwitch!
    @IBOutlet weak var segcontrolTrans: UISegmentedControl!
    @IBOutlet weak var imageTrans: UIImageView!
    
    var intMonthCommuteTime : Int = 0
    var intMonthGasNeeds : Int = 0
    
    func textFieldShouldReturn(_ textField: UITextField) -> Bool {
        textField.resignFirstResponder()
        return true
    }
    
    @IBAction func stepperChangeGasLabel(_ sender: UIStepper) {
        labelAmountofGas.text = String(Int(sender.value)) + " Gallons of Gas"
    }
    
    @IBAction func segcontrolChjangeImage(_ sender: UISegmentedControl) {
        if sender.selectedSegmentIndex == 0 {
            imageTrans.image=UIImage(named: "car_icon")
        }
        if sender.selectedSegmentIndex == 1 {
            imageTrans.image=UIImage(named: "bike_icon")
        }
        if sender.selectedSegmentIndex == 2 {
            imageTrans.image=UIImage(named: "bus_icon")
        }
    }
    @IBAction func buttonCalcTimeGas(_ sender: UIButton) {
        
        if Int(textfieldCommute.text!)! > 50 {
            let alert=UIAlertController(title: "Warning", message: "The amount of commute miles is greater than 50!", preferredStyle: UIAlertController.Style.alert)
            let cancelAction=UIAlertAction(title: "Cancel", style:UIAlertAction.Style.cancel, handler: nil)
            alert.addAction(cancelAction) //adds the alert action to the alert object
            let okAction=UIAlertAction(title: "OK", style: UIAlertAction.Style.default, handler: {action in
            })
            alert.addAction(okAction)
            present(alert, animated: true, completion: nil)
        } else {
            if segcontrolTrans.selectedSegmentIndex == 0 {
                //Calculate Month
                if switchMonthNeeds.isOn {
                    labelCommuteTime.text = String(format: "%.1f", Float(textfieldCommute.text!)! / 20 * 20) + " Hours"
                    labelGasNeeded.text = String(format: "%.1f", Float(textfieldCommute.text!)! / 24 * 20) + " Gallons of Gas"
                } else {
                    labelCommuteTime.text = String(format: "%.1f", Float(textfieldCommute.text!)! / 20) + " Hours"
                    labelGasNeeded.text = String(format: "%.1f", Float(textfieldCommute.text!)! / 24) + " Gallons of Gas"
                }
            }
            //Bike
            if segcontrolTrans.selectedSegmentIndex == 1 {
                //Calculate Month
                if switchMonthNeeds.isOn {
                    labelCommuteTime.text = String(format: "%.1f", Float(textfieldCommute.text!)! / 10 * 20) + " Hours"
                    labelGasNeeded.text = "0 Gallons of Gas"
                } else {
                    labelCommuteTime.text = String(format: "%.1f", Float(textfieldCommute.text!)! / 10) + " Hours"
                    labelGasNeeded.text = "0 Gallons of Gas"
                }
            }
            //Bus
            if segcontrolTrans.selectedSegmentIndex == 2 {
                //Calculate Month
                if switchMonthNeeds.isOn {
                    labelCommuteTime.text = String(format: "%.1f", (Float(textfieldCommute.text!)! / 12 + 10) * 20) + " Hours"
                    labelGasNeeded.text = "0 Gallons of Gas"
                } else {
                    labelCommuteTime.text = String(format: "%.1f", Float(textfieldCommute.text!)! / 12 + 10) + " Hours"
                    labelGasNeeded.text = "0 Gallons of Gas"
                }
            }
        }
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        textfieldCommute.delegate = self
    }


}

