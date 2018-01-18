import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;


public class ReadJson  implements IJson{

	public static String raw;
	
	public ReadJson()
	{
		
	}
	@Override
	public String load(String url) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		
		URL u= new URL(url);
		BufferedReader br= new BufferedReader(new InputStreamReader(u.openStream()));
		String data;
		data=br.readLine();
		return data;
		
	}

	@Override
	public Object parse(String data)  {
		// TODO Auto-generated method stub
		/*
		int b=0;//number of {
		for(int i=0; i<data.length(); i++)
			if(data.charAt(i)=='{')
				b++;
				*/
		int j;
		int nrk=0;
		int nrv=0;
		String k="";
		String v="";
		//System.out.println("brackets="+b);
		String []key= new String [50];
		String []value= new String[50];
		
		/*
		 //storing words
		for(int i=0; i<data.length();i++)
		{
			if(data.charAt(i)=='"')
			{
				if(data.charAt(i+1)!=':' && data.charAt(i+1)!=',' && data.charAt(i+1)!='}' )
				{
				j=i+1;
				while(data.charAt(j)!='"')
				{
					
					k=k+data.charAt(j);
					j++;
				}
				
				key[nrk]=k;
				k="";
				nrk++;
				
				}
			}
		}
		*/
		
		for(int i=0; i<data.length();i++)
		{
			if(data.charAt(i)==':')
			{
				if(data.charAt(i-1)=='"')
				{
					j=i-2;
			
				while(data.charAt(j)!='"')
					j--;
				
				key[nrk]=data.substring(j+1, i-1);
				nrk++;
				
				
				if(data.charAt(i+1)=='{')
				{
					int bs=1,bf=0;
					int l=i+2;
					while(bs!=bf)
						{
						if(data.charAt(l)=='{') bs++;
						if(data.charAt(l)=='}') bf++;
						
						l++;
						}
					value[nrv]=data.substring(i+1,l);
					nrv++;
				}
				else
				{
					int p=i;
					
					while((data.charAt(p)!=',' && data.charAt(p+1)!='"')||(data.charAt(p)!='}'))
						
					while(data.charAt(p)!=',' && data.charAt(p)!='}')
					{			
						p++;
					}
					
					value[nrv]=data.substring(i+1,p-1);
					nrv++;
					
				}
				
				
				}
			}
			
		}
		
		
		System.out.println("====keys:====");
		
		for(int p=0; p<nrk; p++)
			System.out.println(key[p]);
		
		System.out.println("====values:====");
		
		
		for(int q=0; q<nrv; q++)
			System.out.println(value[q]);
		
		
		return null;
	}

	
	
	public static void main(String [] args)
	{
		
		ReadJson json= new ReadJson();
		try {
			//with arg
		//String raw=a.load("http://query.yahooapis.com/v1/public/yql?q=select%20item.condition%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text=%22"+args[0]+"%22)&format=json");
			//withount arg
		raw=json.load("http://query.yahooapis.com/v1/public/yql?q=select%20item.condition%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text=%22prague%22)&format=json");

		
		//String rawlong=json.load("http://query.yahooapis.com/v1/public/yql?q=select%20item.condition%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text=%22prague%22)&format=json");
		System.out.println(raw);
		}
		catch(Exception e)
		{
			System.out.println("ERROR");
		}
		//for now:
		//String data="{"query":{"count":1,"created":"2018-01-18T12:37:03Z","lang":"en-US","results":{"channel":{"item":{"condition":{"code":"11","date":"Thu, 18 Jan 2018 12:00 PM CET","temp":"38","text":"Showers"}}}}}";
		try {
			
		Object data= (Map<String,Object>)json.parse(raw);
		}
		catch(Exception f)
		{
		System.out.println("Error");
		}
		
		//parse(raw);
		
		
	}
}
