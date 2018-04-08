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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
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
public class DataHealth {
     private String measureId;
    private String measureTime;
    private String patId;
    private ArrayList<Float> measureData;
    private String comment;
    private String abnormalDetail;

    public DataHealth() {
    }

    public DataHealth(String measureId, String measureTime, String patId, ArrayList<Float> measureData, String comment, String abnormalDetail) {
        this.measureId = measureId;
        this.measureTime = measureTime;
        this.patId = patId;
        this.measureData = measureData;
        this.comment = comment;
        this.abnormalDetail = abnormalDetail;
    }

    public String getMeasureId() {
        return measureId;
    }

    public void setMeasureId(String measureId) {
        this.measureId = measureId;
    }

    public String getMeasureTime() {
        return measureTime;
    }

    public void setMeasureTime(String measureTime) {
        this.measureTime = measureTime;
    }

    public String getPatId() {
        return patId;
    }

    public void setPatId(String patId) {
        this.patId = patId;
    }

    public ArrayList<Float> getMeasureData() {
        return measureData;
    }

    public void setMeasureData(ArrayList<Float> measureData) {
        this.measureData = measureData;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getAbnormalDetail() {
        return abnormalDetail;
    }

    public void setAbnormalDetail(String abnormalDetail) {
        this.abnormalDetail = abnormalDetail;
    }

    static public List<DataHealth> doReadListData(String patId) { //show List data each patient
        List<DataHealth> dhlist = null;
        JSONParser parser = new JSONParser();
        DataHealth dh = null;

        try {
            URL oracle = new URL("http://139.59.98.254:3000/patients/" + patId + "/allwatjai"); // URL to Parse
            URLConnection yc = oracle.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream(), "UTF-8"));

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                JSONArray a = (JSONArray) parser.parse(inputLine);
                if (dhlist == null) {
                    dhlist = new ArrayList<>();
                }
                // Loop through each item
                for (Object o : a) {
                    JSONObject tut = (JSONObject) o;
                    dh = new DataHealth();

                    String meaId = (String) tut.get("measuringId");
                    dh.setMeasureId(meaId);

                    String meaTime = (String) tut.get("measuringTime");
                    String newdt = dh.subStringDate(meaTime);
                    dh.setMeasureTime(newdt);

                    dhlist.add(dh);

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return dhlist;
    }

    static public DataHealth showData(String idmea) {//showGraph
        DataHealth dh = new DataHealth();
        JSONParser parser = new JSONParser();
        try {
            URL oracle = new URL("http://139.59.98.254:3000/watjainormal/" + idmea); // URL to Parse
            URLConnection yc = oracle.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                JSONArray a = (JSONArray) parser.parse(inputLine);

                // Loop through each item
                for (Object o : a) {
                    JSONObject tutorials = (JSONObject) o;
                    String meaId = (String) tutorials.get("measuringId");
                    dh.setMeasureId(meaId);

                    String meaTime = (String) tutorials.get("measuringTime");
                    String newdt = dh.subStringDate(meaTime);
                    dh.setMeasureTime(newdt);

                    ArrayList<Float> list = new ArrayList<Float>();
                    list.toArray();
                    JSONArray jsonArray = (JSONArray) tutorials.get("measuringData");
                    if (jsonArray != null) {
                        int len = jsonArray.size();
                        for (int i = 0; i < len; i++) {
                            //list.add((Double) jsonArray.get(i));
                            list.add((Float) Float.parseFloat(jsonArray.get(i) + ""));
                        }
                    }
                    dh.setMeasureData(list);

                }
                in.close();
            }
        } catch (Exception e) {

        }

        return dh;
    }

    static public void Addcomment(String idmea, String comment) throws IOException {
        HttpClient httpClient = HttpClientBuilder.create().build(); //Use this instead 

        HttpPost request = new HttpPost("http://139.59.98.254:3000/watjaimeasure/" + idmea);

        TimeZone tz = TimeZone.getTimeZone("UTC");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'"); // Quoted "Z" to indicate UTC, no timezone offset
        df.setTimeZone(tz);
        String nowAsISO = df.format(new Date());

        StringEntity params
                = new StringEntity(("{\"measuringTime\":\"" + nowAsISO + "\","
                        + "\"comment\":\"" + comment + "\"}"),
                        "UTF-8");

        request.setEntity(params);
        HttpResponse responseq = httpClient.execute(request);

    }

