package service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import model.Profile;
import database.DatabaseClass;

public class ProfileService {
	private Map<String, Profile> profiles=DatabaseClass.getProfile();
	
	public ProfileService() {
		profiles.put("pranay", new Profile(1,"Pranay","Pranay","kalva",new Date()));
	}
	public List<Profile> geProfiles(){
		
		return new ArrayList<Profile>(profiles.values());
		}
	public Profile getProfile(String profileName){
		return profiles.get(profileName);
		}
    public Profile addProfile(Profile profile){
    	
		profiles.put(profile.getProfileName(),profile);
		return profile;
		}
    public Profile updateProfile(Profile profile){
		profiles.put(profile.getProfileName(),profile);
		return profile;
    	}
    public Profile removeMessage(String profileName){
    	return profiles.remove(profileName);
    }
}
