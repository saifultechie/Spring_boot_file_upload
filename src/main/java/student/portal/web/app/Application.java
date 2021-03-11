package student.portal.web.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import student.portal.web.app.model.Gender;
import student.portal.web.app.model.User;
import student.portal.web.app.model.UserProfile;
import student.portal.web.app.repository.UserProfileRepository;
import student.portal.web.app.repository.UserRepository;

import java.time.LocalDate;

@SpringBootApplication
public class Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserProfileRepository userProfileRepository;
	@Override
	public void run(String... args) throws Exception {
		User user = new User();
		user.setName("saiful");
		user.setEmail("saiful123@gmaill.com");

		UserProfile userProfile = new UserProfile();
		userProfile.setAddress("dhaka");
		userProfile.setBirthOfDate(LocalDate.of(1995,03,24));
		userProfile.setGender(Gender.MALE);
		userProfile.setPhoneNumber("12345678");

		user.setUserProfile(userProfile);
		userProfile.setUser(user);

		userRepository.save(user);
//		userProfileRepository.save(userProfile);

	}

}
