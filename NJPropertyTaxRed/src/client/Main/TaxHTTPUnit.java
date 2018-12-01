package client.Main;

import java.io.IOException;

import org.xml.sax.SAXException;
import org.junit.Assert.*;
import com.meterware.httpunit.*;


public class TaxHTTPUnit {

	public static void main(String[] args) throws SAXException, IOException {
		// TODO Auto-generated method stub
		WebResponse   resp;
		HttpUnitOptions.setScriptingEnabled( true );

		WebConversation wc = new WebConversation();

		resp = wc.getResponse( "http://tax1.co.monmouth.nj.us/cgi-bin/prc6.cgi?&ms_user=monm&passwd=data&srch_type=0&adv=2&out_type=0&district=1204" );
		String htmldump = resp.getText();
	    
	    System.out.println(htmldump);

	    
	    WebForm form = resp.getForms ()[0];
	    form.setAttribute("street", "addington");
	    
	    resp.getLinks()[0].click();
	    
	    
	    


	}

}
