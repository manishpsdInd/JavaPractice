package com.example.demo.profile.practical;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
//import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

//@RunWith(SpringRunner.class) //SpringJUnit4ClassRunner
//@ExtendWith(SpringExtension.class)

//@ContextConfiguration(classes = { SpringTestConfiguration.class })
@SpringBootTest
public class MasterCardTest {

	/* 
	 * @RunWith(SpringRunner.class)
	 * Classes: SpringJUnit4ClassRunner, SpringRunner
	 * You need this annotation to just enable spring boot features like @Autowire, @MockBean etc..
	 * Is used to provide a bridge between Spring Boot test features and JUnit.
	 */
	
	/* 
	 * @SpringBootTest
	 * This annotation is used to load complete application context for end to end integration testing
	 * The annotation works by creating the ApplicationContext that will be utilized in our tests.
	 */
	
	/*
	 * @Mock annotation is used to create a mock object for a particular class
	 * @InjectMocks annotation is used to inject the mock object into the class being tested. 
	 * It is important to note that @InjectMocks can only be used with classes, not with interfaces.
	 */
	
	//@Mock
	@InjectMocks
	private MasterCard masterCardMocked;
	
	@Test
	public void testMap2Param() {
		System.out.println("testMap2Param test case");
		Assert.assertEquals(0, masterCardMocked.map2Param());
		
	}

	@Test
	public void testMap3Param() {
		System.out.println("testMap3Param test case");
		Assert.assertEquals(1, masterCardMocked.map3Param());
	}

}
