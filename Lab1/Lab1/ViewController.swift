//
//  ViewController.swift
//  Lab1
//
//  Created by Jack Marty on 9/10/19.
//  Copyright © 2019 Jack Marty. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var artPic: UIImageView!
    
    @IBOutlet weak var pictureLabel: UILabel!
    
    @IBAction func choosePic(_ sender: UIButton) {
        if sender.tag == 1 {
            artPic.image=UIImage(named: "piano")
            pictureLabel.text = "Piano"
        }
        else if sender.tag == 2 {
            artPic.image=UIImage(named: "guitar")
            pictureLabel.text = "Guitar"
        }
        else if sender.tag == 3 {
            artPic.image=UIImage(named: "drums")
            pictureLabel.text = "Drums"
        }
    }
    @IBAction func resetController(_ sender: UIButton) {
        artPic.image=UIImage(named: "blank")
        pictureLabel.text = ""
    }
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }


}

