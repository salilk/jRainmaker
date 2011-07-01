package org.jrainmaker;

import com.google.gson.Gson;

import org.jrainmaker.config.Constants;
import org.jrainmaker.entity.RainMakerEntity;
import org.jrainmaker.http.RainMakerHttpRequest;

import java.text.MessageFormat;

public class RainMaker {

	private String apiKey;

	public RainMaker(String apiKey) {
		if (apiKey == null) {
			throw new IllegalArgumentException("apiKey cannot be null.");
		}

		if (apiKey.trim().length() == 0) {
			throw new IllegalArgumentException("apiKey cannot be empty.");
		}

		this.apiKey = apiKey;
	}

	public RainMakerEntity getPersonInformation(String email)
			throws RainMakerException {
		String requestParams = MessageFormat.format(Constants.EMAIL_FORMAT,
				email)
				+ "&"
				+ MessageFormat.format(Constants.API_KEY_FORMAT, apiKey);
		RainMakerEntity message = null;
		Gson gson = new Gson();
		String response = RainMakerHttpRequest.sendRequest(requestParams);

		message = gson.fromJson(response, RainMakerEntity.class);

		return message;
	}

	public RainMakerEntity getPersonInformation(String email, int timeoutSeconds)
			throws RainMakerException {
		String requestParams = MessageFormat.format(Constants.EMAIL_FORMAT,
				email)
				+ "&"
				+ MessageFormat.format(Constants.API_KEY_FORMAT, apiKey)
				+ "&"
				+ MessageFormat.format(Constants.TIMEOUT_SECONDS_FORMAT,
						timeoutSeconds);
		RainMakerEntity message = null;
		Gson gson = new Gson();
		String response = RainMakerHttpRequest.sendRequest(requestParams);

		message = gson.fromJson(response, RainMakerEntity.class);

		return message;
	}
}
