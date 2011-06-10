package org.jrainmaker;

import java.util.List;

import org.jrainmaker.entity.Chats;
import org.jrainmaker.entity.ContactInfo;
import org.jrainmaker.entity.Organizations;
import org.jrainmaker.entity.Photos;
import org.jrainmaker.entity.RainMakerEntity;
import org.jrainmaker.entity.SocialProfiles;

public class Demo {

	public static void main(String[] args) throws RainMakerException {

		String apiKey = "5a4d0e98e418e23a";

		String email = "lorangb@gmail.com";

		RainMaker maker = new RainMaker(apiKey);

		RainMakerEntity entity = maker.getPersonInformation(email);

		System.out.println("-- Status Code --");
		System.out.println("Status Code : " + entity.getStatusCode());

		System.out.println();

		System.out.println("-- Contact Info --");

		ContactInfo contactInfo = entity.getContactInfo();
		System.out.println("Full name : " + contactInfo.getFullName());
		System.out.println("Given name : " + contactInfo.getGivenName());
		System.out.println("Family name : " + contactInfo.getFamilyName());

		System.out.println();

		System.out.println("-- Chats --");

		List<Chats> chats = contactInfo.getChats();
		for (Chats chat : chats) {
			System.out.println("Client : " + chat.getChatClient());
			System.out.println("Handle : " + chat.getChatHandle());
			System.out.println();
		}

		System.out.println();
		System.out.println("-- Organizations --");

		List<Organizations> organizations = entity.getOrganizations();

		for (Organizations org : organizations) {
			System.out.println(org.getOrganizationName());
			System.out.println(org.getOrganizationTitle());
			System.out.println(org.getOrganizationStartDate());
			System.out.println();

		}

		System.out.println();
		System.out.println("-- Photos --");

		List<Photos> photos = entity.getPhotos();

		for (Photos photo : photos) {
			System.out.println("type :" + photo.getPhotoType());
			System.out.println("url :" + photo.getPhotoUrl());
			System.out.println();
		}

		System.out.println();
		System.out.println("-- Social Profiles --");

		List<SocialProfiles> profiles = entity.getSocialProfiles();

		for (SocialProfiles profile : profiles) {
			System.out.println("type : " + profile.getProfileType());
			System.out.println("url :" + profile.getProfileUrl());
			System.out.println("id :" + profile.getProfileId());
			System.out.println("username : " + profile.getProfileUsername());
			System.out.println("currentStatus : " + profile.getCurrentStatus());
			System.out.println("currentStatusTimestamp : " + profile.getCurrentStatusTimestamp());
			System.out.println("connections : " + profile.getConnections());
			System.out.println("bio : " + profile.getBio());
			
			
			System.out.println();
		}

	}
}
