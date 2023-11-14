import com.codegym.main.MainActivity;
import com.codegym.service.AnimalService;
import com.codegym.service.CageService;
import com.codegym.service.EmployeeService;
import com.codegym.service.VisitorService;

public class Main {



    public static void main(String[] args) {

        MainActivity mainActivity = MainActivity.getInstanceMainActivity();
        mainActivity.showMainActivity();
    }

}