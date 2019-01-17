package deepstream.deepstreamExample;

import java.net.URISyntaxException;

import io.deepstream.DeepstreamClient;


public class RecordExample {

	public static void main(String[] args) {
		try {
			DeepstreamClient client = new DeepstreamClient("ws://localhost:6020/deepstream");
			client.login();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
