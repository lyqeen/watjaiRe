/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author User
 */
public class Patient {
      private String Fname;
    private String Lname;
    private String PatId;
    private String underlyingDisease;
    private int birthdate;
    private String address;
    private String subDistrict;
    private String district;
    private String province;
    private String patTel;
    private String bloodType;
    private String docId;
    private String status;
    private String idMea;
    private String sex;

    public Patient() {
    }

    public Patient(String Fname, String Lname, String PatId, String underlyingDisease, int birthdate, String address, String subDistrict, String district, String province, String patTel, String bloodType, String docId, String status, String idMea, String sex) {
        this.Fname = Fname;
        this.Lname = Lname;
        this.PatId = PatId;
        this.underlyingDisease = underlyingDisease;
        this.birthdate = birthdate;
        this.address = address;
        this.subDistrict = subDistrict;
        this.district = district;
        this.province = province;
        this.patTel = patTel;
        this.bloodType = bloodType;
        this.docId = docId;
        this.status = status;
        this.idMea = idMea;
        this.sex = sex;
    }

    

    public String getFname() {
        return Fname;
    }

    public void setFname(String Fname) {
        this.Fname = Fname;
    }

    public String getLname() {
        return Lname;
    }

    public void setLname(String Lname) {
        this.Lname = Lname;
    }

    public String getPatId() {
        return PatId;
    }

    public void setPatId(String PatId) {
        this.PatId = PatId;
    }

    public String getUnderlyingDisease() {
        return underlyingDisease;
    }

    public void setUnderlyingDisease(String underlyingDisease) {
        this.underlyingDisease = underlyingDisease;
    }

