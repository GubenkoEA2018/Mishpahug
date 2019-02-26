package telran.ashkelon2018.mishpahug.service;

import java.time.LocalDateTime;
import java.util.Set;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import telran.ashkelon2018.mishpahug.configuration.AccountConfiguration;
import telran.ashkelon2018.mishpahug.configuration.AccountUserCredentials;
import telran.ashkelon2018.mishpahug.dao.UserAccountRepository;
import telran.ashkelon2018.mishpahug.domain.UserAccount;
import telran.ashkelon2018.mishpahug.dto.ResponseRegisrtationDto;
import telran.ashkelon2018.mishpahug.dto.Roles;
import telran.ashkelon2018.mishpahug.dto.UserProfileDto;
import telran.ashkelon2018.mishpahug.exceptions.UnprocessableEntity;
import telran.ashkelon2018.mishpahug.exceptions.UserConflictException;

@Service
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	UserAccountRepository userRepository;

	@Autowired
	AccountConfiguration accountConfiguration;

	@Override
	public ResponseRegisrtationDto getStaticFieldsForProfileForm() {
		return new ResponseRegisrtationDto();
	}
	
	@Override
	public ResponseRegisrtationDto registrationUser(String token) {
		//FIXME check regular???
		AccountUserCredentials credentials = accountConfiguration.tokenDecode(token);
		if (userRepository.existsById(credentials.getEmail())) {
			throw new UserConflictException("User exists!");
		}
		String hashPassword = BCrypt.hashpw(credentials.getPassword(), BCrypt.gensalt());
		UserAccount userAccount = UserAccount
				.builder()
				.email(credentials.getEmail())
				.password(hashPassword)
				.role(Roles.USER_EMPTY_PROFILE.name())
				.expdate(LocalDateTime.now().plusDays(accountConfiguration.getExpPeriod())).build();
		userRepository.save(userAccount);
		return new ResponseRegisrtationDto();
	}
			
	@Override
	public UserProfileDto loginUser(String token) {
		AccountUserCredentials credentials = 
				accountConfiguration.tokenDecode(token);
		UserAccount userAccount = 
				userRepository.findById(credentials.getEmail()).get();
		if (credentials.getEmail() == userAccount.getEmail()) {
			if(userAccount.getRoles().contains(Roles.USER_EMPTY_PROFILE.name())) {
				throw new UserConflictException("User has empty profile!");
			}
		}
		return convertToUserProfileDto(userAccount);
		}
	
	
	@Override
	public UserProfileDto updateUserProfile(UserProfileDto userProfileDto, String token) {
		AccountUserCredentials credentials = accountConfiguration.tokenDecode(token);
		UserAccount userAccount = userRepository.findById(credentials.getEmail()).get();
		if (credentials.getEmail() == userAccount.getEmail()) {
			if(userProfileDto.getFirstName() != null) {
			userAccount.setFirstName(userProfileDto.getFirstName());
			}
			if(userProfileDto.getDateOfBirth() != null) {
			userAccount.setDateOfBirth(userProfileDto.getDateOfBirth());
			}
			if(userProfileDto.getGender() != null) {
			userAccount.setGender(userProfileDto.getGender());
			}
			if(userProfileDto.getMaritalStatus() != null) {
			userAccount.setMaritalStatus(userProfileDto.getMaritalStatus());
			}
			if(userProfileDto.getConfession() != null) {
			userAccount.setConfession(userProfileDto.getConfession());
			}
			if(userProfileDto.getLastName() != null) {
			userAccount.setLastName(userProfileDto.getLastName());
			}
			if(userProfileDto.getPictureLink() != null) {
			userAccount.setPictureLink(userProfileDto.getPictureLink());
			}
			if(userProfileDto.getPhoneNumber() != null) {
			userAccount.setPhoneNumber(userProfileDto.getPhoneNumber());
			}
			if(userProfileDto.getFoodPreferences() != null) {
			userAccount.setFoodPreferences(userProfileDto.getFoodPreferences());
			}
			if(userProfileDto.getLanguages() != null) {
			userAccount.setLanguages(userProfileDto.getLanguages());
			}
			if(userProfileDto.getDescription() != null) {
			userAccount.setDescription(userProfileDto.getDescription());
			}
			if(userAccount.getRoles().contains("USER_EMPTY_PROFILE")) {
			
			userAccount.removeRole(Roles.USER_EMPTY_PROFILE.name());
			userAccount.addRole(Roles.USER.name());
			}
		userRepository.save(userAccount);
		return convertToUserProfileDto(userAccount);
		}
		throw new UnprocessableEntity("User data is invalid!");
	}

	@Override
	public UserProfileDto getUserProfile(String token) {
		AccountUserCredentials credentials = accountConfiguration.tokenDecode(token);
		UserAccount userAccount = userRepository.findById(credentials.getEmail()).get();
		if (credentials.getEmail() == userAccount.getEmail()) {
			if(userAccount.getRoles().contains(Roles.USER_EMPTY_PROFILE.name())) {
				throw new UserConflictException("User has empty profile!");
			}
		}
		return convertToUserProfileDto(userAccount);
	}
	
	@Override
	public String addFirebaseToken(String token) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteFirebaseToken(String token) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
// service methods
	private UserProfileDto convertToUserProfileDto(UserAccount userAccount) {
		return UserProfileDto
				.builder()
				.email(userAccount.getEmail())
				.firstName(userAccount.getFirstName())
				.dateOfBirth(userAccount.getDateOfBirth())
				.gender(userAccount.getGender())
				.maritalStatus(userAccount.getMaritalStatus())
				.confession(userAccount.getConfession())
				.lastName(userAccount.getLastName())
				.pictureLink(userAccount.getPictureLink())
				.phoneNumber(userAccount.getPhoneNumber())
				.foodPreferences(userAccount.getFoodPreferences())
				.languages(userAccount.getLanguages())
				.description(userAccount.getDescription())
				.rate(0.)
				.numberOfVoters(0)
				.build();
	}

	
	public Set<String> addRole(String login, String role) {
		UserAccount userAccount = userRepository.findById(login).orElse(null);
		if(userAccount == null) {
		return null;	
		}
		userAccount.addRole(role);
		userRepository.save(userAccount);
		return userAccount.getRoles();
	}

	
	public Set<String> removeRole(String login, String role) {
		UserAccount userAccount = userRepository.findById(login).orElse(null);
		if(userAccount == null) {
		return null;	
		}
		userAccount.removeRole(role);
		userRepository.save(userAccount);
		return userAccount.getRoles();
	}


	
//	private void changePassword(String password, String token) {
//		// FIXME if you need
		
	}


