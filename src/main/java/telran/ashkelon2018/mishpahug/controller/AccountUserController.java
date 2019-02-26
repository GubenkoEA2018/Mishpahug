package telran.ashkelon2018.mishpahug.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import telran.ashkelon2018.mishpahug.dto.ResponseRegisrtationDto;
import telran.ashkelon2018.mishpahug.dto.UserProfileDto;
import telran.ashkelon2018.mishpahug.service.AccountService;

@RestController
@RequestMapping("/user")
public class AccountUserController {
	
	@Autowired
	AccountService accountService;
	
	@GetMapping("/staticfields")
	ResponseRegisrtationDto getStaticFieldsForProfileForm() {
		return accountService.getStaticFieldsForProfileForm();
	}
	
	@PostMapping("/registration")
	ResponseRegisrtationDto registrationUser(@RequestHeader("Authorization") String token) {
		return accountService.registrationUser(token);
	}
	
	@PostMapping("/login/{login}")
	UserProfileDto loginUser(@PathVariable String token) {
		return accountService.loginUser(token);
	}

	@PostMapping("/profile")
	UserProfileDto updateUserProfile(@RequestBody UserProfileDto userProfileDto, 
			@RequestHeader("Authorization")String token) {
		return accountService.updateUserProfile(userProfileDto, token);
	}
		
	@GetMapping("/profile")
	UserProfileDto getUserProfile(@RequestHeader("Authorization") String token) {
		return accountService.getUserProfile(token);
	}
	
	@PostMapping("/firebasetoken/add")
	String addFirebaseToken(@RequestHeader("Authorization") String token){
		return accountService.addFirebaseToken(token);
	}
	
	@DeleteMapping("/firebasetoken/delete")
	String deleteFirebaseToken(@RequestHeader("Authorization") String token){
		return accountService.deleteFirebaseToken(token);
	}
	
	
}