    public int getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(int birthdate) {
        this.birthdate = birthdate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSubDistrict() {
        return subDistrict;
    }

    public void setSubDistrict(String subDistrict) {
        this.subDistrict = subDistrict;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getPatTel() {
        return patTel;
    }

    public void setPatTel(String patTel) {
        this.patTel = patTel;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIdMea() {
        return idMea;
    }

    public void setIdMea(String idMea) {
        this.idMea = idMea;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
    
    
    
    

    public static void sendDataPatient(Patient p) throws IOException {

        //String a = p.getFname();
        HttpClient httpClient = HttpClientBuilder.create().build(); //Use this instead 

        HttpPost request = new HttpPost("http://139.59.98.254:3000/patients");

        StringEntity params
                = new StringEntity(("{\"patFirstName\":\"" + p.getFname() + "\","
                        + "\"patLastName\":\"" + p.getLname() + "\","
                        + "\"birthDay\":\"" + p.getBirthdate() + "\","
                        + "\"address\":\"" + p.getAddress() + "\","
                        + "\"subDistrict\":\"" + p.getSubDistrict() + "\","
                        + "\"district\":\"บางมด\","
                        + "\"province\":\"กรุงเทพมหานคร\","
                        + "\"patTel\":\"0858388229\","
                        + "\"bloodType\":\"O\","
                        + "\"docId\":\"DO1708001\","
                        + "\"underlyingDisease\":\"ภูมิแพ้ หืดหอบ\","
                        + "\"relativeName\":\"ภูมิแพ้ หืดหอบ\","
                        + "\"relativeTel\":\"ภูมิแพ้ หืดหอบ\","
                        + "\"patPic\":\"SLKDJFSI\"}"),
                        "UTF-8");

        request.setEntity(params);
        HttpResponse response = httpClient.execute(request);

        System.out.println(response);

    }

    static public List<Patient> doReadPatientName() {
        List<Patient> patlist = null;
         JSONParser parser = new JSONParser();
        Patient pat = null;

        try {
            URL oracle = new URL("http://139.59.98.254:3000/patients"); // URL to Parse
            URLConnection yc = oracle.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream(), "UTF-8"));

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                JSONArray a = (JSONArray) parser.parse(inputLine);
                if(patlist==null){
                    patlist=new ArrayList<>();
                }
                // Loop through each item
                for (Object o : a) {
                    JSONObject tut = (JSONObject) o;
                    pat = new Patient();
                    String id = (String) tut.get("patId");
               
                    pat.setPatId(id);

                    String name = (String) tut.get("patFirstName");
                 
                    pat.setFname(name);

                    String lastname = (String) tut.get("patLastName");
                 
                    pat.setLname(lastname);
                    
                    String disease = (String) tut.get("underlyingDisease");
                 
                    pat.setUnderlyingDisease(disease);
                    
                    String check = pat.checkStatus(id);
                    pat.setStatus(check);
                    patlist.add(pat);
                        

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return patlist;
    }
    
       public String checkStatus(String idP) {
        String state = "ปกติ";

        List<Patient> paList = doReadDiaPatient();
        for (int i = 0; i < paList.size(); i++) {
            String ch = paList.get(i).PatId;
            if (idP.equals(ch)) {
                state = "รอการวินิจฉัย";
            }
        }

        return state;
    }
    
    
    

    static public Patient showInfo(String patId) {
        Patient p = null;

        try {
            URL oracle = new URL("http://139.59.98.254:3000/doctors/DO1803001/showpatients/" + patId); // URL to Parse
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

                    p = new Patient();
                    String id = (String) tutorials.get("patId");
                    p.setPatId(id);
                    //System.out.println(id);

                    String name = (String) tutorials.get("patFirstName");
                    p.setFname(name);

                    String lastname = (String) tutorials.get("patLastName");
                    p.setLname(lastname);

                    String disease = (String) tutorials.get("underlyingDisease");
                    p.setUnderlyingDisease(disease);

                    String bd = (String) tutorials.get("birthDay");
                    int newBd = p.calAge(bd);
                    p.setBirthdate(newBd);
                    //System.out.println(bd);

                    String address = (String) tutorials.get("address");
                    p.setAddress(address);

                    String subDis = (String) tutorials.get("subDistrict");
                    p.setSubDistrict(subDis);

                    String dis = (String) tutorials.get("district");
                    p.setDistrict(dis);

                    String prov = (String) tutorials.get("province");
                    p.setProvince(prov);

                    String blood = (String) tutorials.get("bloodType");
                    p.setBloodType(blood);

                    String tel = (String) tutorials.get("patTel");
                   // System.out.println("tel patietn:"+tel);
                    p.setPatTel(tel);
                    
                    String sex = (String) tutorials.get("sex");
                    p.setSex(sex);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return p;
    }

    private int calAge(String dateTimes) { //1996-02-03  T00:00:00.000Z

        String newDate = dateTimes.substring(0, 10);
        LocalDate dob = LocalDate.parse(newDate);
        LocalDate curDate = LocalDate.now();
        //System.out.println("Age is:" + Period.between(dob, curDate).getYears());

        return Period.between(dob, curDate).getYears();

    }

    static public List<Patient> doReadDiaPatient() {
        List<Patient> patlist = null;
        JSONParser parser = new JSONParser();
        Patient pat = null;

        try {
            URL oracle = new URL("http://139.59.98.254:3000/watjaimeasure/showabnormal"); // URL to Parse
            URLConnection yc = oracle.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream(), "UTF-8"));

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
//                System.out.println(inputLine);
                JSONArray a = (JSONArray) parser.parse(inputLine);
                if (patlist == null) {
                    patlist = new ArrayList<>();
                }
                // Loop through each item
                for (Object o : a) {
                    JSONObject tut = (JSONObject) o;
                    pat = new Patient();

                    String id = (String) tut.get("patId");
                    System.out.println(id);
                    pat.setPatId(id);

                    String mea = (String) tut.get("measuringId");
                    pat.setIdMea(mea);

                    String name = showInfo(id).Fname;
                    pat.setFname(name);

                    String lastname = showInfo(id).Lname;
                    pat.setLname(lastname);

                    String underly = showInfo(id).underlyingDisease;
                    pat.setUnderlyingDisease(underly);
                    patlist.add(pat);

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return patlist;
    }

 

    public static void main(String[] args) {
        Patient p = new Patient();
        //p=Patient.showInfo("PA1709001");
        //String dt = "1995-12-19T00:00:00.000Z";
        //System.out.println("pastm : " + p.calAge(dt));
        //String a = showInfo("PA1709001").Fname;
        List<Patient> patlist = new ArrayList<>();
        patlist= doReadDiaPatient();
        System.out.println(patlist);
                
        //p.doReadPatientName();
        
                

    }
}
