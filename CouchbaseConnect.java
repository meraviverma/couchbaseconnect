package couchbase;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.CouchbaseCluster;
import com.couchbase.client.java.document.JsonDocument;
import com.couchbase.client.java.document.json.JsonArray;
import com.couchbase.client.java.document.json.JsonObject;
import com.couchbase.client.java.query.N1qlQuery;
import com.couchbase.client.java.query.N1qlQueryResult;
import com.couchbase.client.java.query.N1qlQueryRow;
import com.couchbase.client.java.query.Query;

public class CouchbaseConnect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Cluster cluster = CouchbaseCluster.create();
        Bucket bucket = cluster.openBucket("default");
        
        JsonObject user = JsonObject.empty()
        	    .put("firstname", "Walter")
        	    .put("lastname", "White")
        	    .put("job", "chemistry teacher")
        	    .put("age", 50);
        JsonDocument doc = JsonDocument.create("walter", user);
        bucket.upsert(doc);
        JsonDocument walter = bucket.get("walter");
        System.out.println("Found: " + walter);
        
       // If you want to print only the age, you can reach into the content (much like you would access a `Map`):
        System.out.println("Age: " + walter.content().getInt("age"));
        
        cluster.disconnect();

	}

}
