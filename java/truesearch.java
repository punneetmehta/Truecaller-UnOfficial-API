package info.phphive.truesearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/**
 * @author Puneet Mehta
 * @website www.PHPHive.info
 */
 
public class truesearch {

    private static SSLSocketFactory sslSocketFactory = null;

	public static void main(String[] args) {
		truesearch tcapi = new truesearch();
        try {
        String no = ""; // Any Mobile Number you want to Search
        if(no.isEmpty()){
        	System.out.println("Please Enter a Number on Line 28");
        	return ;
        }
		tcapi.search(no); // prints Details like Name, Internet Address ( including Email, Facebook & Twitter ), Spam Score, Spammer Type etc.
		tcapi.searchProfilePic(no); // prints ProfilePic Url ( if Available on TrueCaller )
        } catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void search(String no) throws Exception {

		String url = "https://tcapi.phphive.info/search/"+no;
		URL obj = new URL(url);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
        // For Handling SSL Handshakes
        if( null == sslSocketFactory) {
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, ALL_TRUSTING_TRUST_MANAGER, new java.security.SecureRandom());
            sslSocketFactory = sc.getSocketFactory();
        }
        con.setSSLSocketFactory(sslSocketFactory);
        con.setHostnameVerifier(ALL_TRUSTING_HOSTNAME_VERIFIER);
		//add reuqest header
		con.setRequestMethod("GET");
		con.setRequestProperty("X-User", "PHPHive");
		int responseCode = con.getResponseCode();
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		
		//print result
		System.out.println(response.toString());

	}

	private void searchProfilePic(String no) throws Exception {

		String url = "https://tcapi.phphive.info/pic/"+no;
		URL obj = new URL(url);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
        // For Handling SSL Handshakes
        if( null == sslSocketFactory) {
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, ALL_TRUSTING_TRUST_MANAGER, new java.security.SecureRandom());
            sslSocketFactory = sc.getSocketFactory();
        }
        con.setSSLSocketFactory(sslSocketFactory);
        con.setHostnameVerifier(ALL_TRUSTING_HOSTNAME_VERIFIER);
		//add reuqest header
		con.setRequestMethod("GET");
		con.setRequestProperty("X-User", "PHPHive");
		int responseCode = con.getResponseCode();
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		
		//print result
		System.out.println(response.toString());

	}
	
	// For Handling SSL Handshakes
    private static final TrustManager[] ALL_TRUSTING_TRUST_MANAGER = new TrustManager[] {
            new X509TrustManager() {

				@Override
				public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {					
				}

				@Override
				public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {					
				}

				@Override
				public X509Certificate[] getAcceptedIssuers() {
					return null;
				}

            }
        };

        private static final HostnameVerifier ALL_TRUSTING_HOSTNAME_VERIFIER  = new HostnameVerifier() {
            public boolean verify(String hostname, SSLSession session) {
                return true;
            }
        };

}
