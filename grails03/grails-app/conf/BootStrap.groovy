import de.rio.User;
import de.rio.Role;
import de.rio.UserRole;

class BootStrap {

    def init = { servletContext ->
		Role adminRole = new Role(authority: 'ROLE_ADMIN').save(flush: true);
		Role userRole = new Role(authority: 'ROLE_USER').save(flush: true);
		Role guestRole = new Role(authority: 'ROLE_GUEST').save(flush: true);
		
		User adminUser = new User(username: 'admin', enabled: true, password: 'min80user'); //appuser2
		adminUser.save(flush: true);
		User employeeUser = new User(username: 'employee', enabled: true, password: 'appuser12');
		employeeUser.save(flush: true);
		User hengjunUser = new User(username: 'hengjun', enabled: true, password: 'ckbuser72');
		hengjunUser.save(flush: true);
		User guestUser = new User(username: 'guest', enabled: true, password: 'guest2012');
		guestUser.save(flush: true);

		UserRole.create(adminUser, adminRole, true);
		UserRole.create(employeeUser, userRole, true);
		UserRole.create(hengjunUser, userRole, true);
		UserRole.create(guestUser, guestRole, true);
		
//		assert User.count() == 3;
//		assert Role.count() == 2;
//		assert UserRole.count() == 2;
    }
    def destroy = {
    }
}
