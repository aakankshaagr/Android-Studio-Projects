package com.example.xmltojson

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.json.JSONObject
import javax.xml.parsers.DocumentBuilderFactory

class MainActivity : AppCompatActivity() {


    private lateinit var xmlbtn: Button
    private lateinit var jsonbtn:Button
    private lateinit var data:TextView
    private lateinit var cityname:TextView
    private lateinit var longi:TextView
    private lateinit var lati:TextView
    private lateinit var temp:TextView
    private lateinit var humi:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        xmlbtn=findViewById(R.id.xmlbtn)
        jsonbtn=findViewById(R.id.jsonbtn)
        data=findViewById(R.id.data)
        cityname=findViewById(R.id.cityname)
        longi=findViewById(R.id.longi)
        lati=findViewById(R.id.lati)
        temp=findViewById(R.id.temp)
        humi=findViewById(R.id.humi)

        xmlbtn.setOnClickListener {
            parsexml()
        }

        jsonbtn.setOnClickListener {
            parsejson()
        }








    }

    @SuppressLint("SetTextI18n")
    private fun parsejson() {
        data.text = "JSON Data"
        val obj = JSONObject(LoadJSONFromAsset())

        cityname.text = "city_name: " + obj.getString("city_name")
        longi.text = "longitude: " + obj.getString("longitude")
        lati.text = "latitude: " + obj.getString("latitude")
        temp.text = "temperature: " + obj.getString("temperature")
        humi.text = "humidity: " + obj.getString("humidity")
    }
    private fun LoadJSONFromAsset(): String {
        val json: String
        val istream = assets.open("129.json")
        val size = istream.available()
        val buffer = ByteArray(size)
        istream.read(buffer)
        istream.close()
        json = String(buffer, Charsets.UTF_8)
        return json

    }

    private fun parsexml() {
        data.text="XML DATA"
        val istream=assets.open("123.xml")
        val docbuilder=DocumentBuilderFactory.newInstance()
        val doc = docbuilder.newDocumentBuilder().parse(istream)

        cityname.text="city_name:" + doc.getElementsByTagName("city_name").item(0).firstChild.nodeValue
        longi.text="longitude:" + doc.getElementsByTagName("longitude").item(0).firstChild.nodeValue
        lati.text="latitude:" + doc.getElementsByTagName("latitude").item(0).firstChild.nodeValue
        temp.text="temperature:" + doc.getElementsByTagName("temperature").item(0).firstChild.nodeValue
        humi.text="humidity:" + doc.getElementsByTagName("humidity").item(0).firstChild.nodeValue

    }
}
