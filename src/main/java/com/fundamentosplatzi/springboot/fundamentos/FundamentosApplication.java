package com.fundamentosplatzi.springboot.fundamentos;

import com.fundamentosplatzi.springboot.fundamentos.bean.MyBean;
import com.fundamentosplatzi.springboot.fundamentos.bean.MyBeanWithDependency;
import com.fundamentosplatzi.springboot.fundamentos.bean.MyBeanWithParameter;
import com.fundamentosplatzi.springboot.fundamentos.bean.Vehiculo;
import com.fundamentosplatzi.springboot.fundamentos.component.ComponentDependency;
import com.fundamentosplatzi.springboot.fundamentos.entity.User;
import com.fundamentosplatzi.springboot.fundamentos.pojo.UserPojo;
import com.fundamentosplatzi.springboot.fundamentos.repository.UserRepository;
import com.fundamentosplatzi.springboot.fundamentos.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

	private final Log LOGGER = LogFactory.getLog(FundamentosApplication.class);

	private ComponentDependency componentDependency;
	private MyBean myBean;
	private MyBeanWithDependency myBeanWithDependency;
	private Vehiculo vehiculo;
	private MyBeanWithParameter myBeanWithParameter;
	private UserPojo userPojo;
	private UserRepository userRepository;
	private UserService userService;

	public FundamentosApplication(@Qualifier("componentTwoImplement") ComponentDependency componentDependency, MyBean myBean, MyBeanWithDependency myBeanWithDependency, Vehiculo vehiculo, MyBeanWithParameter myBeanWithParameter, UserPojo userPojo, UserRepository userRepository, UserService userService){
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.vehiculo = vehiculo;
		this.myBeanWithParameter = myBeanWithParameter;
		this.userPojo = userPojo;
		this.userRepository = userRepository;
		this.userService = userService;
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		///ejemplosAnteriores();
		saveUserToDatabase();
		getInformationJpqlFromUser();
		///saveWithErrorTransactional();
	}


	private void saveWithErrorTransactional(){
		User test1 = new User("test1","test1@domain.com", LocalDate.now());
		User test2 = new User("test2","test2@domain.com", LocalDate.now());
		User test3 = new User("test3","test1@domain.com", LocalDate.now());
		User test4 = new User("test4","test4@domain.com", LocalDate.now());

		List<User> users = Arrays.asList(test1, test2, test3, test4);

		try {
			userService.saveTransactional(users);
		}catch (Exception e){
			LOGGER.error("Exception dentro metodo (saveTransactional): " + e);
		}

		userService.getAllUsers()
				.stream()
				.forEach(user -> LOGGER.info("usuario dentro metodo transational: " + user));
	}

	private void getInformationJpqlFromUser(){

		/**LOGGER.info("Usuario buscado con findByUserCorreo: " +
				userRepository.findByUserEmail("carlos@hotmail.com")
						.orElseThrow(()-> new RuntimeException("No se localizo el correo.")));

		LOGGER.info("Usuario buscado con findByUserCorreo: " +
				userRepository.findByUserCorreo("carlos@hotmail.com")
						.orElseThrow(()-> new RuntimeException("No se localizo el correo.")));

		userRepository.findAndSort("user", Sort.by("id").descending())
				.stream()
				.forEach(user -> LOGGER.info("usuario(findAndSort): " + user ));

		userRepository.findByName("user1")
				.stream()
				.forEach(user -> LOGGER.info("usuario (findByName): " + user));

		LOGGER.info("usuario(findByCorreoAndName): " +
				userRepository.findByEmailAndName("pedro@hotmail.com","user3").orElseThrow(()-> new RuntimeException("Usuario no encontrado.")));*/

		/**userRepository.findByName("user1")
				.stream()
				.forEach(user -> LOGGER.info("usuario (findByName): " + user));

		userRepository.findByNameLike("%user1%")
				.stream()
				.forEach(user -> LOGGER.info("usuario (findByNameLike): " + user));

		userRepository.findByNameOrEmail("user1",null)
				.stream()
				.forEach(user -> LOGGER.info("usuario (findByNameOrEmail): " + user));

		userRepository.findByNameLikeOrderByIdDesc("%user%")
				.stream()
				.forEach(user -> LOGGER.info("usuario (findByNameLikeOrderByIdDesc): " + user));

		userRepository.findByNameContainingOrderByIdDesc("user1")
				.stream()
				.forEach(user -> LOGGER.info("usuario (findByNameContainingOrderByIdDesc): " + user));

		userRepository.findByBirthDateBetween(LocalDate.of(2022,03,20), LocalDate.of(2022,05,22))
				.stream()
				.forEach(user -> LOGGER.info("usuario (findByBirthDateBetween): " + user));*/

		LOGGER.info("usuario (getAllByBirthDateAndEmail - named parameters) :" +
				userRepository.getAllByBirthDateAndEmail(LocalDate.of(2022,04,21), "carlos@hotmail.com")
						.orElseThrow(()-> new RuntimeException("No se encontro el usuario (getAllByBirthDateAndEmail - named parameters)")));



	}

	private void saveUserToDatabase(){

		User user1 = new User("user1", "elias_ja@hotmail.com", LocalDate.of(2022,03,20));
		User user2 = new User("user2", "carlos@hotmail.com", LocalDate.of(2022,04,21));
		User user3 = new User("user3", "pedro@hotmail.com", LocalDate.of(2022,05,22));
		User user4 = new User("user4", "user4@hotmail.com", LocalDate.of(2022,02,15));
		User user5 = new User("user5", "user5@hotmail.com", LocalDate.of(2022,02,14));
		User user6 = new User("user6", "user6@hotmail.com", LocalDate.of(2022,01,13));

		List<User> list = Arrays.asList(user1, user2, user3, user4, user5, user6);
		
		list.stream().forEach(userRepository::save);
	}

	private void ejemplosAnteriores(){
		componentDependency.saludar();
		myBean.print();
		myBeanWithDependency.printWithDependency();
		vehiculo.add();
		vehiculo.update();
		vehiculo.delete();
		myBeanWithParameter.print();
		System.out.println(myBeanWithParameter.function());
		System.out.println(userPojo.getCorreo() + " - " + userPojo.getClave() + " - " + userPojo.getEdad());

		LOGGER.error("ERROR: prueba de LOG de errores.");

		try {
			/// error
			//int value = 10/0;
			int value = 10;
			LOGGER.debug("Mi valor es: " + value);
		}catch (Exception e){
			LOGGER.error("ERROR: " + e.getMessage());
		}
	}
}
