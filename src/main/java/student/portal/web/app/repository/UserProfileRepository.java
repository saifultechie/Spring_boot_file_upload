package student.portal.web.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import student.portal.web.app.model.UserProfile;
@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile,Long> {
}
