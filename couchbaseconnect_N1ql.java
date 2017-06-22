package couchbase;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.CouchbaseCluster;
//import com.couchbase.client.java.document.json.JsonArray;
import com.couchbase.client.java.document.json.JsonObject;
//import com.couchbase.client.java.document.json.JsonArray;
import com.couchbase.client.java.query.N1qlQuery;
import com.couchbase.client.java.query.N1qlQueryResult;
import com.couchbase.client.java.query.N1qlQueryRow;
//import com.couchbase.client.java.query.SimpleN1qlQuery;
//import com.couchbase.client.java.view.ViewQuery;

public class Retrivelist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cluster cluster = CouchbaseCluster.create();
        Bucket bucket = cluster.openBucket("default");
        
     // query with a simple string
        System.out.println("Simple string query:");
        String bucketName="default";
        String argument="countries.country.zip";
        String words[] = argument.split(Pattern.quote("."));
        
        List<String> list=new ArrayList<String>();
        //System.out.println(words[2]);
        //N1qlQuery defaultquery= N1qlQuery.simple("select * from `default` limit 1 ");
        N1qlQuery defaultquery= N1qlQuery.simple("select f."+words[2]+" from `" + bucketName + "` unnest "+words[0]+" as c unnest c."+words[1]+" as f ");
        //N1qlQuery Query = N1qlQuery.parameterized("SELECT * from `" + bucketName + "`  WHERE docid=$1", JsonArray.from("000") );
        
//        for (N1qlQueryRow row : Query) {
//            System.out.println(row);}

        N1qlQueryResult queryresult=bucket.query(defaultquery);
        try{
        	for (N1qlQueryRow result: queryresult) {
            //System.out.println(result.value());
            JsonObject obj = result.value();
            String zipcode = (String) obj.get("zip");
            list.add(zipcode);
            //System.out.println(zipcode);
            
        	}
        }catch(Exception e) {
        	System.out.println(e.getMessage());
            System.out.println("Error found!!!");
        }
        System.out.println(list);
        //list.forEach(System.out::println);
       

	}

}
