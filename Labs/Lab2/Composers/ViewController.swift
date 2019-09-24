//
//  ViewController.swift
//  Composers
//
//  Created by Jack Marty on 9/23/19.
//  Copyright © 2019 Jack Marty. All rights reserved.
//

import UIKit

class ViewController: UIViewController {


    @IBOutlet weak var imagePic: UIImageView!
    @IBOutlet weak var textCtrl: UILabel!
    @IBOutlet weak var segValue: UISegmentedControl!
    @IBOutlet weak var sliderLabel: UILabel!
    @IBOutlet weak var sliderValue: UISlider!
    @IBOutlet weak var switchCtrl: UISwitch!
    @IBOutlet weak var fontChange: UISegmentedControl!
    
    
    @IBAction func changeFont(_ sender: UISegmentedControl) {
        let fontSize=sliderValue.value
        let fontSizeCGFloat=CGFloat(fontSize)
        if fontChange.selectedSegmentIndex == 0 {
            textCtrl.font = UIFont.init(name: "Helvetica Neue", size: fontSizeCGFloat)
        }
        else if fontChange.selectedSegmentIndex == 1 {
            textCtrl.font = UIFont.init(name: "Noteworthy", size: fontSizeCGFloat)
        }
        else if fontChange.selectedSegmentIndex == 2 {
            textCtrl.font = UIFont.init(name: "Snell Roundhand", size: fontSizeCGFloat)
        }
    }
    
    @IBAction func capitalizeFont(_ sender: UISwitch) {
        if switchCtrl.isOn {
            textCtrl.text=textCtrl.text?.uppercased()
        } else {
            textCtrl.text=textCtrl.text?.lowercased()
        }
    }
    
    @IBAction func changeTextSize(_ sender: UISlider) {
        let fontSize=sender.value
        sliderLabel.text=String(format: "%.0f", fontSize)
        let fontSizeCGFloat=CGFloat(fontSize)
        
        if fontChange.selectedSegmentIndex == 0 {
            textCtrl.font = UIFont.init(name: "Helvetica Neue", size: fontSizeCGFloat)
        }
        else if fontChange.selectedSegmentIndex == 1 {
            textCtrl.font = UIFont.init(name: "Noteworthy", size: fontSizeCGFloat)
        }
        else if fontChange.selectedSegmentIndex == 2 {
            textCtrl.font = UIFont.init(name: "Snell Roundhand", size: fontSizeCGFloat)
        }
    }
    
    @IBAction func setCtrl(_ sender: UISegmentedControl) {
        if segValue.selectedSegmentIndex == 0 {
            imagePic.image = UIImage(named: "mozart")
            textCtrl.text = "mozart"
            if switchCtrl.isOn {
                textCtrl.text=textCtrl.text?.uppercased()
            } else {
                textCtrl.text=textCtrl.text?.lowercased()
            }
        }
        else if segValue.selectedSegmentIndex == 1 {
            imagePic.image = UIImage(named: "beethoven")
            textCtrl.text = "beethoven"
            if switchCtrl.isOn {
                textCtrl.text=textCtrl.text?.uppercased()
            } else {
                textCtrl.text=textCtrl.text?.lowercased()
            }
        }
    }
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }


}

