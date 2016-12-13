/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FYP.db;

import FYP.bean.DetectedObject;
import FYP.bean.ObjectPoint;
import java.util.Vector;

/**
 *
 * @author Yukimibota
 */
public class FYPDB {
    public void uploadPhotoData(Vector<DetectedObject> obs,Vector<ObjectPoint> pts) {
        System.out.println("-----------------------------------------------");
        for (int i=0; i<obs.size(); i++)
            System.out.println(obs.get(i));
        for (int i=0; i<pts.size(); i++)
            System.out.println(pts.get(i));
    }
}
