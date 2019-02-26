package telran.ashkelon2018.mishpahug.service;

import telran.ashkelon2018.mishpahug.dto.ResponseRegisrtationDto;
import telran.ashkelon2018.mishpahug.dto.UserProfileDto;


public interface AccountService {
	
//	Unauthorized requests
//	GET Static fields for profile form
	ResponseRegisrtationDto getStaticFieldsForProfileForm();
	
//	================================================
//	Authorized requests
//	POST 
//	Registration User
	ResponseRegisrtationDto registrationUser(String token);
	
//	POST 
//	Login User
	UserProfileDto loginUser(String token);

	
//	POST
//	Update User Profile
	UserProfileDto updateUserProfile(UserProfileDto userProfileDto, String token);

//	GET
//	User Profile
	UserProfileDto getUserProfile(String token);
	
//	POST
//	Add firebase token
//	When user logs in, the client side should register 
//	him on Firebase server and receive special token from it. 
//	This token should be sent to server side to enable 
//	notifications. After sending request client side should 
//	save this token until the end of user's session.
	
	String addFirebaseToken(String token);
	
//	DEL
//	Delete firebase token
//	When user logs out, the client side should send 
//	saved token to server side to disable notifications.
	
	String deleteFirebaseToken(String token);
	
	
	//service
//	Set<String> addRole(String role);
//	Set<String> removeRole(String role);
//	void changePassword(String password, String token);
	
}
