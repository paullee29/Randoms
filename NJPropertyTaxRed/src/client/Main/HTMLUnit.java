package client.Main;

import java.io.IOException;
import java.net.MalformedURLException;

import org.junit.Assert;

import com.gargoylesoftware.htmlunit.*;
import com.gargoylesoftware.htmlunit.html.*;


public class HTMLUnit {

	public static void main(String[] args) throws FailingHttpStatusCodeException, MalformedURLException, IOException {
		// TODO Auto-generated method stub
		try (final WebClient webClient = new WebClient ()) {
	        final HtmlPage page = webClient.getPage("http://tax1.co.monmouth.nj.us/cgi-bin/prc6.cgi?&ms_user=monm&passwd=data&district=1204&srch_type=0&adv=2&out_type=2");
	        Assert.assertEquals("NJ Assessment Records Search", page.getTitleText());
	        System.out.println(page.getTitleText());

	        HtmlForm form = page.getFormByName("form1");
	        
	        HtmlTextInput textField = form.getInputByName("street");
	        textField.type("addington");
	        
	        HtmlElement htmlElement = page.getFirstByXPath ("//table[3]/tbody[1]/tr[2]/td[2]/input[1]");

	        htmlElement.click();
//	        HtmlPage HtmlElement = button.click();
	        
	        System.out.println(page.getTitleText());
		}

	}

}
