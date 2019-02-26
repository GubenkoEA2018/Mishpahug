package telran.ashkelon2018.mishpahug.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

	@Getter
	@NoArgsConstructor
	@AllArgsConstructor
	public class ResponseRegisrtationDto{
		String[] confession = {"religious","irreligious"};
		String[] gender = {"male","female"};
		String[] maritalStatus = {"married","single","couple"};
		String[] foodPreferences = {"vegetarian","kosher","non-vegetarian"};
		String[] languages = {"Hebrew","English","Russian"};
	    String[] holiday = {"Pesah","Shabbat","Other"};
	}

//	Enum[] confessions = Confession.values();
//	String[] confession =  
	
//	String name;
//	
//	public ResponseRegisrtationDto() {
//		this.name = "confession": [
//	}
//			                 "religious",
//			                 "irreligious"
//			               ],
//			               "gender": [
//			                 "male",
//			                 "female"
//			               ],
//			               "maritalStatus": [
//			                 "married",
//			                 "single",
//			                 "couple"
//			               ],
//			               "foodPreferences": [
//			                 "vegetarian",
//			                 "kosher",
//			                 "non-vegetarian"
//			               ],
//			               "languages": [
//			                 "Hebrew",
//			                 "English",
//			                 "Russian"
//			               ],
//			               "holiday": [
//			                 "Pesah",
//			                 "Shabbat",
//			                 "Other"
//			               ];
//			             
	
/*////	@JsonProperty("confession")
	String[] confession = {"religious", "irreligious"};
////	@JsonProperty("gender")
	String[] gender = {"male", "female"};
////	@JsonProperty("maritalStatus")
	String[] maritalStatus = {"married", "single", "couple"};
////	@JsonProperty("foodPreferences")
	String[] foodPreferences = {"vegetarian", "kosher", "nonvegetarian"};
////	@JsonProperty("languages")
	String[] languages = {"Hebrew", "English", "Russian"};
////	@JsonProperty("holiday")
	String[] holiday = {"Pesah", "Shabbat", "Other"};
//	
  */
 

