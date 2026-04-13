import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TaskControllerTest {

    @Test
    void shouldCallRepoAdd() throws Exception {

        Main.TaskRepository repo = mock(Main.TaskRepository.class);
        when(repo.add(anyString(), anyString())).thenReturn(true);

        Main.TaskController controller = new Main.TaskController(repo);

        controller.add("Test", "Desc");

        verify(repo).add("Test", "Desc");
    }

    @Test
    void shouldRejectShortTitle() {

        Main.TaskRepository repo = mock(Main.TaskRepository.class);
        Main.TaskController controller = new Main.TaskController(repo);

        assertThrows(IllegalArgumentException.class, () ->
                controller.add("ab", "desc")
        );
    }
}