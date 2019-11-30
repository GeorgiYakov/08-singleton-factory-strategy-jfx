package ohm.softa.a08.services;

import com.google.gson.Gson;
import ohm.softa.a08.api.OpenMensaAPI;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class OpenMensaAPIService {
	private static OpenMensaAPIService instance;
	OpenMensaAPI mensaApiInstance;

	public static OpenMensaAPIService getInstance(){
		return instance;
	}

	private OpenMensaAPIService(){
		Retrofit retrofit = new Retrofit.Builder()
			.addConverterFactory(GsonConverterFactory.create())
			.baseUrl("https://openmensa.org/api/v2/")
			.build();

		mensaApiInstance = retrofit.create(OpenMensaAPI.class);
	}

	public OpenMensaAPI getApi(){
		return mensaApiInstance;
	}

}
