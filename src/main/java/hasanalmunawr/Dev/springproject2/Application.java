package hasanalmunawr.Dev.springproject2;

import hasanalmunawr.Dev.springproject2.domain.RequestContext;
import hasanalmunawr.Dev.springproject2.entity.RoleEntity;
import hasanalmunawr.Dev.springproject2.enumeration.Authority;
import hasanalmunawr.Dev.springproject2.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.info.ProjectInfoAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;


@SpringBootApplication
@EnableJpaAuditing
@EnableAsync
public class Application {


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(RoleRepository roleRepository, ProjectInfoAutoConfiguration projectInfoAutoConfiguration) {
		return args -> {

			RequestContext.setUserId(0L);
			RoleEntity userRole = new RoleEntity();
			userRole.setName(Authority.USER.getName());
			userRole.setAuthorities(Authority.USER);
//			roleRepository.save(userRole);

			var adminRole = new RoleEntity();
			adminRole.setName(Authority.ADMIN.getName());
			adminRole.setAuthorities(Authority.ADMIN);
//			roleRepository.save(adminRole);

			RequestContext.start();
		};
	}
}
