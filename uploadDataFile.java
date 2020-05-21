import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.*;
public class temp {
	public static void main(String[] args) {
		uploadData("Table001","name_varchar(255)@surname_varchar(255)@","createTable");//Create Table
	    uploadData("Table001","Samyak@Vora@","insertTableData");//insert into table
	}
	
	public static void uploadData(String tableName,String data,String fileName) {
		//fileName must be createTable or insertTableData
		String register_url="http://192.168.0.103/"+fileName+".php";
		try{
		    URL url=new URL(register_url);
                HttpURLConnection hp=(HttpURLConnection)url.openConnection();//connection is established
                hp.setRequestMethod("POST");
                hp.setDoOutput(true);
                OutputStream o=hp.getOutputStream();        
                BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(o,"UTF-8"));
                String post_data=URLEncoder.encode("tableName","UTF-8")+"="+URLEncoder.encode(tableName,"UTF-8")+"&"+ URLEncoder.encode("data","UTF-8")+"="+URLEncoder.encode(data,"UTF-8");
                bw.write(post_data);
                bw.flush();
                bw.close();
                o.close();
                hp.getResponseCode();
		}catch(Exception e){
		   System.out.println(e);
		}	
	}
}
