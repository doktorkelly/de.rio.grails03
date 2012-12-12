import de.rio.User;
import de.rio.Role;
import de.rio.UserRole;

class BootStrap {

    def init = { servletContext ->
		Role adminRole = new Role(authority: 'ROLE_ADMIN').save(flush: true);
		Role userRole = new Role(authority: 'ROLE_USER').save(flush: true);
		
		User user1 = new User(username: 'user1', enabled: true, password: 'appuser1');
		user1.save(flush: true);
		User adminUser = new User(username: 'admin', enabled: true, password: 'appuser2');
		adminUser.save(flush: true);
		
		UserRole.create(user1, userRole, true);
		UserRole.create(adminUser, adminRole, true);
		
//		assert User.count() == 3;
//		assert Role.count() == 2;
//		assert UserRole.count() == 2;
    }
    def destroy = {
    }
}
