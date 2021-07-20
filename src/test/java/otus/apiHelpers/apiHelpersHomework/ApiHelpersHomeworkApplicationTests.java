package otus.apiHelpers.apiHelpersHomework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import otus.apiHelpers.apiHelpersHomework.pojo.requestBodies.UserBody;
import otus.apiHelpers.apiHelpersHomework.pojo.responses.CreatedUser;
import otus.apiHelpers.apiHelpersHomework.pojo.responses.Resource;
import otus.apiHelpers.apiHelpersHomework.pojo.responses.User;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

@SpringBootTest
class ApiHelpersHomeworkApplicationTests {

	@Test
	void retrofitTest() throws IOException {

		Response<User> response;

		//Endpoint client for send request
		APIInterface service = APIClientHelper.getClient().create(APIInterface.class);


			//GET request for get request
			response = service.getUser().execute();

		System.out.println(response.body().getData());
		Assertions.assertTrue(response.isSuccessful());
	}

	@Test
	void retrofitTestOfResources() throws IOException {

		Response<Resource> response;

		//Endpoint client for send request
		APIInterface service = APIClientHelper.getClient().create(APIInterface.class);


		//GET request for get request
		response = service.getResource().execute();

		// проверим, что запрос был успешен
		Assertions.assertTrue(response.isSuccessful());

		Integer expectedYear = 2001;
		Assertions.assertEquals(expectedYear, response.body().getData().getYear());

		String expectedName = "fuchsia rose";
		Assertions.assertEquals(expectedName, response.body().getData().getName());

	}

	@Test
	void retrofitTestOfCreatingNewUser() throws IOException {

		Response<CreatedUser> response;
		APIInterface service = APIClientHelper.getClient().create(APIInterface.class);

		// создаём body для отправки в POST методе
		String expectedName = "Vasya";
		String expectedJob = "QA tester";

		UserBody userBody = UserBody.builder()
				.name(expectedName)
				.job(expectedJob)
				.build();

		response = service.createUser(userBody).execute();

		/*
		// проверим, что запрос был успешен
		Assertions.assertTrue(response.isSuccessful());
		// проверим, что вернулся статус 201
		Assertions.assertEquals(200,response.code());
		// и проверим информацию о новом юзере
		Assertions.assertEquals(expectedName, response.body().getName());
		Assertions.assertEquals(expectedJob, response.body().getJob());
*/
		System.out.println(response.body());
	}

	@Test
	void retrofitTestOfCreatingToken() throws IOException {

		Response<CreatedUser> response;

		//Endpoint client for send request
		APIInterface service = APIClientHelper.getClient().create(APIInterface.class);


		String expectedName = "Vasya";
		String expectedJob = "QA tester";

/*
не понадобилось, хотел сделать через аннотацию body
		UserBody userBody = UserBody.builder()
				.name(expectedName)
				.job(expectedJob)
				.build();
*/
		//response = service.createUser(new UserBody(expectedName, expectedJob)).execute();

		/*
		// проверим, что запрос был успешен
		Assertions.assertTrue(response.isSuccessful());
		// проверим, что вернулся статус 201
		Assertions.assertEquals(200,response.code());
		// и проверим информацию о новом юзере
		Assertions.assertEquals(expectedName, response.body().getName());
		Assertions.assertEquals(expectedJob, response.body().getJob());
*/
		//System.out.println(response.body());
	}

}
