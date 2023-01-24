package service;

import io.UsersDatabase;
import io.UsersDatabaseMapImpl;
import org.junit.jupiter.api.*;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserServiceImplTest {

    UsersDatabase usersDatabase;
    UserService userService;
    String createdUserId = "";

    @BeforeAll //OBS does not need to be static because of instante per class
    void setup() {
        //create and initialize database
        usersDatabase = new UsersDatabaseMapImpl();
        usersDatabase.init();
        userService = new UserServiceImpl(usersDatabase);
    }

    @AfterAll //OBS does not need to be static because of instance per class
    void cleanup() {
        //close connection
        //delete database
        usersDatabase.close();
    }

    @Test
    @Order(1)
    @DisplayName("Create User works")
    void testCreateUser_whenProvidedWithValidDetails_returnsUserId() {
        //Arrange
        Map<String, String> user = new HashMap<>();
        user.put("firstName", "Bruno");
        user.put("lastName", "Barbosa");

        //Act
        createdUserId = userService.createUser(user);

        //Assert
        assertNotNull(createdUserId, "User id should not be null");
    }

    @Test
    @Order(2)
    @DisplayName("Update User works")
    void testUpdateUser_whenProvidedWithValidDetails_returnsUpdatedUserDetails() {
        //Arrange
        Map<String, String> userDetails = new HashMap<>();
        userDetails.put("firstName", "Bruno");
        userDetails.put("lastName", "Affeldt");

        //Act
        Map updatedUserDetails = userService.updateUser(createdUserId, userDetails);

        //Assert
        assertEquals(updatedUserDetails.get("firstName"), updatedUserDetails.get("firstName"), "Returned value of user's first name is incorrect");
        assertEquals(updatedUserDetails.get("lastName"), updatedUserDetails.get("lastName"), "Returned value of user's last name is incorrect");
    }

    @Test
    @Order(3)
    @DisplayName("Find user works")
    void testGetUser_whenProvidedWithValidUserId_returnsUserDetails() {
        //Act
        Map userDetails = userService.getUserDetails(createdUserId);

        //Assert
        assertNotNull(userDetails, "User details should not be null");
        assertEquals(createdUserId, userDetails.get("userId"), "Returned user details contains incorrect user id");
    }

    @Test
    @Order(4)
    @DisplayName("Delete User works")
    void testDeleteUser_whenProvidedWithValidUserId_returnsVoid() {
        //Act
        userService.deleteUser(createdUserId);

        //Assert
        assertNull(userService.getUserDetails(createdUserId), "User should not be found");
    }
}