    static public List<DataHealth> ReciveURL(String text1, String patID, String text2) {
        String newURL;
        newURL = text1 + patID + text2;
        System.out.println("newURL : " + newURL);
        List<DataHealth> dataHealth = null;
        dataHealth = doReadInfoMeasureData(patID, newURL);
        //System.out.println("dataHealt : " + dataHealth);
        return dataHealth;
    }
    //"http://watjai.me:3000/patients/"+patId+"/watjaimeasure/latest"
    // URL oracle = new URL("http://watjai.me:3000/watjaimeasure/showabnormal/"+patId); // URL to Parse
    //http://139.59.98.254:3000/patients/PA1803001/watjaimeasure/commented

    /*
    show unread
     */
    static public List<DataHealth> doReadInfoMeasureData(String patid, String newURL) {
        List<DataHealth> dhlist = null;
        JSONParser parser = new JSONParser();
        DataHealth dh = null;

        try {

            URL oracle = new URL(newURL); // URL to Parse
            URLConnection yc = oracle.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream(), "UTF-8"));

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                JSONArray a = (JSONArray) parser.parse(inputLine);
                if (dhlist == null) {
                    dhlist = new ArrayList<>();
                }
                // Loop through each item
                for (Object o : a) {
                    JSONObject tut = (JSONObject) o;
                    dh = new DataHealth();

                    String meaId = (String) tut.get("measuringId");
                    dh.setMeasureId(meaId);

                    String meaTime = (String) tut.get("measuringTime");
                    String newdt = dh.subStringDate(meaTime);
                    dh.setMeasureTime(newdt);

                    dhlist.add(dh);

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return dhlist;
    }
//2561-04-04T12:56Z
    public String subStringDate(String dateTimes) {
        String newTimes = dateTimes.substring(11, 16);
        String newDate = dateTimes.substring(0, 10);

        String newDateTime = newDate + " " + newTimes;

        return newDateTime;
    }

    static public DataHealth showDataAbnormal(String idmea) {//showGraphMeasure
        DataHealth dh = new DataHealth();
        JSONParser parser = new JSONParser();
        try {
            URL oracle = new URL("http://139.59.98.254:3000/watjaimeasure/" + idmea); // URL to Parse
            URLConnection yc = oracle.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                JSONArray a = (JSONArray) parser.parse(inputLine);

                // Loop through each item
                for (Object o : a) {
                    JSONObject tutorials = (JSONObject) o;
                    String meaId = (String) tutorials.get("measuringId");
                    dh.setMeasureId(meaId);

                    String meaTime = (String) tutorials.get("measuringTime");
                    String newdt = dh.subStringDate(meaTime);
                    dh.setMeasureTime(newdt);

                    String meaDetail = (String) tutorials.get("abnormalDetail");
                    dh.setAbnormalDetail(meaDetail);
                    
                    
                    String comment = (String) tutorials.get("comment");
                    dh.setComment(comment);

                    ArrayList<Float> list = new ArrayList<Float>();
                    list.toArray();
                    JSONArray jsonArray = (JSONArray) tutorials.get("measuringData");

                    if (jsonArray != null) {
                        int len = jsonArray.size();
                        for (int i = 0; i < len; i++) {
                            //list.add((Double) jsonArray.get(i));
                            list.add((Float) Float.parseFloat(jsonArray.get(i) + ""));

                        }
                    }
                    dh.setMeasureData(list);

                }
                in.close();
            }
        } catch (Exception e) {

        }

        return dh;
    }

    public static void main(String[] args) throws IOException {
        //String idmea = "ME17092400016";
        //showData(idmea);
        //DataHealth d = new DataHealth();

        //d.subStringDate("2017-09-24T19:37:49.453Z");
        //changeMeaStatus("ME17103100003");
        //Addcomment("ME17103100002", "ทดลอง");
        //String newUrl ="http://139.59.98.254:3000/watjaimeasure/showabnormal/PA1803001";
        //  System.out.println(DataHealth.doReadInfoMeasureData("PA1803001",newUrl));
        // showDataAbnormal("ME17103100007");
        // ReciveURL("http://watjai.me:3000/watjaimeasure/showabnormal/", "PA1709001", "");
        ReciveURL("http://139.59.98.254:3000/patients/", "PA1803001", "/watjaimeasure/commented");
    }
}
