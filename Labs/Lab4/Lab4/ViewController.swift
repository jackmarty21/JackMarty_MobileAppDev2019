//
//  ViewController.swift
//  Lab4
//
//  Created by Jack Marty on 10/2/19.
//  Copyright © 2019 Jack Marty. All rights reserved.
//

import UIKit

class ViewController: UIViewController, UITextFieldDelegate {

    @IBOutlet weak var numCreditHours: UITextField!
    @IBOutlet weak var numClasses: UIStepper!
    @IBOutlet weak var averageCreditHour: UILabel!
    @IBOutlet weak var classText: UILabel!
    
    func textFieldShouldReturn(_ textField: UITextField) -> Bool {
        textField.resignFirstResponder()
        return true
    }
    

    @IBAction func updateClasses(_ sender: UIStepper) {
        if numClasses.value == 4 {
            classText.text = "4 Classes"
        } else {
            classText.text = String(format: "%.0f", numClasses.value) + " Classes"
        }
    }
    
    @IBAction func calculateAveraeg(_ sender: UIButton) {
        updateAverageHours()
    }
    func updateAverageHours() {
        var totalHours:Double
        var totalClasses:Double
        var averageHoursPerClass:Double
        
        if numCreditHours.text!.isEmpty {
            totalHours = 0
            numCreditHours.text = "0"
        } else {
            totalHours = Double(numCreditHours.text!)!
        }
        
        if numClasses.value > 0 {
            totalClasses = Double(numClasses.value)
        } else {
            totalClasses = 1
            let alert=UIAlertController(title: "Warning", message: "The number of classes must be greater than 0", preferredStyle: UIAlertController.Style.alert)
            let cancelAction=UIAlertAction(title: "Cancel", style:UIAlertAction.Style.cancel, handler: nil)
            alert.addAction(cancelAction)
            let okAction=UIAlertAction(title: "OK", style: UIAlertAction.Style.default, handler: {action in
                self.numClasses.value = 1
                self.classText.text? = "1 person"
            })
            alert.addAction(okAction)
            present(alert, animated: true, completion: nil)
        }
        
        
        
        averageHoursPerClass = totalHours / totalClasses
        
        averageCreditHour.text = String(format: "%.2f", averageHoursPerClass)
        
    }
    override func viewDidLoad() {
        numCreditHours.delegate=self
        
        let tap: UITapGestureRecognizer = UITapGestureRecognizer(target: self.view, action: #selector(UIView.endEditing))
        view.addGestureRecognizer(tap)
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }


}

