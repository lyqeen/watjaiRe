/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author User
 */
public class Doctor {
      private String docPrefix;
    private String docFname;
    private String docLname;
    private String docTel;
    private String docId;  //DO1708001

    public Doctor() {
    }

    public Doctor(String docPrefix, String docFname, String docLname, String docTel, String docId) {
        this.docPrefix = docPrefix;
        this.docFname = docFname;
        this.docLname = docLname;
        this.docTel = docTel;
        this.docId = docId;
    }

    
    
    
    public String getDocPrefix() {
        return docPrefix;
    }

    public void setDocPrefix(String docPrefix) {
        this.docPrefix = docPrefix;
    }

    public String getDocFname() {
        return docFname;
    }

    public void setDocFname(String docFname) {
        this.docFname = docFname;
    }

    public String getDocLname() {
        return docLname;
    }

    public void setDocLname(String docLname) {
        this.docLname = docLname;
    }

    public String getDocTel() {
        return docTel;
    }

    public void setDocTel(String docTel) {
        this.docTel = docTel;
    }

    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId;
    }
    
    
    static public Doctor showDoctorDetail(String doctorId) {
        Doctor dr = null;

        try {
            URL oracle = new URL("http://139.59.98.254:3000/doctors/" + doctorId); // URL to Parse
            URLConnection yc = oracle.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream(), "UTF-8"));

            String inputLine;
            while ((inputLine = in.readLine()) != null) {

                JSONParser parser = new JSONParser();
                Object obj = parser.parse(inputLine);
                JSONArray a = new JSONArray();
                a.add(obj);

                // Loop through each item
                for (Object o : a) {
                    JSONObject tutorials = (JSONObject) o;

                    dr = new Doctor();
                    String prefix = (String) tutorials.get("docTitle");
                    dr.setDocPrefix(prefix);
                    //System.out.println(prefix);
                    
                    String name = (String) tutorials.get("docFirstName");
                    dr.setDocFname(name);

                    String lastname = (String) tutorials.get("docLastName");
                    dr.setDocLname(lastname);
                    
                    String tel = (String) tutorials.get("docTel");
                    dr.setDocTel(tel);
                    
                    dr.setDocId(doctorId);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dr;
    }
 
    
    
    public static boolean validate(String user,String userpass){
        boolean check = false;
        Doctor dr = null;
        dr = Doctor.showDoctorDetail(user);
        
        if(dr != null){
            String dr2 = dr.docTel;
            if(userpass.equals(dr2)){
                check = true;
            }
            
            
        }
        /*if(user.equals(showDoctorDetail(user).docId)){
           check = true;
        }*/
        return check;
    }
    
    public static void main(String[] args) {
        String use = "DO1708003"; //0812345678
        boolean s = false;
       
        boolean r = validate("DO1708001","0812345678");
       // System.out.println("docdetail : "+a);
        System.out.println("boolean : "+r);
    }
}
